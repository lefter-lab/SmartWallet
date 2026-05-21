package app.service.user;

import app.model.dto.user.UserDTO;
import app.model.dto.user.UserRegisterRequest;
import app.model.entity.user.User;
import app.model.mapper.user.UserMapper;
import app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserRegisterRequest request) {
        // 1. Check if username already exists
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("User with this username already exists");
            // TODO: Create custom exception
        }

        // 2. Map request to entity (password will be encoded in mapper)
        User user = userMapper.toEntity(request);

        // 3. Save user to database
        User savedUser = userRepository.save(user);

        // 4. Return UserDTO (never return Entity!)
        return userMapper.toDTO(savedUser);
    }

    public UserDTO login(String username, String password) {
        // 1. Find user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 2. Check if password matches
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // 3. Return UserDTO
        return userMapper.toDTO(user);
    }
}

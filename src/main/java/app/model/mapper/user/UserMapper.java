package app.model.mapper.user;

import app.model.dto.user.UserDTO;
import app.model.dto.user.UserRegisterRequest;
import app.model.entity.user.User;
import app.model.entity.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User toEntity(UserRegisterRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .country(request.getCountry())
                .role(UserRole.USER)
                .isActive(true)
                .createdOn(LocalDateTime.now())
                .updatedOn(LocalDateTime.now())
                .build();
    }

    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .profilePicture(user.getProfilePicture())
                .role(user.getRole())
                .country(user.getCountry())
                .isActive(user.getIsActive())
                .createdOn(user.getCreatedOn())
                .updatedOn(user.getUpdatedOn())
                .build();
    }
}

package app.model.dto.user;

import app.model.entity.user.Country;
import app.model.entity.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePicture;
    private UserRole role;
    private Country country;
    private Boolean isActive;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}

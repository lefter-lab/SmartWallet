package app.model.dto.user;

import app.model.entity.user.Country;
import app.model.entity.user.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

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

    // Constructors
    public UserDTO() {
    }

    public UserDTO(UUID id, String username, String firstName, String lastName, String email, String profilePicture, UserRole role, Country country, Boolean isActive, LocalDateTime createdOn, LocalDateTime updatedOn) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.role = role;
        this.country = country;
        this.isActive = isActive;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    // Builder Pattern
    public static UserDTOBuilder builder() {
        return new UserDTOBuilder();
    }

    public static class UserDTOBuilder {
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

        public UserDTOBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public UserDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserDTOBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserDTOBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder profilePicture(String profilePicture) {
            this.profilePicture = profilePicture;
            return this;
        }

        public UserDTOBuilder role(UserRole role) {
            this.role = role;
            return this;
        }

        public UserDTOBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public UserDTOBuilder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public UserDTOBuilder createdOn(LocalDateTime createdOn) {
            this.createdOn = createdOn;
            return this;
        }

        public UserDTOBuilder updatedOn(LocalDateTime updatedOn) {
            this.updatedOn = updatedOn;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(id, username, firstName, lastName, email, profilePicture, role, country, isActive, createdOn, updatedOn);
        }
    }
}

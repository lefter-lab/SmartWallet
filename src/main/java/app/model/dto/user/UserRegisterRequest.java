package app.model.dto.user;

import app.model.entity.user.Country;

public class UserRegisterRequest {
    private String username;
    private String password;
    private Country country;

    // Constructors
    public UserRegisterRequest() {
    }

    public UserRegisterRequest(String username, String password, Country country) {
        this.username = username;
        this.password = password;
        this.country = country;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    // Builder Pattern
    public static UserRegisterRequestBuilder builder() {
        return new UserRegisterRequestBuilder();
    }

    public static class UserRegisterRequestBuilder {
        private String username;
        private String password;
        private Country country;

        public UserRegisterRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserRegisterRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserRegisterRequestBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public UserRegisterRequest build() {
            return new UserRegisterRequest(username, password, country);
        }
    }
}

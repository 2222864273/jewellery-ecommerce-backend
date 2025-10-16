package za.co.jewellerysystem.domain.dto;

public class LoginResponse {
    private UserInfo user;

    public LoginResponse(UserInfo user) {
        this.user = user;
    }

    public UserInfo getUser () {
        return user;
    }

    public static class UserInfo {
        private Long id;
        private String fullName;
        private String email;

        public UserInfo(Long id, String fullName, String email) {
            this.id = id;
            this.fullName = fullName;
            this.email = email;
        }

        public Long getId() { return id; }
        public String getFullName() { return fullName; }
        public String getEmail() { return email; }
    }
}

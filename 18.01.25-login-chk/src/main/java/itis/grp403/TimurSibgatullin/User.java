package itis.grp403.TimurSibgatullin;

public class User {
    String login;
    String password;
    Role role;

    public User(String password, String login, Role role) {
        this.password = password;
        this.login = login;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}

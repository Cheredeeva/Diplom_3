package api.user;

public class UserRequestBody {
    public final String email;
    public final String password;
    public final String name;

    public UserRequestBody(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}

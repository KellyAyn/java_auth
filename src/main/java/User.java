public class User {
    private int id;
    private String name;
    private String password;
    private int loginCount;
    private Boolean isLoggedIn;

    public User(int id, String name, String password, int loginCount, Boolean isLoggedIn) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.loginCount = loginCount;
        this.isLoggedIn = isLoggedIn;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
        if (isLoggedIn) loginCount++;
    }
}

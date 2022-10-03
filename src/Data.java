import java.util.ArrayList;

public class Data {
    public static ArrayList<User> users = new ArrayList<>();
    public static User currentUser = null;
    public static Admin currentAdmin = null;
    public static void Init(){
        users.add(new User(1, "John", "1234", 0, false));
        users.add(new User(2, "Alice", "4321", 0, false));
        users.add(new Admin(3, "Bob", "abcd", 0, false, true,false));
        users.add(new Admin(4, "Lucy", "pass", 0, false, false, true));
    }

}

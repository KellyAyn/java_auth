import java.util.Objects;
import java.util.Scanner;

public class Interface {
    public static Scanner sc = new Scanner(System.in);
    public static void login(){
        System.out.println("Please input your name: ");
        String name = sc.nextLine().trim().toLowerCase();
        System.out.println("Please input your password: ");
        String pass = sc.nextLine().trim();
        for (User user : Data.users) {
            if (user.getName().toLowerCase().equals(name) && user.getPassword().equals(pass)){
                user.setLoggedIn(true);
                System.out.println("Successfully logged in as: " + user.getName());
                if (user instanceof Admin){
                    Data.currentAdmin = (Admin) user;
                } else {
                    Data.currentUser = user;
                }
                return;
            }
        }
        System.out.println("A user with that name does not exist.");
    }

    public static void logout(){
        if (Data.currentUser == null && Data.currentAdmin == null) {
            System.out.println("Please log in first.");
            return;
        }
        if (Data.currentUser != null){
            Data.currentUser.setLoggedIn(false);
            Data.currentUser = null;
        } else {
            Data.currentAdmin.setLoggedIn(false);
            Data.currentAdmin = null;
        }
        System.out.println("You have successfully logged out");
    }

    public static void changePass(){
        if (Data.currentUser == null && Data.currentAdmin == null) {
            System.out.println("Please log in first.");
            return;
        }

        if (Data.currentAdmin == null){
            System.out.println("Please input your current password");
            String oldPass = sc.nextLine().trim();
            if (!Data.currentUser.getPassword().equals(oldPass)){
                System.out.println("Wrong password, try again.");
                return;
            }
            System.out.println("Please input your new password.");
            String newPass = sc.nextLine().trim();
            Data.currentUser.setPassword(newPass);
            System.out.println("Successfully changed your password.");
            return;
        }

        if (!Data.currentAdmin.getRadiusAdmin()){
            System.out.println("You don't have the permission to do this.");
            return;
        }

        System.out.println("Please input the name of the user whose password you want to change: ");
        String name = sc.nextLine().trim().toLowerCase();
        for (User user : Data.users) {
            if (user.getName().toLowerCase().equals(name)){
                System.out.println("Please input your new password.");
                String newPass = sc.nextLine().trim();
                user.setPassword(newPass);
                System.out.println("Successfully changed your password.");
                return;
            }
        }
    }

    public static void user(){
        if (Data.currentUser == null && Data.currentAdmin == null) {
            System.out.println("No user logged in at this time.");
            return;
        }

        System.out.println("Current user: " + Objects.requireNonNullElseGet(Data.currentUser, () -> Data.currentAdmin).getName());
    }

    public static String help(){
        String txt = "The valid commands you can use are:\n";
        txt += "login - lets you log into your account.\n";
        txt += "logout - logs out the current user if one is logged in.\n";
        txt += "changepass - lets you change the current user's password.\n";
        txt += "user - returns the name of the current user";
        txt += "help - displays this message.";
        return txt;
    }

    public static void insert(){
        String sql = "";
    }
}

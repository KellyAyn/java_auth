import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database.connect();
        Data.Init();
        System.out.println(Interface.help());
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("> ");
            switch (sc.next().trim().toLowerCase()) {
                case "login" -> Interface.login();
                case "logout" -> Interface.logout();
                case "changepass" -> Interface.changePass();
                case "user" -> Interface.user();
                case "help" -> System.out.println(Interface.help());
                default -> System.out.println("Please input a valid command.");
            }
        }
    }
}
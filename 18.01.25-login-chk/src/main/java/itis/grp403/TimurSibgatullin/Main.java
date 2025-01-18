package itis.grp403.TimurSibgatullin;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    User user1 = new User("Ab1{},.;&?!_", "Vasyapypkin_1234@kpfu.ru", Role.USER);
    User user2 = new User("Bc2;&?!_{},.", "Vanyapapkin_5678@kpfu.ru", Role.ADMIN);
    User[] userArr = {user1, user2};
    String loginInp = "";
    String passwordInp = "";
    while (true) {
        Scanner loginScan = new Scanner(System.in);
        loginInp = loginScan.nextLine();
        if (loginInp.equals("exit")) {
            return;
        }
        Scanner passwordScan = new Scanner(System.in);
        passwordInp = passwordScan.nextLine();
        String[] src = {loginInp, passwordInp};
        Role role = userCheck(userArr, src);
        if (role == Role.USER) {
            System.out.println("""
                    USER:
                    
                    1. File
                    2. Get play list
                    3. exit""");
        } else if (role == Role.ADMIN) {
            System.out.println("""
                    ADMIN:
                    
                    1. File
                    2. Create new user
                    3. exit""");
        } else {
            System.out.println("Неверный логин или пароль");
        }
    }
    }

    static private Role userCheck(User[] userArr, String[] src) {
        for (User user : userArr) {
            try {
                chkLogin(user.getLogin());
                chkPassword(user.getPassword());
                if (src[0].equals(user.getLogin()) && src[1].equals(user.getPassword())) {
                    return user.getRole();
                }
            } catch (WrongLoginException exception) {
                return null;
            } catch (WrongPasswordException exception) {
                return null;
//            } finally {
            }
        }
        return null;
    }

    static private void chkLogin(String login) throws WrongLoginException {
        final String loginPatt = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@._])[a-zA-Z\\d@._]{20,}$";
        if (!Pattern.matches(loginPatt, login)) throw new WrongLoginException();
    }

    static private void chkPassword(String password) throws WrongPasswordException {
        final String passwordPatt = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[{},.;&?!_\\-+])[a-zA-Z\\d{},.;&?!_\\-+]{8,}$";
        if (!Pattern.matches(passwordPatt, password)) throw new WrongPasswordException();
    }
}
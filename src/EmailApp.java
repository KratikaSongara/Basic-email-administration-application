import java.util.Scanner;

public class EmailApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter firstname : ");
        String firstname = sc.next();
        System.out.println("enter lastname : ");
        String lastname = sc.next();
        Email email1 = new Email(firstname, lastname);
        String info = email1.showInfo();
        System.out.println(info);
    }
}

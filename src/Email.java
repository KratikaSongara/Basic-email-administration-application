import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private int mailBoxCapacity = 500;
    private String alternateEmail;
    private int defaultPasswordLength = 10;
    private String email;

    //constructor to receive firstname and lastname
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        //call a method asking for the department and return the department
        while (true) {
            String dept = setDepartment();
            if (!(dept.equals("Department not found"))) {
                this.department = dept;
                break;
            } else {
                System.out.println("please enter valid department");
            }
        }
        //call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("your password is : " + this.password);
        //combining the elements to generate email :
        this.email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + "." + "company.com";
    }

    //ask for the department
    private String setDepartment() {
        System.out.println("enter your department code:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter the department code : ");
        Scanner sc = new Scanner(System.in);
        int dept = sc.nextInt();
        if(dept == 1) return "sales";
        if(dept == 2) return "development";
        if(dept == 3) return "accounting";
        return "Department not found";
    }

    //generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for(int i=0; i<length; i++) {
            int random = (int)(Math.random() * password.length);
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    //set the mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        if(capacity > 500) {
            this.mailBoxCapacity = capacity;
        }
        else {
            System.out.println("default capacity is more than the entered capacity");
        }
    }

    //set alternate mail
    public void setAlternateEmail(String email) {
        this.alternateEmail = email;
    }

    //change password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return this.mailBoxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String showInfo() {
        return "Display name : " + firstname + " " + lastname + "\nCompany email : " + email + "\nMail box capacity : " + mailBoxCapacity + "mb";
    }
}

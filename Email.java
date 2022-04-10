package emailapp;
import java.util.Scanner;

public class Email<first_n
        ame, last_name> {


    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    //constructor tomrecieve first name and lst name





    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName + " " + this.lastName);

        //call a method asking for deprtmnt and return deprtmnt
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        //combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        //System.out.println("Your email is: " + email);
    }

    //ask for deprtmnt
    private String setDepartment() {
        System.out.print(" New worker: " + firstName + ". Department Codes:\n1 for sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }


    //generate random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set mailbox capcity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    //change the passwoed
    public void changePassword(String password) {
        this.password = password;

    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail()  { return alternateEmail; }
    public String getPassword()  { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName +  " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb" ;

    }
}
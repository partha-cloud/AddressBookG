
    import java.util.Scanner;public class AddressBook {
    Scanner sc=new Scanner(System.in);
    static ContactInfo[] contactList=new ContactInfo[15];
    int add(int increment)
    {
        System.out.println("Enter First Name:");
        String fn=sc.next();
        System.out.println("Enter last name:");
        String ln=sc.next();
        System.out.println("Enter Address:");
        String add=sc.next();
        System.out.println("Enter City:");
        String city=sc.next();
        System.out.println("Enter State:");
        String state=sc.next();
        System.out.println("Enter postal_code:");
        String zip=sc.next();
        System.out.println("Enter Country-code");
        String country=sc.next();
        System.out.println("Enter contact number:");
        String mob=sc.next();
        System.out.println("Enter email :");
        String mail=sc.next();
        contactList[increment++]=new  ContactInfo(fn, ln, add, city, state,zip,country,mob,mail);
        return increment;

    }

    public static void main(String args[]){
        AddressBook ab=new AddressBook();
        ab.toString();
        System.out.println("adding credentials to the MAnager");
    }
}


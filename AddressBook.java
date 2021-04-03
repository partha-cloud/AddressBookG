import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    public ArrayList<ContactInfo> contactbook = new ArrayList<>();
    ArrayList<AddressBookList> addressBookNameList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    public void addContact()
    {
        System.out.println("Enter First Name");
        String first = scan.nextLine();
        duplicateCheck(first);
        System.out.println("Enter Last Name");
        String last = scan.nextLine();
        System.out.println("Enter Address");
        String address = scan.nextLine();
        System.out.println("Enter City");
        String city = scan.nextLine();
        System.out.println("Enter State");
        String state = scan.nextLine();
        System.out.println("Enter Zip Code");
        int zip = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Phone Number");
        long mobileNo = Long.parseLong(scan.nextLine());
        System.out.println("Enter E-mail");
        String email = scan.nextLine();
        ContactInfo contact = new ContactInfo(first, last, address, city, state,  email,mobileNo, zip);
        contactbook.add(contact);
        System.out.println("Contact added Successfully");
        System.out.println("\n You can add multiple person's entry");
    }
    public void displayPerson()
    {
        System.out.println("\nEntered Person Details is:");
        for (ContactInfo person : contactbook)
        {
            System.out.println(person.toString());
        }
    }

    public void editPerson()
    {
        System.out.println("\n enter First name to edit details:");
        String name = scan.nextLine();
        for (ContactInfo person : contactbook) {
            System.out.println(person.toString());
            if (name.equals(person.firstName)) {
                System.out.println("\"Select the option to edit: \n"
                        + "1) Mobile no\n"
                        + "2) Email-Id\n"
                        + "3) Address\n"
                        + "4) Quit");
                int numb = Integer.parseInt(scan.nextLine());
                switch (numb) {
                    case 1 : {
                        System.out.println("enter new Mobile number:");
                        long mobileNo = Long.parseLong(scan.nextLine());
                        person.setMobileNo(mobileNo);
                        System.out.println("mobile no. is updated\n");
                        break;
                    }
                    case 2 : {
                        System.out.println("enter new Email-id:");
                        String email = scan.nextLine();
                        person.setEmail(email);
                        System.out.println("Email-id is updated\n");
                        break;
                    }
                    case 3 : {
                        System.out.println("enter your city");
                        String city = scan.nextLine();
                        System.out.println("enter your state");
                        String state = scan.nextLine();
                        System.out.println("enter your zip code");
                        int zip = Integer.parseInt(scan.nextLine());
                        person.setCity(city);
                        person.setState(state);
                        person.setZip(zip);
                        System.out.println("Address is updated\n");
                        break;
                    }
                    default : System.out.println("please enter right choice");
                }
            }
            else
                System.out.println("Person is not registered");
        }
    }

    public void deletePerson()
    {
        System.out.println("enter First name to delete details:");
        String name = scan.nextLine();
        for (int i=0; i < contactbook.size(); i++)
        {
            String personName = contactbook.get(i).firstName;
            if (name.equals(personName))
            {
                contactbook.remove(i);
                System.out.println("this person details is deleted");
                break;
            }
            else
                System.out.println("please enter valid name");
        }
    }

    public void newAddressBook()
    {
        System.out.println("Enter AddressBook Name");
        String userInputBookName = scan.nextLine();
        AddressBookList addressbook = new AddressBookList(userInputBookName);
        addressBookNameList.add(addressbook);
        System.out.println("New Address Book Name is added to list");
    }
    public void displayAddressBook()
    {
        System.out.println("Existing AddressBook Names are : ");
        for (AddressBookList addressBookList : addressBookNameList)
        {
            System.out.println(addressBookList);
        }
    }

    public void duplicateCheck(String first)
    {
        for (int k = 0; k < contactbook.size(); k++)
        {
            String contactName = contactbook.get(k).firstName;
            if (first.equals(contactName))
            {
                System.out.println("This Person is Already Present");
            }
            else
            {
                System.out.println("You can Add this Person");
                break;
            }
        }
    }

    public void searchPersonByCity()
    {
        System.out.println("Enter City name to search Person by city name");
        String userCity = scan.nextLine();
        Dictionary Citywisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getCity().contains(userCity)).forEach(contactbook -> Citywisedict.put(contactbook.getFirstName(),userCity));
        System.out.println("City Name: " + userCity);
        for (Enumeration i = Citywisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    public void searchPersonByState()
    {
        System.out.println("Enter the state name to search Person by state name");
        String userState = scan.nextLine();
        Dictionary Statewisedict = new Hashtable();
        contactbook.stream().filter(map -> map.getState().contains(userState)).forEach(contactbook -> Statewisedict.put(contactbook.getFirstName(),userState));
        System.out.println("State Name: " + userState);
        for (Enumeration i = Statewisedict.keys(); i.hasMoreElements();)
        {
            System.out.println("Name : " + i.nextElement());
        }
    }
    public void countByCity(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((ContactInfo C) -> C.getCity())));
        System.out.println((contactbook.stream().collect(Collectors.groupingBy((ContactInfo C) -> C.getCity(),Collectors.counting()))));
    }
    public void countByState(){
        System.out.println(contactbook.stream().collect(Collectors.groupingBy((ContactInfo C) ->C.getState(),Collectors.counting())));
    }
    public void sortPerson()
    {
        System.out.println("------Names are sorted alphabetical order----");
        contactbook.stream().sorted(Comparator.comparing(contactInfo -> contactInfo.getFirstName())).forEach(contactInfo -> System.out.println(contactInfo));
    }


    public static void main(String[] args)
    {
        System.out.println("-------------Welcome To The Address Book Problem--------------------");
        AddressBook address = new AddressBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Contact");
        System.out.println("2.Edit Contact");
        System.out.println("3.Display Contact");
        System.out.println("4.Delete Contact");
        System.out.println("5.Add New Address Book");
        System.out.println("6.Display New Address Book");
        System.out.println("7.Search Person By City");
        System.out.println("8. Search Person By State");
        System.out.println("9.Count by city");
        System.out.println("10.Count by state");
        System.out.println("11.sorting names in order");
        System.out.println("12.Exit");
        int k=0;
        while(k==0)
        {
            System.out.println("Enter the choice:");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    address.addContact();
                    break;
                case 2:
                    address.editPerson();
                    break;
                case 3:
                    address.displayPerson();
                    break;

                case 4:
                    address.deletePerson();
                    break;
                case 5:
                    address.newAddressBook();
                    break;
                case 6:
                    address.displayAddressBook();
                    break;
                case 7:
                    address.searchPersonByCity();
                    break;
                case 8:
                    address.searchPersonByState();
                    break;
                case 9:
                    address.countByCity();
                    break;
                case 10:
                    address.countByState();
                    break;
                case 11:
                    address.sortPerson();
                    break;
                case 12:
                    System.out.println("Exit");
                    k = 1;
                    break;
            }
        }
    }
}

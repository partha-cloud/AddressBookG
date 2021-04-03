public class ContactInfo {
    public String firstName;
    public String lastName;
    public String state;
    public String city;
    String FIRST_NAME;
    String LAST_NAME;
    String ADDRESS;
    String CITY;
    String STATE;
    String POSTAL_CODE;
    String COUNTRY;
    String CONTACT_NUMBER;
    String EMAIL;
    ContactInfo(String fn,String ln,String add,String city,String state,String zip,String country,String mob,String mail)
    {
        this.FIRST_NAME=fn;
        this.LAST_NAME=ln;
        this.ADDRESS=add;
        this.CITY=city;
        this.STATE=state;
        this.POSTAL_CODE=zip;
        this.COUNTRY=country;
        this.CONTACT_NUMBER=mob;
        this.EMAIL=mail;
    }

    public ContactInfo(String first, String last, String address, String city, String state, int zip, long phone, String email) {
    }

    public String toString() {
        return String.format(FIRST_NAME+" "+LAST_NAME+" "+ADDRESS+" "+CITY+" "+STATE+" "+POSTAL_CODE+" "
                +COUNTRY+" "+CONTACT_NUMBER+" "+EMAIL);
    }

}


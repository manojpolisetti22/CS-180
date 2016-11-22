/**
 * Created by manojpolisetti on 06/10/15.
 */
public class Contact {
    private String name;
    private long number;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Contact(String name) {
        this(name, 0, null);
    }

    public Contact(String name, long number) {
        this(name, number, null);
    }
    public Contact(String name, long number, String address) {
        this.name = name;
        this.number = number;
        this.address = address;
    }
    public boolean equals(Contact contact ) {
        if(contact.name.equals(this.name)) {
            return true;
        }
        return false;
    }
}

public class AddressBook {
    private int totalContacts;    // The total number of Contacts currently in this AddressBook
    private int maxContacts;      // The maximum number of Contacts this AddressBook can hold
    private Contact[] contacts;   // The array that holds the Contacts of this AddressBook
    
    /**
     * Constructor. Sets the initial size of the AddressBook to hold 10 Contacts.
     */
    public AddressBook() {
        this.totalContacts = 0;
        this.maxContacts = 10;
        this.contacts = new Contact[10];
    }

    /**
     * Adds the specified Contact to this AddressBook at the end of the contacts array. If 
     * the Contact already exists, it updates its phone number if the argument's number is not 0 and 
     * address if the argument's address is not null. If the totalContacts reaches the 
     * maxContacts, then the contacts array is doubled in size and maxContacts is doubled 
     * before the new Contact is added.
     * 
     * @param contact The Contact to add to this AddressBook
     * @return true if the Contact was added, false otherwise
     */
    public boolean addContact(Contact contact) {
        int len = this.contacts.length;
        boolean check = false;
        for(int i = 0; i < this.totalContacts; i++) {
            if(this.contacts[i].getName().equals(contact.getName())) {
                check = true;
                if(contact.getNumber() != 0) {
                    this.contacts[i].setNumber(contact.getNumber());
                }
                if(contact.getAddress() != null) {
                    this.contacts[i].setAddress(contact.getAddress());
                }
                return false;
            }
        }
        //int lastIndex = 0;
        /*Contact[] contacts1 = new Contact[len];
        for(int k = 0; k < len; k++) {
            contacts1[k] = contacts[k];
        }
        */
        if(this.maxContacts == this.totalContacts) {
            this.maxContacts = 2 * this.maxContacts;
            Contact[] tmp = new Contact[maxContacts];
            System.arraycopy(this.contacts,0,tmp,0,this.contacts.length);
            this.contacts = tmp;
        }
        if(check == false) {
            this.contacts[this.totalContacts] = contact;
            this.totalContacts++;
        }
        return true;
    }
    
    /**
     * Removes the specified Contact from this AddressBook and moves all entries 
     * that follow it in the contacts array to the left so that there are no empty
     * entries between Contacts. For example:
     * 
     * before -> {C1, C2, C3, C4, C5, C6, C7, C8, C9, null}
     * remove C6
     * after -> {C1, C2, C3, C4, C5, C7, C8, C9, null, null}
     * 
     * @param contact The Contact to remove from this AddressBook
     * @return true if the Contact was removed, false otherwise
     */
    public boolean removeContact(Contact contact) {
        int indexContact = 0;
        boolean check = false;
        for(int i = 0; i < this.totalContacts; i++) {
            if(this.contacts[i].getName().equals(contact.getName())) {
                indexContact = i;
                check = true;
                totalContacts--;
                break;

            }
        }
        for(int j = indexContact; j < this.contacts.length - 1; j++) {
            this.contacts[j] = this.contacts[j + 1];
        }
        this.contacts[this.contacts.length - 1] = null;
        return check;
    }
    
    /**
     * Gets a Contact by the specified name from this AddressBook.
     * 
     * @param name The name of the Contact to get
     * @return The Contact if they are found, null otherwise
     */
    public Contact getContactByName(String name) {
        for(int i = 0; i < this.totalContacts; i++) {
            if(this.contacts[i].getName().equals(name)) {
                return contacts[i];
            }
        }
        return null;
    }
    
    /**
     * Checks if the given contact is already in this AddressBook.
     * 
     * @param contact The contact to find
     * @return True if the contact is found, false otherwise
     */
    public boolean contains(Contact contact) {
        if(this.totalContacts == 0){
            return false;
        }
        for(int i = 0; i < this.totalContacts; i++) {
            if (this.contacts[i].equals(contact)) {
                return true;
            }
        }
        return false;

    }
    
    /**
     * Prints all the Contacts in this AddressBook.
     */
    public void printAddressBook() {
        for (int i = 0; i < this.totalContacts; i++) {
            System.out.printf("Name: %s%n", this.contacts[i].getName());
            System.out.printf("Number: %d%n", this.contacts[i].getNumber());
            System.out.printf("Address: %s%n%n", this.contacts[i].getAddress());
        }
    }

}
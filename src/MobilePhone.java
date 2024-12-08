import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    // Constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // Adds a new contact if it doesn't already exist
    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) { // Check by name
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    // Updates an existing contact
    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact.getName()); // Find by name
        if (position < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        }
        if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists. Update was not successful.");
            return false;
        }
        myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    // Removes an existing contact
    public boolean removeContact(Contact contact) {
        int position = findContact(contact.getName()); // Find by name
        if (position < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        myContacts.remove(position);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    // Finds a contact by Contact object and returns its position
    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    // Finds a contact by name and returns its position
    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) { // Case-sensitive matching
                return i; // Contact found
            }
        }
        return -1; // Contact not found
    }

    // Queries a contact by name and returns the Contact object
    public Contact queryContact(String name) {
        int position = findContact(name); // Find by name
        if (position >= 0) {
            return myContacts.get(position);
        }
        return null;
    }

    // Prints all contacts in the required format
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}

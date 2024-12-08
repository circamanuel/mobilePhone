import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber, ArrayList<Contact> myContact) {

        this.myNumber = myNumber;
        this.myContact = myContact;
    }
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<>();
    }

    // checks if contact exists: returns true or false and adds new contact.
    public boolean addNewContact(Contact contact) {

        if (myContact.contains(contact)) {

            System.out.println("Contact: " + contact + " exists already.");
            return false;
        } else {
            myContact.add(contact);
            System.out.println("Contact: " + contact + " Added.");
            return true;
        }
    }

    // checks if contact doesn't exist and updates it else returns false.
    public boolean updateContact(Contact oldContact, Contact newContact) {

        if (myContact.contains(oldContact)) {
            myContact.remove(oldContact);
            myContact.add(newContact);
            return true;
        } else {
            return false;
        }
    }

    // checks if contact exists, if so deletes contact else return false.
    public boolean removeContact(Contact contact) {

        if (myContact.contains(contact)) {
            myContact.remove(contact);
            System.out.println("Contact: " + contact + " removed.");
            return true;
        } else {
            System.out.println("Contact: " + contact + " doesn't exists.");
            return false;
        }
    }

    // searches contact end returns index
    private int findContact(Contact contact) {
        return myContact.indexOf(contact);
    }

    // Finds a contact by name and returns its position
    private int findContact(String name) {
        for (int i = 0; i < myContact.size(); i++) {
            Contact contact = myContact.get(i);
            if (contact.getName().equals(name)) {
                return i; // Contact found
            }
        }
        return -1; // Contact not found
    }

    // iterates trought the array myContact. If the contact name exists returns contact else return null;
    public Contact queryContact(String name) {

        for (Contact contact : myContact) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // prints the myContact array.
    public void printContacts() {
        System.out.println("Contact List: ");
        for (int i = 0; i < myContact.size(); i++) {
            Contact contact = myContact.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}

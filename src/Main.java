public class Main {
    public static void main(String[] args) {
        MobilePhone myPhone = new MobilePhone("123-456-7890");

        // Adding contacts
        myPhone.addNewContact(Contact.createContact("Bob", "31415926"));
        myPhone.addNewContact(Contact.createContact("Alice", "16180339"));

        // Printing contacts
        myPhone.printContacts();

        // Querying a contact
        Contact queriedContact = myPhone.queryContact("Alice");
        if (queriedContact != null) {
            System.out.println("Queried Contact: " + queriedContact.getName() + " -> " + queriedContact.getPhoneNumber());
        }

        // Updating a contact
        myPhone.updateContact(
                Contact.createContact("Alice", "16180339"),
                Contact.createContact("Alice", "99999999")
        );

        // Printing contacts after update
        myPhone.printContacts();

        // Removing a contact
        myPhone.removeContact(Contact.createContact("Bob", "31415926"));

        // Printing contacts after removal
        myPhone.printContacts();
    }
}

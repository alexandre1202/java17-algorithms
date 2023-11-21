package br.com.aab.testfornextly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
    private List<PhoneBookEntry> entries;

    public PhoneBook() {
        this.entries = new ArrayList<>();
    }

    //TODO: remover esse .sort() antes de mandar
    //TODO: adicionar o memoization
    //TODO:
    public void addEntry(PhoneBookEntry entry) {
        entries.add(entry);
        Collections.sort(entries); // Sort the entries by name
    }

    public String findPhoneNumberByName(String nameToFind) {
        PhoneBookEntry searchKey = new PhoneBookEntry(nameToFind, "");
        int index = Collections.binarySearch(entries, searchKey);   //O(Log N)

        return (index >= 0) ? entries.get(index).getPhoneNumber() : "Name not found in the phone book.";
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Add entries to the phone book
        phoneBook.addEntry(new PhoneBookEntry("Alexandre", "55-11-99169-1234"));
        phoneBook.addEntry(new PhoneBookEntry("Gabriela", "55-11-98923-4321"));
        // Add more entries as needed

        // Search for a phone number by name
        String nameToFind = "Alexandre";
        String phoneNumber = phoneBook.findPhoneNumberByName(nameToFind);
        System.out.println(nameToFind + "'s phone number: " + phoneNumber);
    }
}

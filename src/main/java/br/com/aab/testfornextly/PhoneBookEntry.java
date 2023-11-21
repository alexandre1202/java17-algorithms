package br.com.aab.testfornextly;

public class PhoneBookEntry implements Comparable<PhoneBookEntry> {
    private String name;
    private String phoneNumber;

    public PhoneBookEntry(String name) {
        this.name = name;
    }
    public PhoneBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(PhoneBookEntry other) {
        return this.name.compareTo(other.name);
    }
}

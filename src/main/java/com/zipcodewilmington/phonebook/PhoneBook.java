package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map ;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if (!phonebook.containsKey(name)){
            List<String> numby = new ArrayList<>();
            numby.add(phoneNumber);
            phonebook.put(name, numby);
        }else{
            List<String> numby2 = new ArrayList<>();
            numby2 = phonebook.get(name);
            numby2.add(phoneNumber);
            phonebook.put(name, numby2);
        }
    }

    public void addAll(String name, String... phoneNumbers) {
            phonebook.put(name, new ArrayList<> (Arrays.asList(phoneNumbers)));
        }

    public void remove(String name) {
        phonebook.remove(name);

    }

    public Boolean hasEntry(String name) {
        List <String> bookFace;
        if (phonebook.containsKey(name)){
                return true;
            }
        return false;
    }


    public Boolean hasEntry(String name, String phoneNumber) {
        List <String> bookFace;
        if (phonebook.containsKey(name)){
            bookFace = phonebook.get(name);
        if (bookFace.contains(phoneNumber)) {
            return true;
        }
        }
        return false;
    }

    public List<String> lookup(String name) {
        if (phonebook.containsKey(name)){
            return phonebook.get(name);
        }
        return null;
    }

    public String reverseLookup(String phoneNumber)  {
        Map<List<String>,String> bookphone = new HashMap<>();
        for (Map.Entry<String, List<String>> PH2 : phonebook.entrySet()){
            bookphone.put(PH2.getValue(), PH2.getKey());
        }
        for (List<String> l : bookphone.keySet()) {
            if (l.contains(phoneNumber)) {
                return bookphone.get(l);
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> names = new ArrayList<>(phonebook.keySet());
        return names;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}

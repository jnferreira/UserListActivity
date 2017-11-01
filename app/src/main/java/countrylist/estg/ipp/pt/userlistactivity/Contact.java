package countrylist.estg.ipp.pt.userlistactivity;

import java.util.ArrayList;

/**
 * Created by NunoFerreira on 31/10/17.
 */

public class Contact {
    private String name;
    private boolean online;

    public Contact(String name, boolean online){
        this.name = name;
        this.online = online;
    }

    public String getName(){
        return this.name;
    }

    public boolean isOnline(){
        return this.online;
    }

    public static ArrayList<Contact> createContactList(int tamanho){

        ArrayList<Contact> contacts = new ArrayList<>(tamanho);


        for (int i = 1; i < tamanho; i++){

            String nome = "Person "+i;

            Contact contact1 = new Contact(nome, getRandomBoolean());

            contacts.add(contact1);
        }

        return contacts;
    }

    public static boolean getRandomBoolean() {
        return Math.random() < 0.5;

    }
}

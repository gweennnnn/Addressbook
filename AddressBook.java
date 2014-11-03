/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook;
import java.util.*;
/**
 *
 * @author gwen
 */

public class AddressBook
{
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public AddressBook() {
    }


    Scanner sc = new Scanner(System.in);

    public void createContact(Contact x)
    {
        contactList.add(x);
    }

    public Contact searchContact(String x)
    {
        int matchFoundLocation = 0;
        for(int i = 0; i < contactList.size(); i++)
        {
            Contact temporary = contactList.get(i);
            if(x.equals(temporary.getName()))
            {
                return contactList.get(i);
            }
        }
        return null;
    }

    public boolean updateAddress (String name, String address)
    {
        for(int i = 0; i < contactList.size(); i++)
        {
            Contact temporary = contactList.get(i);
            if(name.equals(temporary.getName()))
            {
                temporary.setAddress(address);
                contactList.remove(i);
                contactList.add(i, temporary);
                return true;
            }
        }
        return false;
    }

    public boolean deleteContact (String name)
    {
        for(int i = 0; i < contactList.size(); i++)
        {
            Contact temporary = contactList.get(i);
            if(name.equals(temporary.getName()))
            {
                contactList.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayAllContacts ()
    {
        for(int i = 0; i < contactList.size(); i++)
        {
            Contact temporary = contactList.get(i);
            System.out.println("------------------------------------");
            System.out.println("Contact No. " + (i+1));
            System.out.println("------------------------------------");
            System.out.println("Name:       " +temporary.getName());
            System.out.println("Address:    " +temporary.getAddress());
            System.out.println("Mobile:     " +temporary.getMobile());
            System.out.println("Email:      " +temporary.getEmail());
            System.out.println("");

        }
    }

    public int returnAmountOfContacts()
    {
        return contactList.size();
    }
}
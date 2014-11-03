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
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        AddressBook AddressBook = new AddressBook();

        //-----MAIN MENU: REPEAT UNTIL '6' IS ENTERED-----//
        while (true)
        {
            showMainMenu();
            try //If the choice is not a number, then reject answer.
            {
                int choice = sc.nextInt();
                sc.nextLine();
                System.out.println("");
                
                switch (choice)
                {
                    case 1:
                        //-----CREATE CONTACT-----//
                        System.out.println(",====================,");
                        System.out.println("|   Create Contact   |");
                        System.out.println("`===================='");
                        System.out.println("Enter name: "); //Ask for NAME
                        String name = sc.nextLine().toUpperCase();
                        if(name.equals("EXIT")) //If name = exit, return to main menu
                        {
                            System.out.println("Press the Enter key to return to main menu.");
                            sc.nextLine();
                            break;
                        }

                        //Enter details
                        System.out.println("Enter address: ");
                        String address = sc.nextLine().toUpperCase();
                        System.out.println("Enter mobile: ");
                        String mobile = sc.nextLine().toUpperCase();
                        System.out.println("Enter email: ");
                        String email = sc.nextLine().toUpperCase();

                        while (true)//As long as the answer is neither Y or N, the question will keep repeating.
                        {
                            System.out.println("Add to address book? (Y/N)");
                            String add = sc.nextLine().toUpperCase();

                            //If the user wants to add contacto address book
                            if (add.equals("Y"))
                            {
                                //Create a new contact, and record the contact into the addressbook
                                Contact newContact = new Contact(name, address, mobile, email);
                                AddressBook.createContact(newContact);

                                //Check whether contact can be found by searching the name
                                Contact temp = AddressBook.searchContact(name);
                                if (temp != null) //If it can be found
                                {
                                    //Inform that adding was a success
                                    System.out.println("");
                                    System.out.println("Contact added successfully!");
                                    break;
                                }
                                else //If it can not be found
                                {
                                    //Inform that the contact could not be added.
                                    System.out.println("");
                                    System.out.println("Contact could not be added.");
                                    break; //break out of (Y/N?) loop
                                }
                            }
                            //If the user does not want to add contact to addressbook
                            else if (add.equals("N"))
                            {
                                //Inform that the contact was not added.
                                System.out.println("");
                                System.out.println("Contact was not added.");
                                break; //break out of (Y/N?) loop
                            }
                            //If the user inputs something other then Y or N
                            else
                            {
                                //Inform the user that it was an invalid input
                                System.out.println("Invalid input. Please try again.");
                                //Reloop (Y/N?) question
                            }
                        }

                        System.out.println("Press the Enter key to return to main menu.");
                        sc.nextLine();
                        break;

                    case 2:
                        //-----SEARCH CONTACT BY NAME-----//
                        System.out.println(",============================,");
                        System.out.println("|   Search Contact by Name   |");
                        System.out.println("`============================'");

                        //Repeat question if contact is not found
                        while (true)
                        {
                            System.out.println("Enter name: ");
                            String searchName = sc.nextLine().toUpperCase();

                            //If user chooses to exit, return to main menu
                            if(searchName.equals("EXIT"))
                            {
                                break;
                            }

                            //Perform search.
                            Contact searched = AddressBook.searchContact(searchName);

                            //If there was a match found
                            if(searched != null)
                            {
                                //Start printing information
                                System.out.println("");
                                System.out.println("------------");
                                System.out.println("Contact Info");
                                System.out.println("------------");
                                System.out.println("Name:       " + searched.getName());
                                System.out.println("Address:    " + searched.getAddress());
                                System.out.println("Mobile:     " + searched.getMobile());
                                System.out.println("Email:      " + searched.getEmail());
                                System.out.println("");
                                break; //Break loop
                            }
                            //if there was no match found
                            else
                            {
                                //Inform user that no contact can be found.
                                System.out.println("");
                                System.out.println("Contact not found. Please retry, or type 'EXIT' to return to main menu.");
                                //Reloop.
                            }
                        }
                        System.out.println("Press the Enter key to return to main menu.");
                        sc.nextLine();
                        break;

                    case 3:
                        //-----UPDATE ADDRESS-----//
                        System.out.println(",====================,");
                        System.out.println("|   Update Address   |");
                        System.out.println("`===================='");
                        //If contact cannot be found to be updated, reloop.

                        //=====FIRST LOOP=====//
                        while(true)
                        {
                            System.out.println("Enter Name: ");
                            String updateName = sc.nextLine().toUpperCase();

                            //if the user wants to exit the program, break loop.
                            if(updateName.equals("EXIT"))
                            {
                                break;
                            }

                            System.out.println("Enter Address");
                            String updateAddress = sc.nextLine().toUpperCase();
                            boolean updated = false; //This boolean later determines whether or not the program breaks out of the first loop.

                            //If the user inputs something other then Y or N, repeat question

                            //=====SECOND LOOP=====//
                            while (true)
                            {
                                System.out.println("Confirm update? (Y/N)");
                                String updateConfirmation = sc.nextLine().toUpperCase();
                                //If user wants to update
                                if(updateConfirmation.equals("Y"))
                                {
                                    updated = AddressBook.updateAddress(updateName, updateAddress);
                                    //if the program successfully updates
                                    if(updated == true)
                                    {
                                        //reprint with the new address
                                        Contact temporary = AddressBook.searchContact(updateName);
                                        System.out.println("");
                                        System.out.println("---------------");
                                        System.out.println("Updated Address");
                                        System.out.println("---------------");
                                        System.out.println("Name:       " + temporary.getName());
                                        System.out.println("Address:    " + temporary.getAddress());
                                        System.out.println("Mobile:     " + temporary.getMobile());
                                        System.out.println("Email:      " + temporary.getEmail());
                                        System.out.println("");
                                        break;
                                    }
                                    //if the program is unable to update, break out of the second loop.
                                    break;
                                    //This continues at line 221
                                    
                                }

                                //If user does not want to update
                                else if (updateConfirmation.equals("N"))
                                {
                                    updated = true; //This makes it so that it will break out of both loops.
                                    System.out.println("");
                                    System.out.println("Address not updated");
                                    break;
                                }
                                //If user inputs a value that is not "Y" or "N"
                                else
                                {
                                    System.out.println("Invalid input. Please try again.");//reprompt question
                                }
                            }
                            //=====END OF SECOND LOOP=====//

                            //if updated returns false, it prompts the program to reloop the first loop.
                            if(updated == false)
                            {
                                System.out.println("");
                                System.out.println("Contact not found. Unable to update address. Please retry, or type 'EXIT' to return to main menu.");
                            }

                            //if updated returns true, it breaks out of the first loop.
                            if(updated == true)
                            {
                                break;
                            }
                        }
                        //=====END OF FIRST LOOP=====//
                        
                        System.out.println("Press the Enter key to return to main menu.");
                        sc.nextLine();
                        break;

                    case 4:
                        //-----DELETE CONTACT-----//
                        System.out.println(",====================,");
                        System.out.println("|   Delete Contact   |");
                        System.out.println("`===================='");

                        //=====FIRST LOOP=====//
                        //Loops the prompts for name, etc.
                        while (true)
                        {
                            System.out.println("Enter name: ");
                            String deleteName = sc.nextLine().toUpperCase();

                            if(deleteName.equals("EXIT"))
                            {
                                break;
                            }
                            boolean deleted = false; //This later determines whether or not it breaks out of the first loop.

                            //=====SECOND LOOP=====//
                            //Loops the confirmation.
                            while (true)
                            {
                                System.out.println("Confirm delete? (Y/N)");
                                String deleteConfirmation = sc.nextLine().toUpperCase();

                                //if user confirms deletion
                                if(deleteConfirmation.equals("Y"))
                                {
                                    deleted = AddressBook.deleteContact(deleteName);
                                    System.out.println("");
                                    //if contact successfully deleted
                                    if(deleted == true)
                                    {
                                        //Inform user and break out of second loop
                                        System.out.println("Contact successfully deleted!");
                                        break;
                                    }
                                    else
                                    {
                                        break;
                                    }
                                }
                                //if user does not want to delete
                                else if(deleteConfirmation.equals("N"))
                                {
                                    deleted = true; //allows it to break out of the first loop as well.
                                    System.out.println("");
                                    System.out.println("Contact not deleted.");
                                    break; //break out of second loop
                                }
                                //if user inputs neither Y or N
                                else
                                {
                                    //reloop second loop
                                    System.out.println("Input is invalid. Please retry.");
                                }
                            }
                            //=====END OF SECOND LOOP=====//

                            if(deleted == false) //This is when it hits a scenario where I need to reloop the first loop
                            {
                                System.out.println("Contact not found. Unable to update address. Please retry, or type 'EXIT' to return to main menu.");
                            }
                            else if (deleted == true) //This is when it has successfully updated/opted not to delete
                            {
                                break;
                            }
                        }
                        //=====END OF SECOND LOOP=====//

                        System.out.println("Press the Enter key to return to main menu.");
                        sc.nextLine();
                        break;

                    case 5:
                        //-----DISPLAY ALL CONTACTS-----//
                        System.out.println(",==========================,");
                        System.out.println("|   Display All Contacts   |");
                        System.out.println("`=========================='");
                        int numberOfContacts = AddressBook.returnAmountOfContacts();

                        //if there are no contacts
                        if(numberOfContacts == 0)
                        {
                            //tell user.
                            System.out.println("Contact list is empty!");
                        }

                        //if there are contacts
                        else
                        {
                            //first print out the number of contacts present
                            System.out.println("Total number of contacts: " +numberOfContacts);
                            //then print out all the contacts
                            AddressBook.displayAllContacts();
                        }
                        System.out.println("");
                        System.out.println("Press the Enter key to return to main menu.");
                        sc.nextLine();
                        break;

                    case 6:
                        System.out.println(",==========,");
                        System.out.println("|   Quit   |");
                        System.out.println("`=========='");
                        System.out.println("Thank you for using me. Have a nice day.");
                        System.exit(0);

                    default: //if user inputs any other numbers > 6, reloop.
                        System.out.println("Enter from 1 to 6 only.");
                        System.out.println("Press enter to continue");
                        sc.nextLine();
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println(":::::: ERROR! Only integers please! ::::::");
                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
            }
            
        }
    }

    public static void showMainMenu()
    {
        System.out.println(",==================================,");
        System.out.println("|     Address Book Application     |");
        System.out.println("|----------------------------------|");
        System.out.println("|  1.  Create Contact              |");
        System.out.println("|  2.  Search Contact by Name      |");
        System.out.println("|  3.  Update Address              |");
        System.out.println("|  4.  Delete Contact              |");
        System.out.println("|  5.  Display All Contact         |");
        System.out.println("|  6.  Exit                        |");
        System.out.println("'=================================='");
        System.out.print("Enter Option : ");
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook;

/**
 *
 * @author gwen
 */
public class Contact {
    private String name;
    private String address;
    private String mobile;
    private String email;

    public Contact(String name, String address, String mobile, String email) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString()
    {
        return "Name: " +name+ "    Address: " +address+ "  Mobile: " +mobile+ "    Email: " +email;
    }
}

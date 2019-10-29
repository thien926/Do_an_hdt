/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Do_an;

/**
 *
 * @author FPT SHOP
 */
public abstract class TOCHUC {
    protected String ID;
    protected String name;
    protected String phone;
    protected String email;
    protected String DC;
    
    public TOCHUC(String ID, String name, String phone, String email, String DC) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.DC = DC;
    }
    
    public TOCHUC(){
        ID = name = email = DC = phone = "";
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDC() {
        return DC;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDC(String DC) {
        this.DC = DC;
    }
    
}

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
import java.util.GregorianCalendar;
import java.util.Calendar;

public abstract class HUMAN {
    protected String ID;
    protected String name;
    protected String sex;
    protected String birth;
    protected int age;
    protected String phone;
    protected String DC;
    private GregorianCalendar cal = new GregorianCalendar();
    private KTso kt = new KTso();
/*
    public HUMAN(String name, String sex, String birth, String ID, String DC, int age, int phone) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.ID = ID;
        this.DC = DC;
        this.age = age;
        this.phone = phone;
    }
    
    public HUMAN(String name, String sex, String birth, String ID, String DC, String age, String phone) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.ID = ID;
        this.DC = DC;
        this.age = Integer.parseInt(age);
        this.phone = Integer.parseInt(phone);
    }
    
    
    public HUMAN(String name, String sex, String birth, String ID, String DC, int phone) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.ID = ID;
        this.DC = DC;
        this.phone = phone;
        this.age = cal.get(Calendar.YEAR) - kt.birthyear(birth);
        
    }
    
    public HUMAN(String name, String sex, String birth, String ID, String DC, String phone) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.ID = ID;
        this.DC = DC;
        this.phone = Integer.parseInt(phone);
        this.age = cal.get(Calendar.YEAR) - kt.birthyear(birth);
        
    }
    
    public HUMAN(){
        this.name = "No Name";
        this.sex = "";
        this.birth = "";
        this.ID = "";
        this.age = 0;
        this.phone = 0;
        this.DC = "";
    }
*/

    public HUMAN(){
        this.name = "No Name";
        this.sex = "";
        this.birth = "";
        this.ID = "";
        this.age = 0;
        this.phone = "0";
        this.DC = "";
    }
    
    public HUMAN(String ID, String name, String sex, String birth, String age, String phone, String DC) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.age = Integer.parseInt(age);
        this.phone = phone;
        this.DC = DC;
    }
    
    public HUMAN(String ID, String name, String sex, String birth, String phone, String DC) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.age = cal.get(Calendar.YEAR) - kt.birthyear(birth);
        this.phone = phone;
        this.DC = DC;
    }
    
    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getBirth() {
        return birth;
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getDC() {
        return DC;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(String birth) {
        this.birth = birth;
        this.age = cal.get(Calendar.YEAR) - kt.birthyear(birth);
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDC(String DC) {
        this.DC = DC;
    }
    
    
}

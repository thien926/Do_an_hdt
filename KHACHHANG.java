/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Do_an;

import java.util.Scanner;
import java.util.List;
import java.util.Vector;
import java.nio.charset.StandardCharsets;
/**
 *
 * @author FPT SHOP
 */
public class KHACHHANG extends HUMAN{
    private KTso kt = new KTso();

    public KHACHHANG() {
        super();
    }

    public KHACHHANG(String ID, String name, String sex, String birth, String age, String phone, String DC) {
        super(ID, name, sex, birth, age, phone, DC);
    }

    public KHACHHANG(String ID, String name, String sex, String birth, String phone, String DC) {
        super(ID, name, sex, birth, phone, DC);
    }
    
    /*
    public String getDC() {
        return DC;
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

    public int getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setDC(String DC) {
        this.DC = DC;
    }

    public void setAge(int age) {
        this.age = ag e;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }*/
    public void set(){//=============================Hàm nhập không xét trùng số ID===============================
        Scanner kh_inp = new Scanner(System.in, "ISO-8859-1");
        String s;
        int i;
        //====================Nhập Mã khách hàng===============================
        System.out.print("-Mã khách hàng : ");
        setID(kh_inp.next());
        kh_inp.nextLine();
        //=========================Nhập tên khách hàng===========================
        System.out.print("-Tên : ");
        s = kh_inp.nextLine();
        while(!kt.ktname(s)){
            System.err.println("Lỗi nhập tên. Hãy nhập lại. ");
            System.out.print("Tên : ");
            s = kh_inp.nextLine();
        }
        for(i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') break;
        s = s.substring(i);
        for(i = s.length()-1; i >= 0; --i) if(s.charAt(i) != ' ') break;
        s = s.substring(0, i+1);
        setName(s);
        //======================================Nhập giới tính========================================
        System.out.print("-Giới tính : ");
        s = kh_inp.next();
        kh_inp.nextLine();
        while(!kt.ktsex(s)){
            System.err.println("Lỗi nhập giới tính. Hãy nhập lại. ");
            System.out.print("Giới tính : ");
            s = kh_inp.next();
            kh_inp.nextLine();
        }
        s = s.toUpperCase();
        setSex(s);
        //=========================================Nhập ngày sinh=====================================
        System.out.print("-Ngày sinh : ");
        s = kh_inp.next();
        kh_inp.nextLine();
        while(!kt.soBirth(s)){
            System.err.println("Lỗi nhập ngày sinh. Hãy nhập lại. ");
            System.out.print("Ngày sinh : ");
            s = kh_inp.next();
            kh_inp.nextLine();
        }
        s = s.replace('.', '/');
        s = s.replace("-", "/");
        setBirth(s);
        //=========================================Nhập số điện thoại================================
        System.out.print("-Số điện thoại : ");
        s = kh_inp.next();
        phone = kt.ktphone(s);
        kh_inp.nextLine();
        while(phone.equals("-1")){
            System.err.println("Lỗi nhập số điện thoại. Hãy nhập lại.");
            System.out.print("Số điện thoại : ");
            s = kh_inp.next();
            phone = kt.ktphone(s);
            kh_inp.nextLine();
        }
        //=======================================Nhập địa chỉ============================================
        System.out.print("-Địa chỉ : ");
        s = kh_inp.nextLine();
        setDC(s);
//        kh_inp.close();
    }
    
    public void set(Vector<KHACHHANG> a){//==================================Hàm nhập xét có trùng ID ko===================
        Scanner kh_inp = new Scanner(System.in);
        String s;
        int i;
        boolean t = true;
        //====================Nhập Mã khách hàng===============================
        System.out.print("-Mã khách hàng : ");
        s = kh_inp.next();
        kh_inp.nextLine();
        for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(s)) t = false;
        while(!t){
            t = true;
            System.err.println("Lỗi nhập mã khách hàng. Hãy nhập lại. ");
            System.out.print("Mã khách hàng : ");
            s = kh_inp.next();
            kh_inp.nextLine();
            for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(s)) t = false;
        }
        setID(s);
        //=========================Nhập tên khách hàng===========================
        System.out.print("-Tên : ");
        s = kh_inp.nextLine();
        while(!kt.ktname(s)){
            System.err.println("Lỗi nhập tên. Hãy nhập lại. ");
            System.out.print("Tên : ");
            s = kh_inp.nextLine();
        }
        for(i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') break;
        s = s.substring(i);
        for(i = s.length()-1; i >= 0; --i) if(s.charAt(i) != ' ') break;
        s = s.substring(0, i+1);
        s = s.toUpperCase();
        setName(s);
        //======================================Nhập giới tính========================================
        System.out.print("-Giới tính : ");
        s = kh_inp.next();
        kh_inp.nextLine();
        while(!kt.ktsex(s)){
            System.err.println("Lỗi nhập giới tính. Hãy nhập lại. ");
            System.out.print("Giới tính : ");
            s = kh_inp.next();
            kh_inp.nextLine();
        }
        s = s.toUpperCase();
        setSex(s);
        //=========================================Nhập ngày sinh=====================================
        System.out.print("-Ngày sinh : ");
        s = kh_inp.next();
        kh_inp.nextLine();
        while(!kt.soBirth(s)){
            System.err.println("Lỗi nhập ngày sinh. Hãy nhập lại. ");
            System.out.print("Ngày sinh : ");
            s = kh_inp.next();
            kh_inp.nextLine();
        }
        s = s.replace('.', '/');
        s = s.replace("-", "/");
        setBirth(s);
        //=========================================Nhập số điện thoại================================
        System.out.print("-Số điện thoại : ");
        s = kh_inp.next();
        phone = kt.ktphone(s);
        kh_inp.nextLine();
        while(phone.equals("-1")){
            System.err.println("Lỗi nhập số điện thoại. Hãy nhập lại.");
            System.out.print("Số điện thoại : ");
            s = kh_inp.next();
            phone = kt.ktphone(s);
            kh_inp.nextLine();
        }
        //======================================Nhập địa chỉ================================================
        System.out.print("-Địa chỉ : ");
        s = kh_inp.nextLine();
        setDC(s);
//        kh_inp.close();
    }
    
    public void xuat(){
        System.out.format("%-20s%-30s%-15s%-20s%-10d%-20s%-50s\n",ID, name, sex, birth, age, phone, DC);
    }
    
    public static void main(String[] args){
        StandardCharsets.UTF_8.name();
        KHACHHANG cc = new KHACHHANG();
        cc.set();
        cc.xuat();
    }
}

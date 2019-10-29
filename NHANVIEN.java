/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Do_an;

import java.util.Scanner;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author FPT SHOP
 */
public class NHANVIEN extends HUMAN{
    protected String pass;
    private KTso kt = new KTso();

    public NHANVIEN() {
        super();
        pass = "";
    }

    public NHANVIEN(String ID, String pass, String name, String sex, String birth, String age, String phone, String DC) {
        super(ID, name, sex, birth, age, phone, DC);
        this.pass = pass;
    }

    public NHANVIEN(String ID, String pass, String name, String sex, String birth, String phone, String DC) {
        super(ID, name, sex, birth, phone, DC);
        this.pass = pass;
    }
    
    public void setPass(String s){
        pass = s;
    }
    
    public void set(){//=============================Hàm nhập không xét trùng số ID===============================
        Scanner nv_inp = new Scanner(System.in);
        String s;
        int i;
        //====================Nhập Mã nhân viên===============================
        System.out.print("-Mã nhân viên : ");
        setID(nv_inp.next());
        nv_inp.nextLine();
        //========================Nhập pass=====================================
        System.out.print("-Mật khẩu : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        while(!kt.ktPass(s)){
            System.err.println("");
        }
        setPass(s);
        //=========================Nhập tên nhân viên===========================
        System.out.print("-Tên : ");
        s = nv_inp.nextLine();
        while(!kt.ktname(s)){
            System.err.println("Lỗi nhập tên. Hãy nhập lại. ");
            System.out.print("Tên : ");
            s = nv_inp.nextLine();
        }
        for(i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') break;
        s = s.substring(i);
        for(i = s.length()-1; i >= 0; --i) if(s.charAt(i) != ' ') break;
        s = s.substring(0, i+1);
        setName(s);
        //======================================Nhập giới tính========================================
        System.out.print("-Giới tính : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        while(!kt.ktsex(s)){
            System.err.println("Lỗi nhập giới tính. Hãy nhập lại. ");
            System.out.print("Giới tính : ");
            s = nv_inp.next();
            nv_inp.nextLine();
        }
        s = s.toUpperCase();
        setSex(s);
        //=========================================Nhập ngày sinh=====================================
        System.out.print("-Ngày sinh : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        while(!kt.soBirth(s)){
            System.err.println("Lỗi nhập ngày sinh. Hãy nhập lại. ");
            System.out.print("Ngày sinh : ");
            s = nv_inp.next();
            nv_inp.nextLine();
        }
        s = s.replace('.', '/');
        s = s.replace("-", "/");
        setBirth(s);
        //=========================================Nhập số điện thoại================================
        System.out.print("-Số điện thoại : ");
        s = nv_inp.next();
        phone = kt.ktphone(s);
        nv_inp.nextLine();
        while(phone.equals("-1")){
            System.err.println("Lỗi nhập số điện thoại. Hãy nhập lại.");
            System.out.print("Số điện thoại : ");
            s = nv_inp.next();
            phone = kt.ktphone(s);
            nv_inp.nextLine();
        }
        //=======================================Nhập địa chỉ============================================
        System.out.print("-Địa chỉ : ");
        s = nv_inp.nextLine();
        setDC(s);
//        nv_inp.close();
    }
    
    public void set(Vector<NHANVIEN> a){//==================================Hàm nhập xét có trùng ID ko===================
        Scanner nv_inp = new Scanner(System.in);
        String s;
        int i;
        boolean t = true;
        //====================Nhập Mã nhân viên===============================
        System.out.print("-Mã nhân viên : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(s)) t = false;
        while(!t){
            t = true;
            System.err.println("Lỗi nhập mã nhân viên. Hãy nhập lại. ");
            System.out.print("Mã nhân viên : ");
            s = nv_inp.next();
            nv_inp.nextLine();
            for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(s)) t = false;
        }
        setID(s);
        //========================Nhập pass=====================================
        System.out.print("-Mật khẩu : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        setPass(s);
        //=========================Nhập tên nhân viên===========================
        System.out.print("-Tên : ");
        s = nv_inp.nextLine();
        while(!kt.ktname(s)){
            System.err.println("Lỗi nhập tên. Hãy nhập lại. ");
            System.out.print("Tên : ");
            s = nv_inp.nextLine();
        }
        for(i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') break;
        s = s.substring(i);
        for(i = s.length()-1; i >= 0; --i) if(s.charAt(i) != ' ') break;
        s = s.substring(0, i+1);
        s = s.toUpperCase();
        setName(s);
        //======================================Nhập giới tính========================================
        System.out.print("-Giới tính : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        while(!kt.ktsex(s)){
            System.err.println("Lỗi nhập giới tính. Hãy nhập lại. ");
            System.out.print("Giới tính : ");
            s = nv_inp.next();
            nv_inp.nextLine();
        }
        s = s.toUpperCase();
        setSex(s);
        //=========================================Nhập ngày sinh=====================================
        System.out.print("-Ngày sinh : ");
        s = nv_inp.next();
        nv_inp.nextLine();
        while(!kt.soBirth(s)){
            System.err.println("Lỗi nhập ngày sinh. Hãy nhập lại. ");
            System.out.print("Ngày sinh : ");
            s = nv_inp.next();
            nv_inp.nextLine();
        }
        s = s.replace('.', '/');
        s = s.replace("-", "/");
        setBirth(s);
        //=========================================Nhập số điện thoại================================
        System.out.print("-Số điện thoại : ");
        s = nv_inp.next();
        phone = kt.ktphone(s);
        nv_inp.nextLine();
        while(phone.equals("-1")){
            System.err.println("Lỗi nhập số điện thoại. Hãy nhập lại.");
            System.out.print("Số điện thoại : ");
            s = nv_inp.next();
            phone = kt.ktphone(s);
            nv_inp.nextLine();
        }
        //======================================Nhập địa chỉ================================================
        System.out.print("-Địa chỉ : ");
        s = nv_inp.nextLine();
        setDC(s);
    //    nv_inp.close();
    }
    
    public void xuat(){
        System.out.format("%-20s%-20s%-30s%-15s%-20s%-10d%-20s%-50s\n",ID, pass, name, sex, birth, age, phone, DC);
    }
    
    public static void main(String[] args){
        NHANVIEN cc = new NHANVIEN();
        cc.set();
        cc.set();
        cc.xuat();
    }
}

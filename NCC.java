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
import java.util.Scanner;
import java.util.List;
import java.util.Vector;

public class NCC extends TOCHUC{
    private KTso kt = new KTso();

    public NCC(String ID, String name, String phone, String email, String DC) {
        super(ID, name, phone, email, DC);
    }

    public NCC() {
        super();
    }
    
    public void set(Vector<NCC> a){//=====================================Hàm nhập nhà cung cấp xét theo ID===============
        Scanner inp = new Scanner(System.in);
        String s;
        int i;
        boolean t = true;
        //======================================Nhập Mã nhà cung cấp============
        System.out.print("-Mã nhà cung cấp : ");
        s = inp.next();
        inp.nextLine();
        for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(s)){
            t = false;
            break;
        }
        while(!t){
            t = true;
            System.err.println("Lỗi nhập mã nhà cung cấp. Hãy nhập lại.");
            System.out.print("Mã nhà cung cấp : ");
            s = inp.next();
            inp.nextLine();
            for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(s)){
                t = false;
                break;
            }
        }
        setID(s);
        //============================Nhập tên nhà cung cấp=====================
        System.out.print("-Tên nhà cung cấp : ");
        setName(inp.nextLine().toUpperCase());
        //============================Nhập số điện thoại========================\
        System.out.print("-Số điện thoại : ");
        s = inp.next();
        inp.nextLine();
        while(kt.ktphone(s).equals("-1")){
            System.err.println("Lỗi nhập số điện thoại. Hãy nhập lại. ");
            System.out.print("Số điện thoại : ");
            s = inp.next();
            inp.nextLine();
        }
        setPhone(s);
        //===========================Nhập email=================================
        System.out.print("-Email : ");
        s = inp.next();
        inp.nextLine();
        while(!kt.ktemail(s)){
            System.err.println("Lỗi nhập email. Hãy nhập lại. ");
            System.out.print("Email : ");
            s = inp.next();
            inp.nextLine();
        }
        setEmail(s);
        //=========================Nhập địa chỉ=================================
        System.out.print("-Địa chỉ : ");
        setDC(inp.nextLine());
    }
    
    public void xuat(){
        System.out.format("%-20s%-30s%-15s%-30s%-50s", ID, name, phone, email, DC);
    }
    
    public static void main(String[] args){
        Vector<NCC> a = new Vector<>();
        NCC cc = new NCC();
        cc.set(a);
        cc.xuat();
    }
}

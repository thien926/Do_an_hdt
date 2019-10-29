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
import java.util.Vector;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class DSKH {
    protected Vector<KHACHHANG> a = new Vector<>();

    public DSKH() throws IOException{
    }

    public Vector<KHACHHANG> getDSKH() {
        return a;
    }
    //==============================Lấy thông tin của 1 khách hàng theo ID======
    public KHACHHANG get1kh(String ID){
        int i = 0;
        for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(ID)){
            return a.get(i);
        }
        return null;
    }
    //===========================Lấy thông tin của 1 khách hàng theo ID và xuất ra, cần getfileDSKH trước=================
    public void get1kh(){
        Scanner inp = new Scanner(System.in);
        String s;
        System.out.print("Nhập mã khách hàng cần tìm : ");
        s = inp.next();
        inp.nextLine();
        KHACHHANG cc = get1kh(s);
        if(cc != null){
            System.out.format("\n**************************************************************%20s*******************"
                + "*********************************************************\n", 
                "THÔNG TIN KHÁCH HÀNG CẦN TÌM");
            System.out.format("%-20s%-30s%-15s%-20s%-10s%-20s%-50s\n","Mã khách hàng", "Tên", "Giới tính", "Ngày sinh", "Tuổi", "Số điện thoại", "Địa chỉ");
            System.out.format("%-20s%-30s%-15s%-20s%-10d%-20s%-50s\n",cc.ID, cc.name, cc.sex, cc.birth, cc.age, cc.phone, cc.DC);
        }
        else{
            System.err.println("Không tìm thấy thông tin của khách hàng cần tìm. ");
        }
//        inp.close();
    }
    
    public void setDSKH(Vector<KHACHHANG> a) {
        this.a = a;
    }
    
    public boolean getfileDSKH(){
        try{
            File inp = new File("DSKH.txt");
            
            //Nếu file không tồn tại thì tạo file
            if(!inp.exists()){
                inp.createNewFile();
            }
            Scanner fi = new Scanner(inp);
            Vector<String> ss = new Vector<>();
            int i = 0, j = 0;
            while(fi.hasNextLine()){
//               s = s + fi.nextLine() + "\r\n";
                String s = fi.nextLine();
                ss.add(s);
            }
//            String[] ss = s.split("\r?\n");
//            int i = 0, j = 0, k = ss.length/7;
            int k = ss.size()/7;
            for(i = 0; i < k; i++){
                KHACHHANG cc = new KHACHHANG(ss.get(j+0), ss.get(j+1), ss.get(j+2), ss.get(j+3), ss.get(j+4), ss.get(j+5), ss.get(j+6));
                a.add(cc);
                j = j + 7;
            }
            ss.clear();
            fi.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e);
            return false;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public boolean add(KHACHHANG aa){
        try{
            FileOutputStream out = new FileOutputStream("DSKH.txt", true);
            PrintWriter fo = new PrintWriter(out);
            int i;
            for(i = 0; i < a.size(); i++) if(a.get(i).ID == aa.ID){
                System.err.println("Đã tồn tại mã khách hàng. ");
                return false;
            }
            a.add(aa);
            fo.println(aa.ID + "\n" + aa.name + "\n" + aa.sex + "\n" + aa.birth + "\n" + aa.age + "\n" + aa.phone + "\n" +
                    aa.DC);
            fo.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e);
            return false;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public void add(){
        System.out.println("                           *******************************Nhập thông tin khách hàng cần thêm***************************"
                + "****                                   ");
        KHACHHANG cc = new KHACHHANG();
        cc.set(a);
        if(add(cc)) System.out.println("Thêm thành công. ");
        else System.out.println("Thêm thất bại. ");
    }
    
    //=================================Xóa 1 đối tượng khách hàng(Trước khi xóa cần getfileDSKH)============================
    public boolean move(KHACHHANG c){
        int i;
        for(i = 0; i < a.size(); i++) if(c.equals(a.get(i))){
            try{
                FileOutputStream out = new FileOutputStream("DSKH.txt");
                PrintWriter fo = new PrintWriter(out);
                a.remove(i);
                for(i = 0; i < a.size(); i++) fo.println(a.get(i).ID + "\n" + a.get(i).name + "\n" + a.get(i).sex + "\n" + a.get(i).birth + "\n" + a.get(i).age + "\n" + a.get(i).phone + "\n" +
                    a.get(i).DC);
                fo.close();
            }
            catch(FileNotFoundException e){
                System.err.println(e);
                return false;
            }
            catch(Exception e){
                System.err.println(e);
            }
            return true;
        }
        return false;
    }
    //=================================Xóa những khách hàng theo ID(Trước khi xóa cần getfileDSKH)============================
    public boolean moveAll(KHACHHANG c){
        boolean t = false;
        try{
            FileOutputStream out = new FileOutputStream("DSKH.txt");
            PrintWriter fo = new PrintWriter(out);
            int i;
            t = false;
            for(i = 0; i < a.size(); i++) if(c.equals(a.get(i))){
                a.remove(i);
                t = true;
            }
            for(i = 0; i < a.size(); i++) fo.println(a.get(i).ID + "\n" + a.get(i).name + "\n" + a.get(i).sex + "\n" + a.get(i).birth + "\n" + a.get(i).age + "\n" + a.get(i).phone + "\n" +
                    a.get(i).DC);
            fo.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e);
            return false;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return t;
    }
    //=================================Xóa 1 khách hàng theo ID(Trước khi xóa cần getfileDSKH)==============================
    public boolean move(String ID){
        try{
            FileOutputStream out = new FileOutputStream("DSKH.txt");
            PrintWriter fo = new PrintWriter(out);
            int i;
            for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(ID)){
                a.remove(i);
                for(int j = 0; j < a.size(); j++) fo.println(a.get(j).ID + "\n" + a.get(j).name + "\n" + a.get(j).sex + "\n" + a.get(j).birth + "\n" + a.get(j).age + "\n" + a.get(j).phone + "\n" +
                    a.get(j).DC);
                fo.close();
                return true;
            }
            fo.close();
        }
        catch(FileNotFoundException e){
            System.err.println(e);
            return false;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return false;
    }
    //=================================Xóa những khách hàng theo ID(Trước khi xóa cần getfileDSKH)==============================
    public boolean moveAll(String ID){
        try{
            FileOutputStream out = new FileOutputStream("DSKH.txt");
            PrintWriter fo = new PrintWriter(out);
            int i;
            boolean t = false;
            for(i = 0; i < a.size(); i++) if(a.get(i).ID.equals(ID)){
                a.remove(i);
                t = true;
            }
            if(t){
                for(i = 0; i < a.size(); i++) fo.println(a.get(i).ID + "\n" + a.get(i).name + "\n" + a.get(i).sex + "\n" + a.get(i).birth + "\n" + a.get(i).age + "\n" + a.get(i).phone + "\n" +
                    a.get(i).DC);
            }
            fo.close();
            return t;
        }
        catch(FileNotFoundException e){
            System.err.println(e);
            return false;
        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
    }
    
    public void xuat(){
        System.out.format("\n**************************************************************%20s*******************"
                + "*********************************************************\n", 
                "DANH SÁCH KHÁCH HÀNG");
        System.out.format("%-20s%-30s%-15s%-20s%-10s%-20s%-50s\n","Mã khách hàng", "Tên", "Giới tính", "Ngày sinh", "Tuổi", "Số điện thoại", "Địa chỉ");
        for(int i = 0; i < a.size(); i++) a.get(i).xuat();
    }
    
    public static void main(String[] args) throws IOException{
        DSKH cc = new DSKH();
        cc.getfileDSKH();
//        cc.get1kh();
        cc.add();
        cc.xuat();
    }
}


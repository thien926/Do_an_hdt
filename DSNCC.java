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
import java.io.*;
import java.util.Vector;
import java.util.List;

public class DSNCC {
    protected Vector<NCC> a = new Vector<>();

    public DSNCC() throws IOException{
    }
    
    public DSNCC(Vector<NCC> b)throws IOException{
        a = b;
    }

    public Vector<NCC> getDSNCC() {
        return a;
    }
    //=============================kiếm 1 nhà cung cấp theo ID, gọi hàm getfileDSNCC trc==================
    public NCC get1NCC(String ID){
        for(int i = 0; i < a.size(); i++) if(a.get(i).equals(ID)) return a.get(i);
        return null;
    }
    
    //============================kiếm 1 nhà cung cấp theo ID và xuất, gọi hàm getfileDSNCC trc===========
    public void get1NCC(){
        String s;
        Scanner inp = new Scanner(System.in);
        System.out.println("Nhập mã nhà cung cấp cần tìm : ");
        s = inp.next();
        inp.nextLine();
        while()
    }

    public void setDSNCC(Vector<NCC> a) {
        this.a = a;
    }
    
    public boolean getfileNCC(){
        try{
            File inp = new File("DSNCC.txt");
            if(!inp.exists()){
                inp.createNewFile();
            }
            Scanner fi = new Scanner(inp);
            Vector<String> ss = new Vector<>();
            int i = 0, j = 0;
            while(fi.hasNextLine()){
                String s = fi.nextLine();
                ss.add(s);
            }
            int k = ss.size()/5;
            for(i = 0; i < k; i++){
                NCC cc = new NCC(ss.get(0), ss.get(1), ss.get(2), ss.get(3), ss.get(4));
                a.add(cc);
                j = j + 5;
            }
            ss.clear();
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
}

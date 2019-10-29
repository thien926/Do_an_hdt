/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Do_an;

import java.util.regex.Pattern;

/**
 *
 * @author FPT SHOP
 */
public class KTso {
    private String N = "[\\d]*";
    private String Z = "[\\d]*+|[-][\\d]*";
    private String R = "[\\d]*+|[-][\\d]*+|[\\d]*[.][\\d]*+|[-][\\d]*[.][\\d]*";
    private String R_ = "[\\d]*+|[\\d]*[.][\\d]*";
    private String N_ = "[1-9][\\d]*";
    private String birth = "([0-9]{1,2}/[0-9]{1,2}/[0-9]{4})|([0-9]{1,2}-[0-9]{1,2}-[0-9]{4})|([0-9]{1,2}+[\\.]+[0-9]{1,2}+[\\.]+[0-9]{4})";
    private String sex = "(Nam)|(nam)|(Nữ)|(nữ)|(NAM)|(NỮ)|(nu)|(NU)|(Nu)";
    private String name = "([a-zA-Z]|[\\s])*";
    private String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public KTso(){}
    
    public boolean soN(String s){
        if(Pattern.matches(N, s)) return true;
        return false;
    }
    
    public boolean soZ(String s){
        if(Pattern.matches(Z, s)) return true;
        return false;
    }
    
    public boolean soR(String s){
        Pattern pa = Pattern.compile(R);
        if(Pattern.matches(R, s)) return true;
        return false;
    }
    
    public boolean soR_(String s){
        if(Pattern.matches(R_, s)) return true;
        return false;
    }
    
    public boolean soN_(String s){
        if(Pattern.matches(N_, s)) return true;
        return false;
    }
    
    public boolean soBirth(String s){
        if(Pattern.matches(birth, s)){
            String[] ss;
            if(s.indexOf('/') >= 0){
                ss = s.split("/");
            }
            else if(s.indexOf('-') >= 0){
                ss = s.split("-");
            }
            else{
                ss = s.split("\\.");
            }
            switch(Integer.parseInt(ss[1])){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:{
                    int day = Integer.parseInt(ss[0]);
                    return (day > 0 && day <= 31);
                }
                case 4:
                case 6:
                case 9:
                case 11:{
                    int day = Integer.parseInt(ss[0]);
                    return (day > 0 && day <= 30);
                }
                case 2:{
                    int day = Integer.parseInt(ss[0]);
                    if(day <= 0 || day > 29) return false;
                    if(day <= 28) return true;
                    int year = Integer.parseInt(ss[2]);
                    if(year % 100 == 0 && year % 400 == 0) return true;
                    if(year % 4 == 0) return true;
                    return false;
                }
            }
        }
        return false;
    }
    
    public int birthyear(String s){
        if(soBirth(s)){
            if(s.indexOf('/') > 0){
                String[] ss = s.split("/");
                return Integer.parseInt(ss[2].toString());
            }
            else if(s.indexOf("\\.") > 0){
                String[] ss = s.split("\\.");
                return Integer.parseInt(ss[2].toString());
            }
        }
        return 0;
    }
    
    public boolean ktsex(String s){
        return Pattern.matches(sex, s);
    }
    
    public String ktphone(String s){
        if(s.length() >= 10 && s.length() <= 11){
            if(s.charAt(0) == '0'){
                return s;
            }
        } 
        return "-1";
    }
    
    public boolean ktname(String s){/*
        if (Pattern.matches(name, s)){
            int i;
            for(i = 0; i < s.length(); i++) if(s.charAt(i) != ' ') break;
            s = s.substring(i);
            for(i = s.length()-1; i >= 0; --i) if(s.charAt(i) != ' ') break;
            s = s.substring(0, i+1);
            for(i = 0; i < s.length(); i++) if(s.charAt(i) == ' ') return true;
        }
        return false;*/
        return true;
    }
    
    public boolean ktemail(String s){
        return Pattern.matches(email, s);
    }
    
    public boolean ktPass(String s){
        return (s.length() >= 8 && s.length() <= 20);
    }
    
    public static void main(String[] args){
        KTso cc = new KTso();
        System.out.println(cc.ktemail("thien.070202@gmail.com"));
    }
}

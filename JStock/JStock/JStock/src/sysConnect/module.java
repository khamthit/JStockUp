/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysConnect;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import static sysConnect.AESencrp.decrypt;

/**
 *
 * @author Malimar
 */
public class module {
    public static String lblUsers;
    public static String Menu_emp_nbr;
    public static String DBUser;
    public static String DBPass;
    public static String DBPort;
    public static String DB_Ser;
    public static String DB_IP;
    
    public static Connection getConnection(){
        try {
//this is connect with Access
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String db = null;
        String us = null;
        String pas = null;
        String dbs= null;
        String port = null;
        String ip= null;
        
//       connection=DriverManager.getConnection("jdbc:ucanaccess://C:\\Conn/Datasoure.accdb");
//        statement = connection.createStatement();
//        resultSet = statement.executeQuery("SELECT * FROM Tb_Datasoure");
//        if(resultSet.next()) {
//            port = decrypt(resultSet.getString("ports"));
//            dbs = decrypt(resultSet.getString("DBName"));
//            String s = decrypt(resultSet.getString("servername"));
//            String ips = decrypt(resultSet.getString("ServerIP"));
//            db = "jdbc:sqlserver://"+s+"; DatabaseName ="+dbs;    
//            ip = "jdbc:sqlserver://"+ips+":"+port+"; DatabaseName = "+dbs;
//            us = decrypt(resultSet.getString("users"));
//            pas = decrypt(resultSet.getString("passwords"));
//        }
//        Connection c = DriverManager.getConnection(db,us,pas);
//        return c;  

            //String url = "jdbc:sqlserver://DESKTOP-CBH2504\\ADMIN; databaseName = JStock";
            String url = "jdbc:sqlserver://LAPTOP-UJFR8QFD\\ADMIN:1433; databaseName = JStock";
            us = "sa";
            pas = "operator@123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c= DriverManager.getConnection(url,us,pas);
            return c;
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, e);
            //System.exit(0);
        }
        return null;
    }
    public static String TxtFileW() throws FileNotFoundException, IOException{

        ArrayList<String> obj = new ArrayList<String>();
//         ArrayList<String> readObj = new ArrayList<String>();   
        //obj.add("jdbc:sqlserver://PC-M01\\SQLEXPRESS; databaseName = HRMS");
        obj.add(DB_Ser);
        obj.add(DB_IP);
        obj.add(DBUser);
        obj.add(DBPass);
        obj.add(DBPort);  
        //obj.add("jdbc:sqlserver://192.168.99.127: "+ obj.add(DBPort) +"; databaseName = HRMS");
        FileOutputStream fop = null;
            File file;
            //String content = "This is the text content";
            try {
                    file = new File("src/Connection/Datasource.txt");
                    fop = new FileOutputStream(file);
                    String separator = System.getProperty("line.separator");

                    // if file doesnt exists, then create it
                    if (!file.exists()) {
                            file.createNewFile();
                    }
                    // get the content in bytes
                    String Rtxt=TxtEncrpt(obj.get(0), 10)+ separator;
                    byte[] contentInBytes = Rtxt.getBytes();
                    fop.write(contentInBytes);
                    
                    Rtxt=TxtEncrpt(obj.get(1), 10)+ separator;
                    contentInBytes = Rtxt.getBytes();
                    fop.write(contentInBytes);        
                    
                    Rtxt=TxtEncrpt(obj.get(2), 10)+ separator;
                    contentInBytes = Rtxt.getBytes();
                    fop.write(contentInBytes);   
                    
                    Rtxt=TxtEncrpt(obj.get(3), 10)+ separator;
                    contentInBytes = Rtxt.getBytes();
                    fop.write(contentInBytes);  
                    
                    Rtxt=TxtEncrpt(obj.get(4), 10)+ separator;
                    contentInBytes = Rtxt.getBytes();
                    fop.write(contentInBytes);  
                    
                    fop.flush();
                    fop.close();
                    //System.out.println("Done");

                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                            if (fop != null) {
                                    fop.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
        return null;
    }
    public static String TxtEncrpt(String txt, int p){

        try {
             char[] chars = "@#$%&*()¢£¤©¼_+?tabcdefghijkWlmnopqrustAuvwxyz".toCharArray();
             StringBuilder sb = new StringBuilder();
             Random random = new Random();
             for (int i = 0; i < p; i++) {
                 char c = chars[random.nextInt(chars.length)];
                 sb.append(c);
             }

             String r="";
             for(int x = 0; x < txt.length(); x = x + 1) {
                 char c = txt.charAt(x); 
                 int v = Integer.valueOf(c);
             //    int s = Integer.valueOf(c)%10;

                 switch(x) {
                     case 0 :
                       v=v+99+p; 
                       break;                        
                     case 1 :
                       v=v+10+p; 
                       break;
                    case 2 :
                       v=v+5+p; 
                       break;
                    case 3 :
                       v=v+2+p;
                       break;
                    case 4 :
                       v=v+17+p;
                       break;
                    case 5 :
                       v=v+20+p;
                       break;
                    case 6 :
                       v=v+50+p; 
                       break;
                    case 7 :
                       v=v+12+p; 
                       break;
                    case 8 :
                       v=v+17+p;
                       break;
                    case 9 :
                       v=v+69+p;
                       break;
                    default:
                       v=v+79+p;
                   }
                String ch = String.valueOf(Character.toChars(v)); 
                r=r+ch; 
               // System.out.print("Encrpt value of x : " + c +" Unicode : " + Integer.valueOf(c) +" Plus : " +v +" Char : "+ ch+ " Return : "+ r);
               // System.out.print("\n");
             }

             txt=sb.toString()+r;

            } catch (Exception e) {
                    e.printStackTrace();
            }
        return txt;
    }  
    public static String TxtDecrpt(String txt, int p){

        try {
             String r="";
             txt =txt.substring(p);
             for(int x = 0; x < txt.length(); x = x + 1) {
                 char c = txt.charAt(x); 
                 int v = Integer.valueOf(c);
               //  int s = Integer.valueOf(c)%10;

                 switch(x) {
                    case 0 :
                       v=v-99-p;
                       break;                      
                    case 1 :
                       v=v-10-p; 
                       break;
                    case 2 :
                       v=v-5-p; 
                       break;
                    case 3 :
                       v=v-2-p;
                       break;
                    case 4 :
                       v=v-17-p;
                       break;
                    case 5 :
                       v=v-20-p;
                       break;
                    case 6 :
                       v=v-50-p; 
                       break;
                    case 7 :
                       v=v-12-p; 
                       break;
                    case 8 :
                       v=v-17-p;
                       break;
                    case 9 :
                       v=v-69-p;
                       break;
                    default:
                        v=v-79-p;
                   }
                String ch = String.valueOf(Character.toChars(v)); 
                r=r+ch; 
               // System.out.print("Decrpt value of x : " + c +" Unicode : " + Integer.valueOf(c) +" Plus : " +v +" Char : "+ ch+ " Return : "+ r);
               // System.out.print("\n");
             }

             txt=r;

            } catch (Exception e) {
                    e.printStackTrace();
            }
        return txt;
    } 
}

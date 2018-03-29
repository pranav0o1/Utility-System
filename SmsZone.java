/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author ravi
 */
public class SmsZone{
    
    /** Creates a new instance of SmsZone */
    public SmsZone() {
    }
    //############### Sending SMS Code 
    public void SendToSms(String msg,String mobileNumber){
     
        
        String[] str =msg.split(" ");
        String s="";
        for (int l=0;l<str.length;l++){
            s=s+str[l].toString()+"%20";
        
        }
        String TestMessage=s;
       
       String smss="http://173.45.76.227/send.aspx?username=vspace&pass=vspace123&route=trans1&senderid=vspace&numbers="+mobileNumber+"&message="+s;
//        String smss = "http://bulk1.citisms.com/sms/sendsms.sms?username=tulajaram&password=amyhv&clientid=56337&from=PTM&to="+mobileNumber+"&text="+s; 
//        String smss ="http://173.45.76.227/send.aspx?username=vspace&pass=vspace&route=trans1&senderid=vspace&numbers="+mobileNumber+"&message="+s;
        System.out.println("smslink "+smss);
        try{            
        URL ur = new URL(smss);
        URLConnection conn = ur.openConnection();        
        InputStream is = conn.getInputStream();
    
        //  HttpsURLConnection conn = (HttpsURLConnection) ur.openConnection();
        }catch(Exception ex){
            ex.printStackTrace();
        }     
    }    
    public static void main(String args[])
    {
    SmsZone sms=new SmsZone();
//    sms.SendToSms("hiii ","7507775154");
    sms.SendToSms("hiii ","8087752232");
    
    }
}

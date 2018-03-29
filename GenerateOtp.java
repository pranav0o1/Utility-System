/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.Random; 

/**
 *
 * @author tulajaram
 */
public class GenerateOtp {
    public String generateKey(){
    
    final String dCase = "abcdefghijklmnopqrstuvwxyz";
        final String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String sChar = "!#$^*";
        final String intChar = "0123456789";
        Random r = new Random();
        String pass = "";
//        SendMsg send = new SendMsg();
//        send.send(pass);
        System.out.println("Generating pass...");
        while (pass.length() != 6) {
            int rPick = r.nextInt(4);
            if (rPick == 0) {
                int spot = r.nextInt(25);
                pass += dCase.charAt(spot);
            } else if (rPick == 1) {
                int spot = r.nextInt(25);
                pass += uCase.charAt(spot);
            } else if (rPick == 2) {
                int spot = r.nextInt(5);
                //  pass += sChar.charAt(spot);
            } else if (rPick == 3) {
                int spot = r.nextInt(9);
                pass += intChar.charAt(spot);
            }
        }
        System.out.println("Generated Pass: " + pass);
        return pass;
    
    }
}

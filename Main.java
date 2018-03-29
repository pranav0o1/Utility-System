/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author tulajaram
 */
//public class Demo {
//
//    /**
//     * @param args the command line arguments
//     */
//    Socket socket;
//    DataOutputStream dos;
//    DataInputStream dis;
//
//    public void SendQr() {
//
//        try {
//            socket = new Socket("219.91.141.5", 8088);
//            dos = new DataOutputStream(socket.getOutputStream());
//            dis = new DataInputStream(socket.getInputStream());
//            String str = "<TRXU|RELCON|1,1234>";
//            dos.writeUTF(str);
////            dos.writeUTF("RELCON");
////            dos.writeUTF("2");
////            dos.writeUTF("1Ah");
//
//            String read = (String) dis.readUTF();
////            String readUTF = dis.readUTF();
////            String readUTF1 = dis.readUTF();
//            System.out.println("" + read);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
public class Main {

    public static void main(String[] args) {
        List<String> monthsList = new ArrayList<String>();
        String[] months = new DateFormatSymbols().getMonths();
        for (int i = 0; i < months.length - 1; i++) {
            String month = months[i];
//      System.out.println("month = " + month);
            monthsList.add(months[i]);
        }
        System.out.println("" + monthsList);

        Calendar cal = Calendar.getInstance();

        int get = cal.get(Calendar.MONTH);
        System.out.println("" + get);
        cal.set(Calendar.MONTH, 3);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        SimpleDateFormat df = new SimpleDateFormat("EEE_dd_MMM_yyyy");
        System.out.println(df.format(cal.getTime()));
        for (int i = 1; i < maxDay; i++) {
            cal.set(Calendar.DAY_OF_MONTH, i+1 );
            System.out.println("qq  "+df.format(cal.getTime()));
        }
    }
}
//    public static void main(String[] args) {
//        // TODO code application logic here
////        new Demo().SendQr();
////        String[] butt={"yes","No"};
////        String enro = JOptionPane.showInputDialog("Please Enter Enrollment");
//////        int showOptionDialog = JOptionPane.showOptionDialog(null, "Narrative", "Narrative", JOptionPane.WARNING_MESSAGE, 0, null, butt, butt[0]);
////        System.out.println(""+enro);
////        "EEE, d MMM yyyy HH:mm:ss Z"
////        Date d=new Date();
////                SimpleDateFormat format=new SimpleDateFormat("EEE-d-MMM-yyyy");
////                System.out.println(""+format.format(d));
//        String yourString = "abc ,xyx ,av ,";
////        str.replaceAll(str.lastIndexOf(","), "");
//        StringBuilder b = new StringBuilder(yourString);
//        b.replace(yourString.lastIndexOf(","), yourString.lastIndexOf(",") + 1, "");
//        yourString = b.toString();
//        System.out.println();
//
//    }

//}

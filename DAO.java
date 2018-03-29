/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DAO {

    int cont = 0;
    float xpos = 240;
    float ypos =  144;
    float axpos = 280f;
    float aypos = 635f;
    float ax = 10f;
    float ay = 0f;
    int almnt =  10;
    String path=System.getProperty("user.dir");//D:\\

    public void imageWariter(ArrayList rollarray, String roll, String dept,String year,String shift) {
        try {

            File f1 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + roll);
            String[] list = f1.list();
            
            
            File file = new File(path +File.separator+"IDCARD PDF"+ File.separator + dept+File.separator+year+File.separator+shift);
            file.mkdirs();
//            File filee = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + rollarray.get(0) + "-" + rollarray.get(rollarray.size() - 1) + ".pdf");
            File filee = new File(path+File.separator+"IDCARD PDF"+ File.separator + dept +File.separator+year+File.separator+shift+ File.separator + rollarray.get(0) + "-" + rollarray.get(rollarray.size() - 1) + ".pdf");
            
            System.out.println("File Path===>>>>" + filee);
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filee));
            document.open();
            for (int i = 0; i < rollarray.size(); i++) {
                Object get = rollarray.get(i);
                File f2 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + get + File.separator + get + "Frant.jpg");
                File f3 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + get + File.separator + get + "back.jpg");
                


//                if (cont==0) {

                document.add(new Paragraph("\n"));

                //Add Image
                Image image1 = Image.getInstance(f3.getAbsolutePath());
                //Fixed Positioning
                image1.setAbsolutePosition(axpos, aypos);
//                image1.setAlignment( almnt);
//                image1.setTop(almnt);
                //Scale to new height and new width of image
                image1.scaleAbsolute(xpos, ypos);
//                image1.setAbsolutePosition(axpos, aypos);
                //Add to document
                document.add(image1);
//                image1.setAlignment(iALIGN_TOP);

                Image image2 = Image.getInstance(f2.getAbsolutePath());
//                image2.setAlignment(almnt);
//                image2.setAbsolutePosition(ax, ay);
                image2.scaleAbsolute(xpos, ypos);
                document.add(image2);
//                document.top();

                almnt = almnt+80;
                aypos-=170;
//                a

//                cont++;
            }
            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public void imageWariterTech(ArrayList rollarray, String roll, String dept ,String shift) {
        try {

            File f1 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + roll);
            String[] list = f1.list();
            File file = new File(path +File.separator+"IDCARD PDF TECH"+ File.separator + dept+File.separator+shift);
            file.mkdirs();
//            File filee = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + rollarray.get(0) + "-" + rollarray.get(rollarray.size() - 1) + ".pdf");
            File filee = new File(path+File.separator+"IDCARD PDF TECH"+ File.separator + dept+File.separator+shift+ File.separator + rollarray.get(0) + "-" + rollarray.get(rollarray.size() - 1) + ".pdf");
            
            System.out.println("File Path===>>>>" + filee);
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filee));
            document.open();
            for (int i = 0; i < rollarray.size(); i++) {
                Object get = rollarray.get(i);
                File f2 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + get + File.separator + get + "Frant.jpg");
                File f3 = new File(System.getProperty("user.dir") + File.separator + dept + File.separator + get + File.separator + get + "back.jpg");
                


//                if (cont==0) {

                document.add(new Paragraph("\n"));

                //Add Image
                Image image1 = Image.getInstance(f3.getAbsolutePath());
                //Fixed Positioning
//                image1.setAlignment(almnt);
                image1.setAbsolutePosition(axpos, aypos);
//                image1.setTop(almnt);
                //Scale to new height and new width of image
                image1.scaleAbsolute(xpos, ypos);
//                image1.setAbsolutePosition(axpos, aypos);
                //Add to document
                document.add(image1);
//                image1.setAlignment(iALIGN_TOP);

                Image image2 = Image.getInstance(f2.getAbsolutePath());
//                image2.setAlignment(almnt);
//                image2.setAbsolutePosition(ax, ay);
                image2.scaleAbsolute(xpos, ypos);
                document.add(image2);
//                document.top();

//                almnt = almnt+80;
                aypos-=170;

//                cont++;
            }
            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}

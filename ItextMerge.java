/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

public class ItextMerge {
//    public static void main(String[] args) {
        public void pdfmarge(List l,String dept){
        List<InputStream> list = new ArrayList<InputStream>();
        try {
            for (int i = 0; i < l.size(); i++) {
                String get = (String) l.get(i);
                String filee =System.getProperty("user.dir")+ File.separator + dept + File.separator+ get+".pdf";
               list.add(new FileInputStream(new File(filee))); 
            }
            // Source pdfs
            
//            list.add(new FileInputStream(new File(file2))); 
            
            
            
//            list.add(new FileInputStream(new File(file3)));
//            list.add(new FileInputStream(new File(file4)));
//            list.add(new FileInputStream(new File(file5)));
//            list.add(new FileInputStream(new File(file6)));
            // Resulting pdf
            File f=new File("D:"+File.separator+"ID Card Pdf"+File.separator+dept);
            f.mkdirs();
            String result="D:"+File.separator+"ID Card Pdf"+File.separator+dept+File.separator+l.get(0)+"-"+l.get(l.size()-1)+".pdf";
            OutputStream out = new FileOutputStream(new File(result));

            doMerge(list, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Merge multiple pdf into one pdf
     * 
     * @param list
     *            of pdf input stream
     * @param outputStream
     *            output file output stream
     * @throws DocumentException
     * @throws IOException
     */
    public static void doMerge(List<InputStream> list, OutputStream outputStream)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        
        for (InputStream in : list) {
            PdfReader reader = new PdfReader(in);
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }
        
        outputStream.flush();
        document.close();
        outputStream.close();
    }
       public static void main(String[] args) {
           String last ="abca";
             String replace="";
             
//         char str = last.toUpperCase().charAt(0);
//         
//       
//                        System.out.println("str ==="+str);
//                     replace = last.replace(last.charAt(0),str);
               
           String str = "javaj";
            String cap = str.substring(0,1).toUpperCase() + str.substring(1);
             System.out.println("replac   "+cap);
                    
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class ImageBackSiderWrite {

    public void DrawBack(String Address, String contact, String dob, String bg,File file) throws IOException {
        File f = new File("Student ID2.png");
        final BufferedImage image = ImageIO.read(f);
//        "http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));
//        File f1 = new File("DSC.jpg");
//        BufferedImage bi = ImageIO.read(f1);
        Graphics g = image.getGraphics();

        g.setColor(Color.DARK_GRAY);
//    g.setFont(Font.ITALIC);
        Font myFont = new Font("Verdana", Font.PLAIN, 8);
        g.setFont(myFont);
        g.setFont(g.getFont().deriveFont(27f));
        g.drawString(Address, 200, 343);
        g.drawString(contact, 200, 510);
//        g.drawString("Information Technology", 160, 245);
        g.drawString(bg, 200, 460);
        g.drawString(dob, 200, 553);
//        BufferedImage tempJPG = resizeImage(bi, bi.getWidth(), bi.getHeight());
//        g.drawImage(tempJPG, 515, 120, null);
//        File f2 = new File("Sachin_tendulkar_signature.png");
//        BufferedImage image1 = ImageIO.read(f2);
//        g.drawImage(image1, 515, 330, null);
//        boolean italic = g.getFont().isItalic();
//        g.setFont();
        g.dispose();
        Rotation90Image ri=new Rotation90Image();
        BufferedImage createRotatedCopy = ri.createRotatedCopy11(image);
        ImageIO.write(createRotatedCopy, "png", file);
//        imagewrite im=new imagewrite();
//        im.ResizeImage();
    }
    
    
     public void DrawBackTech(String Address, String contact, File file) throws IOException {
        File f = new File("teachers2.png");
        final BufferedImage image = ImageIO.read(f);
//        "http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));
//        File f1 = new File("DSC.jpg");
//        BufferedImage bi = ImageIO.read(f1);
        Graphics g = image.getGraphics();

        g.setColor(Color.DARK_GRAY);
//    g.setFont(Font.ITALIC);
        Font myFont = new Font("Verdana", Font.PLAIN, 8);
        g.setFont(myFont);
        g.setFont(g.getFont().deriveFont(27f));
        g.drawString(Address, 200, 407);
        g.drawString(contact, 200, 550);
//        g.drawString("Information Technology", 160, 245);
//        g.drawString("O+ve", 200, 460);
//        g.drawString(dob, 200, 553);
//        BufferedImage tempJPG = resizeImage(bi, bi.getWidth(), bi.getHeight());
//        g.drawImage(tempJPG, 515, 120, null);
//        File f2 = new File("Sachin_tendulkar_signature.png");
//        BufferedImage image1 = ImageIO.read(f2);
//        g.drawImage(image1, 515, 330, null);
//        boolean italic = g.getFont().isItalic();
//        g.setFont();
        g.dispose();
        Rotation90Image ri=new Rotation90Image();
        BufferedImage createRotatedCopy = ri.createRotatedCopy11(image);
        ImageIO.write(createRotatedCopy, "png", file);
//        imagewrite im=new imagewrite();
//        im.ResizeImage();
    }
    
    
    
private Image image;
    public void rotate(File f) throws IOException {
        BufferedImage read = ImageIO.read(f);
    AffineTransform identity = new AffineTransform();

    Graphics2D g2d = (Graphics2D) read.getGraphics();
    AffineTransform trans = new AffineTransform();

    trans.setTransform (identity);

    trans.rotate (Math.PI/2 );
    g2d.drawImage (read, trans,  null);
    g2d.dispose();
    File f1=new File("abc.png");
    ImageIO.write(read, "png", f1);
    }
    
    public static void main(String[] args) throws IOException {
        ImageBackSiderWrite write=new ImageBackSiderWrite();
        File f=new File("1234.png");
        write.DrawBackTech("Abcd","9999999",f);
        write.rotate(f);
    }
    
}

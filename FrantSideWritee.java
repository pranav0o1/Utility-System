/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class FrantSideWritee {

    public void ForntSide(File userimg, String name, String roll, String dept, String year, String shift, File file, String last) throws IOException {
        File f = new File(System.getProperty("user.dir") + File.separator + "Student ID1.png");
        final BufferedImage image = ImageIO.read(f);
//        "http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));
//        File f1 = new File(userimg);
        BufferedImage bi = ImageIO.read(userimg);
        Graphics g = image.getGraphics();
        Graphics g1 = image.getGraphics();
        Color HSBtoRGB = Color.getHSBColor((float) 1.0, (float) 171.0, (float) 196.0);
        g.setColor(Color.DARK_GRAY);
        g1.setColor(new Color(4, 119, 150));
//    g.setFont(Font.ITALIC);
        Font myFont = new Font("Arial", Font.BOLD, 8);
        g.setFont(myFont);
        g.setFont(g.getFont().deriveFont(37f));
        g1.setFont(myFont);
        g1.setFont(g1.getFont().deriveFont(40f));
        int size = name.length() + last.length();
        System.out.println("size :" + size);
        if (size > 21) {
            g.drawString(name + " " + last, 102, 588);
            System.out.println("1");
            } else if (size > 18 && size < 22) {
            g.drawString(name + " " + last, 130, 588);
            System.out.println("2");
        } else if (size > 15 && size < 19) {
            g.drawString(name + " " + last, 150, 588);
            System.out.println("2");
        } else if (size < 16 && size > 12) {
            g.drawString(name + " " + last, 180, 588);
            System.out.println("3");
        } else {
            g.drawString(name + " " + last, 190, 588);
            System.out.println("4");
        }
        g.drawString(roll, 290, 670);
        g1.drawString(dept, 500, 245);
        g1.drawString(year, 335, 850);
        g1.drawString(shift, 520, 850);
        BufferedImage tempJPG = resizeImage(bi, bi.getWidth(), bi.getHeight());
        g.drawImage(tempJPG, 220, 290, null);

//        File f2 = new File(singimg);
//        BufferedImage image1 = ImageIO.read(f2);
//        g.drawImage(image1, 515, 330, null);
//        boolean italic = g.getFont().isItalic();
//        g.setFont();
        g.dispose();
        g1.dispose();
        Rotation90Image ri = new Rotation90Image();
        BufferedImage createRotatedCopy = ri.createRotatedCopy(image);
        ImageIO.write(createRotatedCopy, "png", file);
//        imagewrite im=new imagewrite();
//        im.ResizeImage();
    }

    public void ForntSideTech(File userimg, String name, String dept, File file, String last, String desig, String shift) throws IOException {
        File f = new File(System.getProperty("user.dir") + File.separator + "teachers1.png");
        final BufferedImage image = ImageIO.read(f);
//        "http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));
//        File f1 = new File(userimg);
        BufferedImage bi = ImageIO.read(userimg);
        Graphics g = image.getGraphics();
        Graphics g1 = image.getGraphics();
        Color HSBtoRGB = Color.getHSBColor((float) 49.0, (float) 215.0, (float) 198.0);
        g1.setColor(HSBtoRGB);
        g.setColor(Color.DARK_GRAY);
//    g.setFont(Font.ITALIC);
        Font myFont = new Font("Arial", Font.BOLD, 10);
        g.setFont(myFont);
        g.setFont(g.getFont().deriveFont(27f));
        g1.setFont(myFont);
        g1.setFont(g1.getFont().deriveFont(42f));
        g.drawString(name + " " + last, 220, 554);
//        g.drawString(Id, 200, 585);
        g1.drawString(dept, 500, 260);
        g.drawString(dept, 220, 668);
        g.drawString(shift, 220, 710);
        g.drawString(desig, 220, 610);
        BufferedImage tempJPG = resizeImage(bi, bi.getWidth(), bi.getHeight());
        g.drawImage(tempJPG, 220, 309, null);

//        File f2 = new File(singimg);
//        BufferedImage image1 = ImageIO.read(f2);
//        g.drawImage(image1, 515, 330, null);
//        boolean italic = g.getFont().isItalic();
//        g.setFont();
        
        g.dispose();
        g1.dispose();
        Rotation90Image ri = new Rotation90Image();
        BufferedImage createRotatedCopy = ri.createRotatedCopy(image);
        ImageIO.write(createRotatedCopy, "png", file);
//        imagewrite im=new imagewrite();
//        im.ResizeImage();
    }

    public static BufferedImage resizeImage(final Image image, int width, int height) {
        int targetw = 0;
        int targeth = 205;

        if (width > height) {
            targetw = 300;
        } else {
            targetw = 169;
        }

        do {
            if (width > targetw) {
                width /= 2;
                if (width < targetw) {
                    width = targetw;
                }
            }

            if (height > targeth) {
                height /= 2;
                if (height < targeth) {
                    height = targeth;
                }
            }
        } while (width != targetw || height != targeth);

        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        BufferedImage makeRoundedCorner = makeRoundedCorner(bufferedImage, 20);
        return makeRoundedCorner;
    }

    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        // This is what we want, but it only does hard-clipping, i.e. aliasing
        // g2.setClip(new RoundRectangle2D ...)
        // so instead fake soft-clipping by first drawing the desired clip shape
        // in fully opaque white with antialiasing enabled...
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));

        // ... then compositing the image on top,
        // using the white shape from above as alpha source
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }

    public static void main(String[] args) {
        try {
//           File f=new File("back.jpg");
////           final BufferedImage image = ImageIO.read(f);
//           String s=System.getProperty("user.dir")+"userr.jpg";
////        "http://upload.wikimedia.org/wikipedia/en/2/24/Lenna.png"));
////           File f1 = new File(s);
//           BufferedImage bi = ImageIO.read(f);
//           resizeImage(bi, bi.getWidth(), bi.getHeight());
            FrantSideWritee fsw = new FrantSideWritee();
            File f = new File(System.getProperty("user.dir") + File.separator + "22.jpg");
            File ff = new File(System.getProperty("user.dir") + File.separator + "11.png");
            fsw.ForntSideTech(f, "Yatin", "IF", ff, "Gandhi", "Teacher", "II");
//            fsw.ForntSide(f, "Nityasaka", "1234567890", "IF", "TY", "II", ff, "Nimbalkar");
        } catch (IOException ex) {
            Logger.getLogger(FrantSideWritee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

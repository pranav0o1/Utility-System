package dao;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tulajaram
 */
public class Rotation90Image {

    public static void main(String[] args) {
        File f = new File("12.png");
        try {
            BufferedImage br = ImageIO.read(f);
            Rotation90Image ri=new Rotation90Image();
            BufferedImage createRotatedCopy =ri.createRotatedCopy11(br);
            ImageIO.write(createRotatedCopy, "png", new File("Copy.png"));
        } catch (IOException ex) {
            Logger.getLogger(Rotation90Image.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public  BufferedImage createRotatedCopy(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rot = new BufferedImage(h, w, BufferedImage.TYPE_INT_RGB);

        double theta;
        theta = Math.PI / 2;
//    AffineTransform xform = AffineTransform.getRotateInstance(theta, w / 2, h / 2);

        AffineTransform xform = new AffineTransform();
        xform.translate(0.5 * h, 0.5 * w);
        xform.rotate(theta);
        xform.translate(-0.5 * w, -0.5 * h);
        Graphics2D g = (Graphics2D) rot.createGraphics();
        g.drawImage(img, xform, null);
        g.dispose();

        return rot;
    }
    public  BufferedImage createRotatedCopy11(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();

        BufferedImage rot = new BufferedImage(h, w, BufferedImage.TYPE_INT_RGB);

        double theta;
        theta = Math.PI / -2;
//    AffineTransform xform = AffineTransform.getRotateInstance(theta, w / 2, h / 2);

        AffineTransform xform = new AffineTransform();
        xform.translate(0.5 * h, 0.5 * w);
        xform.rotate(theta);
        xform.translate(-0.5 * w, -0.5 * h);
        Graphics2D g = (Graphics2D) rot.createGraphics();
        g.drawImage(img, xform, null);
        g.dispose();

        return rot;
    }
}

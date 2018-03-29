
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tulajaram
 */
public class NewClass {
   public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame("Test");

    frame.add(new JComponent() {
        File f=new File("back.png");
         BufferedImage image = ImageIO.read(f);

         @Override
         protected void paintComponent(Graphics g) {
              super.paintComponent(g);

              // create the transform, note that the transformations happen
              // in reversed order (so check them backwards)
              AffineTransform at = new AffineTransform();

              // 4. translate it to the center of the component
              at.translate(getWidth() / 2, getHeight() / 2);

              // 3. do the actual rotation
              at.rotate(Math.PI/2);

              // 2. just a scale because this image is big
              at.scale(0.5, 0.5);

              // 1. translate the object so that you rotate it around the 
              //    center (easier :))
              at.translate(-image.getWidth()/2, -image.getHeight()/2);

              // draw the image
              Graphics2D g2d = (Graphics2D) g;
              g2d.drawImage(image, at, null);

              // continue drawing other stuff (non-transformed)
              //...
              File f=new File("file.png");
            try {
                ImageIO.write(image, "png", f);
            } catch (IOException ex) {
                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            }

         }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
} 
}

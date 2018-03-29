package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class ChangeGui {

    public JFrame frame = new JFrame("Utility System");

    public void change() {
        JWindow window = new JWindow();
        window.getContentPane().add(
                new JLabel("", new ImageIcon(System.getProperty("user.dir") + File.separator + "1.png"/*new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")*/), SwingConstants.CENTER));
        window.setSize(880, 400);
        window.setLocationRelativeTo(null);
//        window.setBounds(500, 150, 300, 200);
        window.setVisible(true);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
//        JFrame frame = new JFrame("ID Card Generation");

        frame.add(new MainPln(frame));
//        frame.setLocationRelativeTo(null);
//        frame.setExtendedState(BaseRootPaneUI.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.setSize(600, 300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

//        GUI_MAIN gui_main=new GUI_MAIN();
//        GUI_MAIN.MainPanel.removeAll();
//        GUI_MAIN.MainPanel.add(new Login_pnl());
//        GUI_MAIN.MainPanel.updateUI();
        window.dispose();
    }

    public static void main(String[] args) {
        new ChangeGui().change();
    }
}

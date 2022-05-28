package ThapHaNoi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class frmGame extends JFrame {
	public static JFrame frm = new JFrame();
	
	public frmGame(int level) {
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setBounds(100, 100, 550, 300);		
		frm.setTitle("Tower of HaNoi");
		frm.setLayout(new BorderLayout());
		frm.setContentPane(new pnlGamePlay(level));
		frm.setLocationRelativeTo(null);
		frm.setResizable(false);
		frm.setVisible(true);

	}

}

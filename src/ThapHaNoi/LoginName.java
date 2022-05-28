package ThapHaNoi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.PanelUI;

public class LoginName extends JPanel{

	public static String tenLogin; 
	ImageIcon icon = new ImageIcon("image/Math_Tower_of_Hanoi.jpg");
	public LoginName() {

		setSize(550, 700);
		setLayout(new GridBagLayout());
		JLabel user = new JLabel("Tên đăng nhập: ");
		JTextField name = new JTextField(20);
		
		Button ok = new Button("OK chơi");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
				Database data = new Database();
				setTenLogin(name.getText());
				new frmGame(1);
				Menu.jFrame.setVisible(false);
			}

		});

		Button thoat = new Button("Thoát");
		thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
				Menu.jFrame.getContentPane().removeAll();
				new Menu();
				Menu.jFrame.setSize(550, 300);
				Menu.jFrame.setLayout(new GridLayout(1, 0));
			}
		});
		
		
		GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = c.HORIZONTAL; //tÄƒng chiá»�u rá»™ng cá»§a thÃ nh pháº§n theo chiá»�u ngang
        c.insets = new Insets(20, 20, 20, 20);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;

        add(user, c);

        c.gridx = 2;
        c.gridwidth = 2;

        add(name, c);
        
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;

        add(ok, c);
        
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 2;

        add(thoat, c);
        
	}
	

	@Override
	public void paintComponent(Graphics g) {
		 Dimension d = getSize();
		 g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		 setOpaque( false );
		super.paintComponent(g);  
	}

	public static String getTenLogin() {
		if(tenLogin.equals("")) return "Ẩn danh";
		else return tenLogin;
	}

	public static void setTenLogin(String tenLogin) {
		LoginName.tenLogin = tenLogin;
	}
}

package ThapHaNoi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HuongDanChoi extends JPanel{
	
	protected String textHD="";
	ImageIcon background = new ImageIcon("image/HD.jpg");
	
	public HuongDanChoi() {
		try {
		     // Tạo đối tượng luồng và liên kết nguồn dữ liệu
		     File f = new File("resources/HuongDan.txt");
		     FileReader fr = new FileReader(f); //mở file để đọc
		     // Đọc dữ liệu
		     BufferedReader br = new BufferedReader(fr); //con trỏ đọc
		     String line;
		     while ((line = br.readLine()) != null){ //khi mà vẫn còn kí tự trong file thì vẫn còn đọc
		    	 textHD += line + "\n";
		     }
		     //Đóng luồng
		     fr.close();
		     br.close();
		    } catch (Exception ex) {
		      System.out.println("Lỗi đọc file: "+ex);
		  }
		ImageIcon icon = new ImageIcon("image/Tower-of-hanoi.gif");
			JLabel hd = new JLabel();
			JLabel anh = new JLabel();
			anh.setIcon(new ImageIcon(new ImageIcon("image/Tower-of-hanoi.gif").getImage().getScaledInstance(550, 270, Image.SCALE_DEFAULT)));
			hd.setText(textHD);
			hd.setFont(new Font("Serif", Font.PLAIN, 15));
			
			setLayout(new GridBagLayout());
			Button thoat = new Button("Quay lại");
			
			GridBagConstraints c = new GridBagConstraints();
	        c.weightx = 1;
	        c.fill = c.HORIZONTAL;
	        c.insets = new Insets(10, 20, 10, 20);
	        
	        c.gridx = 0;
	        c.gridy = 0;
	        c.gridwidth = 2;
	        add(hd, c);


	        c.gridx = 0;
	        c.gridy = 1;
	        c.gridwidth = 1;
	        add(thoat, c);
			
			thoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
					Menu.jFrame.getContentPane().removeAll();
					new Menu();
					Menu.jFrame.setLayout(new GridLayout(1, 0));
				}
			});
			Button cuthe = new Button("Chi tiết");
			
			cuthe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
					c.gridx = 0;
					c.gridy = 3;
			        c.gridwidth = 1;
			        
					add(anh, c);
					Menu.jFrame.pack();
				}
			});
			c.gridx = 1;
	        c.gridwidth = 1;
	        add(cuthe, c);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		 Dimension d = getSize();
		 g.drawImage(background.getImage(), 0, 0, d.width, d.height, null);
		 setOpaque( false );
		super.paintComponent(g);  
	}
}

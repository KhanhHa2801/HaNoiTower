package ThapHaNoi;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
		
		
public class Menu{

	public static JFrame jFrame = new JFrame();
	public Menu() {
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setBounds(100, 100, 550, 300);
		jFrame.setTitle("Tower of HaNoi");
		jFrame.setResizable(false); //không cho phép mở rộng frame
		jFrame.setLocationRelativeTo(null);
		

		ImageIcon icon = new ImageIcon("image/Math_Tower_of_Hanoi.jpg");
		 JPanel Panel = new JPanel() {
			 public void paintComponent(Graphics g)
			 {
				 // Co giãn kích thước hình ảnh lớn bằng kích thước JFrame
				 Dimension d = getSize();
		
				 g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				 setOpaque( false );//ko vẽ nền cho panel
				 super.paintComponent(g);
			 }
		 };
		 Panel.setLayout(new GridBagLayout());
		jFrame.add(Panel);
		
		JButton start = new JButton("Chơi ngay  ");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
				jFrame.setContentPane(new LoginName());
				jFrame.setSize(551, 300);
			}
		});
		
		JButton count = new JButton("Kỉ Lục");
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
				jFrame.setContentPane(new DiemCao());
				jFrame.setSize(551, 300);
			}
		});
		
		JButton HD = new JButton("Hướng Dẫn");
		HD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//bắt nút hướng dẫn
        		new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
        		jFrame.setContentPane(new HuongDanChoi());
				jFrame.setSize(551, 300);
            }
        });
		
		GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.fill = c.HORIZONTAL;
        c.insets = new Insets(10, 210, 10, 210);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        Panel.add(start, c);


        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        Panel.add(count, c);
        

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        Panel.add(HD, c);
		
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Sound("resources/Nhac-nen-PowerPoint-vui-nhon-www_nhacchuongvui_com.wav",4);
		new Menu();		
	}
	
	
}

package ThapHaNoi;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DiemCao extends JPanel{
	ImageIcon icon = new ImageIcon("image/Math_Tower_of_Hanoi.jpg");
	public DiemCao() {
		JLabel diemcao = new JLabel();
		Database dtb = new Database();
		Button thoat = new Button("Quay lại");
		setLayout(new GridBagLayout());
		
		dtb.DiemCao();
		diemcao.setText("<html>" + dtb.getTextDiem()+"</html>");
		diemcao.setFont(new Font("Serif", Font.PLAIN, 20));
		
		GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.insets = new Insets(10, 100, 10, 100);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(diemcao, c);


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
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		 Dimension d = getSize();
		 g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		 setOpaque( false );
		super.paintComponent(g);  
	}
}

package ThapHaNoi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class pnlGamePlay extends JPanel {

	//khai báo các cọc, mỗi cọc là một đối tượng ngăn xếp
	Stack tower1 = new Stack(); 
	Stack tower2 = new Stack();
	Stack tower3 = new Stack();
	protected int demlandichuyen = 0;
	
	protected ImageIcon icon = new ImageIcon("image/backGround.jpg");
	
	//các biến để chọn, mặc định chọn từ cọc đầu tiên
	boolean isSelectedTower1 = true;
	boolean isSelectedTower2 = false;
	boolean isSelectedTower3 = false;
	
	Block carriedBlock = null; //xét các đĩa chọn
	
	String nameString=new LoginName().getTenLogin();
//	LoginName lg = new LoginName();

	int soblock=0;
	protected static int level=1;
	Database dt = new Database();
	

	public pnlGamePlay(int level) {
		
		this.level = level;
		JOptionPane.showMessageDialog(pnlGamePlay.this, "Màn " + level + ": Số bước di chuyển đĩa tối đa là: " + dt.getSobuoc(level));
		addKeyListener(new ControlAdapter()); //bắt sự kiện cho bàn phím
		setFocusable(true); //khung tiêu điểm
		
		//khai báo các đĩa có trong cọc
		for(int x=dt.getDodai(level); x>=30; x=x-20) {
			tower1.push(new Block(x));
			soblock++;
		}
		
//		tower1.push(new Block(90)); //đĩa ở vị trí cuối cùng là đĩa dài nhất
//		tower1.push(new Block(70)); 
//		tower1.push(new Block(50));
//		tower1.push(new Block(30)); //đĩa ở vị trí trên cùng là ngắn nhất
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		// Co giãn kích thước hình ảnh lớn bằng kích thước JFrame
		 Dimension d = getSize();

		 g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		 setOpaque( false );
		
		super.paintComponent(g); 
		//cài đặt cho các cọc  
		g.setColor(Color.LIGHT_GRAY);
		//tower 1
		g.fillRect(70, 40, 20, 160); //do day hinh chu nhat tai toa do x, y, do rong, va do cao
		//tower 2
		g.fillRect(230, 40, 20, 160);
		//tower 3
		g.fillRect(390, 40, 20, 160);
		
		//blocks
		tower1.drawBlocks(g, 30); //vẽ các cọc tại hoành độ mà hình 30
		tower2.drawBlocks(g, 190);
		tower3.drawBlocks(g, 350);
		
		if(carriedBlock != null) {
			int xPos = 0;
			if(isSelectedTower1)
				xPos = 30 +(100 -carriedBlock.getLength())/2;
			else if(isSelectedTower2)
				xPos = 190 +(100 -carriedBlock.getLength())/2;
			else if(isSelectedTower3)
				xPos = 350 +(100 -carriedBlock.getLength())/2;
			g.fillRect(xPos, 20, carriedBlock.getLength(), 19 );
		}
		//bộ chọn
		g.setColor(Color.red);//khung tiêu điểm màu đỏ
		if(isSelectedTower1)//nếu đang ở cọc 1
			g.drawRect(1, 20, 158, 190); //thì vẽ ra hình chữ nhật với tọa độ màn hình (1,20), rộng 158, dài 190
		else if(isSelectedTower2)
			g.drawRect(161, 20, 158, 190);
		else if(isSelectedTower3)
			g.drawRect(321, 20, 158, 190);
		
		repaint(); // gọi đến phương thức update() sau đó gọi đến phương thức paint()
	}
	
	private void checkMove() { //kiểm tra xếp đúng hay chưa
		if(tower3.count() == soblock && demlandichuyen <= dt.getSobuoc(level)) {
			new Sound("resources/Tieng-vo-tay-www_nhacchuongvui_com.wav",0);
			JOptionPane.showMessageDialog(pnlGamePlay.this, "You Win ^^, điểm của bạn là: " + demlandichuyen);
			level++;
			frmGame.frm.setVisible(false);
			new frmGame(level);
			System.out.println(level);
		}
		else if(demlandichuyen>dt.getSobuoc(level)) { //nếu vượt quá số bước cho phép
			new Sound("resources/Am-thanh-tra-loi-sai-www_nhacchuongvui_com.wav",0);
			dt.setData(nameString, demlandichuyen, level);
			
			//hiển thị thông báo
			Object[] options = {"Đăng nhập chơi tiếp", "Về lại màn hình chính", "Thôi bỏ"};
			int result = JOptionPane.showOptionDialog(pnlGamePlay.this, 
					"Thua rồi, điểm của bạn là "+demlandichuyen+"\nBạn có muốn chơi tiếp ?", 
					"Xác nhận",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if(result == JOptionPane.YES_OPTION){
            		frmGame.frm.dispose();
					Menu.jFrame.setVisible(true);
            }else if (result == JOptionPane.NO_OPTION){
					frmGame.frm.dispose();
					new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
					Menu.jFrame.getContentPane().removeAll();
					new Menu();
					Menu.jFrame.setSize(550, 300);
					Menu.jFrame.setLayout(new GridLayout(1, 0));
            } else {
        			System.exit(0);
            }
            
			
			
//			JOptionPane.showMessageDialog(pnlGamePlay.this, "You Lose =(, điểm của bạn là: " + demlandichuyen);
//			dt.setData(nameString, demlandichuyen, level);
//			frmGame.frm.dispose();
//			Menu.jFrame.setVisible(true);
		}
	}
	
	public class ControlAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) { //bấm sang phải
				if(isSelectedTower1) { //nếu khung đỏ đang ở cọc 1
					isSelectedTower2 = true;//sau khi bấm sẽ chuyển sang cọc 2
					isSelectedTower1 = false;//khung ở cọc 1 biến mất
				}
				else if(isSelectedTower2) { //nếu đang ở cọc 2
					isSelectedTower3 = true;//thì chuyển sang cọc 3
					isSelectedTower2 = false;//cọc 2 mất
				}
			}
			
			if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {//tương tự, ngược lại khi bấm phím trái
				if(isSelectedTower2) {
					isSelectedTower1 = true;
					isSelectedTower2 = false;
				}
				else if(isSelectedTower3) {
					isSelectedTower2 = true;
					isSelectedTower3 = false;
				}
			}
			
			if(key == KeyEvent.VK_UP || key == KeyEvent.VK_W) { //bấm lên trên
				if(carriedBlock == null) {//nếu cái đĩa chọn vẫn trống
					if(isSelectedTower1) {//nếu ở cọc 1
						carriedBlock = tower1.pop();//xóa thằng đầu tiên (trên cùng) của cọc, tức là lấy nó ra
					}
					else if(isSelectedTower2) {//tương tự
						carriedBlock = tower2.pop();
					}
					else if(isSelectedTower3) {
						carriedBlock = tower3.pop();
					}
				}
			}
			
			if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {//bấm xuống
				if(carriedBlock != null) {//nếu cái đĩa chọn đang giữ 1 đĩa
					if(isSelectedTower1) {//nếu khung đỏ ở cọc 1
						if(tower1.peek() == null || tower1.peek().getLength()>carriedBlock.getLength()) {
						// nếu trong cọc 1 không có đĩa nào, hoặc đĩa trên cùng của cọc 1 có độ dài lớn hơn độ dài của thằng định cho vào
						tower1.push(carriedBlock);//thì thêm được
						carriedBlock = null;//thêm xong
						}
					}
				if(isSelectedTower2) { //tương tự với cọc 2, và cọc 3
						if(tower2.peek() == null || tower2.peek().getLength()>carriedBlock.getLength()) {
							tower2.push(carriedBlock);
							carriedBlock = null;
							}
					}
				if(isSelectedTower3) {
					if(tower3.peek() == null || tower3.peek().getLength()>carriedBlock.getLength()) {
						tower3.push(carriedBlock);
						carriedBlock = null;
						}
					}
				}
				demlandichuyen++;
			}
			
			repaint(); //cập nhật lại vị trí của các đĩa
		
			checkMove();
		}
		
	}

}

package ThapHaNoi;

import java.awt.Color;
import java.awt.Graphics;

public class Stack { //lớp này là lớp ngăn xếp

	private Block headBlock; //khai báo đĩa đầu có trong ngăn xếp, tức là đĩa cuối cùng
	
	public Stack() {
		// TODO Auto-generated constructor stub
	}
	
	public Block getHeadBlock() {
		return headBlock;
	}
	public void setHeadBlock(Block headBlock) {
		this.headBlock = headBlock;
	}
	 // thêm 1 đĩa vào stack
	public void push(Block block) {
		if(headBlock == null) {
			headBlock = block; //nếu trong stack chưa có đĩa nào thì thêm 1 đĩa vào, đĩa này nằm ở dưới cùng
		}
		else {
			Block currentBlock = headBlock; //nếu có rồi, thì đĩa hiện đang có là đĩa bên dưới cùng
			while (currentBlock.getNext() !=null) { 
				currentBlock = currentBlock.getNext(); //thêm lần lượt các đĩa lên trên				
			}										   //
			currentBlock.setNext(block);               //
		}
		new Sound("resources/Hieu-ung-am-thanh-Ui-www_nhacchuongvui_com.wav",0);
	}
	
	//xóa block
	public Block pop() {
		Block popBlock = null; 
		if(count() == 1) { //nếu trong cọc đó đang chỉ có 1 đĩa
			popBlock = headBlock; //gán đĩa đó vào đĩa tạm
			headBlock = null; //đã xóa
		}
		else if(count() > 1){ //còn nếu trong cọc có nhiều hơn 1 đĩa
			Block currentBlock = headBlock; //lấy ra thằng hiện tại đang ở trên đầu
			for(int i=1; i<count()-1; i++) 
				currentBlock = currentBlock.getNext(); //lần lượt lấy ra các thằng tiếp theo
			
			popBlock =  currentBlock.getNext();
			currentBlock.setNext(null); //đã xóa
		}
		new Sound("resources/Am-thanh-click-chuot-www_nhacchuongvui_com.wav",0);
		return popBlock;
	}
	
	//lấy ra block
	public Block peek() {
		if(count()>0) {
			Block currentBlock = headBlock; //lấy ra thằng đang ở trên đầu
			while (currentBlock.getNext()!=null) { //nếu trong stack vẫn còn
				currentBlock = currentBlock.getNext();//thì vẫn lấy được
			}
			return currentBlock;
		}
		else {
			return null; //ko có thì ko lấy ra được gì
		}
	}
	
	//đếm số đĩa có trong stack
	public int count() {
		int ctr = 0;//khởi tạo biến đếm 
		Block currentBlock = headBlock; //lấy ra th đầu
		while(currentBlock != null) { //khi mà vẫn còn trong stack
			ctr ++; //biến đếm tăng lên
			currentBlock = currentBlock.getNext();//lấy tiếp
		}
		return ctr;
	}
	
	public void drawBlocks(Graphics g, int x) { //hàm này để vẽ ra các đĩa, với tọa độ màn hình
		Block currentBlock = headBlock;
		for(int i=0; i<count(); i++) {
			
			int xPos = x + (100 - currentBlock.getLength())/2; //hoành độ của đĩa
			int yPos = 180 - (i*20); //tung độ của đĩa
			
			g.setColor(Color.green); //cài màu xanh cho đĩa
			g.fillRect(xPos, yPos, currentBlock.getLength(), 19); //lấp đầy thành hình chữ nhật, tọa độ xPos, yPos, chiều dài là độ dài của từng đĩa, độ rộng bằng 19
			currentBlock = currentBlock.getNext();
		}
	}
}

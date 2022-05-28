package ThapHaNoi;

public class Block {
	private int length; //độ dài của đĩa
	private Block next; //đĩa để di chuyển
	
	
	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public Block getNext() {
		return next;
	}


	public void setNext(Block next) {
		this.next = next;
	}


	public Block(int length) {
		super();
		this.length = length;
		this.next = null;
	}

}

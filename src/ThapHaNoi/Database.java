package ThapHaNoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	protected final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	protected final String DB_URL = "jdbc:mysql://localhost/khanhhii?useUnicode=true&characterEncoding=UTF-8";
	protected final String USER = "root";
	protected final String PASS = "";
	protected Connection conn = null;
	
	protected String textDiem="";

	public Database() {
			try {
				Class.forName(DRIVER_CLASS);
			} catch (ClassNotFoundException e1) {
				System.out.println("Không tìm thấy class trong lib");
				e1.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (SQLException e) {
				System.out.println("Không kết nối được với database");
				e.printStackTrace();
			}
	}
	
	public void getData() { //lấy ra database
		Statement stms = null; //cung cấp các phương thức để thực thi câu lệnh truy vấn
		try {
			stms = conn.createStatement();
			ResultSet rs = stms.executeQuery("SELECT ten, diem, level FROM towerofhanoi");
			while(rs.next()) {
				String tenString = rs.getString("ten");
				int diem = rs.getInt("diem");
				int level = rs.getInt("level");
				System.out.println("Tên: " + tenString + ", Điểm: " + diem + ", Level: " + level);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setData(String ten, int diem, int level) {
		try {
			String sql = "INSERT INTO towerofhanoi (ten, diem, level)"
					+ "VALUES (?, ?, ?)";
			PreparedStatement pstms = conn.prepareStatement(sql);//thực thi câu lệnh sql với tham số truyền vào 
			pstms.setString(1, ten);
			pstms.setInt(2, diem);
			pstms.setInt(3, level);
			pstms.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getDodai(int lv) {
		// TODO Auto-generated method stub
		int ddBlock=0;
		Statement stms = null; //cung cấp các phương thức để thực thi câu lệnh truy vấn
		try {
			stms = conn.createStatement();
			ResultSet rs = stms.executeQuery("SELECT dodai, level FROM leveltower");
			while(rs.next()) {
				if(lv == rs.getInt("level"))
					ddBlock = rs.getInt("dodai");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ddBlock;
	}
	
	public int getSobuoc(int lv) {
		// TODO Auto-generated method stub
		int sobuoc=0;
		Statement stms = null; //cung cấp các phương thức để thực thi câu lệnh truy vấn
		try {
			stms = conn.createStatement();
			ResultSet rs = stms.executeQuery("SELECT sobuoc, level FROM leveltower");
			while(rs.next()) {
				if(lv == rs.getInt("level"))
					sobuoc = rs.getInt("sobuoc");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sobuoc;
	}
	
	public void DiemCao() {
		Statement stms = null; //cung cấp các phương thức để thực thi câu lệnh truy vấn
		textDiem = "<html> ";
		try {
			stms = conn.createStatement();
			ResultSet rs = stms.executeQuery("SELECT ten, diem, level FROM towerofhanoi	"
					+ "where diem in (Select min(diem) from towerofhanoi group by level) "
					+ "order by level desc LIMIT 4");
			int i=1;
				while(rs.next()) {
					String tenString = rs.getString("ten");
					int diem = rs.getInt("diem");
					int level = rs.getInt("level");
					textDiem += "<strong>" + i + ".  " + tenString + ", Điểm: " + diem + ", Level: " + level +"</strong> <br>";
					i++;
				}
				textDiem += "</html>";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTextDiem() {
		if(textDiem=="")
			return "Bạn chưa chơi";
		else
		return textDiem;
	}

	
//	public static void main(String[] args) {
//		Database dtb = new Database();
//		System.out.println("Kết nối thành công");
//		dtb.getData();
////		dtb.setName("Khánh", 4);
//		int x = dtb.getDodai(2);
//		System.out.print(x+" ");
//	}
	
}

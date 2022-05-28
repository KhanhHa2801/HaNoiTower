package ThapHaNoi;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;



public class Sound {
	static Clip clip;
	public Sound(String tenbai, int lap) {
		// TODO Auto-generated constructor stub
		File f = new File(tenbai);
		try{// AudioSystem hỗ trợ lấy ra các tệp hệ thống
	        clip=AudioSystem.getClip();//Lấy một clip có thể được sử dụng để phát lại tệp âm thanh hoặc luồng âm thanh
	        clip.open(AudioSystem.getAudioInputStream(f));//Nhận luồng đầu vào âm thanh từ nguồn được cung cấp File. và mở nó
	        clip.start();
	        clip.loop(lap);
	    } catch (Exception e){
	        e.printStackTrace();
	    }
	}
	
	public static void stop() {
		clip.stop();
	}
}

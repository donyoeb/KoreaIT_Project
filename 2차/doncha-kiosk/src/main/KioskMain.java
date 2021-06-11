package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import customer.CustomerMain;
import manager.ManagerMain;
import user.UserMain;

public class KioskMain extends JFrame{
	JButton bt_user; //유저 전용 화면으로 가는 버튼
	JButton bt_manager; // 관리자 전용 화면으로 가는 버튼
	
	JPanel container; //컨테이너 패널
	JPanel p_main;	 //버튼을 담을 패널
	JPanel p_img; //이미지 패널
	JLabel la_img; // 이미지 라벨
	
	
	public KioskMain() {
		container = new JPanel();
		p_main = new JPanel();
		bt_user = new JButton("메뉴선택");
		bt_manager = new JButton("관리자모드");
		
		p_img = new JPanel();
		la_img= new JLabel();
		la_img.setIcon(
				new ImageIcon("D:\\korea_it_workspace\\korea202102_java\\eclipse\\doncha-kiosk\\res\\logo_doncha_250.png"));
	
		p_main.add(bt_user);	//패널에 버튼 추가
		p_main.add(bt_manager);
		
		p_img.add(la_img);
		
		container.add(p_img,BorderLayout.NORTH);
		container.add(p_main,BorderLayout.SOUTH);
		add(container); //패널을 프레임에 추가
		
		bt_user.addActionListener((new ActionListener(){ //메뉴선택버튼 클릭이벤트
			public void actionPerformed(ActionEvent e){
				new UserMain();
			}
		}));
		
		bt_manager.addActionListener((new ActionListener(){ //관리자버튼 클릭이벤트
			public void actionPerformed(ActionEvent e){
				new ManagerMain();
			}
		}));
		
		setTitle("키오스크 메인");
		setBounds(300, 100, 300, 400); //x,y,w,h
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new KioskMain();
	}
}

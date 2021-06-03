package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import customer.CustomerMain;
import manager.ManagerMain;

public class KioskMain extends JFrame{
	JButton bt_user; //유저 전용 화면으로 가는 버튼
	JButton bt_manager; // 관리자 전용 화면으로 가는 버튼
	JPanel p_main;	 //버튼을 담을 패널
	
	public KioskMain() {
		p_main = new JPanel();
		bt_user = new JButton("메뉴선택");
		bt_manager = new JButton("관리자모드");
		
		
		p_main.add(bt_user);	//패널에 버튼 추가
		p_main.add(bt_manager);
		add(p_main, BorderLayout.CENTER); //패널을 프레임에 추가
		
		bt_user.addActionListener((new ActionListener(){ //메뉴선택버튼 클릭이벤트
			public void actionPerformed(ActionEvent e){
				new CustomerMain();
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

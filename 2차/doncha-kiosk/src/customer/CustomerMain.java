package customer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CustomerMain extends JFrame{
	JTextArea jt;
	
	public CustomerMain() {
		jt=new JTextArea();
		
		add(jt);

		setTitle("유저 화면");
		setBounds(0, 100, 300, 400); //x,y,w,h
		setVisible(true);
		addWindowListener(new WindowAdapter() { //종료 이벤트 
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
	});
	}
	
	
	


	public static void main(String[] args) {
		new CustomerMain();
	}
}

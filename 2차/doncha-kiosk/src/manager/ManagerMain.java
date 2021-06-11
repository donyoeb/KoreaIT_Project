package manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import member.JoinForm;
import member.LoginForm;
import member.MemberMain;
import order.OrderMain;
import product.ProductMain;
import user.UserMain;

public class ManagerMain extends JFrame implements ActionListener{
	
	JPanel p_north; //상단 버튼 놓기위한 패널
	JPanel p_center;//페이지 교체를 위한 패널
	
	String[] menu_title= {"상품관리","회원관리","주문관리"};
	CustomButton[] bt_menu=new CustomButton[menu_title.length]; //배열생성
	
	//p_center에 들어갈 페이지 선언 
	Page[] pages = new Page[5]; //크기는 메뉴타이틀 사이즈+회원가입
	
	//데이터베스 관련 
	String driver="com.mysql.jdbc.Driver"; // 8.xx 인 경우 com.mysql.jdbc.cj.Driver
	String url="jdbc:mysql://localhost:3306/doncha?characterEncoding=UTF-8";
	String user="root";
	String password="1234";	
	private Connection con;
	private boolean session=false; //세션이 true 일때 인증받은 것이고, false일때는 미인증 간주
	
	public ManagerMain() {
		connect();//DB접속
		
		//생성
		p_north = new JPanel();
		p_center = new JPanel();
		
		for(int i=0;i< menu_title.length;i++) {
			bt_menu[i] = new CustomButton(menu_title[i]);
			bt_menu[i].setId(i); //반복문의 i 를 각 버튼의 식별  id 로 할당!!!
		}
		 

		//페이지들 생성 
		pages[0] = new ProductMain(this); //상품관리
		pages[1] = new MemberMain(this);//회원관리
		pages[2] = new OrderMain(this);//주문관리
		pages[3] = new LoginForm(this);//로그인
		pages[4] = new JoinForm(this);//회원가입폼
		
		p_north.setBackground(new Color(207, 220, 186));
		
		//조립
		for(JButton bt : bt_menu) { 
			p_north.add(bt);
		}
		add(p_north, BorderLayout.NORTH);
		
		//p_center 에 페이지들 붙이기
		for(Page p : pages) {
			p_center.add(p);
		}
		add(p_center);
		
		
		for(int i=0;i<bt_menu.length;i++) {
			bt_menu[i].addActionListener(this);
		}
		
		//보여주기
		//인증여부에 따라 알맞는 페이지 보여주기 
		if(session==false) { //인증을 받지 않은 상태이므로, 로그인을 디폴트로 보여주기
			showHide(3);//제일 먼저 보여주고 싶은 페이지
		}else {
			showHide(0);
		}
		
		setBounds(0, 10, 1200, 700);
		setVisible(true);
	
		
		addWindowListener(new WindowAdapter() { //종료 이벤트 해당창만 종료
				@Override
				public void windowClosing(WindowEvent e) {
					
					dispose();
				}
		});
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//어떤 버튼이 눌렸는지 
		Object obj = e.getSource();
		CustomButton bt=(CustomButton)obj; 
		if(session) {
			showHide(bt.getId());
		}else {
			JOptionPane.showMessageDialog(this , "로그인이 필요한 서비스입니다");
		}
	}
	
	public void connect() { //데이터베이스 접속 
		try {
			Class.forName(driver); //드라이버 로드 
			con = DriverManager.getConnection(url, user, password);
			if(con !=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 실패");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}
	public void disConnect() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//쿼리문이 DML
	public void release(PreparedStatement pstmt) {
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//쿼리문이 select인 경우
	public void release(PreparedStatement pstmt, ResultSet rs) {
		if(rs !=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(pstmt !=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Connection getCon() {
		return con;
	}
	
	public void showHide(int n) { //보여주고 싶은 페이지의 번호를 넘기기
		for(int i=0;i<pages.length;i++) {
			if(n==i) {
				pages[i].setVisible(true); //현재 선택한 버튼과 같은 인덱스를 갖는 페이지면 보이기
			}else {
				pages[i].setVisible(false);
			}
		}
	}
	
	public boolean isSession() {
		return session;
	}

	public void setSession(boolean session) {
		this.session = session;
	}

	public static void main(String[] args) {
		new ManagerMain();
	}
}
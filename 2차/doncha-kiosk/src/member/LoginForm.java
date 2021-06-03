package member;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import manager.ManagerMain;
import manager.Page;

public class LoginForm extends Page{
	JPanel p_container;//BorderLayout 
	JPanel p_center; //form 
	JPanel p_south; //버튼 영역 
	JLabel la_id, la_pass;
	JTextField t_id; 
	JPasswordField t_pass;
	JButton bt_login, bt_join;
	
	public LoginForm(ManagerMain managerMain) {
		super(managerMain);
		
		//생성
		p_container = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		la_id = new JLabel("ID");
		la_pass = new JLabel("Password");
		t_id = new JTextField();
		t_pass = new JPasswordField();
		bt_login = new JButton("Login");
		bt_join = new JButton("회원가입");
		
		//스타일 레이아웃
		p_container.setPreferredSize(new Dimension(250, 85));
		p_container.setLayout(new BorderLayout());
		p_center.setLayout(new GridLayout(2, 2));
		
		//조립
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		p_container.add(p_center);
		p_container.add(p_south, BorderLayout.SOUTH);
		
		add(p_container);
		
		//리스너
		bt_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginCheck();
			}
		});
		
		bt_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// index 4번째인 회원가입 폼을 호출
				LoginForm.this.getAppMain().showHide(4);
			}
		});
		
	}
	
	public void loginCheck() {
		String sql="select * from manager where m_id=? and m_pass=?";
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		try {
			pstmt=this.getAppMain().getCon().prepareStatement(sql);
			pstmt.setString(1, t_id.getText());
			pstmt.setString(2, new String(t_pass.getPassword()));
			rs=pstmt.executeQuery();
			
			//회원인지 아닌지
			if(rs.next()) {
				JOptionPane.showMessageDialog(this.getAppMain(), "인증되었습니다");
				this.getAppMain().setSession(true);//인증 성공의 데이터 대입!!
				LoginForm.this.getAppMain().showHide(0); // 로그인 성공하면 첫페이지로
				
			}else {
				JOptionPane.showMessageDialog(this.getAppMain(), "로그인 정보가 올바르지 않습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.getAppMain().release(pstmt, rs);
		}
	}
}











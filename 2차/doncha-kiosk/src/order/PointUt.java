package order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PointUt {
	
	String url = "jdbc:mysql://localhost:3306/doncha?characterEncoding=UTF-8";
	String user = "root";
	String pass = "1234";

	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	double rate = 0.5;
	int pn = 0;
	
	public int checkPoint(String phone_number) {//포인트 조회
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			stmt = con.createStatement();
			System.out.println("포인트 체크 시작");

			String sql = "select * from member where phone_number = " + phone_number;
			
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				pn = rs.getInt("point");
				System.out.println("rs = " + pn);
			} else {// 회원이 없는경우
				System.out.println("회원아님");
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pn;
	}

	public void pointPlus(String phone_num, int revenue) {//포인트 적립
		checkPoint(phone_num);
		double incrPoint = rate*revenue;
		pn = (int) (pn+incrPoint);
		System.out.println("변경될 포인트 = " + pn);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("포인트 드라이버 로드 성공!!");

			String sql = "update member set point = ?  where phone_number = ?";
			
			pstmt = con.prepareStatement(sql);
	
			pstmt.setInt(1, pn); 
			pstmt.setString(2, phone_num);
			
			System.out.println(sql);
			int rsu = pstmt.executeUpdate();
			System.out.println("rsus는 " + rsu);
		} catch (SQLException | ClassNotFoundException e) {
		} finally {
			try {
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	public void pointSub(String phone_num, int usePoint) {//포인트 차감
		checkPoint(phone_num);
		pn = pn - usePoint;
		System.out.println("차감 후 포인트 = " + pn);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("포인트 드라이버 로드 성공!!");

			String sql = "update member set point = ?  where phone_number = ?";
			
			pstmt = con.prepareStatement(sql);
	
			pstmt.setInt(1, pn); 
			pstmt.setString(2, phone_num);
			
			System.out.println(sql);
			int rsu = pstmt.executeUpdate();
			System.out.println("rsus는 " + rsu);
		} catch (SQLException | ClassNotFoundException e) {
		} finally {
			try {
				pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	

}

package order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import user.OrderProduct;

public class PaymentUt {
	
   String url = "jdbc:mysql://localhost:3306/doncha?characterEncoding=UTF-8";
   String user = "root";
   String pass = "1234";

   Connection con = null;
   ResultSet rs = null;
   Statement stmt = null;
   PreparedStatement pstmt = null;

   OrderList ol = new OrderList();

   // 들어온 주문자의 휴대폰 번호 check
      public boolean checkMember(String phone_number) {
         boolean flag = true;
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
            System.out.println("맴버 체크 시작");

            String sql = "select * from member where phone_number = " + phone_number;

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
               String pn = rs.getString("phone_number");
               System.out.println("rs = " + pn);
               flag = true;
            } else {// 회원이 없는경우
               System.out.println("회원이 아니네??");
               flag = false;
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
         System.out.println(flag);
         return flag;
      }

      // 맴버 추가하는 메서드
      public void joinMember(String phone_number) {

         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stmt = con.createStatement();
            System.out.println("맴버 추가 시작");
            System.out.println(phone_number);
            String sql = "insert into member (phone_number) values ('" + phone_number + "')";

            stmt.executeUpdate(sql);

         } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
         } finally {
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
      }

   // 들어온 주문을 order_history로 보내는 메서드
   public void orderConfirm(String phone_number, ArrayList<OrderProduct> arrOp, int totalPrice, int usePoint) throws SQLException {
//      String allName = "";
//      int allCnt = 0;
//      int cnt = 1;
//      for(OrderProduct op : arrOp) {
//         allCnt += op.getCnt();
//         if(arrOp.size() == cnt) {
//            allName += op.getName();
//         }else {
//            allName += op.getName()+", ";
//            cnt++;
//         }
//      }
//      System.out.println("주문된 메뉴들 : "+allName + ", 총 수량 : "+allCnt + ", 총 가격 : " + totalPrice);

	   PointUt pt = new PointUt();
	   
      try {
         Class.forName("com.mysql.jdbc.Driver");
         con = DriverManager.getConnection(url, user, pass);
         System.out.println("드라이버 로드 성공!!");

         String sql = "insert into order_history(product_name, phone_number, order_count, order_price, revenue)";
         sql += " values(?,?,?,?,?)";

         String allName = "";
         int allCnt = 0;
         int cnt = 1;
         for(OrderProduct op : arrOp) {
            allCnt += op.getCnt();
            if(arrOp.size() == cnt) {
               allName += op.getName();
            }else {
               allName += op.getName()+", ";
               cnt++;
            }
         }
         
         String cntStr = allCnt +"(";
         String tpStr = totalPrice+"(";
         cnt = 1;
         for(OrderProduct op : arrOp) {
            if(arrOp.size() == cnt) {
               cntStr += op.getCnt()+")";
               tpStr += (op.getPrice() * op.getCnt())+")";
            }else {
               cntStr += op.getCnt()+",";
               tpStr += (op.getPrice() * op.getCnt())+",";
               cnt++;
            }
         }
         
         System.out.println("주문된 메뉴들 : "+allName + ", 총 수량 : " + cntStr + ", 총 가격 : " + tpStr);

         pstmt = con.prepareStatement(sql);
         // 바인드 변수값 처리
         pstmt.setString(1, allName);// 상품명
         pstmt.setString(2, phone_number); // 폰번
         pstmt.setString(3, cntStr);// 수량
         pstmt.setString(4, tpStr);// 가격
         String[] rev_arr = tpStr.split("[,\\(\\)]");
         System.out.println( Integer.parseInt(rev_arr[0]));
         System.out.println( usePoint);
         
         int rev = (Integer.parseInt(rev_arr[0]) - usePoint);
         pt.pointPlus(phone_number, rev);//포인트 적립
         
         pstmt.setInt(5, rev);
         
         // 쿼리실행(DML)
         int result = pstmt.executeUpdate();
         if (result == 1) {
            System.err.println("성공");

         } else {
            System.out.println("실패");
         }
      } catch (SQLException | ClassNotFoundException e) {
         e.printStackTrace();
      } finally {
         con.close();
      }

   }

//   
//   public void pointPlus(String phone_num,double revenue) throws SQLException {
//      try {
//         Class.forName("com.mysql.jdbc.Driver");
//         con = DriverManager.getConnection(url, user, pass);
//         System.out.println("드라이버 로드 성공!!");
//
//         String sql = "update member set point=?  phone_num=?";
//         pstmt = con.prepareStatement(sql);
//         revenue = 1.1*revenue;
//         pstmt.setDouble(1,revenue);
//         pstmt.setString(2, phone_num);// 상품명
//         
//      } catch (SQLException | ClassNotFoundException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();         
//      }finally {
//         con.close();
//      }
//            
//   }

}
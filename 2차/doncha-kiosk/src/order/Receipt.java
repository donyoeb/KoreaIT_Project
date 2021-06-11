package order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import manager.ManagerMain;
import user.OrderProduct;
import user.UserMain;

public class Receipt extends JFrame {
   UserMain userMain;
   ArrayList<ReceiptPanel> arrRp;
   String[] name_arr;
   String[] cnt_arr;
   String[] price_arr;
//   ReceiptPanel rp;
   

   int id;
   public Integer rev;
   public Integer use_point; // 포인트 사용한거 적기
   JPanel container;
   JPanel p_top, p_option, p_center, p_option2, p_bottom, p_option3;
   JLabel la_line, la_line2, la_line3, la_line4;
   JLabel la_null1, la_null2;
   JLabel la_name, la_cnt, la_price;
   JLabel text_id, text_phone, text_name, text_cnt, text_price, text_time, text_state;
   JLabel total_text, total_cnt, total_money, la_point, la_rev;

   // 데이터베스 관련
   String driver = "com.mysql.jdbc.Driver"; // 8.xx 인 경우 com.mysql.jdbc.cj.Driver
   String url = "jdbc:mysql://localhost:3306/doncha?characterEncoding=UTF-8";
   String user = "root";
   String password = "1234";
   private Connection con;

   public Receipt(int id) {
      arrRp = new ArrayList<ReceiptPanel>();
      // this.arrOp = userMain.getArrOp();
      connect();

      this.id = id;

      container = new JPanel();
      la_line = new JLabel("****************************************************************");
      la_line.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      la_line.setHorizontalAlignment(JLabel.RIGHT);// 이돈엽 화면에서 오른쪽 정렬 해야 가운데 정렬처럼 보여서 이렇게 설정한거. 다른 사람은 CENTER로 변경.
      la_line2 = new JLabel("****************************************************************");
      la_line2.setHorizontalAlignment(JLabel.RIGHT);// 이돈엽 화면에서 오른쪽 정렬 해야 가운데 정렬처럼 보여서 이렇게 설정한거. 다른 사람은 CENTER로 변경.
      la_line2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      la_line3 = new JLabel(
            "------------------------------------------------------------------------------------------------");
      la_line3.setHorizontalAlignment(JLabel.RIGHT);// 이돈엽 화면에서 오른쪽 정렬 해야 가운데 정렬처럼 보여서 이렇게 설정한거. 다른 사람은 CENTER로 변경.
      la_line4 = new JLabel(
            "------------------------------------------------------------------------------------------------");
      la_line4.setHorizontalAlignment(JLabel.RIGHT);// 이돈엽 화면에서 오른쪽 정렬 해야 가운데 정렬처럼 보여서 이렇게 설정한거. 다른 사람은 CENTER로 변경.

      la_null1 = new JLabel(
            "                                                                                                                          ");
      la_null1.setHorizontalAlignment(JLabel.RIGHT);// 이돈엽 화면에서 오른쪽 정렬 해야 가운데 정렬처럼 보여서 이렇게 설정한거. 다른 사람은 CENTER로 변경.

      la_null2 = new JLabel(
            "                                                                                                                          ");
      la_null2.setHorizontalAlignment(JLabel.RIGHT);// 이돈엽 화면에서 오른쪽 정렬 해야 가운데 정렬처럼 보여서 이렇게 설정한거. 다른 사람은 CENTER로 변경.

      p_top = new JPanel();
      p_option = new JPanel();
      p_center = new JPanel();
      p_option2 = new JPanel();
      p_bottom = new JPanel();
      p_option3 = new JPanel();

      la_name = new JLabel("상품명");
      la_cnt = new JLabel("수량");
      la_price = new JLabel("금액");

      total_text = new JLabel("합    계 : ");
      total_cnt = new JLabel();
      total_money = new JLabel();

      text_id = new JLabel();
      text_phone = new JLabel();
      text_name = new JLabel();
      text_cnt = new JLabel();
      text_price = new JLabel();
      text_time = new JLabel();
      text_state = new JLabel();
      
      la_rev = new JLabel("결제금액 : ");
      la_point = new JLabel("포인트 : ");

      getDB(id); // db에서 값들 가져오기
      
      
      total_text.setHorizontalAlignment(JLabel.CENTER);
      total_cnt.setHorizontalAlignment(JLabel.CENTER);
      total_money.setHorizontalAlignment(JLabel.CENTER);

      la_name.setHorizontalAlignment(JLabel.CENTER);
      la_cnt.setHorizontalAlignment(JLabel.CENTER);
      la_price.setHorizontalAlignment(JLabel.CENTER);

      text_id.setHorizontalAlignment(JLabel.CENTER);
      text_phone.setHorizontalAlignment(JLabel.CENTER);
      text_name.setHorizontalAlignment(JLabel.CENTER);
      text_cnt.setHorizontalAlignment(JLabel.CENTER);
      text_price.setHorizontalAlignment(JLabel.CENTER);
      text_time.setHorizontalAlignment(JLabel.CENTER);
      text_state.setHorizontalAlignment(JLabel.CENTER);
      
      la_rev.setHorizontalAlignment(JLabel.LEFT);
      la_point.setHorizontalAlignment(JLabel.LEFT);

      la_line.setPreferredSize(new Dimension(300, 5));
      la_line.setLayout(new FlowLayout());
      la_line2.setPreferredSize(new Dimension(300, 5));
      la_line2.setLayout(new FlowLayout());
      la_line3.setPreferredSize(new Dimension(300, 5));
      la_line3.setLayout(new FlowLayout());
      la_line4.setPreferredSize(new Dimension(300, 5));
      la_line4.setLayout(new FlowLayout());

      la_null1.setPreferredSize(new Dimension(300, 5));
      la_null1.setLayout(new FlowLayout());
      la_null2.setPreferredSize(new Dimension(300, 5));
      la_null2.setLayout(new FlowLayout());

      container.setPreferredSize(new Dimension(300, 400));

      p_top.setPreferredSize(new Dimension(300, 50));
      p_option.setPreferredSize(new Dimension(300, 20));
      p_center.setPreferredSize(new Dimension(300, 200));
      p_bottom.setPreferredSize(new Dimension(300, 50));
      p_option2.setPreferredSize(new Dimension(300, 20));
      p_option3.setPreferredSize(new Dimension(300, 20));

      la_name.setPreferredSize(new Dimension(90, 50));
      la_cnt.setPreferredSize(new Dimension(50, 50));
      la_price.setPreferredSize(new Dimension(70, 50));

      text_name.setPreferredSize(new Dimension(90, 50));
      text_cnt.setPreferredSize(new Dimension(50, 50));
      text_price.setPreferredSize(new Dimension(70, 50));

      total_text.setPreferredSize(new Dimension(90, 50));
      total_cnt.setPreferredSize(new Dimension(50, 50));
      total_money.setPreferredSize(new Dimension(70, 50));
      
      la_point.setPreferredSize(new Dimension(150, 50));
      la_rev.setPreferredSize(new Dimension(100, 50));
      
      p_top.add(new JLabel("오더 넘버 : "));
      p_top.add(text_id);
      p_top.add(la_null1);
      p_top.add(new JLabel("주문고객 : "));
      p_top.add(text_phone);

      p_option.setLayout(new BorderLayout());
      p_option.add(la_name, BorderLayout.WEST);
      p_option.add(la_cnt, BorderLayout.CENTER);
      p_option.add(la_price, BorderLayout.EAST);

      p_center.setLayout(new FlowLayout());
      
      for (int i = 0; i < name_arr.length; i++) {
         ReceiptPanel rp = new ReceiptPanel(name_arr[i], cnt_arr[i+1], price_arr[i+1]);
         System.out.println("name : "+name_arr[i]+", cnt : "+cnt_arr[i+1]+", price : "+price_arr[i+1]);
         p_center.add(rp);
      }
      
      total_cnt.setText(cnt_arr[0]);
      total_money.setText(price_arr[0]+ " 원" );
      
      la_rev.setText("결제금액 : "+ rev +"원");
      la_point.setText("       사용 포인트 : "+ use_point + "점");
      
      
//      p_center.add(text_name, BorderLayout.WEST);
//      p_center.add(text_cnt, BorderLayout.CENTER);
//      p_center.add(text_price, BorderLayout.EAST);

      p_option2.setLayout(new BorderLayout());
      p_option2.add(total_text, BorderLayout.WEST);
      p_option2.add(total_cnt, BorderLayout.CENTER);
      p_option2.add(total_money, BorderLayout.EAST);

      p_option3.setLayout(new BorderLayout());
      //p_option3.add(new JLabel("  "), BorderLayout.CENTER);
      p_option3.add(la_point, BorderLayout.WEST);
      p_option3.add(la_rev, BorderLayout.CENTER);
      
     
      p_bottom.add(new JLabel("오더시간 : "));
      p_bottom.add(text_time);
      p_bottom.add(la_null2);
      p_bottom.add(new JLabel("상태 : "));
      p_bottom.add(text_state);

      container.add(p_top);
      container.add(la_line);
      container.add(p_option);
      container.add(la_line3);
      container.add(p_center);
      container.add(la_line4);
      container.add(p_option2);
      container.add(p_option3);
      container.add(la_line2);
      container.add(p_bottom);
      add(container);
      
      

      setTitle("관리번호 - " + id + "- 영수증");
      setVisible(true);
      setBounds(500, 100, 320, 500);

      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
   }

//   public void createReceipt(String name, String cnt, String price) {
//      this.p_center.add(rp = new ReceiptPanel(name, cnt, price));
//      arrRp.add(rp);
//   }

   private void getDB(int orderid) {

      String sql = "select * from order_history";
      sql += " where order_history_id=" + orderid;
      System.out.println("db 요청한 테이블:" + orderid);

      PreparedStatement pstmt = null;
      ResultSet rs = null;
      try {
         pstmt = getCon().prepareStatement(sql);
         rs = pstmt.executeQuery();

         while (rs.next()) {
//              System.out.println(  
//                    "오더넘버 : " +Integer.toString(rs.getInt("order_history_id"))+
//                     " / 폰 번호 : "+rs.getString("phone_number")+
//                     " / 주문 메뉴 : "+rs.getString("product_name")+
//                     " / 개수 : "+Integer.toString(rs.getInt("order_count"))+
//                     " / 가격 : "+Integer.toString(rs.getInt("order_price"))+
//                     " / 오더시간 : "+rs.getString("order_time")+
//                     " / 순이익 : "+Integer.toString(rs.getInt("revenue"))+
//                     " / 상태 : "+rs.getString("order_state")
//                );
//              
            text_id.setText(Integer.toString(rs.getInt("order_history_id")));
            text_phone.setText(rs.getString("phone_number"));

            name_arr = rs.getString("product_name").split("\\s*,\\s*");
            // String[] name_list = new String[name_arr.length];
            for (int i = 0; i < name_arr.length; i++) {
               // name_list[i] = name_arr[i];
               System.out.println(name_arr[i]);
            }

            cnt_arr = rs.getString("order_count").split("[,\\(\\)]");
            // String[] cnt_list = new String[cnt_arr.length];
            for (int i = 0; i < cnt_arr.length; i++) {
               // cnt_list[i] = cnt_arr[i];
               System.out.println(cnt_arr[i]);
            }

            price_arr = rs.getString("order_price").split("[,\\(\\)]");
            // String[] price_list = new String[price_arr.length];
            for (int i = 0; i < price_arr.length; i++) {
               // price_list[i] = price_arr[i];
               System.out.println(price_arr[i]);
            }

            // text_name.setText(rs.getString("product_name"));
            // text_cnt.setText(rs.getString(rs.getInt("order_count")));
            // text_price.setText(Integer.toString(rs.getInt("order_price")));
            text_time.setText(rs.getString("order_time"));
            text_state.setText(rs.getString("order_state"));
            
            rev = rs.getInt("revenue");
            use_point = Integer.parseInt( price_arr[0]) - rev;      
            System.out.println("순이익 : " + rev  + "    사용포인트 :  " + use_point);
             
         }
         

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         release(pstmt, rs);
      }

   }

   public void connect() { // 데이터베이스 접속
      try {
         Class.forName(driver); // 드라이버 로드
         con = DriverManager.getConnection(url, user, password);
         if (con != null) {
            this.setTitle("접속 성공");
         } else {
            this.setTitle("접속 실패");
         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   public void disConnect() {
      if (con != null) {
         try {
            con.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   // 쿼리문이 DML
   public void release(PreparedStatement pstmt) {
      if (pstmt != null) {
         try {
            pstmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

   // 쿼리문이 select인 경우
   public void release(PreparedStatement pstmt, ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

      if (pstmt != null) {
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

}
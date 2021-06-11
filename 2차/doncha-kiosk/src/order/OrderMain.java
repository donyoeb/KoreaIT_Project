package order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import manager.ManagerMain;
import manager.Page;
import user.UserMain;

public class OrderMain extends Page {
   /*생성*/
   //동쪽
   JPanel p_east; 
   
   JPanel p_profit;//수익 패널
   JLabel total_profit;//총 수익 라벨  
   Integer t_profit;

   JPanel p_order;
   JLabel total_order; //총 주문건수 라벨
   Integer t_order;
   
   JPanel p_wait;
   JLabel total_wait; //총 대기건수 라벨
   Integer t_wait;
   
   JPanel p_cancel;
   JLabel total_cancel; //총 취소건수 라벨
   Integer t_cancel;
   
   JPanel p_confirm;
   JLabel total_confirm; //총 완료건수 라벨
   Integer t_confirm;
   //서
   JPanel p_west;
   JButton bt_cancel;// 주문취소
   JButton bt_confirm;// 주문완료
   //남
   JPanel p_south;// 버튼 패널
   //북
   JPanel p_north;// 타이틀 패널
   JPanel p_share_1;
   JPanel p_share_2;
   //센터
   JPanel p_center;// 주문관리 패널
   JTable table;// 주문관리 테이블
   
   JScrollPane scroll_table;
   String[] columns = { "관리번호", "주문고객", "상품명", "수량", "가격", "주문시간", "순이익", "주문처리" };// 컬럼배열
   String[][] records = {};// 레코드배열
   JLabel orderlabel;// 텍스트 넣을 라벨

   int order_id; // 선택한 테이블의 row

   public OrderMain(ManagerMain managerMain) {
      super(managerMain);
      setBackground(new Color(207, 220, 186));
      
      //동쪽 패널
      p_east = new JPanel();
      
      p_profit = new JPanel();
      p_order = new JPanel();
      p_confirm = new JPanel();
      p_wait = new JPanel();
      p_cancel = new JPanel();
      
      total_profit = new JLabel("총 순이익 : 원"); 
      total_order = new JLabel("총 주문 건수 : 건");
      total_confirm = new JLabel("총 완료 건수 : 건");
      total_wait = new JLabel("총 대기 건수 : 건");
      total_cancel = new JLabel("총 취소 건수 : 건");
      total_profit.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      total_order.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      total_confirm.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      total_wait.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      total_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      //서쪽 패널
      p_west = new JPanel();
      
      bt_cancel = new JButton("주문 취소");// 주문취소
      bt_confirm = new JButton("주문 완료");// 주문완료
      bt_cancel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      bt_confirm.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      //남쪽 패널
      p_south = new JPanel();// 버튼
      //북쪽 패널
      p_north = new JPanel();// 타이틀 패널
      orderlabel = new JLabel("고객 주문 내역");
      p_share_1 = new JPanel();
      p_share_2 = new JPanel();
      //센터 패널
      p_center = new JPanel();// 테이블
     
      
      table = new JTable(new AbstractTableModel() {
         public int getRowCount() {
            return records.length;
         }

         public int getColumnCount() {
            return columns.length;
         }

         // 컬럼의 제목을 배열로부터 구한다
         public String getColumnName(int col) {
            return columns[col];
         }

         // 각 셀에 들어갈 데이터를 이차원 배열로 부터 구한다
         public Object getValueAt(int row, int col) {
            return records[row][col];
         }

         // JTable의 각셀의 값을 지정
         // 셀을 편집한 후, 엔터치는 순간 아래의 메서드 호출됨
         public void setValueAt(Object value, int row, int col) {

         }

         // 다른 메서드와 마찬가지로, 아래의 isCellEditable메서드도 호출자가 JTable이다
         public boolean isCellEditable(int row, int col) {
            if (col != 7) { // 7번째 열인 order_rate만 읽기전용으로 세팅
               return false;
            } else {
               return true;
            }
         }
      });
      scroll_table = new JScrollPane(table); // 테이블 스크롤 처리
      
      
      
      
      //남
      bt_cancel.setPreferredSize(new Dimension(200, 50));
      bt_confirm.setPreferredSize(new Dimension(200, 50));
   
      /*스타일 및 레이아웃*/
      setLayout(new BorderLayout());
      Dimension d = new Dimension(200, 30);
      //동쪽
      p_east.setPreferredSize(new Dimension(250,600));
      //서쪽
      p_profit.setPreferredSize(d);
      p_order.setPreferredSize(d);
      p_wait.setPreferredSize(d);
      p_cancel.setPreferredSize(d);
      p_confirm.setPreferredSize(d);
      p_west.setPreferredSize(new Dimension(250,600));
      //북쪽
      orderlabel.setPreferredSize(new Dimension(250, 100));
      orderlabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      //orderlabel.setHorizontalAlignment(JLabel.LEFT);
      //orderlabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
      p_share_1.setPreferredSize(new Dimension(250, 100));
      p_share_2.setPreferredSize(new Dimension(800, 100));
      p_north.setPreferredSize(new Dimension(1200, 100));
      p_north.setLayout(new FlowLayout(FlowLayout.CENTER));
      //센터
      p_center.setPreferredSize(new Dimension(600, 600));
      p_center.setLayout(new BorderLayout());
      p_center.add(scroll_table);
      //남쪽
      p_south.setPreferredSize(new Dimension(1200, 100));
      
      //센터
      
      /*조립*/
      //북
      p_share_1.add(orderlabel);
      p_north.add(p_share_1);
      p_north.add(p_share_2);
      //동
      p_profit.add(total_profit);
      p_order.add(total_order);
      p_wait.add(total_wait);
      p_cancel.add(total_cancel);
      p_confirm.add(total_confirm);
      
      p_west.add(p_profit);
      p_west.add(p_order);
      p_west.add(p_wait);
      p_west.add(p_cancel);
      p_west.add(p_confirm);
      //서
      p_east.add(bt_cancel);// 주문취소
      p_east.add(bt_confirm);// 주문완료
     
      add(p_north, BorderLayout.NORTH);
      add(p_west, BorderLayout.WEST);
      add(p_center, BorderLayout.CENTER);
      add(p_south, BorderLayout.SOUTH);
      add(p_east, BorderLayout.EAST);

      /*색상*/
      p_share_1.setBackground(new Color(207, 220, 186));
      p_share_2.setBackground(new Color(207, 220, 186));
      p_center.setBackground(new Color(207, 220, 186));
      p_west.setBackground(new Color(207, 220, 186));
      p_north.setBackground(new Color(207, 220, 186));
      p_south.setBackground(new Color(207, 220, 186));
      p_east.setBackground(new Color(207, 220, 186));
      //orderlabel.setForeground(new Color(195, 14, 46));
      
//      setBounds(0, 10, 1200, 700);
//      setVisible(true);

      // 테이블과 리스너 연결
      table.addMouseListener(new MouseAdapter() {
    	   public void mouseReleased(MouseEvent e) {
               //getTableRow();  //테이블 클릭시 해당 row의 id값 저장하기
                  
            }
            
            @Override

            public void mouseClicked(MouseEvent e) {

               if (e.getButton() == 1) {
                  System.out.println("한번 클릭");
                  getTableRow();  //테이블 클릭시 해당 row의 order_id값 저장하기
                      
                  
               } //클릭
      
               if (e.getClickCount() == 2 || e.getButton() == 3) {
                  System.out.println("더블클릭 or 오른쪽 클릭"); 
                  new Receipt(order_id); //영수증 출력
                  
               } // 더블클릭
      
            }
      });

      // 주문 취소버튼 이벤트
      bt_cancel.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            orderCancel(); // 취소처리하기
            tableCalculation(); //테이블 계산 다시하기
            getProductList(); // 다시 불러오기
         }
      });

      bt_confirm.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            orderConfirm(); // 취소처리하기
            tableCalculation(); //테이블 계산 다시하기
            getProductList(); // 다시 불러오기
         }
      });

      getProductList(); // 처음 접속시 order_history 테이블 리스트 가져오기
      tableCalculation(); //처음 테이블 계산 결과 조회
   }

   // 상품 목록 가져오기
   public void getProductList() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select order_history_id, phone_number, product_name ,order_count, order_price, order_time, revenue, order_state";
      sql += " from order_history";

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY);

         rs = pstmt.executeQuery();

         rs.last(); // 커서를 마지막레코드로 보냄
         int total = rs.getRow(); // 레코드 번호 구하기

         // JTable이 참조하고 있는 records라는 이차원배열의 값을, rs를 이용하여 갱신해보자!
         records = new String[total][columns.length];

         rs.beforeFirst(); // 커서 위치 제자리로
         int index = 0;
         while (rs.next()) {

            records[index][0] = Integer.toString(rs.getInt("order_history_id"));
            records[index][1] = rs.getString("phone_number");
            records[index][2] = rs.getString("product_name");
            records[index][3] = rs.getString("order_count");
            records[index][4] =  rs.getString("order_price");
            records[index][5] = rs.getString("order_time");
            records[index][6] = Integer.toString(rs.getInt("revenue"));
            records[index][7] = rs.getString("order_state");
            index++;
         }
         table.updateUI();// JTable 갱신
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
   }

   // 테이블 선택
   public void getTableRow() {
      // 선택한 레코드의 order_id
      order_id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
      System.out.println("선택한 테이블:" + order_id);
   }

   // 선택한 테이블 주문 취소하기
   public void orderCancel() {
      String sql = "update order_history set order_state='주문취소' ";
      sql += " where order_history_id=" + order_id;
      System.out.println("취소 요청한 테이블:" + order_id);
      
      PreparedStatement pstmt = null;

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql); //  con가져오기

         int result = pstmt.executeUpdate(); // DML 실행

         if (result > 0) {
            JOptionPane.showMessageDialog(this.getAppMain(), "수정완료");
         } else {
            JOptionPane.showMessageDialog(this.getAppMain(), "수정실패");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt);
      }
   }
   
   //선택한 테이블 주문 완료하기
   public void orderConfirm() {
      String sql = "update order_history set order_state='주문완료' ";
      sql += " where order_history_id=" + order_id;
      System.out.println("완료 요청한 테이블:" + order_id);
      
      PreparedStatement pstmt = null;

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql); // 메인에서 con가져오기

         int result = pstmt.executeUpdate(); // DML 실행

         if (result > 0) {
            JOptionPane.showMessageDialog(this.getAppMain(), "수정완료");
         } else {
            JOptionPane.showMessageDialog(this.getAppMain(), "수정실패");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt);
      }
   }
   
   public void tableCalculation() {
      String profit_sql = " select SUM(revenue) as sum from order_history ";
      profit_sql += "where order_state='주문완료';"; //주문완료인경우 => 순이익
      
      String order_sql = " select count(*) as cnt from order_history"; //총 주문건수
      
      String wait_sql = " select count(*) as cnt from order_history where order_state='주문대기' "; //주문대기 건수
      
      String cancel_sql = " select count(*) as cnt from order_history where order_state='주문취소' "; //주문취소 건수
      
      String confirm_sql = " select count(*) as cnt from order_history where order_state='주문완료' "; //주문완료 건수
      
      
      ResultSet rs = null; //쿼리 결과 가져올 resultset
      PreparedStatement pstmt = null;
      
      try {
         pstmt = this.getAppMain().getCon().prepareStatement(profit_sql); // 순수익 sql 처리
         rs = pstmt.executeQuery();
          rs.next();
            int sum = rs.getInt("sum");
            total_profit.setText("총 순수익 : " +sum+" 원");
            
            pstmt = this.getAppMain().getCon().prepareStatement(order_sql); // 총주문 건수 sql 처리
            rs = pstmt.executeQuery();
          rs.next();
            int order_cnt = rs.getInt("cnt");
            total_order.setText("총 주문 수 : " +order_cnt+" 건");
            
            pstmt = this.getAppMain().getCon().prepareStatement(wait_sql); // 주문대기 건수 sql 처리
            rs = pstmt.executeQuery();
          rs.next();
            int wait_cnt = rs.getInt("cnt");
            total_wait.setText("주문대기 수 : " +wait_cnt+" 건");
            
            pstmt = this.getAppMain().getCon().prepareStatement(cancel_sql); // 주문취소 건수 sql 처리
            rs = pstmt.executeQuery();
          rs.next();
            int cancel_cnt = rs.getInt("cnt");
            total_cancel.setText("주문취소 수 : " +cancel_cnt+" 건");
            
            pstmt = this.getAppMain().getCon().prepareStatement(confirm_sql); // 주문완료 건수 sql 처리
            rs = pstmt.executeQuery();
          rs.next();
            int confirm_cnt = rs.getInt("cnt");
            total_confirm.setText("주문완료 수 : " +confirm_cnt+" 건");
            
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt,rs);
      }
   }

}
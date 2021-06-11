package member;

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
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import manager.ManagerMain;
import manager.Page;

public class MemberMain extends Page {
   /*생성*/
   //동
   JPanel p_east;
   // 서
   JPanel p_west;
   JLabel la_phone;
   JLabel la_point;
   JTextField t_phone;
   JTextField t_point;
   JButton bt_add; // 추가
   JButton bt_edit; // 수정
   JButton bt_del; // 삭제
   JButton bt_empty; // 지우기
   JLabel la_count; //총 회원 수
   //남
   JPanel p_south;
   // 북
   JPanel p_north;
   JLabel la_title;
   JPanel p_search; // 검색 컴포넌트들 올려놓을 패널
   JTextField t_search;
   JButton bt_search;
   JButton bt_reset;
   // 센터
   JPanel p_center;
   JTable table;
   JScrollPane scroll_table;
   
   //기타 선언
   String[] columns = { "phone_number", "point" };// 컬럼배열
   String[][] records = {};// 레코드배열

   String phone_number;

   public MemberMain(ManagerMain managerMain) {
      super(managerMain);
      setBackground(new Color(207, 220, 186));
      //동쪽 영역 생성
      p_east = new JPanel();
      // 서쪽 영역 생성
      p_west = new JPanel();
      
      la_phone = new JLabel("휴대폰");
      la_point = new JLabel("포인트");
      t_phone = new JTextField();
      t_point = new JTextField();
      bt_add = new JButton("회원추가");
      bt_edit = new JButton("회원수정");
      bt_del = new JButton("회원삭제");
      bt_empty = new JButton("지우기");
      la_count = new JLabel("총 회원 수 :");
      la_phone.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      la_point.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      la_count.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      
      //남쪽 영역 생성
      p_south = new JPanel();
      // 북쪽 영역 생성
      p_north = new JPanel();
      la_title = new JLabel("돈차 멤버쉽 리스트");
      t_search = new JTextField();
      bt_search = new JButton("검색");
      bt_reset = new JButton("회원 목록 초기화");
      la_title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      // 센터 영역 생성
      p_center = new JPanel();
      

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

         // JTable의 각 셀의 값을 지정
         // 셀을 편집한 후, 엔터치는 순간 아래의 메서드 호출됨
         public void setValueAt(Object value, int row, int col) {
            System.out.println(row + "," + col + " 번째 셀의 데이터는 " + value + "로 바꿀게요");
            records[row][col] = (String) value;
         }

         // 다른 메서드와 마찬가지로, 아래의 isCellEditable 메서드도 호출자가 JTable이다
         public boolean isCellEditable(int row, int col) {
            if (col == 0) { // 첫번째 열인 product_id만 읽기전용으로 세팅
               return false;
            } else {
               return true;
            }
         }
      });
      scroll_table = new JScrollPane(table);

      /*스타일 및 레이아웃*/
      setLayout(new BorderLayout());
      Dimension d = new Dimension(200, 30);
      //동쪽
      p_east.setPreferredSize(new Dimension(250, 600));
      // 서쪽
      p_west.setPreferredSize(new Dimension(250, 600));
      la_phone.setPreferredSize(d);
      la_point.setPreferredSize(d);
      t_phone.setPreferredSize(d);
      t_point.setPreferredSize(d);
//      bt_add.setPreferredSize(new Dimension(105, 30));
//      bt_del.setPreferredSize(new Dimension(105, 30));
//      bt_edit.setPreferredSize(new Dimension(105, 30));
//      bt_empty.setPreferredSize(new Dimension(105, 30));
      // 남쪽
      p_south.setPreferredSize(new Dimension(1200, 100));
      // 북쪽
      p_north.setPreferredSize(new Dimension(1200, 100));
      la_title.setPreferredSize(new Dimension(250, 100));
      t_search.setPreferredSize(d);
      
      /*색*/
      p_east.setBackground(new Color(207, 220, 186));
      p_west.setBackground(new Color(207, 220, 186));
      p_north.setBackground(new Color(207, 220, 186));
      p_south.setBackground(new Color(207, 220, 186));
      
      la_title.setForeground(new Color(195, 14, 46));
      
      /*조립*/
      //북쪽
      p_north.add(la_title);
      p_north.add(t_search);
      p_north.add(bt_search);
      p_north.add(bt_reset);


      // 서쪽 조립
      //p_west.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
      p_west.add(la_phone);
      p_west.add(t_phone);
      p_west.add(la_point);
      p_west.add(t_point);
      p_west.add(bt_add);
      p_west.add(bt_edit);
      p_west.add(bt_del);
      p_west.add(bt_empty);
      p_west.add(la_count);

      // 센터관련
      p_center.setBackground(new Color(207, 220, 186));
      p_center.setPreferredSize(new Dimension(600, 600));

      p_center.setLayout(new BorderLayout());
      p_center.add(scroll_table);

      add(p_north, BorderLayout.NORTH);
      add(p_west, BorderLayout.WEST);
      add(p_center, BorderLayout.CENTER);
      add(p_south, BorderLayout.SOUTH);
      add(p_east, BorderLayout.EAST);

      // 이벤트

      // 회원 등록
      bt_add.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            regist();
            countMember();
         }
      });

      // 회원 상세보기
      table.addMouseListener(new MouseAdapter() {
         public void mouseReleased(MouseEvent e) {
            getDetail();
         }
      });

      // 회원 삭제
      bt_del.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(MemberMain.this.getAppMain(),
                  "회원 삭제하시겠어요?") == JOptionPane.OK_OPTION) {
               deleteMember();
               countMember();
            }
         }
      });

      // 회원 목록 초기화
      bt_reset.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            getMemberList();
            t_search.setText("");
         }
      });

      // 회원 정보 수정
      bt_edit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            //Point는 정수만 입력 받도록 체크!!
            if(isNumeric(t_point.getText())) {
               editMember();
            }else {
               JOptionPane.showMessageDialog(MemberMain.this.getAppMain(), "포인트는 정수만 입력해주세요");
            }
         }
      });
      
      //회원 검색
      bt_search.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            searchMember();
         }
      });

      // 입력 칸 지우기
      bt_empty.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            t_phone.setText("");
            t_point.setText("");
         }
      });

      getMemberList(); // 회원 목록
      countMember(); //총 회원 수
   }

   // 회원 등록하기
   public void regist() {
      PreparedStatement pstmt = null;

      String sql = "insert into member(phone_number, point) values(?,?)";

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);

         // 바인드 변수값 처리
         pstmt.setString(1, t_phone.getText()); // 핸드폰 번호
         pstmt.setInt(2, Integer.parseInt(t_point.getText()));// 포인트

         // 쿼리실행(DML)
         int result = pstmt.executeUpdate();
         if (result == 1) {
            JOptionPane.showMessageDialog(this.getAppMain(), "회원 등록성공");
            getMemberList();
         } else {
            JOptionPane.showMessageDialog(this.getAppMain(), "회원 등록실패");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt);
      }
   }

   // 리스트 목록 불러오기
   public void getMemberList() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select * from member";

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE);
         rs = pstmt.executeQuery();
         rs.last(); // 커서를 마지막으로 보냄
         int total = rs.getRow();

         records = new String[total][columns.length];

         rs.beforeFirst(); // 커서 제자리로
         int index = 0;
         while (rs.next()) {
            records[index][0] = rs.getString("phone_number");
            records[index][1] = Integer.toString(rs.getInt("point"));
            index++;
         }
         table.updateUI();
         t_phone.setText("");
         t_point.setText("");

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
   }

   // 상세보기 구현
   public void getDetail() {
      // 선택한 레코드의 phone_number
      phone_number = (String) table.getValueAt(table.getSelectedRow(), 0);

      String sql = "select * from member where phone_number=" + phone_number;

      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);
         rs = pstmt.executeQuery(); // select 결과 받기

         if (rs.next()) {
            // 좌측 영역에 채워 넣기
            t_phone.setText(rs.getString("phone_number"));
            t_point.setText(Integer.toString(rs.getInt("point")));

         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
   }

   // 회원 삭제
   public void deleteMember() {
      String sql = "delete from member where phone_number=" + phone_number;
      PreparedStatement pstmt = null;

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);
         int result = pstmt.executeUpdate(); // delete 수행

         if (result > 0) {
            JOptionPane.showMessageDialog(this.getAppMain(), "회원 삭제 성공");
            getMemberList(); // 리스트 다시 조회
         } else {
            JOptionPane.showMessageDialog(this.getAppMain(), "회원 삭제 실패");
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt);
      }
   }

   // 회원 수정
   public void editMember() {
      // 휴대폰번호 입력 칸과 테이블의 선택된 회원의 휴대폰 번호가 일치하는지 확인!!
      String sameCheck = (String) table.getValueAt(table.getSelectedRow(), 0);
      if (sameCheck.equals(t_phone.getText())) { // 일치 O
         PreparedStatement pstmt = null;
         String sql = "update member set point=? where phone_number=" + phone_number;

         try {
            pstmt = this.getAppMain().getCon().prepareStatement(sql);

            pstmt.setInt(1, Integer.parseInt(t_point.getText()));

            int result = pstmt.executeUpdate();
            if (result > 0) {
               JOptionPane.showMessageDialog(this.getAppMain(), "회원 수정 완료");
               getMemberList();
               getDetail();
            } else {
               JOptionPane.showMessageDialog(this.getAppMain(), "회원 수정 실패");
            }

         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            this.getAppMain().release(pstmt);
         }

      } else { // 일치 X
         JOptionPane.showMessageDialog(this.getAppMain(), "수정하려는 회원과 일치하지 않습니다!");
      }
   }
   
   //회원 검색
   public void searchMember() {
      String keyword = t_search.getText();
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      String sql = "select * from member where phone_number like '%"+keyword+"%'";
      
      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE);
         
         rs = pstmt.executeQuery();
         rs.last(); //커서를 마지막으로
         int total = rs.getRow();
         
         records = new String[total][columns.length];
         
         rs.beforeFirst(); // 커서 위치 제자리로
         int index = 0;
         while (rs.next()) {
            records[index][0] = rs.getString("phone_number");
            records[index][1] = Integer.toString(rs.getInt("point"));
            index++;
         }
         table.updateUI();// JTable 갱신
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
   }
   
   public void countMember() {
      String sql = "select count(*) as cnt from member";
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);
         rs = pstmt.executeQuery();
         
         rs.next();
         int cnt = rs.getInt("cnt");
         
         la_count.setText("총 회원 수 : "+cnt+" 명");
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
      
   }

   public static boolean isNumeric(String s) {
      try {
         Integer.parseInt(s);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
}
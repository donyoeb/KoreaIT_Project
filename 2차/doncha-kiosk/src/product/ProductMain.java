package product;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import manager.ManagerMain;
import manager.Page;
import util.FileManager;

public class ProductMain extends Page {
   // 동
   JPanel p_east;
   JTextField t_top;
   JTextField t_product_name2;
   JTextField t_price2;
   Canvas can2;
   JButton bt_del;
   JLabel e_label_category;
   JLabel e_label_pname;
   JLabel e_label_price;
   JLabel e_label_img;
   // 서
   JPanel p_west;
   Choice ch;
   JTextField t_product_name;
   JTextField t_price;
   JButton bt_file; // 로컬 파일에서 가져오기
   Canvas can;
   JButton bt_regist;
   JLabel w_label_category;
   JLabel w_label_pname;
   JLabel w_label_price;
   JLabel w_label_img;
   ArrayList<Category> cList = new ArrayList<Category>(); // size 0 즉 아무것도 채워진게 없다
   //남
   JPanel p_south;
   // 북
   JPanel p_north;
   JLabel la_title;
   JPanel p_search; // 검색 컴포넌트들 올려놓을 패널
   Choice ch_category;// 검색 카테고리 선택
   JTextField t_keyword;// 검색어 입력
   JButton bt_search;
   // 센터
   JPanel p_center; // 테이블 패널
   JTable table;
   JScrollPane scroll_table;
   
   //기타 선언
   JFileChooser chooser;
   Toolkit kit = Toolkit.getDefaultToolkit();
   Image image; // 등록시 미리보기에 사용할 이미지
   Image image2; // 상세보기시 그려질 이미지
   String filename; // 유저의 복사에 의해 생성된 파일명!!!

   String[] columns = { "product_id", "category_id", "product_name", "product_price", "filename" };// 컬럼배열
   String[][] records = {};// 레코드배열
   int product_id; // 현재 상세보기 중인 product의 pk
   String del_file; // 현재 상세보기 중인 filename(삭제 대상이 될 수 있슴)

   public ProductMain(ManagerMain managerMain) {
      super(managerMain);
      setBackground(new Color(207, 220, 186));
      
      // 동쪽 영역 생성
      p_east = new JPanel();
      t_top = new JTextField();
      t_product_name2 = new JTextField();
      t_price2 = new JTextField();
      can2 = new Canvas() {
         public void paint(Graphics g) {
            g.drawImage(image2, 0, 0, 200, 200, can2);
         }
      };
      bt_del = new JButton("상품삭제");
      e_label_category = new JLabel("선택한 상품의 카테고리");
      e_label_pname = new JLabel("선택한 상품의 이름");
      e_label_price = new JLabel("선택한 상품의 가격");
      e_label_img = new JLabel("상품 이미지 미리보기");
      e_label_category.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      e_label_pname.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      e_label_pname.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      e_label_img.setFont(new Font("맑은 고딕", Font.BOLD, 15));

      chooser = new JFileChooser("D:\\korea_it_workspace\\korea202102_java\\eclipse\\doncha-kiosk\\res\\menu");
      // 서쪽 영역 생성
      p_west = new JPanel();
      ch = new Choice();
      t_product_name = new JTextField();
      t_price = new JTextField();
      bt_file = new JButton("파일찾기");
      can = new Canvas() {
         // 내부익명 클래스는 외부클래스의 멤버(변수,메서드)들을 내것처럼 접근 가능!!
         public void paint(Graphics g) {
            g.drawImage(image, 0, 0, 200, 200, can);
         }
      };
      bt_regist = new JButton("상품등록");
      w_label_category = new JLabel("카테고리 선택");
      w_label_pname = new JLabel("상품명 입력");
      w_label_price = new JLabel("상품 가격 입력");
      w_label_img = new JLabel("상품 이미지 미리보기");
      w_label_category.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      w_label_pname.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      w_label_price.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      w_label_img.setFont(new Font("맑은 고딕", Font.BOLD, 15));
      //남쪽 영역 생성
      p_south = new JPanel();
      //북쪽 영역 생성
      p_north = new JPanel();
      la_title = new JLabel("돈차 상품 관리");
      la_title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      p_search = new JPanel();
      ch_category = new Choice();
      // 검색 카테고리 등록
      ch_category.add("choose category");
      ch_category.add("category_id");
      ch_category.add("product_name");
      ch_category.add("product_price");
      t_keyword = new JTextField();
      bt_search = new JButton("search");
      // 센터 영역 생성
      //p_search.setPreferredSize(new Dimension(600, 100));
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

         // JTable의 각셀의 값을 지정
         // 셀을 편집한 후, 엔터치는 순간 아래의 메서드 호출됨
         public void setValueAt(Object value, int row, int col) {
            System.out.println(row + "," + col + " 번째 셀의 데이터는 " + value + "로 바꿀께요");
            records[row][col] = (String) value;
            updateProduct();
         }

         // 다른 메서드와 마찬가지로, 아래의 isCellEditable메서드도 호출자가 JTable이다
         public boolean isCellEditable(int row, int col) {
            if (col == 0) { // 첫번째 열인 product_id만 읽기전용으로 세팅
               return false;
            } else {
               return true;
            }
         }
      });

      scroll_table = new JScrollPane(table); // 테이블 스크롤 처리
      
      /*스타일 및 레이아웃*/
      setLayout(new BorderLayout());
      Dimension d = new Dimension(200, 30); // 공통 크기
      //동쪽
      p_east.setPreferredSize(new Dimension(250, 600));
      t_top.setPreferredSize(d);
      t_product_name2.setPreferredSize(d);
      t_price2.setPreferredSize(d);
      e_label_category.setPreferredSize(d);
      e_label_pname.setPreferredSize(d);
      e_label_price.setPreferredSize(d);
      e_label_img.setPreferredSize(d);
      can2.setPreferredSize(new Dimension(200,200));
      can2.setBackground(Color.BLACK);
      //서쪽
      p_west.setPreferredSize(new Dimension(250, 600));
      ch.setPreferredSize(d);
      t_product_name.setPreferredSize(d);
      t_price.setPreferredSize(d);
      w_label_category.setPreferredSize(d);
      ch.setPreferredSize(d);
      w_label_pname.setPreferredSize(d);
      w_label_price.setPreferredSize(d);
      w_label_img.setPreferredSize(d);

      can.setPreferredSize(new Dimension(200, 200));
      can.setBackground(Color.BLACK);

      // 센터관련
      p_center.setBackground(new Color(207, 220, 186));
      p_center.setPreferredSize(new Dimension(600, 600));
      
      p_center.setLayout(new BorderLayout());
      p_center.add(scroll_table);

      //남쪽
      p_south.setPreferredSize(new Dimension(1200, 100));
      //북쪽
      p_north.setPreferredSize(new Dimension(1200, 100));
      la_title.setPreferredSize(new Dimension(250, 100));
      ch_category.setPreferredSize(d);
      t_keyword.setPreferredSize(d);
      
      /*색*/
      p_west.setBackground(new Color(207, 220, 186));
      p_east.setBackground(new Color(207, 220, 186));
      p_north.setBackground(new Color(207, 220, 186));
      p_search.setBackground(new Color(207, 220, 186));
      p_south.setBackground(new Color(207, 220, 186));
      la_title.setForeground(new Color(195, 14, 46));
//      p_west.setBorder(new EmptyBorder(50, 0, 0, 0));
//      p_east.setBorder(new EmptyBorder(50, 0, 0, 0));
      
      /*조립*/
      // 동쪽조립
      //p_east.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
      p_east.add(e_label_category);
      p_east.add(t_top);
      p_east.add(e_label_pname);
      p_east.add(t_product_name2);
      p_east.add(e_label_price);
      p_east.add(t_price2);
      p_east.add(e_label_img);
      p_east.add(can2);
      p_east.add(bt_del);
      // 서쪽조립
      //p_west.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
      p_west.add(w_label_category);
      p_west.add(ch);
      p_west.add(w_label_pname);
      p_west.add(t_product_name);
      p_west.add(w_label_price);
      p_west.add(t_price);
      p_west.add(w_label_img);
      p_west.add(can);
      p_west.add(bt_file);
      p_west.add(bt_regist);
      //남쪽
      //북쪽
      p_north.add(la_title);
      p_north.add(ch_category);
      p_north.add(t_keyword);
      p_north.add(bt_search);
      //p_north.add(p_search);
      
      //여백
      
      
      
      add(p_north, BorderLayout.NORTH);// 북쪽영역에 부착
      add(p_west, BorderLayout.WEST);// 서쪽영역에 부착
      add(p_east, BorderLayout.EAST);// 동쪽영역에 부착
      add(p_south, BorderLayout.SOUTH);// 남쪽영역에 부착
      add(p_center, BorderLayout.CENTER);// 센터영역에 부착

      ch.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            // 지금 선택한 카테고리의 pk값을 알아 맞추
            Choice choice = (Choice) e.getSource();

            System.out.println("당신이 선택한 아이템은 " + choice.getSelectedIndex() + " 번째 입니다");

            // 유저가 현재 선택한 Choice에서의 아이템을 이용하여 ArrayList의 객체를 꺼내자!!
            int index = ch.getSelectedIndex() - 1;
            Category category = cList.get(index);// List에서 VO 한개 꺼내기!!
            System.out.println("선택하신 아이템의 정보 category_id=" + category.getcategory_id());
            System.out.println("선택하신 아이템의 정보 name=" + category.getname());

         }
      });
      // 파일찾기 버튼과 리스너 연결
      bt_file.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            findLocal();
         }
      });

      bt_regist.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // 유효성 체크 통과되면 아래의 두 메서드 호출!!!
            // 숫자값을 문자로 입력할 경우 문제가 심각함...따라서 이 부분만 체크해보자!!
            try {
               Integer.parseInt(t_price.getText()); // ""
               regist();
               getProductList();
            } catch (NumberFormatException e1) {
               JOptionPane.showMessageDialog(ProductMain.this.getAppMain(), "가격은 숫자를 입력하세요");
               t_price.setText(""); // 기존 입력값 지우고
               t_price.requestFocus();// 포커스 올려놓기
            }

         }
      });

      
      // 검색 버튼과 리스너 연결
      bt_search.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // 검색을 안할 경우 모든 데이터가 나오게 (category 선택안하고, keyword 입력X)
            if (ch_category.getSelectedIndex() == 0 && t_keyword.getText().length() == 0) {
               getProductList();
            } else {
               // 검색을 하면 검색결과만 나오게..
               getListBySearch();
            }
         }
      });

      // 테이블과 리스너 연결
      table.addMouseListener(new MouseAdapter() {
         public void mouseReleased(MouseEvent e) {
            getDetail();
         }
      });

      // 삭제 리스너 연결
      bt_del.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(ProductMain.this.getAppMain(), "삭제하시겠어요?") == JOptionPane.OK_OPTION) {
               deleteProduct();
            }
         }
      });

      getList(); //카테고리 불러오기
      getProductList(); // 상품 목록 가져오기

   }

   // 왼쪽 영역의 Cateogry 가져오기
   public void getList() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String sql = "select * from category";

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);
         rs = pstmt.executeQuery();// select 실행 후 레코드 반환

         ch.add("Choose Category");

         while (rs.next()) {// 커서한칸씩 이동하면서 true인 동안
            ch.add(rs.getString("category_name"));

            // Empty 상태의 인스턴스 한개 생성 , 이 안에 카테고리 이름과 pk을 넣기
            Category category = new Category();
            category.setcategory_id(rs.getInt("category_id")); // pk
            category.setname(rs.getString("category_name")); // 카테고리 이름

            cList.add(category); // ArrayList에 아이템 추가
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getAppMain().release(pstmt, rs);
      }

   }

//상품 한건 수정 
   public void updateProduct() {

      String sql = "update product set product_name=?, product_price=?, filename=?";
      sql += " where product_id=?";
      PreparedStatement pstmt = null;
      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);

         int category = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 1));
         String product_name = (String) table.getValueAt(table.getSelectedRow(), 2);
         int price = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 3));
         String filename = (String) table.getValueAt(table.getSelectedRow(), 4);

         pstmt.setString(1, product_name);// product_name
         pstmt.setInt(2, price);// price
         pstmt.setString(3, filename);// filename
         pstmt.setInt(4, product_id);// product_id

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

   // 로컬 시스템에서 파일 찾아서 이미지 미리 보기 구현
   public void findLocal() {
      FileInputStream fis = null;
      FileOutputStream fos = null;

      if (chooser.showOpenDialog(this.getAppMain()) == JFileChooser.APPROVE_OPTION) {
         File file = chooser.getSelectedFile();

         image = kit.getImage(file.getAbsolutePath()); // 파일의 물리적 풀 경로
         can.repaint();

         // 유저가 선택한 파일을 data 디렉토리에 복사해보자~~
         try {
            fis = new FileInputStream(file);

            // 여기서부터!!!!!
            // 타임부분 시간대신 파일명으로 바꿔서 데이터베이스에 고정 값 넣게끔 하기
            long time = System.currentTimeMillis();
            filename = time + "." + FileManager.getExtend(file.getAbsolutePath(), "\\");
            fos = new FileOutputStream(
            		"D:\\korea_it_workspace\\korea202102_java\\eclipse\\doncha-kiosk\\res\\data\\" + filename); // 복사될

            // 입력과 출력스트림이 준비되었으므로, 복사를 시작하자!!!
            int data = -1;
            byte[] buff = new byte[1024]; // 1kbyte 의 버퍼확보
            while (true) {
               data = fis.read(buff); // 버퍼로 읽었다면,
               if (data == -1)
                  break;
               fos.write(buff);// 버퍼로 내려쓰자
            }
            JOptionPane.showMessageDialog(this.getAppMain(), "복사완료");
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            if (fos != null) {
               try {
                  fos.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }

            if (fis != null) {
               try {
                  fis.close();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }

      }

   }

   public void regist() {
      PreparedStatement pstmt = null;

      String sql = "insert into product(category_id, product_name, product_price, filename)";
      sql += " values(?,?,?,?)";
      int index = ch.getSelectedIndex() - 1;

      // 얻어진 초이스 컴포넌트의 index를 이용하여, VO가 들어있는 ArrayList의 접근해보자!!
      Category category = cList.get(index);
      System.out.println("당신이 등록하려는 상품의 category_id 는 " + category.getcategory_id());

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);
         // 바인드 변수값 처리
         pstmt.setInt(1, category.getcategory_id()); // 서브 카테고리
         pstmt.setString(2, t_product_name.getText());// 상품명
         pstmt.setInt(3, Integer.parseInt(t_price.getText()));// 가격
         pstmt.setString(4, filename);// 이미지명

         // 쿼리실행(DML)
         int result = pstmt.executeUpdate();
         if (result == 1) {
            JOptionPane.showMessageDialog(this.getAppMain(), "상품 등록성공");
         } else {
            JOptionPane.showMessageDialog(this.getAppMain(), "상품 등록실패");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt);
      }

   }

   // 상품 목록 가져오기
   public void getProductList() {
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select product_id, category_id, product_name, product_price, filename";
      sql += " from product";

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
            records[index][0] = Integer.toString(rs.getInt("product_id"));
            records[index][1] = Integer.toString(rs.getInt("category_id"));
            records[index][2] = rs.getString("product_name");
            records[index][3] = Integer.toString(rs.getInt("product_price"));
            records[index][4] = rs.getString("filename");
            index++;
         }
         table.updateUI();// JTable 갱신
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
   }

   // 검색 결과 가져오기
   public void getListBySearch() {
      String category = ch_category.getSelectedItem();
      String keyword = t_keyword.getText();
      PreparedStatement pstmt = null;
      ResultSet rs = null;

      String sql = "select product_id, category_id, product_name, product_price ,filename";
      sql += " from product p";
      sql += " where " + category + " like '%" + keyword + "%'";

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
            records[index][0] = Integer.toString(rs.getInt("product_id"));
            records[index][1] = rs.getString("category_id");
            records[index][2] = rs.getString("product_name");
            records[index][3] = Integer.toString(rs.getInt("product_price"));
            records[index][4] = rs.getString("filename");
            index++;
         }
         table.updateUI();// JTable 갱신
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }

   }

   // 상세보기 구현
   public void getDetail() {
      // 선택한 레코드의 product_id
      product_id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));

      // String immuable 특징이 있기 때문에, 즉 문자열 상수이기에 아래와 같이 sql문을 처리하면
      // 문자열상수가 5개가 생성된다, 즉 sql이 수정되는게 아니다!!!
      // 따라서 좀더 메모리 효율을 생각한다면, 수정가능한 문자열처리를 해야 한다
      StringBuffer sb = new StringBuffer();

      sb.append("select product_id, category_id , product_name, product_price,filename");
      sb.append(" from product p");
      sb.append(" where product_id=" + product_id);

      System.out.println(sb.toString());

      PreparedStatement pstmt = null;
      ResultSet rs = null;

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sb.toString());
         rs = pstmt.executeQuery(); // select 실행 후 결과 받기 !!!

         if (rs.next()) { // 레코드가 있다면..
            // 우측 영역에 채워넣기!!!
            if (rs.getString("category_id").equals("1")) {
               t_top.setText("Bakery");
            } else if (rs.getString("category_id").equals("2")) {
               t_top.setText("BubbleTea");
            } else if (rs.getString("category_id").equals("3")) {
               t_top.setText("Coffee");
            } else {
               t_top.setText("해당 상품은 정해진 카테고리가 없습니다");
            }
            // t_top.setText(rs.getString("category_id"));
            t_product_name2.setText(rs.getString("product_name"));
            t_price2.setText(Integer.toString(rs.getInt("product_price")));
            del_file = rs.getString("filename");

            // 우측 켄버스에 이미지 나오게!!!
            image2 = kit.getImage("D:\\korea_it_workspace\\korea202102_java\\eclipse\\doncha-kiosk\\res\\data\\"
                  + rs.getString("filename"));
            can2.repaint();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         this.getAppMain().release(pstmt, rs);
      }
   }

   // 상품 삭제 처리
   public void deleteProduct() {
      // 데이터 삭제 + 파일삭제
      String sql = "delete from product where product_id=" + product_id;
      PreparedStatement pstmt = null;

      try {
         pstmt = this.getAppMain().getCon().prepareStatement(sql);
         int result = pstmt.executeUpdate(); // DML중 delete 수행
         if (result > 0) {
            // 파일 삭제!!
            File file = new File(
            		"D:\\korea_it_workspace\\korea202102_java\\eclipse\\doncha-kiosk\\res\\data\\"
                        + del_file);
            file.delete(); // 파일 삭제
            getProductList(); // 리스트 다시 조회
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
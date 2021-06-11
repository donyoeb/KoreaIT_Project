package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import order.Payment;
import order.PaymentCash;

public class UserMain extends JFrame implements ActionListener {
	JPanel Menu_frame;
	JPanel p_north;// 구분 바
	JPanel p_center;// 메뉴화면
	JPanel p_south;// 장바구니

	OrderProduct op; // 주문내역 패널
	ArrayList<OrderProduct> arrOp = new ArrayList<OrderProduct>();

	// 데이터베스 관련
	String driver = "com.mysql.jdbc.Driver"; // 8.xx 인 경우 com.mysql.jdbc.cj.Driver
	String url = "jdbc:mysql://localhost:3306/doncha?characterEncoding=UTF-8";
	String user = "root";
	String password = "1234";
	private Connection con;
	private boolean session = false; // 세션이 true 일때 인증받은 것이고, false일때는 미인증 간주

	public Integer[] select_menu;// = new Integer[30]; //각 페이지에서 선택한 메뉴 담을 리스트
	public Integer select_menu_cnt = 0; // 리스트 카운트

	JScrollPane scroll_center;

	String[] menu_title = { "BubbleTea", "Coffee", "Bakery" };
	String bt_img[] = { "Bubbletea.png", "Coffee.png", "Bakery.png" };
	Page[] pages = new Page[3];
	CustomButton[] bt_menu = new CustomButton[menu_title.length]; // 배열생성

	int flag = 1; // 현재 카테고리가 어디인지 나타내주기 초기값 1(커피).... 0(버블티), 2(베이커리)

	//총 금액 및 결제 버튼
	JPanel p_bt;
	JButton card_bt;
	JButton cash_bt;
	JLabel text_la;
	JLabel la_total;
	JLabel la_won;
	
	JScrollPane scrollSouth; //주문내역 스크롤
	JPanel p_orderList;

	public UserMain() {
		/* 생성 */
		connect();// DB접속

		//주문 총 금액 및 결제 버튼
		p_bt = new JPanel();
		text_la = new JLabel("총 금액 : ");
		la_total = new JLabel("0");
		la_won = new JLabel("원");
		card_bt = new JButton("카드결제");
		cash_bt = new JButton("현금결제");
		
		p_bt.setPreferredSize(new Dimension(800, 50));
		p_bt.setBackground(new Color(231, 227, 255));
		
		text_la.setPreferredSize(new Dimension(400, 40));
		text_la.setBackground(Color.WHITE);
		text_la.setFont(new Font("맑은고딕", Font.BOLD, 20));
		text_la.setHorizontalAlignment(JLabel.CENTER);
		
		la_total.setPreferredSize(new Dimension(100, 40));
		la_total.setBackground(Color.WHITE);
		la_total.setFont(new Font("맑은고딕", Font.BOLD, 20));
		la_total.setHorizontalAlignment(JLabel.CENTER);
		
		la_won.setPreferredSize(new Dimension(50, 30));
		la_won.setBackground(Color.WHITE);
		la_won.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		card_bt.setPreferredSize(new Dimension(100, 40));
		card_bt.setBackground(Color.WHITE);
		
		cash_bt.setPreferredSize(new Dimension(100, 40));
		cash_bt.setBackground(Color.WHITE);
		
		//주문 내역
		p_orderList = new JPanel();
		p_orderList.setPreferredSize(new Dimension(800, 1200));
		p_orderList.setBorder(new EmptyBorder(0, 0, 0, 0));
		p_orderList.setBackground(new Color(255, 199, 198));
		
		scrollSouth = new JScrollPane(p_orderList);
		scrollSouth.setPreferredSize(new Dimension(810, 220));
		scrollSouth.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollSouth.getViewport().setBackground(new Color(207, 220, 186));
		scrollSouth.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollSouth.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		scrollSouth.setViewportView(p_orderList);
		scrollSouth.getVerticalScrollBar().setUnitIncrement(15);
		

		// 전체 패널
		Menu_frame = new JPanel();
		// 구분 바
		p_north = new JPanel();
		for (int i = 0; i < menu_title.length; i++) {
			bt_menu[i] = new CustomButton(new ImageIcon(this.getClass().getClassLoader().getResource(bt_img[i])));
			bt_menu[i].setId(i); // 반복문의 i 를 각 버튼의 식별 id 로 할당!!!
		}

		// 메뉴화면
		p_center = new JPanel();
		pages[0] = new BubbleTea(this); // 버블티
		pages[1] = new Coffee(this);// 커피
		pages[2] = new Bakery(this);// 베이커리
		// 주문 목록
		p_south = new JPanel();
		/* 요소 조립 */
		// 메뉴 바
		for (JButton bt : bt_menu) { // improved for loop : 주로 집합데이터 형식을 대상으로 한 loop
			p_north.add(bt);
			bt.setPreferredSize(new Dimension(250, 40));
			bt.setBorder(new EmptyBorder(0, 0, 0, 0));
			bt.setBackground(new Color(207, 220, 186));
		}
		// 메뉴 화면
		for (Page p : pages) {
			p_center.add(p);
		}

		/* 스타일 및 틀 조립 */

		Menu_frame.setPreferredSize(new Dimension(800, 1000));
		Menu_frame.setLayout(new BorderLayout(0, 0));

		p_north.setBackground(new Color(207, 220, 186));
		p_north.setPreferredSize(new Dimension(800, 50));
		p_north.setBorder(new EmptyBorder(0, 0, 0, 0));

		p_center.setBackground(new Color(207, 220, 186));
		p_center.setPreferredSize(new Dimension(800, 550));
		p_center.setBorder(new EmptyBorder(0, 0, 0, 0));

		p_south.setBackground(new Color(207, 220, 186));
		p_south.setPreferredSize(new Dimension(800, 300));
		p_south.setBorder(new EmptyBorder(0, 0, 0, 0));

		p_bt.add(text_la);
		p_bt.add(la_total);
		p_bt.add(la_won);
		p_bt.add(card_bt);
		p_bt.add(cash_bt);

		p_south.add(p_bt);
		p_south.add(scrollSouth);

		Menu_frame.add(p_north, BorderLayout.NORTH);
		Menu_frame.add(p_center, BorderLayout.CENTER);
		Menu_frame.add(p_south, BorderLayout.SOUTH);

		add(Menu_frame);

		// 장바구니

		// 리스너
		addWindowListener(new WindowAdapter() { // 종료 이벤트 해당창만 종료
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		for (int i = 0; i < bt_menu.length; i++) {
			bt_menu[i].addActionListener(this);

		}

		cash_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("현금결제");
				new PaymentCash(Integer.parseInt(la_total.getText()), arrOp, Integer.parseInt(la_total.getText()));
			}
		});

		card_bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("카드결제");
				new Payment(arrOp, Integer.parseInt(la_total.getText()));
			}
		});

		// 보여주기
		showHide(1); // 첫 화면 커피로~
		Menu_frame.setBounds(0, 10, 800, 1000);
		setBounds(0, 10, 800, 1000);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		CustomButton bt = (CustomButton) obj; // down casting
		System.out.println(bt.getText());
		showHide(bt.getId());
		flag = bt.getId(); // 선택한 버튼위치 확인하기위해 flag에 저장
		// System.out.println(flag);

	}

	public void showHide(int n) { // 보여주고 싶은 페이지의 번호
		for (int i = 0; i < pages.length; i++) {
			if (n == i) {
				pages[i].setVisible(true); // 현재 선택한 버튼과 같은 인덱스를 갖는 페이지
			} else {
				pages[i].setVisible(false);
			}
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

	public HashMap<Integer, ArrayList<Product>> getProductByType() {

		HashMap<Integer, ArrayList<Product>> prMap = new HashMap<>();

		if (con != null) {
			for (int i = 0; i < Product.CATEGORY.length; i++) {
				ArrayList<Product> tempList = new ArrayList<Product>();
				String category = Product.CATEGORY[i];
				String sql = "select * from product where category_id=" + (i + 1);
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try {
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						int product_id = rs.getInt("product_id");
						String product_name = rs.getString("product_name");
						int product_price = rs.getInt("product_price");
						String filename = rs.getString("filename");

						Product pr = new Product(product_id, category, product_name, product_price, filename);
						tempList.add(pr);
					}
					prMap.put(i, tempList);
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					release(pstmt, rs);
				}
			}
		}
		return prMap;
	}

	public void createProduct(Product pr) {
		boolean overlapFlag = true;
		for (OrderProduct op : arrOp) {
			if (op.name.equals(pr.getProduct_name())) {
				System.out.println(op.name + " 가 이미 있음");
				overlapFlag = false;
			}
		}

		if (overlapFlag) {
			this.p_orderList.add(op = new OrderProduct(this, pr, pr.getProduct_name(), pr.getProduct_price(), 1));
			arrOp.add(op);
			la_total.setText(Integer.toString(Integer.parseInt(la_total.getText()) + pr.getProduct_price())); //총 금액 변경
			p_orderList.updateUI();
		}
	}

	
	
	public ArrayList<OrderProduct> getArrOp() {
		return arrOp;
	}

	public void setArrOp(ArrayList<OrderProduct> arrOp) {
		this.arrOp = arrOp;
	}

	public static void main(String[] args) {
		new UserMain();

	}
}

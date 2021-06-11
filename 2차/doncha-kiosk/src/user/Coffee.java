package user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class Coffee extends Page {
	UserMain userMain;
	String[] coffee_img;
	Integer[] menu_id; // 각메뉴 db에서의 id값 저장하기
	CustomButton[] bt_menu; // 배열생성
	JPanel p_center;// 메뉴화면

	JScrollPane scroll;

	ArrayList<Product> prList;

	public Coffee(UserMain userMain) {
		super(userMain);
		p_center = new JPanel();

		HashMap<Integer, ArrayList<Product>> prMap = userMain.getProductByType();
		prList = prMap.get(2);
//		System.out.println(prList.size());

		bringImg();// 이미지 데이터베이스에서 가져와서 이미지배열 초기화

		bt_menu = new CustomButton[coffee_img.length]; // 가져온 이미지길이만큼 버튼 생성
		// System.out.println(bubbleTea_img.length);
		for (int i = 0; i < coffee_img.length; i++) {
			// System.out.println("이미지: "+bubbleTea_img[i] + "id: "+menu_id[i]); //새로 이미지
			// 등록했으면 res파일 새로고침해주기~!
//			bt_menu[i] = new CustomButton(ImageIcon(userMain.get));
			bt_menu[i] = new CustomButton(
					new ImageIcon(this.getClass().getClassLoader().getResource("data/" + coffee_img[i])));
			bt_menu[i].setId(menu_id[i]); // 저장한 product_id를 식별 id 로 할당!!!
		}

		for (JButton bt : bt_menu) { // improved for loop : 주로 집합데이-터 형식을 대상으로 한 loop
			p_center.add(bt);
			bt.setPreferredSize(new Dimension(250, 250));
			bt.setBorder(new EmptyBorder(0, 0, 0, 0));
			bt.setBackground(new Color(207, 220, 186));
		}
		p_center.setBackground(new Color(207, 220, 186));
		p_center.setPreferredSize(new Dimension(800, 675));
		p_center.setBorder(new EmptyBorder(0, 0, 0, 0));

		scroll = new JScrollPane(p_center);
		scroll.setPreferredSize(new Dimension(800, 650));
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.getVerticalScrollBar().setUnitIncrement(15);
		add(scroll);

		// 메뉴 버튼 클릭 이벤트
		for (int i = 0; i < bt_menu.length; i++) {
			int n = i;
			bt_menu[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					userMain.createProduct(prList.get(n));//주문 내역 패널 추가
//					userMain.la_total.setText(Integer.toString(Integer.parseInt(userMain.la_total.getText()) + prList.get(n).getProduct_price())); //총 금액 변경
				} 
			});
		}

	}

	public void bringImg() {
		menu_id = new Integer[prList.size()];
		coffee_img = new String[prList.size()];

		for (int i = 0; i < prList.size(); i++) {
			menu_id[i] = prList.get(i).getProduct_id();
			coffee_img[i] = prList.get(i).getFilename();
		}
	}
}

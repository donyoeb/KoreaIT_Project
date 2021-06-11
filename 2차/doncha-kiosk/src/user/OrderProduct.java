package user;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderProduct extends JPanel {
	JLabel laName;
	JLabel laPrice;
	JLabel laCnt;
	JLabel laWon;
	JButton btMinus;
	JButton btPlus;
	JButton btRemove;

	UserMain um;
	String name;
	int price;
	int cnt;
	int totalPrice;
	
	

	public OrderProduct(UserMain um, Product pr, String name, int price, int count) {
		this.um = um;
		this.name = name;
		this.price = price;
		this.cnt = count;
		this.totalPrice = Integer.parseInt(um.la_total.getText());
		
		
		ArrayList<OrderProduct> arrOp = um.arrOp;

		OrderProduct op = null;
		// 생성
		laName = new JLabel(name);
		laCnt = new JLabel(Integer.toString(cnt));
		laPrice = new JLabel(Integer.toString(price));
		laWon = new JLabel("원");
		btMinus = new JButton("-");
		btPlus = new JButton("+");
		btRemove = new JButton("X");

		// 스타일
		setPreferredSize(new Dimension(800, 40));
		setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		setBackground(Color.WHITE);

		laName.setPreferredSize(new Dimension(300, 30));
		laName.setBackground(Color.WHITE);
		laName.setFont(new Font("맑은고딕", Font.BOLD, 20));
		laName.setHorizontalAlignment(JLabel.CENTER);

		btMinus.setPreferredSize(new Dimension(50, 30));
		btMinus.setBackground(Color.WHITE);

		laCnt.setPreferredSize(new Dimension(50, 30));
		laCnt.setBackground(Color.WHITE);
		laCnt.setFont(new Font("맑은고딕", Font.BOLD, 20));
		laCnt.setHorizontalAlignment(JLabel.CENTER);

		btPlus.setPreferredSize(new Dimension(50, 30));
		btPlus.setBackground(Color.WHITE);

		laPrice.setPreferredSize(new Dimension(200, 30));
		laPrice.setBackground(Color.WHITE);
		laPrice.setFont(new Font("맑은고딕", Font.BOLD, 20));
		laPrice.setHorizontalAlignment(JLabel.CENTER);

		laWon.setPreferredSize(new Dimension(50, 30));
		laWon.setBackground(Color.WHITE);
		laWon.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		btRemove.setPreferredSize(new Dimension(50, 30));
		btRemove.setBackground(Color.WHITE);

		// 레이아웃
		add(laName);
		add(btMinus);
		add(laCnt);
		add(btPlus);
		add(laPrice);
		add(laWon);
		add(btRemove);

		// 기능
		//갯수 1개 감소
		btMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(laCnt.getText()) > 1) { //1 아래로 내려가지 않도록
					laCnt.setText(Integer.toString(Integer.parseInt(laCnt.getText()) - 1)); //갯수 변경
					laPrice.setText(Integer.toString(pr.getProduct_price() * Integer.parseInt(laCnt.getText()))); //중간 정산 금액 변경
					um.la_total.setText(Integer.toString(Integer.parseInt(um.la_total.getText()) - pr.getProduct_price())); //총 금액 변경
					totalPrice -= pr.getProduct_price();
					cnt--;//총 갯수
					um.p_south.updateUI(); //UI 업데이트
				}
			}
		});

		//갯수 1개 증가
		btPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				laCnt.setText(Integer.toString(Integer.parseInt(laCnt.getText()) + 1)); //갯수 변경
				laPrice.setText(Integer.toString(pr.getProduct_price() * Integer.parseInt(laCnt.getText()))); //중간 정산 금액 변경
				um.la_total.setText(Integer.toString(Integer.parseInt(um.la_total.getText()) + pr.getProduct_price())); //총 금액 변경
				totalPrice += pr.getProduct_price();
				cnt++;//총 갯수
				um.p_south.updateUI(); //UI 업데이트
			}
		});

		//주문 내역 패널 제거
		btRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				um.p_orderList.remove(OrderProduct.this); //GUI 제거
				for (Iterator<OrderProduct> it = arrOp.iterator(); it.hasNext();) { //배열에서 제거
					OrderProduct opt = (OrderProduct) it.next();
					if(opt.name.equals(name)) {
						it.remove();
					}
				}
				um.la_total.setText(Integer.toString(Integer.parseInt(um.la_total.getText()) - (pr.getProduct_price() * Integer.parseInt(laCnt.getText())))); //총 금액 변경
				totalPrice -= pr.getProduct_price() * Integer.parseInt(laCnt.getText());
				cnt -= Integer.parseInt(laCnt.getText()); //총 갯수
				um.p_south.updateUI(); //UI 업데이트
			}
		});

		// 보이기
		setVisible(true);
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getCnt() {
		return cnt;
	}



	public void setCnt(int cnt) {
		this.cnt = cnt;
	}



	public int getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}

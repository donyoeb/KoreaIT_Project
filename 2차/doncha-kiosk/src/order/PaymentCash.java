package order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import user.OrderProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class PaymentCash extends JDialog {

	private JTextField cashField;
	private JTextField pnField;
	private JTextField ptField;
	private JTextField fldInsertedCash;
	private int insertedCash;
	private boolean isPurchaseSuccess = false;
	OrderList ol = new OrderList();
	PaymentUt pUt = new PaymentUt();
	PointUt ptUt = new PointUt();
	int pointCash = 0;
	public int usePoint = 0;
	
	ArrayList<OrderProduct> arrOp;
	int totalPrice;

	public PaymentCash(int cashSum, ArrayList<OrderProduct> arrOP, int totalP) {
		this.arrOp = arrOP;
		this.totalPrice = totalP;

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\korea2021_javaworkspace\\doncha-kiosk\\res\\icons\\money.png"));
		getContentPane().setBackground(new Color(207, 220, 186));
		setModal(true);
		setTitle("현금결제 모듈");
		setSize(320, 509);
		setLocationRelativeTo(getParent());
		getContentPane().setLayout(null);

		JButton button = new JButton("10000 원");
		button.setFont(new Font("굴림", Font.BOLD, 16));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 10000));
			}
		});
		button.setBounds(12, 195, 164, 56);
		getContentPane().add(button);

		JButton button_1 = new JButton("5000 원");
		button_1.setFont(new Font("굴림", Font.BOLD, 16));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 5000));
			}
		});
		button_1.setBounds(12, 257, 164, 56);
		getContentPane().add(button_1);

		JButton button_2 = new JButton("1000 원");
		button_2.setFont(new Font("굴림", Font.BOLD, 16));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 1000));
			}
		});
		button_2.setBounds(12, 320, 164, 56);
		getContentPane().add(button_2);

		JButton button_3 = new JButton("500원");
		button_3.setFont(new Font("굴림", Font.BOLD, 12));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 500));
			}
		});
		button_3.setBounds(12, 385, 73, 56);
		getContentPane().add(button_3);

		JButton button_4 = new JButton("100원");
		button_4.setFont(new Font("굴림", Font.BOLD, 12));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fldInsertedCash.setText(String.valueOf(insertedCash += 100));
			}
		});
		button_4.setBounds(103, 385, 73, 56);
		getContentPane().add(button_4);

		pnField = new JTextField();
		pnField.setBackground(new Color(175, 238, 238));
		pnField.setBounds(95, 10, 154, 31);
		getContentPane().add(pnField);
		pnField.setColumns(11);

		cashField = new JTextField();
		cashField.setBackground(new Color(175, 238, 238));
		cashField.setEditable(false);
		cashField.setText(String.valueOf(cashSum) + " 원");
		cashField.setBounds(95, 51, 154, 31);
		getContentPane().add(cashField);
		cashField.setColumns(10);

		fldInsertedCash = new JTextField();
		fldInsertedCash.setBackground(new Color(175, 238, 238));
		fldInsertedCash.setEditable(false);
		fldInsertedCash.setColumns(10);
		fldInsertedCash.setBounds(95, 92, 154, 31);
		getContentPane().add(fldInsertedCash);

		ptField = new JTextField();
		ptField.setBackground(new Color(175, 238, 238));

		ptField.setBounds(95, 139, 154, 31);
		getContentPane().add(ptField);
		cashField.setEditable(false);
		ptField.setColumns(11);
		
		JLabel label_pn = new JLabel("휴대폰 번호");
		label_pn.setBounds(12, 18, 73, 15);
		getContentPane().add(label_pn);

		JLabel label = new JLabel("결제할 금액");
		label.setBounds(12, 59, 73, 15);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("투입한 금액");
		label_1.setBounds(12, 105, 73, 15);
		getContentPane().add(label_1);
		
		JLabel label_point = new JLabel("잔여포인트");
		label_point.setBounds(12, 145, 73, 15);
		getContentPane().add(label_point);

		JButton btPoint = new JButton("포인트조회");
		btPoint.setBounds(188, 219, 97, 36);
		getContentPane().add(btPoint);
		btPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pointCash = ptUt.checkPoint(pnField.getText());

				ptField.setText(pointCash + " 점");
			}
		});

		JButton btPoint2 = new JButton("포인트사용");
		btPoint2.setBounds(188, 269, 97, 36);
		getContentPane().add(btPoint2);
		btPoint2.addActionListener(new ActionListener() {
			boolean btFlag = true;

			public void actionPerformed(ActionEvent e) {
				if (btFlag == true) {
					if (cashSum >= pointCash) {// 결제할 금액이 포인트보다 많을때
						fldInsertedCash.setText(String.valueOf(insertedCash += pointCash));
						btFlag = false;
						usePoint = pointCash;
					} else {// 결제할 금액이 포인트보다 적을때
						fldInsertedCash.setText(String.valueOf(insertedCash += cashSum));
						btFlag = false;
						usePoint = cashSum;
					}
				} else {
					JOptionPane.showMessageDialog(null, "이미 포인트를 사용하셨습니다.");
				}
			}
		});

		JButton btPurchase = new JButton("결제");

		btPurchase.setBounds(188, 329, 97, 36);
		getContentPane().add(btPurchase);

		JButton button_6 = new JButton("취소");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPurchaseSuccess(false);
				dispose();
			}
		});
		button_6.setBounds(188, 370, 97, 36);
		getContentPane().add(button_6);
		// 로고
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setPreferredSize(new Dimension(50,50));
//		lblNewLabel.setIcon(new ImageIcon("D:\\korea2021_javaworkspace\\doncha-kiosk\\res\\logo_doncha_250.png"));
//		lblNewLabel.setBounds(188, 346, 100, 177);
//		getContentPane().add(lblNewLabel);

		// 결제 버튼
		btPurchase.addActionListener(ev -> {
			if (cashSum == Integer.parseInt(fldInsertedCash.getText())) {
				System.out.println("결제 성공");
				JOptionPane.showMessageDialog(null, "결제 성공");
				ol.setPhone_number(pnField.getText());

				try {
					if (pUt.checkMember(pnField.getText()) == false) {
						pUt.joinMember(pnField.getText());

					} else {
						System.out.println("이미 회원");
					}
					pUt.orderConfirm(pnField.getText(), arrOp, totalPrice,usePoint);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ptUt.pointSub(pnField.getText(), usePoint);
				setPurchaseSuccess(true);
				dispose();
			} else if (cashSum < Integer.parseInt(fldInsertedCash.getText())) {
	            JOptionPane.showMessageDialog(null, "거스름돈 지급");
	            
	            int change = keepTheChange(Integer.parseInt(fldInsertedCash.getText()), cashSum);
	            
	            try {
	               if (pUt.checkMember(pnField.getText()) == false) {
	                  pUt.joinMember(pnField.getText());

	               } else {
	                  System.out.println("이미 회원");
	               }
	               pUt.orderConfirm(pnField.getText(), arrOp, totalPrice , usePoint);
	            } catch (SQLException e1) {
	               e1.printStackTrace();
	            }
	            ptUt.pointSub(pnField.getText(), usePoint);
	            JOptionPane.showMessageDialog(null, "거스름돈: " + change + " 원");
	            
	            setPurchaseSuccess(true);
	            dispose();
	         } else {
	            JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
	         }
		});

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setType(Type.UTILITY);

	}

	public boolean isPurchaseSuccess() {
		return isPurchaseSuccess;
	}

	public void setPurchaseSuccess(boolean isPurchaseSuccess) {
		this.isPurchaseSuccess = isPurchaseSuccess;
	}

	public int keepTheChange(int insertedCash, int cashSum) {
		return insertedCash - cashSum;

	}
}

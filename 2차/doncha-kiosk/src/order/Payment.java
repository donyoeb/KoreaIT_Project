package order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import user.OrderProduct;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {
	JPanel contentPane;

	JTextField txtFirstCardNo;
	JPasswordField pfSecond;
	JPasswordField pfThird;
	JTextField txtLast;

	JTextField txtDash;
	JTextField txtDash2;
	JTextField txtDash3;

	JLabel lbCardImage;

	JPanel panel_2;
	JPanel panel_3;

	JTextField txtPhone;

	JLabel lbReturn;
	JButton btAccept;
	JButton btCancel;
	String bankName;
	JTable orderTable;
	OrderList ol = new OrderList();
	JTextField putPN;
	
	ArrayList<OrderProduct> arrOp;
	int totalPrice;

	public Payment(ArrayList<OrderProduct> arrOp, int totalPrice) {
		this.arrOp = arrOp;
		this.totalPrice = totalPrice;
		
		setTitle("신용카드 결제 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons"));
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(207, 220, 186));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lbTitle = new JLabel("카드 결제");
		lbTitle.setFont(new Font("굴림", Font.BOLD, 24));
		lbTitle.setBounds(12, 21, 110, 38);
		panel.add(lbTitle);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(207, 220, 186));
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));

		panel_1.setBounds(12, 95, 500, 300);
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lbCardComp = new JLabel("카드사를 선택해 주세요");
		lbCardComp.setHorizontalAlignment(SwingConstants.CENTER);

		panel_1.add(lbCardComp);

		String[] bankList = { "", "국민", "비씨", "하나", "신한", "삼성", "현대", "우리", "농협" };
//		Choice chBank = new Choice();
//		for(int i=0; i<bank.length; i++){
//			   chBank.add(bank[i]);
//			  }
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("text"));
		comboBox.setModel(new DefaultComboBoxModel(bankList));
		comboBox.setSelectedIndex(0);
		// int selCombo = comboBox.getSelectedIndex();

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();
				bankName = (String) cb.getSelectedItem();
				System.out.println(bankName);

				showCardImg(bankName);
			}
		});
		panel_1.add(comboBox);

		JLabel lbCardNo = new JLabel("카드번호를 입력해 주세요.");
		lbCardNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbCardNo);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(207, 220, 186));
		panel_1.add(panel_2);

		txtFirstCardNo = new JTextField();
		txtFirstCardNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFirstCardNo.setForeground(Color.BLACK);
				txtFirstCardNo.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtFirstCardNo.setBackground(Color.WHITE);
				txtFirstCardNo.setForeground(Color.BLACK);
			}
		});
		txtFirstCardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		panel_2.add(txtFirstCardNo);
		txtFirstCardNo.setColumns(4);

		txtDash = new JTextField();
		txtDash.setBackground(new Color(192, 192, 192));
		txtDash.setText("-");
		panel_2.add(txtDash);
		txtDash.setColumns(1);

		pfSecond = new JPasswordField();
		pfSecond.setColumns(4);
		pfSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfSecond.setForeground(Color.BLACK);
				pfSecond.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfSecond.setBackground(Color.WHITE);
				pfSecond.setForeground(Color.BLACK);
			}
		});
		panel_2.add(pfSecond);

		txtDash2 = new JTextField();
		txtDash2.setText("-");
		txtDash2.setColumns(1);
		txtDash2.setBackground(Color.LIGHT_GRAY);
		panel_2.add(txtDash2);

		pfThird = new JPasswordField();
		pfThird.setColumns(4);
		pfThird.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfThird.setForeground(Color.BLACK);
				pfThird.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfThird.setBackground(Color.WHITE);
				pfThird.setForeground(Color.BLACK);
			}
		});
		panel_2.add(pfThird);

		txtDash3 = new JTextField();
		txtDash3.setText("-");
		txtDash3.setColumns(1);
		txtDash3.setBackground(Color.LIGHT_GRAY);
		panel_2.add(txtDash3);

		txtLast = new JTextField();
		txtLast.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLast.setForeground(Color.BLACK);
				txtLast.setBackground(Color.YELLOW);
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtLast.setBackground(Color.WHITE);
				txtLast.setForeground(Color.BLACK);
			}
		});

		panel_2.add(txtLast);
		txtLast.setColumns(4);

		lbCardImage = new JLabel("");
		lbCardImage.setSize(350, 400);
		panel_2.add(lbCardImage);

		JLabel lbPhone = new JLabel("연락처");
		lbPhone.setHorizontalAlignment(SwingConstants.CENTER);

		putPN = new JTextField();

		panel_1.add(lbPhone);
		panel_1.add(putPN);

//		JLabel lbTotalPoint = new JLabel("사용하실 포인트");
//		panel_1.add(lbTotalPoint);

		JLabel lbTotalPrice = new JLabel("총 결제금액");
		lbTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbTotalPrice);

		JLabel lbTotalMoney = new JLabel(totalPrice + " 원");
		lbTotalMoney.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbTotalMoney);

		JPanel panel_3 = new JPanel();

		panel_3.setLayout(null);
		panel_3.setBounds(145, 400, 250, 50);
		panel_3.setBackground(new Color(207, 220, 186));
		JButton btAccept = new JButton("결 제");
		JButton btCash = new JButton("현금 결 제");
		JButton btCancel = new JButton("취 소");

		btAccept.setBounds(10, 5, 100, 45);
		btCash.setBounds(80, 5, 100, 45);
		btCancel.setBounds(150, 5, 100, 45);

		panel_3.add(btAccept);
//		panel_3.add(btCash);
		panel_3.add(btCancel);
		panel.add(panel_3);

		btAccept.addActionListener(new ActionListener() { // 결제확인
			public void actionPerformed(ActionEvent e) {
				PaymentComplete pc = new PaymentComplete();
				pc.setVisible(true);
				PaymentUt pUt = new PaymentUt();

				ol.setPhone_number(putPN.getText());
				System.out.println("폰번은 : " + putPN.getText());

				try {
					if (pUt.checkMember(putPN.getText()) == false) {
						pUt.joinMember(putPN.getText());

					} else {
						System.out.println("이미 회원");
					}
					pUt.orderConfirm(putPN.getText(), arrOp, totalPrice, 0);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});


		btCancel.addActionListener(new ActionListener() { // 결제취소 - 창닫기
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
//		setType(Type.UTILITY);

	}

	public void showCardImg(String bankName) {// 카드사 로고 출력 메서드

		if (bankName == "국민") { // 국민
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\kb.png");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "비씨") { // 비씨
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\bc.png");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "하나") { // 하나
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\hn.jpg");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "신한") { // 신한
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\sh.jpg");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "삼성") { // 삼성
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\ss.PNG");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "현대") { // 현대
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\hd.jpg");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "우리") { // 우리
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\wr.png");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		}
		if (bankName == "농협") { // 농협
			ImageIcon ic = new ImageIcon("C:\\korea202102_javaworkspace\\doncha-kiosk\\res\\icons\\nh.png");
			lbCardImage.setIcon(ic);
			lbCardImage.repaint();
		} else {
			lbCardImage.setText("");
			lbCardImage.repaint();
		}
	}

//	public static void main(String[] args) {
//		Payment payment = new Payment(arrOp);
//		payment.setVisible(true);
//	}

}

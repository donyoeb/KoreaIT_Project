package order;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentComplete extends JFrame {

	private JPanel contentPane;
	JButton btComfirm;
	PaymentUt pUt = new PaymentUt();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentComplete frame = new PaymentComplete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaymentComplete() {
		setTitle("결제완료");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("D:\\korea2021_javaworkspace\\doncha-kiosk\\res\\icons\\icon_card.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 359, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(207, 220, 186));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("결제가 완료되었습니다.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 10, 142, 56);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("이용해 주셔서 감사합니다.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(85, 33, 172, 56);
		contentPane.add(label);

		btComfirm = new JButton("확인");
		btComfirm.setBounds(122, 114, 97, 23);
		contentPane.add(btComfirm);

		btComfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}
}

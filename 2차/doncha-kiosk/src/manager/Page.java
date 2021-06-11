package manager;

import java.awt.Dimension;

import javax.swing.JPanel;

//모든 페이지의 부모패널 정의 (공통된 코드가 있을 경우 이 클래스에 적용)
public class Page extends JPanel{
	private ManagerMain managerMain;
	
	//다른 패키지에서도 접근할 수 있도록
	public ManagerMain getAppMain() {
		return managerMain;
	}
	
	public Page(ManagerMain managerMain) {
		this.managerMain=managerMain;
		setPreferredSize(new Dimension(1200, 700));
		setVisible(false);
	}
}

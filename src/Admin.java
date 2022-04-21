package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Admin extends JFrame{
	
	JTabbedPane tabpane;
	public Admin(String name) {
			
		setTitle("ͼ�����ϵͳ");
		setSize(1000, 800);
		setLocationRelativeTo(null);
		Toolkit t =Toolkit.getDefaultToolkit();
		Image img = t.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel jLabel = new JLabel(i);
		jLabel.setBounds(0, 0, 1000, 800);
		
		
		
		Container c = getContentPane();
		tabpane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		c.add(tabpane, BorderLayout.CENTER);
		
		
		tabpane.setFont(new Font("����",Font.BOLD,18));
		tabpane.setBackground(Color.pink);
		
		/*������*/
		MainMenu mm = new 	MainMenu();
		tabpane.addTab("������",mm.panel);
		
		/*����ͼ�����*/
		SearchBook sb = new SearchBook();
		sb.setName(name);
		tabpane.addTab("ͼ�����", sb.laypane);
		
		
		/*������ʷ����*/
		AdminBorrowHistory abh = new AdminBorrowHistory();
		abh.setPanel();
		sb.setModel(abh.model);
		tabpane.addTab("������ʷ", abh.laypane);
		
		
		/*��ɾ��ͼ��*/
		ChangeBook cb = new ChangeBook();
		tabpane.addTab("ͼ�����",cb.laypane1);
		
		/*�û�����*/
		UserManage um = new UserManage();
		tabpane.addTab("�û�����", um.panel);
		
		
		/*�޸���Ϣ����*/
		ChangeInfo ci = new ChangeInfo();
		ci.setName(name);
		tabpane.addTab("�޸���Ϣ", ci.panel);
		
		
//		/*�˳���¼*/
//		mm.button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

package menu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.BookData;


public class BorrowHistory extends JFrame{
	private String name;
	public JLayeredPane laypane = new JLayeredPane();
	DefaultTableModel model ;
	JScrollPane jp;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BorrowHistory() {
		//setTable();
	}
	
	public void setPanel() {

		//�ı䴰��ͼ��
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		/*���ô��ڱ���ͼ��*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0,1000, 800);
				
		
		JLabel lab = new JLabel("ͼ�������ʷ");
		Font font = new Font("����",Font.BOLD,40);
		lab.setFont(font);
		lab.setBounds(330, 40, 800, 100);

		
		model = new DefaultTableModel();
		model.addColumn("ͼ����", new Vector<Integer>());
		model.addColumn("����", new Vector<String>());
		model.addColumn("����", new Vector<Date>());
		model.addColumn("����״̬", new Vector<String>());
		JTable table = new JTable(model);
		
		jp = new JScrollPane(table);
		jp.setBounds(90, 130, 800, 500);
		
		//System.out.println(name);
		BookData bd = new BookData();
		try {
			bd.showHistory(model, name);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		JTableHeader head = table.getTableHeader();//��������ͷ����
		head.setPreferredSize(new Dimension(head.getWidth(),35));//���ñ�ͷ����С
		head.setFont(new Font("����",Font.BOLD,15));//���ñ������
		table.setRowHeight(30);//���ñ���п�
		table.setFont(new Font("����",Font.BOLD,20));//���ñ�����������С
		
		
		laypane.add(label, new Integer(0),0);
		laypane.add(lab, new Integer(30),1);
		laypane.add(jp, new Integer(130),2);
		
		label.setOpaque(false);
		laypane.setOpaque(false);
	}
	
}

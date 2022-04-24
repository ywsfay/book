package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import database.ABorrowHistory;
import database.BookData;

public class AdminBorrowHistory extends JFrame{
	private String book;
	private int id;
	private String select ;
	public int bookid;//��ı��
	public Date borrowtime;//����ʱ��
	private String borrower;//������
	public String lend;//�Ƿ��ڹ�
	public String bookname;//����
	
	public JLayeredPane laypane = new JLayeredPane();
		private String name;
		
		DefaultTableModel model ;
		JScrollPane jp;
		
		public void setName(String name) {
			this.name = name;
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
			
			Font font1 = new Font("����",Font.BOLD,13);
			Font font2 = new Font("����",Font.BOLD,20);
					
			/*���3�еı�ǩ*/
			Font font = new Font("����",Font.BOLD,20);
			JLabel lab3 = new JLabel("��ѡ���ѯ��ʽ��");
			lab3.setFont(font);
			lab3.setBounds(140, 60, 600, 30);
			
			
			/*���3�еĲ�ѯ������*/
			Dimension dimension = new Dimension(220,30);
			JComboBox<String> j = new JComboBox<>();
			j.setSize(dimension);
			j.addItem("����������ѯ");
			j.addItem("���ս����˲�ѯ");
			j.addItem("���ձ�Ų�ѯ");
			j.setBounds(140, 100,220, 30);
			j.setBackground(Color.pink );
			j.setFont(font1);
			
			
			/*���3�е�������*/
			JTextField text3 = new JTextField();
			Dimension dimension1 = new Dimension(270,30);
			text3.setFont(font1);
			text3.setSize(dimension1);
			text3.setBackground(Color.pink);
			text3.setBounds(390,100, 270, 30);
			
			/*��ť*/
			JButton button = new JButton("����");
			button.setBackground(Color.pink);
			button.setBounds(670, 100, 120, 30);
			button.setFont(font2);
			
			model = new DefaultTableModel();
			model.addColumn("ͼ����", new Vector<Integer>());
			model.addColumn("����", new Vector<String>());
			model.addColumn("������", new Vector<String>());
			model.addColumn("����", new Vector<Date>());
			model.addColumn("����״̬", new Vector<String>());
			JTable table = new JTable(model);
			
			jp = new JScrollPane(table);
			jp.setBounds(90, 160, 800, 500);
			
			/*��ʾ���н�����¼*/
			ABorrowHistory abh = new ABorrowHistory();
			try {
				abh.allHistory(model);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*����������¼�*/
			select = "����������ѯ";
			j.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					
					if(e.getStateChange()==ItemEvent.SELECTED) {
						select =(String) e.getItem();
						
					}
				}
			});
			
			
			
			/*��������*/
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					model.setRowCount(0);
					if(select.equals("����������ѯ")) {
						book = text3.getText().trim();
						try {
							
							abh.bookSelect(model, book);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						
					}else if(select.equals("���ս����˲�ѯ")) {
						borrower = text3.getText().trim();
						try {
							
							abh.borrowerSelect(model, borrower);
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						
					}else if(select.equals("���ձ�Ų�ѯ")) {
						
						try {
							id = Integer.parseInt(text3.getText().trim());
							abh.idSelect(model, id);
						} catch (Exception e1) {
							
						}
					}
				}
			});
			
			
			
			JTableHeader head = table.getTableHeader();//��������ͷ����
			head.setPreferredSize(new Dimension(head.getWidth(),35));//���ñ�ͷ����С
			head.setFont(new Font("����",Font.BOLD,15));//���ñ������
			table.setRowHeight(30);//���ñ���п�
			table.setFont(new Font("����",Font.BOLD,20));//���ñ�����������С
			
			
			laypane.add(label, new Integer(0),0);
			laypane.add(lab3,new Integer(150),1);
			laypane.add(j,new Integer(100),2);
			laypane.add(text3,new Integer(100),3);
			laypane.add(button, new Integer(100),4);
			laypane.add(jp, new Integer(200), 5);
			laypane.add(jp, new Integer(130),6);
			
			label.setOpaque(false);
			laypane.setOpaque(false);
		}
		
}


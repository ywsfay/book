package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import database.BookData;

public class ChangeBook extends JFrame{
	
	private String book;
	private String author;
	private int id;
	public JLayeredPane laypane1 = new JLayeredPane();
	private DefaultTableModel model;
	private String select ;
	private JCheckBox box;
	private int selectrow;
	private int selectcolumn;
	public int bookid;//��ı��
	public Date borrowtime;//����ʱ��
	private String borrower;//������
	public String lend;//�Ƿ��ڹ�
	public String bookname;//����
	private String bookname1;//����1
	private String bookname2;//����2
	DefaultTableModel model1;
	private String borroww;
	private String returnn;
	
	public void setName(String name) {
		this.borrower = name;
		
	}
	
	public void setModel(DefaultTableModel model1) {
		this.model1 = model1;
	}
	
	public ChangeBook()  {
		
		/*
		 * ��ѯͼ��
		 */
		Font font1 = new Font("����",Font.BOLD,13);
		Font font2 = new Font("����",Font.BOLD,20);
		
		
		//�ı䴰��ͼ��
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		this.setIconImage(img);
		
		/*���ô��ڱ���ͼ��*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 1000, 800);
		
		
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
		j.addItem("�������߲�ѯ");
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
		
		/*�½����*/
		model = new DefaultTableModel();
		model.addColumn("�鱾���", new Vector<Integer>());
		model.addColumn("����",new Vector<String>());
		model.addColumn("����",new Vector<String>());
		model.addColumn("�Ƿ��ڹ�",new Vector<String>());
		model.addColumn("ѡ��ͼ��", new Vector<String>());
		JTable table = new JTable(model);
		
		JScrollPane jp = new JScrollPane(table);
		jp.setBounds(100, 150, 750, 450);
		
		/*��ʾ��ȫ��ͼ��*/
		BookData bd = new BookData();
		try {
			
			bd.selectAll(model);
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
		
		
		JTableHeader head = table.getTableHeader();//��������ͷ����
		head.setPreferredSize(new Dimension(head.getWidth(),35));//���ñ�ͷ����С
		head.setFont(new Font("����",Font.BOLD,15));//���ñ������
		table.setRowHeight(30);//���ñ���п�
		table.setFont(new Font("����",Font.ROMAN_BASELINE,13));//���ñ�����������С
		
		/*ʹ��Ԫ���е����ݾ���*/
		DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		/*��Ӹ�ѡ��*/
		table.getColumnModel().getColumn(4).setCellRenderer(new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, 
					boolean isSelected, boolean hasFocus,int row, int column) {
				/*���帴ѡ��*/
				box = new JCheckBox();
				/*ʹ���н�����ж�Ӧ�ĸ�ѡ��ѡ��*/
				box.setSelected(isSelected);
				
				/*ʹ��ѡ���ڱ���о���*/
				box.setHorizontalAlignment((int)0.5f);
				return box;
			}
		});
		
		
		
		JButton button1 = new JButton("���");
		JButton button2 = new JButton("ɾ��");
		JButton button3 = new JButton("�޸�");
		button1.setFont(font2);
		button2.setFont(font2);
		button3.setFont(font2);
		button1.setBackground(Color.pink);
		button1.setBounds(160, 630, 170, 40);
		button2.setBackground(Color.pink);
		button2.setBounds(405,630, 170, 40);
		button3.setBackground(Color.pink);
		button3.setBounds(630,630, 170, 40);
		
		/*��������ڷֲ㴰����*/
		laypane1.add(label, new Integer(0),0);
		laypane1.add(lab3,new Integer(150),1);
		laypane1.add(j,new Integer(100),2);
		laypane1.add(text3,new Integer(100),3);
		laypane1.add(button, new Integer(100),4);
		laypane1.add(jp, new Integer(200), 5);
		laypane1.add(button1, new Integer(630),6);
		laypane1.add(button2, new Integer(630),7);
		laypane1.add(button3, new Integer(630),8);
		

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
						
						bd.bookSelect(model,book);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				}else if(select.equals("�������߲�ѯ")) {
					author = text3.getText().trim();
					try {
						
						bd.authorSelect(model,author);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					
				}else if(select.equals("���ձ�Ų�ѯ")) {
					id = Integer.parseInt(text3.getText().trim());
					try {
						
						bd.idSelect(model,id);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		
		/*ѡ���м���*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectrow = table.getSelectedRow();
				bookid =  (int) table.getValueAt(selectrow, 0);//��ȡ��ѡ�鱾���
				bookname = (String) table.getValueAt(selectrow, 1);//��ȡ��ѡ����
				lend= (String) table.getValueAt(selectrow, 3);//��ȡ��ѡ�鱾״̬
				
			}
		});
		
		borroww = "���";
		returnn = "�˻�";
		
		
		/*���ͼ��*/
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddBook(model);
				
			}
		});
		
		/*�޸�ͼ��*/
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FixBook(model,bookid);
				
			}
		});
		
		/*ɾ��ͼ��*/
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new DeleteBook(model,bookid,bookname);
			}
		});
		
		
		
//		/*ɾ��ͼ�����*/
//		button2.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(lend.equals("��")) {
//					bookname1 = "��" + bookname + "��";
//					JOptionPane.showMessageDialog(null, bookname1+"�˻��ɹ�", "лл����ʹ��", JOptionPane.PLAIN_MESSAGE);
//					try {
//						bd.updatereturn(model, bookname);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					/*������ʷ��ӵ����ݿ�*/
//					try {
//						bd.addHistory(bookid, borrower, bookname, borrowtime, returnn);
//						
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					
//					
//					/*���½�����ʷ*/
//					try {
//						bd.showHistory(model1, borrower);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		
//		
//		/*�޸�ͼ�����*/
//		button3.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(lend.equals("��")) {
//					/*��ȡ����ʱ��*/
//					try {
//						borrowtime = (Date) bd.booktime();
//					} catch (Exception e2) {
//						// TODO Auto-generated catch block
//						e2.printStackTrace();
//					}
//					
//					/*�����ڹ���Ϣ*/
//					bookname2 = "��" + bookname + "��";
//					JOptionPane.showMessageDialog(null, bookname2+"���ĳɹ�", "��ϲ��", JOptionPane.PLAIN_MESSAGE);
//					try {
//						bd.updatelend(model, bookname);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//					
//					/*������ʷ��ӵ����ݿ�*/
//					try {
//						bd.addHistory(bookid, borrower, bookname, borrowtime, borroww);
//						
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					
//					
//					/*���½�����ʷ*/
//					try {
//						bd.showHistory(model1, borrower);
//					} catch (Exception e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}else {
//					bookname2 = "��" + bookname + "��";
//					JOptionPane.showMessageDialog(null, bookname+"�ѱ�����", "��Ǹ", JOptionPane.PLAIN_MESSAGE);
//				}
//				
//			}
//		});
//	
		
		
		label.setOpaque(false);
		laypane1.setOpaque(false);
		
		text3.setOpaque(false);
	} 
	
}

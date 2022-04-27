package menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.ManageUser;

public class FixPass {
	
	public FixPass() {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setTitle("�޸�����");
		
		//�ı䴰��ͼ��
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		f.setIconImage(img);
		
		/*���ô��ڱ���ͼ��*/
		Icon i = new ImageIcon("picture\\admin_background.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 500, 500);
		
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		Font font = new Font("����",Font.BOLD,30);
		Font font1 = new Font("����",Font.PLAIN,20);
		Dimension dimension = new Dimension(300,40);
		Dimension dimension1 = new Dimension(200,40);
		
		/*�û�����ǩ*/
		JLabel labname= new JLabel(" �û�����");
		labname.setFont(font);
		panel1.add(labname);
		panel1.setBounds(50, 30, 200, 60);
		
		/*�û��������ı���*/
		JTextField textname = new JTextField(12);
		panel2.setLayout(null);
		textname.setSize(dimension);
		textname.setFont(font1);
		panel2.add(textname);
		panel2.setBounds(100, 90, 500, 50);
		
		/*�����ǩ*/
		JLabel labpass = new JLabel("���룺");
		labpass.setFont(font);
		panel3.add(labpass);
		panel3.setBounds(50, 160, 200, 60);
		
		/*���������ı���*/
		JPasswordField textpass = new JPasswordField(12);
		panel4.setLayout(null);
		textpass.setSize(dimension);
		textpass.setFont(font1);
		panel4.add(textpass);
		panel4.setBounds(100, 220, 500, 50);
		
		
		/*��Ӱ�ť*/
		JButton button = new JButton("ȷ���޸�");
		button.setPreferredSize(dimension);
		button.setBackground(Color.PINK);
		button.setFont(new Font("����",Font.BOLD,25));
		panel5.add(button);
		panel5.setBounds(100, 300, 300, 100);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textname.getText().trim();
				String password = textpass.getText().trim();
				ManageUser mu = new ManageUser();
				try {
					mu.changePass(name, password);
					JOptionPane.showMessageDialog(null, "�޸�����ɹ�", "�޸�����", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		f.add(panel1);
		f.add(panel2);
		f.add(panel3);
		f.add(panel4);
		f.add(panel5);
		f.add(label);
		
		textname.setOpaque(false);
		textpass.setOpaque(false);
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		
		f.setVisible(true);
	}
}



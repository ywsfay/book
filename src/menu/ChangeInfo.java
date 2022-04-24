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

import database.ChangeInfoData;

public class ChangeInfo extends JFrame{
	JPanel panel = new JPanel();
	private String password1;
	private String password2;
	private String password3;
	private String borrowname;
	private String borrower;
	private int flag = 0;
	
	public void setName(String borrower) {
		this.borrower = borrower;
	}
	
	public ChangeInfo() {
		
		/*
		 * �޸���Ϣ
		 */
		
		panel.setLayout(null);
		
		
		/*���ô��ڱ���ͼ��*/
		Icon i = new ImageIcon("picture\\background5.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0,1000, 800);
		
		/*���5�������ǩ*/
		JLabel prepassword = new JLabel("������:");
		Font font2 = new Font("����",Font.BOLD,25);
		prepassword.setFont(font2);
		prepassword.setBounds(300, 80, 600, 30);
		panel.add(prepassword);
		
		
		/*���5�������ı���*/
		JPasswordField textprepass = new JPasswordField();
		Dimension d = new Dimension(350,45);
		textprepass.setFont(font2);
		textprepass.setSize(d);
		textprepass.setBounds(300, 130, 350, 45);
		panel.add(textprepass);
		
		
		/*�����ǩ*/
		JLabel password = new JLabel("���룺");
		password.setFont(font2);
		password.setBounds(300,190, 600, 30);
		panel.add(password);
		
		
		/*�����ı���*/
		JPasswordField textpass = new JPasswordField();
		textpass.setFont(font2);
		textpass.setSize(d);
		textpass.setBounds(300, 240, 350, 45);
		panel.add(textpass);
		
		
		/*ȷ�������ǩ*/
		JLabel repassword = new JLabel("ȷ�����룺");
		repassword.setFont(font2);
		repassword.setBounds(300, 300, 600, 30);
		panel.add(repassword);
		
		/*ȷ�������ı���*/
		JPasswordField textrepass = new JPasswordField();
		textrepass.setFont(font2);
		textrepass.setSize(d);
		textrepass.setBounds(300, 350, 350, 45);
		panel.add(textrepass);
		
		
		/*�޸�������ǩ*/
		JLabel name = new JLabel("������");
		name.setFont(font2);
		name.setBounds(300, 410, 600, 30);
		panel.add(name);
		
		/*�޸������ı���*/
		JTextField textname = new JTextField();
		textname.setFont(font2);
		textname.setSize(d);
		textname.setBounds(300, 460, 350, 45);
		panel.add(textname);
		
		
		/*ȷ���޸İ�ť*/
		JButton button = new JButton("ȷ���޸�");
		Font font = new Font("����",Font.BOLD,16);
		button.setFont(font);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.PINK);
		button.setBounds(300, 550, 350, 50);
		panel.add(button);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				password1 = textprepass.getText().trim();
				password2 = textpass.getText().trim();
				password3 = textrepass.getText().trim();
				borrowname = textname.getText().trim();
				String regex = "\\p{Alnum}";
				
				ChangeInfoData ci = new ChangeInfoData();
				try {
					flag = ci.checkPass(borrower, password1);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(flag==1) {
					if((password2.length()<6||password2.length()>12)||password2.matches(regex)) {
						JOptionPane.showMessageDialog(null, "�������벻����Ҫ��", "����", JOptionPane.WARNING_MESSAGE);
					}else {
						if(!(password2.equals(password3))){
							JOptionPane.showMessageDialog(null, "��������������벻��ͬ", "����",JOptionPane.ERROR_MESSAGE);
						}else {
							
							try {
								ci.savePass(password2, borrower);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							try {
								ci.savePass2(borrowname, borrower);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "��Ϣ���ĳɹ�", "��ϲ",JOptionPane.PLAIN_MESSAGE);
						}
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "�Բ������ľ���������", "����������", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		panel.add(label);
		
		panel.setOpaque(false);
		textprepass.setOpaque(false);
		textpass.setOpaque(false);
		textrepass.setOpaque(false);
		textname.setOpaque(false);
		
		
		this.add(panel);
	}
}

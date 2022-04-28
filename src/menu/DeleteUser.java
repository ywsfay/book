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

public class DeleteUser {
	
	public DeleteUser() {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setTitle("删除用户");
		
		//改变窗口图标
		Toolkit tool = Toolkit.getDefaultToolkit();
		Image img = tool.getImage("picture\\sign.jpg");
		f.setIconImage(img);
		
		/*设置窗口背景图案*/
		Icon i = new ImageIcon("picture\\admin_background.jpg");
		JLabel label = new JLabel(i);
		label.setBounds(0, 0, 500, 500);
		
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel5 = new JPanel();
		
		Font font = new Font("宋体",Font.BOLD,30);
		Font font1 = new Font("宋体",Font.PLAIN,20);
		Dimension dimension = new Dimension(300,40);
		Dimension dimension1 = new Dimension(200,40);
		
		/*用户名标签*/
		JLabel labname= new JLabel(" 用户名：");
		labname.setFont(font);
		panel1.add(labname);
		panel1.setBounds(50, 100, 200, 60);
		
		/*用户名输入文本框*/
		JTextField textname = new JTextField(12);
		panel2.setLayout(null);
		textname.setSize(dimension);
		textname.setFont(font1);
		panel2.add(textname);
		panel2.setBounds(100, 180, 500, 50);
		
		
		
		
		/*添加按钮*/
		JButton button = new JButton("确定删除");
		button.setPreferredSize(dimension);
		button.setBackground(Color.PINK);
		button.setFont(new Font("宋体",Font.BOLD,25));
		panel5.add(button);
		panel5.setBounds(100, 250, 300, 100);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textname.getText().trim();
				ManageUser mu = new ManageUser();
				try {
					mu.deleteUser(name);
					JOptionPane.showMessageDialog(null, "成功删除此用户", "删除", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		

	}
}



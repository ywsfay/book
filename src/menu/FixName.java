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

public class FixName {
	
	public FixName() {
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		f.setLayout(null);
		f.setTitle("修改姓名");
		
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
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		Font font = new Font("宋体",Font.BOLD,30);
		Font font1 = new Font("宋体",Font.PLAIN,20);
		Dimension dimension = new Dimension(300,40);
		Dimension dimension1 = new Dimension(200,40);
		
		/*用户名标签*/
		JLabel labusername= new JLabel(" 用户名：");
		labusername.setFont(font);
		panel1.add(labusername);
		panel1.setBounds(50, 30, 200, 60);
		
		/*用户名输入文本框*/
		JTextField textusername = new JTextField(12);
		panel2.setLayout(null);
		textusername.setSize(dimension);
		textusername.setFont(font1);
		panel2.add(textusername);
		panel2.setBounds(100, 90, 500, 50);
		
		/*姓名标签*/
		JLabel labname = new JLabel("姓名：");
		labname.setFont(font);
		panel3.add(labname);
		panel3.setBounds(50, 160, 200, 60);
		
		/*姓名输入文本框*/
		JTextField textname = new JTextField(12);
		panel4.setLayout(null);
		textname.setSize(dimension);
		textname.setFont(font1);
		panel4.add(textname);
		panel4.setBounds(100, 220, 500, 50);
		
		
		/*添加按钮*/
		JButton button = new JButton("确定修改");
		button.setPreferredSize(dimension);
		button.setBackground(Color.PINK);
		button.setFont(new Font("宋体",Font.BOLD,25));
		panel5.add(button);
		panel5.setBounds(100, 300, 300, 100);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = textusername.getText().trim();
				String name = textname.getText().trim();
				ManageUser mu = new ManageUser();
				try {
					mu.changeName(username, name);
					JOptionPane.showMessageDialog(null, "修改姓名成功", "修改", JOptionPane.PLAIN_MESSAGE);
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
		textusername.setOpaque(false);
		panel1.setOpaque(false);
		panel2.setOpaque(false);
		panel3.setOpaque(false);
		panel4.setOpaque(false);
		panel5.setOpaque(false);
		
		f.setVisible(true);
	}
}



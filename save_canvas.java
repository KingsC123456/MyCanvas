package Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Choose.Ichoose;
import MysqlConnnect.connect;

public class save_canvas implements ActionListener{
	connect con;
	JFrame iFrame;
	JDialog dialog;
	JTextField text1;
	Ichoose panel = new MyPanel();
	MyPoint[] mp;
	
	public void set_window(){
		con = new connect();
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		panel1.setLayout(new GridBagLayout());
		
		JLabel lable1 = new JLabel(" 图形名称：");
		lable1.setFont(new Font("华文仿宋", Font.BOLD, 14));
		lable1.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLable = new GridBagConstraints();
		gbc_lblNewLable.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLable.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLable.anchor = GridBagConstraints.EAST;
		gbc_lblNewLable.gridx = 3;
		gbc_lblNewLable.gridy = 2;
		panel1.add(lable1, gbc_lblNewLable);
		
		text1 = new JTextField(11);
		text1.setFont(new Font("华文仿宋", Font.BOLD, 14));
		GridBagConstraints textField = new GridBagConstraints();
		textField.fill = GridBagConstraints.HORIZONTAL;
		textField.insets = new Insets(0, 0, 5, 5);
		textField.anchor = GridBagConstraints.NORTHWEST;
		textField.gridx = 4;
		textField.gridy = 2;
		textField.gridwidth = 4;
		panel1.add(text1,textField);
		text1.setColumns(10);
		
		JButton button0 = new JButton("确定");
		button0.setFont(new Font("华文仿宋", Font.BOLD, 14));
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.insets = new Insets(10, 0, 2, 5);
		gbc_button1.anchor = GridBagConstraints.SOUTH;
		gbc_button1.gridx = 7;
		gbc_button1.gridy = 3;
		gbc_button1.gridheight =3;
		gbc_button1.gridwidth = 10;
		panel1.add(button0, gbc_button1);
		
		button0.addActionListener(new insert());

		dialog = new JDialog(iFrame, "保存绘画信息",true);
    	dialog.add(panel1);
    	dialog.setBackground(Color.white);
    	dialog.setSize(400, 300);
    	dialog.setLocation(600, 400);
    	dialog.setVisible(true);
		
	}
	
	public save_canvas(JFrame iFrame,Ichoose panel){
		this.iFrame = iFrame;
		this.panel = panel;
		mp = panel.return_point();
    }
	
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e){
		if(panel.c.drawType == 0){
			new tips(iFrame, "抱歉，自由绘画不能储存");
		}else if(mp[0].x == 0&&mp[0].y==0&&mp[1].x==0&&mp[1].y==0){
			new tips(iFrame, "画板为空");
		}else{
			this.set_window();
		}
	}
	
	class insert implements ActionListener{
        String name;
        @SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e){
        	this.name = text1.getText();
        	if(name.equals("")){
        		new tips(iFrame,"没有输入文件名");//插入相关小提示
        	}else{
            	int state = con.search(name);
            	if(state == 0){
            		new tips(iFrame,"该文件名已经存在诶，考虑换一个？");
            	}else{
            		state = con.insert(name, mp[1].x, mp[0].x, mp[1].y, mp[0].x, panel.c.c, panel.c.l, panel.c.drawType);
            		if(state == 0){
            			new tips(iFrame,"数据库可能疯了，要不稍后试试？");
            		}else{
            			dialog.setVisible(false);
            			new tips(iFrame,"存入成功");
            		}
            	}
        	}
        }
    }
}

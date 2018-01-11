package Window;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Canvas.canvas;
import Choose.Ichoose;
import MysqlConnnect.connect;

public class read_canvas implements ActionListener{
	connect con;
	JFrame iFrame;
	JDialog dialog;
	JComboBox<Object> box1;//下拉框;
	String[] str1;
	Ichoose panel = new MyPanel();
	MyPoint[] mp;
	
	public void set_window(){
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
		
		box1.setFont(new Font("华文仿宋", Font.BOLD, 14));
		GridBagConstraints textField2 = new GridBagConstraints();
		textField2.fill = GridBagConstraints.HORIZONTAL;
		textField2.insets = new Insets(0, 0, 5, 5);
		textField2.gridx = 5;
		textField2.gridy = 2;
		textField2.gridwidth = 10;
		panel1.add(box1,textField2);
		box1.setPreferredSize(new Dimension(180, 20));
		
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

		dialog = new JDialog(iFrame, "读取绘画信息",true);
    	dialog.add(panel1);
    	dialog.setBackground(Color.white);
    	dialog.setSize(400, 300);
    	dialog.setLocation(600, 400);
    	dialog.setVisible(true);
		
	}
	
	public read_canvas(JFrame iFrame,Ichoose panel){
		con = new connect();
		this.iFrame = iFrame;
		this.panel = panel;
		mp = panel.return_point();
    }
	
	public void actionPerformed(ActionEvent e){
		str1 = con.searchCourseName();
		box1 = new JComboBox<Object>(str1);
		this.set_window();
	}
	
	class insert implements ActionListener{
        String name;
        
		public void actionPerformed(ActionEvent e){
        	this.name = (String)box1.getSelectedItem();
        	canvas c = con.returnAll(name);
        	dialog.setVisible(false);
        	panel.rebuild(c);
        }
    }
}

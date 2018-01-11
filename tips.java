package Window;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class tips {
	public tips(JFrame iFrame,String say){//尝试是否将小提示添加一个按钮，确定
    	JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		
		JLabel lable1 = new JLabel(say);
		lable1.setFont(new Font("华文仿宋", Font.BOLD, 14));
		lable1.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lblNewLable = new GridBagConstraints();
		gbc_lblNewLable.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLable.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLable.anchor = GridBagConstraints.EAST;
		gbc_lblNewLable.gridx = 3;
		gbc_lblNewLable.gridy = 2;
		panel1.add(lable1, gbc_lblNewLable);
    	
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridBagLayout());
		
		JButton button0 = new JButton("确定");
		button0.setFont(new Font("华文仿宋", Font.BOLD, 14));
		//button0.setBorder(BorderFactory.createRaisedBevelBorder()); //设置边框
		GridBagConstraints gbc_button1 = new GridBagConstraints();
		gbc_button1.insets = new Insets(5, 0, 5, 0);
		gbc_button1.anchor = GridBagConstraints.SOUTH;
		gbc_button1.gridx = 7;
		gbc_button1.gridy = 8;
		gbc_button1.gridheight =3;
		gbc_button1.gridwidth = 4;
		panel2.add(button0, gbc_button1);
		
    	JDialog dialog = new JDialog(iFrame, "提示",true);
    	dialog.setLayout(new BorderLayout());
    	panel1.setBorder(new TitledBorder(new EtchedBorder()));
    	
    	button0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dialog.setVisible(false);
			}
		});
    	dialog.getContentPane().add(panel1, BorderLayout.CENTER);
    	dialog.getContentPane().add(panel2, BorderLayout.SOUTH);
    	
    	dialog.setSize(500, 200);
    	dialog.setLocation(600, 400);
    	dialog.setVisible(true);
    }
}

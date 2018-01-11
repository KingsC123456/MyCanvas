package Window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Canvas.canvas;
import Choose.Ichoose;
import Choose.choose_enlarge;
import Choose.choose_moveBottom;
import Choose.choose_moveLeft;
import Choose.choose_moveRight;
import Choose.choose_moveTop;
import Choose.choose_reduce;
import Shap.shap;
import Tactics.Itactics;
import Tactics.tactics_four;
import Tactics.tactics_handler;
import Tactics.tactics_one;
import Tactics.tactics_three;
import Tactics.tactics_two;

@SuppressWarnings("serial")
public class iframe extends JFrame{
	tactics_handler tc = new tactics_handler();
	Itactics tactics;
	canvas c = new canvas();
    final Ichoose panel = new MyPanel();
	
	public iframe(){
		super("画板");
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu []menu = {new JMenu("图形"), new JMenu("线条"), new JMenu("颜色"), new JMenu("操作"),new JMenu("策略"),new JMenu("设置")};
		JMenuItem [][]menuItem = { 
			{new JMenuItem("自由"),new JMenuItem("线形"),new JMenuItem("圆形"),new JMenuItem("矩形"),new JMenuItem("三角形")}, 
            {new JMenuItem("实线"), new JMenuItem("虚线")}, 
            {new JMenuItem("红色"),new JMenuItem("黄色"),new JMenuItem("粉色"), new JMenuItem("灰色"),new JMenuItem("黑色"), new JMenuItem("蓝色")},
            {new JMenuItem("选中"),new JMenuItem("放大"), new JMenuItem("缩小"), new JMenuItem("上移"), new JMenuItem("下移"), new JMenuItem("左移"), new JMenuItem("右移")},
            {new JMenuItem("策略一"),new JMenuItem("策略二"),new JMenuItem("策略三"), new JMenuItem("策略四")},
            {new JMenuItem("保存"),new JMenuItem("读取")},
        }; 
		int i; 
		int j; 
		for(i=0;i<menu.length;i++){ 
			menuBar.add(menu[i]); 
			for(j=0;j<menuItem[i].length;j++){ 
				menu[i].add(menuItem[i][j]); 
			} 
		} 
		
//		Ichoose panel;
//		panel = new MyPanel();
//		
//		//this.add(panel,BorderLayout.CENTER);
		Container contentPane = getContentPane(); 
        contentPane.setBounds(0, menuBar.getHeight(),getWidth(),getHeight() - menuBar.getHeight());
        ((Component) panel).setBackground(Color.white);
        contentPane.add((Component) panel); 
        
        //图形 
		for(int type=0;type<5;type++){    
            final int t = type; 
            menuItem[0][type].addActionListener(new ActionListener(){ 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    panel.set_drawType(t); 
                }    
            }); 
        }
		
		//颜色 
		for(int type=0;type<6;type++){ 
            final int t = type; 
            menuItem[2][type].addActionListener(new ActionListener(){ 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    panel.set_lineColor(t); 
                } 
            }); 
        } 
		
		//线条 
		for(int type=0;type<2;type++){ 
            final int t = type; 
            menuItem[1][type].addActionListener(new ActionListener(){ 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    panel.set_linelinellae(t); 
                } 
            });
		}
		
		menuItem[3][1].addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choose_enlarge enlarge = new choose_enlarge(panel);
				shap sp = panel.return_shap();
				switch (panel.c.drawType) {
					case 1:panel.set_enlarge(enlarge.paintelse1(sp)); break;
					case 2:panel.set_enlarge(enlarge.paintelse(sp)); break;
					case 3:panel.set_enlarge(enlarge.paintelse(sp)); break;
					case 4:panel.set_enlarge(enlarge.paintelse1(sp)); break;
				}
			}
		});
		
		menuItem[3][2].addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choose_reduce reduce = new choose_reduce(panel);
				shap sp = panel.return_shap();
				switch (panel.c.drawType) {
				case 1:panel.set_enlarge(reduce.paintelse1(sp)); break;
				case 2:panel.set_enlarge(reduce.paintelse(sp)); break;
				case 3:panel.set_enlarge(reduce.paintelse(sp)); break;
				case 4:panel.set_enlarge(reduce  .paintelse1(sp)); break;
				}
			}
		});
		
		menuItem[3][3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choose_moveTop reduce = new choose_moveTop(panel);
				shap sp = panel.return_shap();
				panel.set_enlarge(reduce.paintelse(sp));
			}
		});
		
		menuItem[3][4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choose_moveBottom reduce = new choose_moveBottom(panel);
				shap sp = panel.return_shap();
				panel.set_enlarge(reduce.paintelse(sp));
			}
		});
		
		menuItem[3][5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choose_moveLeft reduce = new choose_moveLeft(panel);
				shap sp = panel.return_shap();
				panel.set_enlarge(reduce.paintelse(sp));
			}
		});
		
		menuItem[3][5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				choose_moveRight reduce = new choose_moveRight(panel);
				shap sp = panel.return_shap();
				panel.set_enlarge(reduce.paintelse(sp));
			}
		});
		
		menuItem[4][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tactics = new tactics_one();
				tc.set_tactics(tactics);
				panel.set_tactics(tc.tactics(c));
			}
		});
		
		menuItem[4][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tactics = new tactics_two();
				tc.set_tactics(tactics);
				panel.set_tactics(tc.tactics(c));
			}
		});
		
		menuItem[4][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tactics = new tactics_three();
				tc.set_tactics(tactics);
				panel.set_tactics(tc.tactics(c));
			}
		});
		
		menuItem[4][3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tactics = new tactics_four();
				tc.set_tactics(tactics);
				panel.set_tactics(tc.tactics(c));
			}
		});
		
		menuItem[5][0].addActionListener(new save_canvas(this,panel));
		menuItem[5][1].addActionListener(new read_canvas(this,panel));
	}
}

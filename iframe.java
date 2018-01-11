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
		super("����");
		setLayout(new BorderLayout());
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu []menu = {new JMenu("ͼ��"), new JMenu("����"), new JMenu("��ɫ"), new JMenu("����"),new JMenu("����"),new JMenu("����")};
		JMenuItem [][]menuItem = { 
			{new JMenuItem("����"),new JMenuItem("����"),new JMenuItem("Բ��"),new JMenuItem("����"),new JMenuItem("������")}, 
            {new JMenuItem("ʵ��"), new JMenuItem("����")}, 
            {new JMenuItem("��ɫ"),new JMenuItem("��ɫ"),new JMenuItem("��ɫ"), new JMenuItem("��ɫ"),new JMenuItem("��ɫ"), new JMenuItem("��ɫ")},
            {new JMenuItem("ѡ��"),new JMenuItem("�Ŵ�"), new JMenuItem("��С"), new JMenuItem("����"), new JMenuItem("����"), new JMenuItem("����"), new JMenuItem("����")},
            {new JMenuItem("����һ"),new JMenuItem("���Զ�"),new JMenuItem("������"), new JMenuItem("������")},
            {new JMenuItem("����"),new JMenuItem("��ȡ")},
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
        
        //ͼ�� 
		for(int type=0;type<5;type++){    
            final int t = type; 
            menuItem[0][type].addActionListener(new ActionListener(){ 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    panel.set_drawType(t); 
                }    
            }); 
        }
		
		//��ɫ 
		for(int type=0;type<6;type++){ 
            final int t = type; 
            menuItem[2][type].addActionListener(new ActionListener(){ 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    panel.set_lineColor(t); 
                } 
            }); 
        } 
		
		//���� 
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

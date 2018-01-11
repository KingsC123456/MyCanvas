package Window;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.JPanel;

import Canvas.canvas;
import Choose.Ichoose;
import Shap.shap;
import Shap.shap_factory;

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements Ichoose{
	MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)};
	public shap sp=null;
	Vector<Vector<Point>> FreedomDatas = new Vector<Vector<Point>>();
	
	public MyPanel(){
//		this.c.drawType = c.drawType;
//		this.c.color	= c.color;
//		this.c.linellae = c.linellae;
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseReleased(MouseEvent e){
				// TODO Auto-generated method stub
				switch(c.drawType){ 
                    case 0: //自由
                        break; 
                    case 1: p[0] = new MyPoint(e.getX(), e.getY()); break; //画直线
                    case 2: p[0] = new MyPoint(e.getX(), e.getY()); break; //画圆形 
                    case 3: p[0] = new MyPoint(e.getX(), e.getY()); break; //画矩形 
                    case 4: p[0] = new MyPoint(e.getX(), e.getY()); break; //画三角形
                }
				repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				switch(c.drawType){ 
                case 0: //自由
                	Point p_free = new Point(e.getX(),e.getY()); 
                    Vector<Point> newLine = new Vector<Point>(); 
                    newLine.add(p_free); 
                    FreedomDatas.add(newLine); 
                    break; 
                case 1: p[1] = new MyPoint(e.getX(), e.getY()); break;  //画直线
                case 2: p[1] = new MyPoint(e.getX(), e.getY()); break; //画圆形 
                case 3: p[1] = new MyPoint(e.getX(), e.getY()); break; //画矩形 
                case 4: p[1] = new MyPoint(e.getX(), e.getY()); break; //画三角形
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter(){ 
            public void mouseDragged(MouseEvent e) 
            { 
                switch(c.drawType){ 
                case 0: 
                    Point p = new Point(e.getX(),e.getY()); 
                    int n = FreedomDatas.size()-1; //拿到最后一条线的位置 
                    Vector<Point> lastLine = FreedomDatas.get(n); 
                    lastLine.add(p);
                    break; 
                case 1: break; //画直线
                case 2: break; //画圆形 
                case 3: break; //画矩形 
                case 4: break; //画三角形
                } 
 
                //repaint(); //刷新画面 
            } 
        }); 
	}
	
	public void paint(Graphics g){
		if(c.drawType == 0){
			sp = shap_factory.Create_Operation(0);
			sp.FreedomDatas = this.FreedomDatas;
		}else{
			switch (c.drawType) {
				case 1:sp = shap_factory.Create_Operation(1);break;
				case 2:sp = shap_factory.Create_Operation(2);break;
				case 3:sp = shap_factory.Create_Operation(3);break;
				case 4:sp = shap_factory.Create_Operation(4);break;
			}
			sp.p[0].setX(this.p[0].getX());
			sp.p[1].setX(this.p[1].getX());
			sp.p[0].setY(this.p[0].getY());
			sp.p[1].setY(this.p[1].getY());
		}
		System.out.println(sp.p[0].x+""+sp.p[0].y);
		sp.g = (Graphics2D) g;
		sp.set_color(c.color);
		sp.set_line(c.linellae);
		super.paint(sp.g);//不加上就不会清除之前的画板内容
		sp.Draw();
		
		//sp.g.setColor(Color.BLACK);
	}
	
	public void set_drawType(int drawType){
		if(drawType == 0){
			c.drawType=0; p[0] = new MyPoint(0, 0); p[1] = new MyPoint(0, 0);
			FreedomDatas = new Vector<Vector<Point>>(); 
			System.out.println("自由");
		}else{
			switch (drawType) {
				case 1:c.drawType=1; p[0] = new MyPoint(0, 0); p[1] = new MyPoint(0, 0); break;
				case 2:c.drawType=2; p[0] = new MyPoint(0, 0); p[1] = new MyPoint(0, 0); break;
				case 3:c.drawType=3; p[0] = new MyPoint(0, 0); p[1] = new MyPoint(0, 0); break;
				case 4:c.drawType=4; p[0] = new MyPoint(0, 0); p[1] = new MyPoint(0, 0); break;
			}
		}
		//System.out.println(this.c.drawType);
		repaint();
	}
	
	public void set_lineColor(int i){ 
        c.set_color(i);
        //repaint(); 
    } 
	
	public void set_linelinellae(int i){ 
        c.set_linellae(i);
        //repaint(); 
    } 
	
	public void set_enlarge(MyPoint[] p1){
		this.p[0].setX(p1[0].getX());
		this.p[0].setY(p1[0].getY());
		this.p[1].setX(p1[1].getX());
		this.p[1].setY(p1[1].getY());
		int x2 = this.p[0].getX();
		int x1 = this.p[1].getX();
		int y2 = this.p[0].getY();
		int y1 = this.p[1].getY();
		System.out.println(x1+" " + y1 + " " + x2 + " " +y2);
		repaint();
	}
	
	public void set_tactics(canvas c1){
		c.drawType = c1.drawType;
		c.color    = c1.color;
		c.linellae = c1.linellae;
	}
	
	public shap return_shap(){
		return this.sp;
	}
	
	public MyPoint[] return_point(){
		return this.p;
	}
	
	@SuppressWarnings("static-access")
	public canvas return_canvas(){
		return this.c;
	}
	
	public void rebuild(canvas ccc){
		c.drawType = ccc.drawType;
		c.set_color(ccc.c);
		c.set_linellae(ccc.l);
		this.p[0].setX(ccc.x2);
		this.p[0].setY(ccc.y2);
		this.p[1].setX(ccc.x1);
		this.p[1].setY(ccc.y1);
		repaint();
	}
}

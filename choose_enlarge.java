package Choose;

import Shap.shap;
import Window.MyPoint;

public class choose_enlarge extends choose_changer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public choose_enlarge(Ichoose choose){
		super(choose);
	}
	public MyPoint[] paintelse(shap sp){
		MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)};
		p[0].setX(sp.p[0].x+20);
		p[1].setX(sp.p[1].x-10);
		p[0].setY(sp.p[0].y+10);
		p[1].setY(sp.p[1].y-20);
//		int y = sp.p[0].y - sp.p[1].y;
//		int x = sp.p[0].x - sp.p[1].x;
//		//放大的算法不正确
//		p[0].setX(sp.p[0].x+20*x/y);
//		p[1].setX(sp.p[1].x-10);
//		p[0].setY(sp.p[0].y+10);
//		p[1].setY(sp.p[1].y-20*y/x);
		return p;
	}
	
	public MyPoint[] paintelse1(shap sp){ //处理三角形和线形
		MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)};
		int y = sp.p[0].y - sp.p[1].y;
		int x = sp.p[0].x - sp.p[1].x;
		//放大的算法不正确
		p[0].setX(sp.p[0].x+10);
		p[1].setX(sp.p[1].x-10);
		p[0].setY(sp.p[0].y+10*y/x);
		p[1].setY(sp.p[1].y-10*y/x);
		return p;
	}
}

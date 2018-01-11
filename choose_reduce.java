package Choose;

import Shap.shap;
import Window.MyPoint;

public class choose_reduce extends choose_changer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public choose_reduce(Ichoose choose){
		super(choose);
	}
	public MyPoint[] paintelse(shap sp){
		MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)};
		
		//缩小的算法不正确
		p[0].setX(sp.p[0].x-20);
		p[1].setX(sp.p[1].x+10);
		p[0].setY(sp.p[0].y-10);
		p[1].setY(sp.p[1].y+20);
		return p;
	}
	
	public MyPoint[] paintelse1(shap sp){
		MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)};
		int y = sp.p[0].y - sp.p[1].y;
		int x = sp.p[0].x - sp.p[1].x;
		//缩小的算法不正确
		p[0].setX(sp.p[0].x-10);
		p[1].setX(sp.p[1].x+10);
		p[0].setY(sp.p[0].y-10*y/x);
		p[1].setY(sp.p[1].y+10*y/x);
		
		return p;
	}
}

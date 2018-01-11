package Choose;

import Shap.shap;
import Window.MyPoint;

public class choose_moveBottom extends choose_changer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public choose_moveBottom(Ichoose choose){
		super(choose);
	}
	public MyPoint[] paintelse(shap sp){
		MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)};
		p[0].setX(sp.p[0].x);
		p[1].setX(sp.p[1].x);
		p[0].setY(sp.p[0].y+10);
		p[1].setY(sp.p[1].y+10);
		return p;
	}

}

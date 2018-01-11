package Choose;

import java.awt.Graphics;

import Canvas.canvas;
import Shap.shap;
import Window.MyPoint;

public interface Ichoose{
	public canvas c = new canvas();
	
	public abstract void paint(Graphics g);

	public abstract void set_drawType(int t);

	public abstract void set_lineColor(int t);

	public abstract void set_linelinellae(int t);
	
	public abstract shap return_shap();

	public abstract void set_enlarge(MyPoint[] p1);

	public abstract void set_tactics(canvas tactics);

	public abstract MyPoint[] return_point();

	public abstract void rebuild(canvas c2);
}

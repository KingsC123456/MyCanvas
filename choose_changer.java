package Choose;

import java.awt.Graphics;

import javax.swing.JPanel;

import Canvas.canvas;
import Shap.shap;
import Window.MyPoint;

public class choose_changer extends JPanel implements Ichoose{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ichoose choose;
	public choose_changer(Ichoose choose){
		this.choose =choose;
	}
	public void paint(Graphics g){
		choose.paint(g);
	}
	@Override
	public void set_drawType(int t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void set_lineColor(int t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void set_linelinellae(int t) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public shap return_shap() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void set_enlarge(MyPoint[] p1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void set_tactics(canvas tactics) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public MyPoint[] return_point() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void rebuild(canvas c2) {
		// TODO Auto-generated method stub
		
	}
}

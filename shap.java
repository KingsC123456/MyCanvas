package Shap;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

import Color.Icolor;
import Ilinellae.Ilinellae;
import Window.MyPoint;

public abstract class shap{
	protected Icolor color;
	protected Ilinellae linellae;
	public Graphics2D g;
	public MyPoint[] p = {new MyPoint(0,0),new MyPoint(0,0)}; //记录坐标
	public Vector<Vector<Point>> FreedomDatas = new Vector<Vector<Point>>(); //自由时使用
	public void set_color(Icolor color){
		this.color = color;
	}
	public void set_line(Ilinellae linellae){
		this.linellae = linellae;
	}
	public abstract void Draw();
}

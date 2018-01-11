package Shap;
//矩形
public class shap_rectangle extends shap{
	public void Draw(){
		this.color.set_color(g);
		this.linellae.set_linellae(g);
		g.drawRect(p[1].x,p[1].y,Math.abs(p[0].x-p[1].x),Math.abs(p[0].y-p[1].y));//起点坐标（x,y）,宽度，高度
	}
}

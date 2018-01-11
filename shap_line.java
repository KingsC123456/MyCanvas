package Shap;
//直线
public class shap_line extends shap{
	public void Draw(){
		this.color.set_color(g);
		this.linellae.set_linellae(g);
		g.drawLine(p[1].x,p[1].y,p[0].x,p[0].y);//起点坐标（x,y）,终点坐标（x，y)
	}
}

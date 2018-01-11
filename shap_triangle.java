package Shap;
//三角形
public class shap_triangle extends shap{//设计待考虑
	public void Draw(){
		int px1[]={p[0].x,p[0].x,p[1].x,p[0].x};
		int py1[]={p[0].y,p[1].y,p[1].y,p[0].y};
		this.color.set_color(g);
		this.linellae.set_linellae(g);
		g.drawPolygon(px1, py1, 4);//起点坐标，终点坐标，还有一点随机
	}
}

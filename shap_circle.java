package Shap;
//画圆
class shap_circle extends shap{
	public void Draw(){
		this.color.set_color(g);
		this.linellae.set_linellae(g);
		g.drawOval(p[1].x,p[1].y,Math.abs(p[0].x-p[1].x),Math.abs(p[0].y-p[1].y));//起点坐标（x,y）,宽度，高度
	}
}

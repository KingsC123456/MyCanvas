package Shap;
//������
public class shap_triangle extends shap{//��ƴ�����
	public void Draw(){
		int px1[]={p[0].x,p[0].x,p[1].x,p[0].x};
		int py1[]={p[0].y,p[1].y,p[1].y,p[0].y};
		this.color.set_color(g);
		this.linellae.set_linellae(g);
		g.drawPolygon(px1, py1, 4);//������꣬�յ����꣬����һ�����
	}
}

package Shap;

import java.awt.Point;
import java.util.Vector;

//使用点集实线自由绘画
public class shap_freedom extends shap{
	public void Draw(){
		this.color.set_color(g);
		this.linellae.set_linellae(g);
		Vector<Point> v; 
        Point s,e; 
        int i,j,m; 
        int n = FreedomDatas.size(); 
        for(i=0;i<n;i++) 
        { 
            v = FreedomDatas.get(i); 
            m = v.size()-1; 
            for(j=0;j<m;j++) 
            { 
                s = (Point)v.get(j); 
                e = (Point)v.get(j+1); 
                g.drawLine(s.x, s.y, e.x, e.y); 
            } 
        } 
	}
}

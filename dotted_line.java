package Ilinellae;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class dotted_line implements Ilinellae{
	public void set_linellae(Graphics2D g){
		float[] dash1 = {5.0f};
		BasicStroke s = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f); //线条性质
		//System.out.println(1111);
		g.setStroke(s);
	}
}

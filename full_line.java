package Ilinellae;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class full_line implements Ilinellae{
	public void set_linellae(Graphics2D g){
		BasicStroke s = new BasicStroke(1.0f, 1, 1, 1.0f);
		g.setStroke(s);
	}
}

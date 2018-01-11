package Tactics;

import Canvas.canvas;
import Color.color_red;
import Ilinellae.dotted_line;


//策略一，画红色的虚线三角形
public class tactics_one implements Itactics{
	public canvas tactics(canvas c){
		c.drawType = 4;
		c.color	   = new color_red();
		c.linellae = new dotted_line();
		return c;
	}
}

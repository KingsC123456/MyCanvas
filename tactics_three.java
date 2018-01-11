package Tactics;

import Canvas.canvas;
import Color.color_gray;
import Ilinellae.dotted_line;

//»ÒÉ«¾ØÐÎ
public class tactics_three implements Itactics{
	public canvas tactics(canvas c){
		c.drawType = 3;
		c.color	   = new color_gray();
		c.linellae = new dotted_line();
		return c;
	}
}
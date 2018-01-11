package Tactics;

import Canvas.canvas;
import Color.color_pink;
import Ilinellae.full_line;

//·ÛÉ«ÊµÏß
public class tactics_four implements Itactics{
	public canvas tactics(canvas c){
		c.drawType = 1;
		c.color	   = new color_pink();
		c.linellae = new full_line();
		return c;
	}
}
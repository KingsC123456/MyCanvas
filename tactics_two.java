package Tactics;

import Canvas.canvas;
import Color.color_blue;
import Ilinellae.full_line;

//���Զ�����ɫʵ��Բ��
public class tactics_two implements Itactics{
	public canvas tactics(canvas c){
		c.drawType = 2;
		c.color	   = new color_blue();
		c.linellae = new full_line();
		return c;
	}
}
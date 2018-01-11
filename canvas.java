package Canvas;

import Color.Icolor;
import Color.color_black;
import Color.color_blue;
import Color.color_gray;
import Color.color_pink;
import Color.color_red;
import Color.color_yellow;
import Ilinellae.Ilinellae;
import Ilinellae.dotted_line;
import Ilinellae.full_line;

public class canvas {						//用于存储
	public int drawType = 0;						//画基本类型  0 1 2 3 4 "自由" "线形" "圆形" "矩形" "三角形"
	public int c = 4;								//0 1 2 3 4 5 "红色" "黄色" "粉色" "灰色" "黑色" "蓝色"
	public Icolor color = new color_black();		//颜色
	public int l = 0;								//0 1 "实线" "虚线"
	public Ilinellae linellae = new full_line(); 	//线条线段
	public int x1,x2,y1,y2;
	
	public void set_color(int i){
		c = i;
		switch(i){ 
		    case 0:color = new color_red();    	break; 
		    case 1:color = new color_yellow();  break; 
		    case 2:color = new color_pink();    break; 
		    case 3:color = new color_gray();    break; 
		    case 4:color = new color_black();   break;  
		    case 5:color = new color_blue();    break; 
		}
	}
	
	public void set_linellae(int i){
		l = i;
		switch(i){ 
		    case 0:linellae = new full_line();    	break; 
		    case 1:linellae = new dotted_line();  	break;
		}
	}
}

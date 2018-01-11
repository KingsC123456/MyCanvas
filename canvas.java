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

public class canvas {						//���ڴ洢
	public int drawType = 0;						//����������  0 1 2 3 4 "����" "����" "Բ��" "����" "������"
	public int c = 4;								//0 1 2 3 4 5 "��ɫ" "��ɫ" "��ɫ" "��ɫ" "��ɫ" "��ɫ"
	public Icolor color = new color_black();		//��ɫ
	public int l = 0;								//0 1 "ʵ��" "����"
	public Ilinellae linellae = new full_line(); 	//�����߶�
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

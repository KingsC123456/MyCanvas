package Window;

import javax.swing.JFrame;


public class client {
	public static void main(String [] args){
		iframe iF = new iframe(); 
        iF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //iF.setBackground(Color.white);
        iF.setBounds(480, 260, 800, 600); //�������λ�� //���붥��λ��   //��� //�߶�
        iF.setVisible(true);
	}
}

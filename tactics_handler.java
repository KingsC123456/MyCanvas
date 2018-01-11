package Tactics;

import Canvas.canvas;

public class tactics_handler {
	private Itactics tac;
	
	public canvas tactics(canvas c){
		tac.tactics(c);
		return c;
	}
	
	public void set_tactics(Itactics tactics){
		this.tac = tactics;
	}
}

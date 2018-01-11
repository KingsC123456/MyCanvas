package Shap;

import Shap.shap_line;

public class shap_factory {
	public static shap Create_Operation(int operate){
		shap result = null;
		switch(operate){
			case 0: result = new shap_freedom();	break;
			case 1: result = new shap_line();   	break;
			case 2: result = new shap_circle();		break;
			case 3: result = new shap_rectangle();	break;
			case 4: result = new shap_triangle();	break;
		}
		return result;
	}
}

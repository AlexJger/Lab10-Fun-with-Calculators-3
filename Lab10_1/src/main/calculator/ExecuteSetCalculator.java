package main.calculator;

import main.calculator.set.CalcEngineSet;
import main.calculator.set.UserInterfaceSet;


public class ExecuteSetCalculator {
	 public static void main(String[] args) {

	        CalcEngineSet calcEngine = new CalcEngineSet();
	        UserInterfaceSet userInterface = new UserInterfaceSet(calcEngine);
	        userInterface.setVisible(true);

	    }

}

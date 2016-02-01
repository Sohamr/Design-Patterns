/**
 * 
 */
package myComputerManual.driver;

import java.io.IOException;
import java.util.Vector;

import myComputerManual.choice.Choices;
import myComputerManual.manual.ComputerManualStore;
import myComputerManual.manual.Manual;
import myComputerManual.manual.ManualStore;
import myComputerManual.util.LogType;
import myComputerManual.util.Logger;
import myComputerManual.util.UserMenu;

public class Driver {

	public static void main(String[] args) {


		if (args.length != 1) {
			System.err.println("Invalid number of arguements");
			System.err
					.println("<Data Filename> <Search Filename> <Number of Threads> <Debug Value>");
			System.exit(0);
		}
		Vector< Choices> MMap = null;
		UserMenu um = new UserMenu();
		
		try {
			int arg = Integer.parseInt(args[0]);			
			Logger l = Logger.getInstance();
			l.setDebugValue(arg);
			MMap = um.displayMenu();
			if(MMap == null) {
				System.err.println("Error in taking input");
				System.exit(1);
			}
			ManualStore ms = new ComputerManualStore();
			Manual m = ms.orderManual(MMap);
			if (l.getGlobalDebugValue() == LogType.PRINT_MANUAL)
				m.printManual();					

		} catch (IOException ex) {
				System.err.println("IO Exception "+ex.getLocalizedMessage());
				System.exit(-1);
		}catch(NumberFormatException ex)
		{
			System.err.println("IO Exception "+ex.getLocalizedMessage());
			System.exit(-1);	
		}

	}
}

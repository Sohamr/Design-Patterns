package studentRecordsBackup.driver;

import java.io.File;

import studentRecordsBackup.util.BSTBuilder;

public class Driver {

	public static void main(String[] args) {

		// If all arguments not given, exit
		if (args.length != 2) {
			System.err
					.println("Invalid Parameters... <Input Filename> <Update Value>");
			System.exit(1);
		}

		int updateVal = 0;
		File file = null;

		try {
			
			file = new File(args[0]); // Get Filename and create File object
			updateVal = Integer.parseInt(args[1]); // Get update value
			
		} catch (NullPointerException ex) {
			System.err.println("Unable to Open file: " + args[0]);
			System.exit(1);
		} catch (NumberFormatException ex) {
			System.err
					.println("Invalid Parameters... <Update Value> - Should be an integer");
			System.exit(1);
		} finally {

		}

		BSTBuilder main = new BSTBuilder(file, 2); // Creates a BSTBuilder
													// object, with 2 backup
													// trees
		main.buildTree(); // Build the trees
		main.printInOrder(); // Print all trees
		main.printSum(); // Print sums of all trees
		main.updateMain(updateVal); // Update main tree with updateVal
		main.printInOrder(); // Print all trees after updating
		main.printSum(); // Print sums of all trees after updating
	}

}

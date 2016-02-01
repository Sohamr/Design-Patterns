package maxKVisitors.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInput {

	private static int showRandomInteger(int aStart, int aEnd, Random random) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}

		long range = (long) aEnd - (long) aStart + 1;
		long fraction = (long) (range * random.nextDouble());
		int randomNumber = (int) (fraction + aStart);

		// System.out.println(randomNumber);
		return (randomNumber);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRecords = 10;
		int numStart = 1; // 100000;
		int numEnd = 1000; // 9999999;
		try {
			if (args.length == 1) {
				numRecords = Integer.parseInt(args[0]);
			}
		} catch (Exception ex) {

		}
		FileWriter fw = null;
		// creates the file
		try {
			File f = new File("Input.txt");
			f.createNewFile();
			fw = new FileWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {

		}

		Random random = new Random();
		// Generate random number and string
		for (int i = 0; i < numRecords; i++) {
			/*
			 * System.out.println(showRandomInteger(100000, 999999, random) +
			 * "\t" + randomWord(rangeChars, random));
			 */
			try {
				fw.write(showRandomInteger(numStart, numEnd, random) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} finally {

			}
		}
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally{
			
		}
	}
}

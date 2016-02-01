package studentRecordsBackup.util;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateBnumbers {

	final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	final static int len = alphabet.length();

	// Returns random number
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

	// Returns random string
	private static String randomWord(int range, Random random) {
		String s = "";
		s += alphabet.charAt(random.nextInt(len - 26));
		for (int i = 0; i < range - 1; i++) {
			s += alphabet.charAt(random.nextInt(len));
		}
		return s;
	}

	public static void main(String[] args) {

		FileWriter fw = null;
		int numRecords = 10;
		int rangeChars = 16;
		int numStart = 1;	// 100000;
		int numEnd =  1000;	//9999999;
		try{
		if (args.length == 1) {
			numRecords = Integer.parseInt(args[0]);
		} else if (args.length == 2) {
			numRecords = Integer.parseInt(args[0]);
			rangeChars = Integer.parseInt(args[1]);
		} else if (args.length > 2){
			System.err.println("Invalid Arguements \n");
			System.exit(1);
		}
		}catch(Exception ex){
			
		} finally{
			
		}
		
		// creates the file
		try {
			File f = new File("bstInput.txt");
			f.createNewFile();
			fw = new FileWriter(f);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally{
			
		}

		Random random = new Random();
		// Generate random number and string
		for (int i = 0; i < numRecords; i++) {
			/*
			 * System.out.println(showRandomInteger(100000, 999999, random) +
			 * "\t" + randomWord(rangeChars, random));
			 */
			try {
				fw.write(showRandomInteger(numStart, numEnd, random) + "\t\t"
						+ randomWord(rangeChars, random) + "\n");
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} finally{
				
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

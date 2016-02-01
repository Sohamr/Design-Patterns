package dTunesStore.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;

import dTunesStore.Interface.IResult;
import dTunesStore.dataStore.CreateSearchWorker;
import dTunesStore.dataStore.FileProcessor;
import dTunesStore.dataStore.MusicStore;
import dTunesStore.dataStore.PopulateWorker;
import dTunesStore.util.Logger;
import dTunesStore.util.Results;

public class Driver {

	public static void main(String args[]) {

		if (args.length != 4) {
			System.err.println("Invalid number of arguements");
			System.err
					.println("<Data Filename> <Search Filename> <Number of Threads> <Debug Value>");
			System.exit(0);
		}

		int numOfThreads = 0;
		int logtyp = 0;
		FileReader fdr = null;
		FileReader fsr = null;
		// System.out.println("Hello Design-Patterns students. Welcome to Assignment 1\n");

		try {
			numOfThreads = Integer.parseInt(args[2]);
			logtyp = Integer.parseInt(args[3]);
			if (numOfThreads < 1 || numOfThreads > 5 || logtyp < 0
					|| logtyp > 4) {
				System.out
						.println("Please enter Thread value between 1 - 5 and Log value between 0 to 4 ");
				System.exit(0);
			}

			Logger.setDebugValue(logtyp);

			String dataFileName = args[0];
			String searchFileName = args[1];
			// Open both files
			fdr = new FileReader(dataFileName);
			fsr = new FileReader(searchFileName);

		} catch (FileNotFoundException e) {
			System.err.println("Error in File : " + e.getLocalizedMessage());
			System.exit(1);
		} catch (NullPointerException e) {
			System.err.println("Error: Incorrect Arguement : "
					+ e.getLocalizedMessage());
			System.exit(1);
		} catch (NumberFormatException nfe) {
			System.err.println("Error: Arguement Incorrect : "
					+ nfe.getLocalizedMessage() + ".  Should be a number.");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Error: " + e.getLocalizedMessage());
			System.exit(1);
		} finally {
		}

		MusicStore ms = new MusicStore();
		FileProcessor fp_DF = new FileProcessor(fdr);
		PopulateWorker pw = new PopulateWorker(ms, fp_DF);

		ms = pw.read(); // Reading from Data file and storing into MusicStore
		fp_DF.Close(); // Close File handle for Search File

		FileProcessor fp_SF = new FileProcessor(fsr);
		IResult r = new Results();

		CreateSearchWorker csw = new CreateSearchWorker(numOfThreads, r, ms,
				fp_SF);

		csw.spawnThread(); // Read from Search file and if Hit, store in Results

		fp_SF.Close(); // Close File handle for Search File

		r.displayData(); // Print the Results found.

	} // end main(...)
} // end class Driver
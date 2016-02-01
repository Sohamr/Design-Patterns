package dTunesStore.dataStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import dTunesStore.util.LogType;
import dTunesStore.util.Logger;

public class FileProcessor {

	private BufferedReader br = null;
	private FileReader fr = null;

	public FileProcessor(FileReader fr) {

		this.fr = fr;
		this.br = new BufferedReader(fr);
		Logger.Write(LogType.CONSTRUCTOR, "In FileProcessor Class");
	}

	public synchronized String readLineFromFile() {
		String s = null;

		try {

			if (br != null) {
				if ((s = br.readLine()) != null)
					return s;
			} else
				return null;

		} catch (IOException e) {
			System.err.println("Error Reading line : "
					+ e.getLocalizedMessage());
			System.exit(1);
		} finally {

		}
	
		try {
			if (br != null) {
				br.close();
				br = null;
			}
		} catch (IOException ex) {
			System.err.println("Error in Closing file "
					+ ex.getLocalizedMessage());
			System.exit(1);
		} finally {
		}
		return null;
	}

	public void Close() {
		try {
			if (br != null)
				br.close();
			if (fr != null)
				fr.close();
		} catch (IOException ex) {
			System.err.println("Error in Closing file "
					+ ex.getLocalizedMessage());
			System.exit(1);
		} finally {
		}
	}
}

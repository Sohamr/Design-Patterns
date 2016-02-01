package maxKVisitors.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

	private BufferedReader br = null;
	private FileReader fr = null;
	private boolean fileEnd = true;

	/**
	 * Opens the file in BufferedReader
	 * 
	 * @param name
	 */
	public FileProcessor(String name) {
		// Open File
		try {
			this.fr = new FileReader(name);
			this.br = new BufferedReader(fr);
			Logger l = Logger.getInstance();
			l.Write(LogType.CONSTRUCTOR, "In " + this.getClass());
		} catch (FileNotFoundException ex) {
			System.err.println("File Error : " + name);
			System.exit(1);
		} catch (IOException ex) {
			System.err.println("File Error : " + name);
			System.exit(1);
		}

	}

	/**
	 * 
	 * @return Integer on next line
	 */
	public Integer nextInt() {
		String s = null;
		int num;
		try {

			if (br != null) {
				if ((s = br.readLine()) != null) {
					num = Integer.parseInt(s);
					return num;
				} else {
					fileEnd = false;
					return null;
				}
			}

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

	/**
	 * Closes the buffer and file reader
	 */
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

	/**
	 * 
	 * @return True if file is not ended
	 */
	public boolean hasItem() {

		return fileEnd;
	}
}

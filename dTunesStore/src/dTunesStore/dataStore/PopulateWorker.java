package dTunesStore.dataStore;

import java.util.StringTokenizer;

import dTunesStore.util.LogType;
import dTunesStore.util.Logger;

/**
 * Reads from the dataFile and populates the MusicStore
 */
public class PopulateWorker {

	private FileProcessor fp = null;
	private MusicStore mi = null;

	/**
	 * PopulateWorker Constructor takes a handle to the FileStream or the name
	 * of the file
	 * 
	 * @param m
	 *            MusicStore instance which stores the records read from the
	 *            data file
	 * @param fpp
	 *            It holds the FileProcessor instance to read the datafile
	 */
	public PopulateWorker(MusicStore m, FileProcessor fpp) {
		Logger.Write(LogType.CONSTRUCTOR, "In PopulateWorker Class");
		this.fp = fpp;
		this.mi = m;
	}

	/**
	 * Reads from data file using FileProcessor and stores in MusicStore
	 * 
	 * @return Returns a MusicStore instance which has all the music records
	 *         read from data file
	 */
	public MusicStore read() {

		try {
			String line = null;
			StringTokenizer st = null;
			while ((line = fp.readLineFromFile()) != null) {
				// System.out.println("Line : " + line +"\n");

				st = new StringTokenizer(line);
				if (st.countTokens() == 3)
					mi.storeInfo(st.nextToken(), st.nextToken(), st.nextToken());

			}
		} catch (NullPointerException ex) {
			System.err.println("Null value read from Data file "
					+ ex.getMessage());
			System.exit(1);
		} finally {
		}

		return mi;
	}
} // end class PopulateWorker
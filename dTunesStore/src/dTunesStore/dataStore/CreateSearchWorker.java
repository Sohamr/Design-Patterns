package dTunesStore.dataStore;

import dTunesStore.Interface.IResult;
import dTunesStore.util.LogType;
import dTunesStore.util.Logger;

/**
 * Creates N numnber of SearchWorkerThreads
 */
public class CreateSearchWorker {

	private MusicStore ms = null;
	private FileProcessor fp = null;
	private Thread t[];
	private int numOfThreads = 0;
	private IResult r = null;

	/**
	 * Initializes data members
	 * 
	 * @param numOfThreads
	 *            number of threads to create
	 * @param r
	 *            Iresult object to pass to SearchWorker
	 * @param ms
	 *            MusicStore object to pass to SearchWorker
	 * @param fp
	 *            FileProcessor instance to pass to SearchWorker
	 */
	public CreateSearchWorker(int numOfThreads, IResult r, MusicStore ms,
			FileProcessor fp) {

		Logger.Write(LogType.CONSTRUCTOR, "In CreateSearchWorker Class");
		this.numOfThreads = numOfThreads;
		this.r = r;
		this.ms = ms;
		this.fp = fp;
		t = new Thread[numOfThreads];
	}

	/**
	 * To create and execute N of threads of SearchWorker class
	 */
	public void spawnThread() {

		for (int i = 0; i < numOfThreads; i++) {

			SearchWorker sw = new SearchWorker(ms, fp, r, i);
			t[i] = new Thread(sw);
			t[i].start();
		}

		try {
			for (int i = 0; i < numOfThreads; i++)
				t[i].join();

		} catch (InterruptedException e) {
			System.err.println("Thread Interrupted" + e.getLocalizedMessage());
			System.exit(1);
		} finally {
		}
	}

	@Override
	public String toString() {
		return "Create Search Worker [ms=" + ms + ", numOfThreads="
				+ numOfThreads + ", r=" + r + "]";
	}

}
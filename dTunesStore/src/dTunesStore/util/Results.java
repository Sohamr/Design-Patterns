package dTunesStore.util;

import java.util.Vector;

import dTunesStore.Interface.IResult;
import dTunesStore.dataStore.MusicInfo;

public class Results implements IResult {

	private Vector<MusicInfo> v = null;

	public Results() {
		v = new Vector<MusicInfo>(100);
		Logger.Write(LogType.CONSTRUCTOR, "In Results Class");
	}

	@Override
	public synchronized void storeInfo(Object o) {

		if (o != null) {
			MusicInfo mi = (MusicInfo) o;
			v.addElement(mi);
			// System.out.println("Result "+((MusicInf)o));
			Logger.Write(LogType.RESULT_ENTRY, "Entry " + mi.getInfo()
					+ " added in Result ");
		}
	}

	@Override
	public void displayData() {

		for (MusicInfo mi : v) {
			Logger.Write(LogType.SEARCH_RESULTS, mi.toString());
		}
	}

	@Override
	public String toString() {
		return "Results v = " + v;
	}

}

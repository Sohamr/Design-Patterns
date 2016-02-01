
package dTunesStore.dataStore;

import java.util.Arrays;
import java.util.HashMap;

import dTunesStore.util.LogType;
import dTunesStore.util.Logger;

/**
 * Class to store MusicInfo objects i.e Music records
 * 
 */
public class MusicStore  {

	private MusicInfo[] mi = null;
	private static int index = 0;
	private HashMap<String, Integer> InfoMap= null;
	
	public MusicStore(){
		mi = new MusicInfo[1000];
		this.InfoMap = new HashMap<String, Integer>();

		Logger.Write(LogType.CONSTRUCTOR, "In MusicStore Class");
	}
	
	/**
	 * 
	 * @param index	 an integer value to get the MusicInfo instance from MusicInfor array
	 * @return instance of MusicInfo at index i
	 */
	public MusicInfo getMusicInfoo(int index){
		
		return mi[index];
	}
	
	/**
	 * 
	 * @param _songName		Song Name
	 * @param _albumName	Album Name
	 * @param _singerName	Singer Name
	 */
	public void storeInfo(String _songName, String _albumName, String _singerName){
		
		mi[index] = new MusicInfo();
		mi[index].setInfo(_songName, _albumName, _singerName);
		InfoMap.put(_songName.trim().toUpperCase(), index);
		InfoMap.put(_albumName.trim().toUpperCase(), index);
		InfoMap.put(_singerName.trim().toUpperCase(), index);
		index++;
	}
	
	/**
	 * Searches in Hashmap and returns the MusicInfo object from m[] if found
	 * @param s	String to search
	 * @return	MusicInfo object found in MusicStore
	 */
	public synchronized MusicInfo searchInfo(String s) {
		
		int key = -1;
		try{
			if(InfoMap.containsKey(s))
			{
				key = Integer.parseInt(InfoMap.get(s).toString());
				return this.getMusicInfoo(key);
			}
		}catch(NumberFormatException nfe)
		{		
			System.err.println("Error: Arguement Incorrect : "
						+nfe.getLocalizedMessage());
			System.exit(1);
		} finally {
		}
		
		return null;
	}

	/**
	 * Prints data to Console
	 */
	public void displayData(){
	
		for(int i = 0; i < index; i++)
			System.out.println(mi[i]);
	}

	@Override
	public String toString() {
		return "MusicStore = " + Arrays.toString(mi) + ", InfoMap = " + InfoMap;
	}
	

} // end class MusicStore


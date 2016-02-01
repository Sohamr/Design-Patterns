package dTunesStore.dataStore;

import dTunesStore.util.LogType;
import dTunesStore.util.Logger;

/**
 * Stores the Music Records
 * 
 */
public class MusicInfo {

	private String songName = null;
	private String albumName = null;
	private String singerName = null;

	public MusicInfo() {
		Logger.Write(LogType.CONSTRUCTOR, "In MusicInfo Class");
	}
	
	/**
	 * 
	 * @return song name
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * 
	 * @return album name
	 */
	public String getAlbumName() {
		return albumName;
	}

	/**
	 * 
	 * @return singer name
	 */
	public String getSingerName() {
		return singerName;
	}

	/**
	 * @param songName the songName to set
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * @param albumName the albumName to set
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	/**
	 * @param singerName the singerName to set
	 */
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	/**
	 * 
	 * @param songName
	 *            Song Name
	 * @param albumName
	 *            Album Name
	 * @param singerName
	 *            Singer Name
	 */
	public void setInfo(String songName, String albumName, String singerName) {

		this.songName = songName;
		this.albumName = albumName;
		this.singerName = singerName;
	}

	@Override
	public String toString() {

		return "Song " + songName.trim() + " from Album " + albumName.trim()
				+ ", Sung by " + singerName.trim();
	}

	public String getInfo() {
		return this.songName + " " + this.albumName + " " + this.singerName;
	}
}


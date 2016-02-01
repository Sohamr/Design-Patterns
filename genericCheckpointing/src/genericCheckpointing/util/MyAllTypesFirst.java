package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {

	private int myInt;
	private String myString;
	private double myDouble;
	private long myLong;
	private char myChar;

	/**
	 * Constructor
	 * @param _myInt
	 * @param _myString
	 * @param _myDouble
	 * @param _myLong
	 * @param _myChar
	 */
	public MyAllTypesFirst(int _myInt, String _myString, double _myDouble,
			long _myLong, char _myChar) {
		this.myInt = _myInt;
		myString = _myString;
		myDouble = _myDouble;
		myLong = _myLong;
		myChar = _myChar;
	}

	/**
	 * Empty Constructor
	 */
	public MyAllTypesFirst() {
		
	}

	/**
	 * @return the myInt
	 */
	public int getMyInt() {
		return myInt;
	}

	/**
	 * @param myInt the myInt to set
	 */
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	/**
	 * @return the myString
	 */
	public String getMyString() {
		return myString;
	}

	/**
	 * @param myString the myString to set
	 */
	public void setMyString(String myString) {
		this.myString = myString;
	}

	/**
	 * @return the myDouble
	 */
	public double getMyDouble() {
		return myDouble;
	}

	/**
	 * @param myDouble the myDouble to set
	 */
	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}

	/**
	 * @return the myLong
	 */
	public long getMyLong() {
		return myLong;
	}

	/**
	 * @param myLong the myLong to set
	 */
	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	/**
	 * @return the myChar
	 */
	public char getMyChar() {
		return myChar;
	}

	/**
	 * @param myChar the myChar to set
	 */
	public void setMyChar(char myChar) {
		this.myChar = myChar;
	}

	@Override
	public String toString() {

		return "MyAllTypesFirst [myInt=" + myInt + ", "
				+ (myString != null ? "myString=" + myString + ", " : "")
				+ "myDouble=" + myDouble + ", myLong=" + myLong + ", myChar="
				+ myChar + "]";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myChar;
		long temp;
		temp = Double.doubleToLongBits(myDouble);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myInt;
		result = prime * result + (int) (myLong ^ (myLong >>> 32));
		result = prime * result
				+ ((myString == null) ? 0 : myString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesFirst other = (MyAllTypesFirst) obj;
		if (myChar != other.myChar)
			return false;
		if (Double.doubleToLongBits(myDouble) != Double
				.doubleToLongBits(other.myDouble))
			return false;
		if (myInt != other.myInt)
			return false;
		if (myLong != other.myLong)
			return false;
		if (myString == null) {
			if (other.myString != null)
				return false;
		} else if (!myString.equals(other.myString))
			return false;
		return true;
	}

}

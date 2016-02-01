package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {

	private int myIntS;
	private String myStringS;
	private double myDoubleS;
	private long myLongS;
	private char myCharS;

	/**
	 * Empty Constructor
	 */
	public MyAllTypesSecond() {

	}
	/**
	 * Constructor
	 * @param _myInt
	 * @param _myString
	 * @param _myDouble
	 * @param _myLong
	 * @param _myChar
	 */
	public MyAllTypesSecond(int _myInt, String _myString, double _myDouble,
			long _myLong, char _myChar) {
		this.myIntS = _myInt;
		myStringS = _myString;
		myDoubleS = _myDouble;
		myLongS = _myLong;
		myCharS = _myChar;
	}


	/**
	 * @return the myIntS
	 */
	public int getMyIntS() {
		return myIntS;
	}
	/**
	 * @param myIntS the myIntS to set
	 */
	public void setMyIntS(int myIntS) {
		this.myIntS = myIntS;
	}
	/**
	 * @return the myStringS
	 */
	public String getMyStringS() {
		return myStringS;
	}
	/**
	 * @param myStringS the myStringS to set
	 */
	public void setMyStringS(String myStringS) {
		this.myStringS = myStringS;
	}
	/**
	 * @return the myDoubleS
	 */
	public double getMyDoubleS() {
		return myDoubleS;
	}
	/**
	 * @param myDoubleS the myDoubleS to set
	 */
	public void setMyDoubleS(double myDoubleS) {
		this.myDoubleS = myDoubleS;
	}
	/**
	 * @return the myLongS
	 */
	public long getMyLongS() {
		return myLongS;
	}
	/**
	 * @param myLongS the myLongS to set
	 */
	public void setMyLongS(long myLongS) {
		this.myLongS = myLongS;
	}
	/**
	 * @return the myCharS
	 */
	public char getMyCharS() {
		return myCharS;
	}
	/**
	 * @param myCharS the myCharS to set
	 */
	public void setMyCharS(char myCharS) {
		this.myCharS = myCharS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myCharS;
		long temp;
		temp = Double.doubleToLongBits(myDoubleS);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + myIntS;
		result = prime * result + (int) (myLongS ^ (myLongS >>> 32));
		result = prime * result
				+ ((myStringS == null) ? 0 : myStringS.hashCode());
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
		MyAllTypesSecond other = (MyAllTypesSecond) obj;
		if (myCharS != other.myCharS)
			return false;
		if (Double.doubleToLongBits(myDoubleS) != Double
				.doubleToLongBits(other.myDoubleS))
			return false;
		if (myIntS != other.myIntS)
			return false;
		if (myLongS != other.myLongS)
			return false;
		if (myStringS == null) {
			if (other.myStringS != null)
				return false;
		} else if (!myStringS.equals(other.myStringS))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MyAllTypesSecond [myIntS=" + myIntS + ", "
				+ (myStringS != null ? "myStringS=" + myStringS + ", " : "")
				+ "myDoubleS=" + myDoubleS + ", myLongS=" + myLongS
				+ ", myCharS=" + myCharS + "]";
	}
	

}
/*
 * 	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + myDoubleS;
		result = prime * result + myIntS;
		result = prime * result + myCharS;
		result = prime * result + myLongS;
		String resultt = prime * result + myStringS;
		
		return Integer.parseInt(resultt);
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyAllTypesSecond mf = (MyAllTypesSecond) obj;
		if (myIntS != mf.myIntS)
			return false;
		if (myDoubleS != mf.myDoubleS)
			return false;
		if (myCharS != mf.myCharS)
			return false;
		if (myLongS != mf.myLongS)
			return false;
		if (!myStringS.equals( mf.myStringS))
			return false;

		return true;

	}*/
 
package studentRecordsBackup.bst;

import java.util.Vector;

import studentRecordsBackup.observerP.ObserverI;
import studentRecordsBackup.observerP.SubjectI;

/**
 * 
 * Node implements interfaces SubjectI, ObserverI Class to store BNumber and
 * Description, Stores Observers array Pointer to left and right child(Node)
 * 
 */
public class Node implements SubjectI, ObserverI {

	private int bNo;
	private String description;
	private Vector<ObserverI> observers = null;
	Node left = null;
	Node right = null;
	private boolean isSubject = false;

	/**
	 * Constructor
	 * 
	 * @param bno
	 *            - BNumber
	 * @param desc
	 *            - Description
	 */
	public Node(int bno, String desc) {
		bNo = bno;
		description = desc;
	}

	/**
	 * 
	 * Constructor
	 * 
	 * @param bno
	 *            - BNumber
	 * @param desc
	 *            - Description
	 * @param subject
	 *            - Is this node a Subject node
	 */
	public Node(int bno, String desc, boolean subject) {
		bNo = bno;
		description = desc;
		if (isSubject = subject)
			observers = new Vector<ObserverI>();
	}

	@Override
	public String toString() {
		/*
		 * return "Node [bNo=" + bNo + ", " + (description != null ?
		 * "description=" + description + ", " : "") + (observers != null ?
		 * "observers=" + observers + ", " : "") + (left != null ? "left=" +
		 * left + ", " : "") + (right != null ? "right=" + right : "") + "]";
		 */
		return bNo + " \t" + (description != null ? description : "");
	}

	/**
	 * Getter for BNumber
	 * @return Bnumber
	 */
	public int getbNo() {
		return bNo;
	}
	/**
	 * Setter for BNumber
	 * 
	 */
	public void setbNo(int bNo) {
		this.bNo = bNo;
		if (isSubject)
			notifyObservers(bNo);
	}
	/**
	 * Getter for Description
	 * @return Description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter for Description
	 *
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Update method of ObserverI
	 */
	@Override
	public void update(int value) {
		// Update
		setbNo(value);

	}

	@Override
	public void registerObserver(ObserverI observer) {
		// Add observer
		if(null != observers && null != observer)
			observers.add(observer);

	}

	@Override
	public void removeObserver(ObserverI observer) {
		// Remove
		if(null != observers && null != observer)
			observers.remove(observer);
	}

	@Override
	public void notifyObservers(int value) {
		// Notify
		if (null != observers)
			for (ObserverI ob : observers) {
				ob.update(value);
			}

	}

}

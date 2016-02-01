package studentRecordsBackup.observerP;

public interface SubjectI {

	/**
	 * Register an observer
	 * 
	 * @param observer
	 *            - observer to be added
	 */
	public void registerObserver(ObserverI observer);

	/**
	 * Remove an observer
	 * 
	 * @param observer
	 *            - observer to be removed
	 */
	public void removeObserver(ObserverI observer);

	/**
	 * Notify all observers
	 * 
	 * @param value
	 *            - Value to be updated
	 */
	public void notifyObservers(int value);
}

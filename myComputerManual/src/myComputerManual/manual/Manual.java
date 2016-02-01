package myComputerManual.manual;

import java.util.ArrayList;

import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

/**
 * Manual Class
 * 
 */
public abstract class Manual {

	// public abstract void createManual();
	/**
	 * Constructor
	 */
	public Manual() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
	}

	/**
	 * Create the Manual Pages
	 */
	public abstract void createPages();

	/**
	 * Create the Manual Table of Contents
	 */
	public abstract void createIndex();

	/**
	 * Create the Manual List of Figures
	 */
	public abstract void createListOfFigures();

	/**
	 * Create the Manual Glossary
	 */
	public abstract void createGlossary();

	/**
	 * Create the Component objects
	 */
	public abstract void prepareManual();

	/**
	 * Print the Manual Index
	 */
	public abstract void printIndex();

	/**
	 * Print the Manual List of Figures
	 */
	public abstract void printListofFigures();

	/**
	 * Print the Manual Pages
	 */
	public abstract void printPages();

	/**
	 * Print the Manual Glossary
	 */
	public abstract void printGlossary();

	/**
	 * Print the Manual
	 */
	public abstract void printManual();

	/**
	 * 
	 * For storing the Information to be printed on Manual
	 * 
	 */
	protected class PrintManual {
		protected ArrayList<String> _pages = null;
		protected ArrayList<String> _figures = null;
		protected ArrayList<String> _index = null;
		protected ArrayList<String> _listOfFigures = null;
		protected int _numPages = 0;
		protected int _numFigures = 0;
		protected ArrayList<String> _glossary = null;

		public PrintManual() {

			Logger l = Logger.getInstance();
			l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
					+ " Class");
			_pages = new ArrayList<String>();
			_figures = new ArrayList<String>();
			_index = new ArrayList<String>();
			_listOfFigures = new ArrayList<String>();
			_glossary = new ArrayList<String>();
		}

		/**
		 * toString for PrintManual
		 */
		@Override
		public String toString() {
			return "PrintManual ["
					+ (_pages != null ? "_pages=" + _pages + ", " : "")
					+ (_figures != null ? "_figures=" + _figures + ", " : "")
					+ (_index != null ? "_index=" + _index + ", " : "")
					+ (_listOfFigures != null ? "_listOfFigures="
							+ _listOfFigures + ", " : "") + "_numPages="
					+ _numPages + ", _numFigures=" + _numFigures + ", "
					+ (_glossary != null ? "_glossary=" + _glossary : "") + "]";
		}

	}

}

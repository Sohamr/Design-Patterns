package myComputerManual.manual;

import java.util.ArrayList;
import java.util.Vector;

import myComputerManual.choice.Choices;
import myComputerManual.component.Component;
import myComputerManual.component.ComponentFactoryI;
import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

public class ComputerManual extends Manual {

	private ComponentFactoryI cf = null;
	private ArrayList<Component> components = null;
	private Vector<Choices> chs = null;
	private PrintManual printc;
	private int pgNO = 1;
	private Logger l;

	/**
	 * Constructor
	 * 
	 * @param cFI
	 *            Component Factory
	 * @param mMap2
	 *            List of Component choices
	 */
	public ComputerManual(ComponentFactoryI cFI, Vector<Choices> mMap2) {

		l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
		this.cf = cFI;

		chs = mMap2;
		components = new ArrayList<Component>();
		printc = new PrintManual();
	}

	@Override
	public void prepareManual() {

		for (Choices c : chs) {
			Component comp = cf.create(c);
			if (comp != null)
				components.add(comp);
		}
	}

	@Override
	public void createPages() {

		int pgNo = 1;

		for (Component c : components) {
			for (String s : c.getDescription()) {
				printc._pages.add("\t " + s + "\n\t\t Page " + pgNo++);
				l.Write(LogType.PAGES_ENTRY, s + " added to _pages ");

			}
			for (String s : c.getFigures()) {
				printc._pages.add("\t " + s + "\n\t\t Page " + pgNo++);
				l.Write(LogType.PAGES_ENTRY, s + " added to _pages ");
			}
		}
		pgNO = pgNo;
	}

	@Override
	public void createIndex() {
		int in = 1;
		int pgNo = 1;

		for (Component c : components) {

			printc._index.add((in) + ".) " + c.getName() + "\t\t" + pgNo++);
			l.Write(LogType.INDEX_ENTRY, c.getName() + " added to _index ");
			in++;
			pgNo += c.getNumofPages() + c.getNumofFigures() - 1;
		}
	}

	@Override
	public void createListOfFigures() {
		int in = 1;
		int pgNo = 1;

		// + "\n\t\t Page " + pgNo++);

		for (Component c : components) {
			pgNo += c.getNumofPages();

			for (String s : c.getFigures()) {
				printc._listOfFigures.add((in) + ".)  " + s + "\t\t" + pgNo++);
				l.Write(LogType.LIST_FIGURES_ENTRY, s
						+ " added to _listOfFigures ");
				in++;
			}

		}

	}

	@Override
	public void createGlossary() {

		for (Component c : components) {
			for (String s : c.getGlossary()) {
				printc._glossary.add("\t " + s);
				l.Write(LogType.GLOSSARY_ENTRY, s + " added to _glossary ");
			}
		}
		printc._glossary.add("\t\t Page " + pgNO);
	}

	@Override
	public void printIndex() {
		System.out.println("\n\t**********Index**********\t\t\t");
		for (String s : printc._index)
			System.out.println("" + s);
	}

	@Override
	public void printListofFigures() {
		System.out.println("\n\t**********List of Figures**********\t\t\t");
		for (String s : printc._listOfFigures)
			System.out.println("" + s);
	}

	@Override
	public void printPages() {

		System.out.println("");
		for (String s : printc._pages)
			System.out.println("" + s);
	}

	@Override
	public void printGlossary() {
		System.out.println("\n\t**********Glossary**********\t\t\t");
		for (String s : printc._glossary)
			System.out.println("" + s);
	}

	@Override
	public void printManual() {

		System.out.println("\n\t **********User Manual**********");
		printIndex();
		printListofFigures();
		printPages();
		printGlossary();

	}

}

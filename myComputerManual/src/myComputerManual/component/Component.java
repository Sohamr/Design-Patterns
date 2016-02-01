package myComputerManual.component;

import java.util.ArrayList;

import myComputerManual.choice.Choices;
import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

public abstract class Component extends ComponentAbstractFactory{

	protected Choices _componentName = null;
	protected ArrayList<String> _description = null;
	protected ArrayList<String> _figures = null;
	protected int _numPages = 0;
	protected int _numFigures = 0;
	protected ArrayList<String> _glossary = null;

	public Component() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
	}

	public String getName() {
		return _componentName.getDescription();
	}

	public ArrayList<String> getDescription() {
		return _description;
	}

	public int getNumofPages() {
		return _description.size();
	}

	public int getNumofFigures() {
		return _figures.size();
	}

	public ArrayList<String> getFigures() {
		return _figures;
	}

	public ArrayList<String> getGlossary() {
		return _glossary;
	}

	public void setInfo(Choices name, ArrayList<String> description,
			ArrayList<String> Glossary, ArrayList<String> Figures) {

		_componentName = name;
		_description = description;
		_glossary = Glossary;
		_figures = Figures;
	}

	@Override
	public String toString() {
		return "Component [Component Name: " + _componentName
				+ ", Description: " + _description + ", Figures: " + _figures
				+ ", Glossary: " + _glossary + "]";
	}

	/**
	 * Sets Component name
	 */
	public abstract void set_componentName();

	/**
	 * Sets Description
	 */
	public abstract void set_description();

	/**
	 * Sets Figures
	 */
	public abstract void set_figures();

	/**
	 * Sets Number of Pages
	 */
	public abstract void set_numPages();

	/**
	 * Sets Number of Figures
	 */
	public abstract void set_numFigures();

	/**
	 * Sets Number of Figures
	 */
	public abstract void set_glossary();

}

/**
 * 
 */
package myComputerManual.component;

import java.util.ArrayList;

import myComputerManual.choice.Choices;

/**
 * 
 *
 */
public class Monitor_20 extends Monitor{

	public Monitor_20(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super(Name, Description,Glossary, Figures);
	}

	public Monitor_20() {
		// TODO Auto-generated constructor stub		
		super();
	}

	@Override
	public void set_componentName() {
		_componentName = Choices.HP_20_MONITOR;
		
	}

	@Override
	public void set_description() {
		
		_description.add( _componentName.getDescription());
		_description.add( "Better display");
	}

	@Override
	public void set_figures() {
		
		_figures.add(_componentName.name() + " Figure A	");
		_figures.add(_componentName.name() + " Figure B	");
	}

	@Override
	public void set_numPages() {
		_numPages = _description.size();
	}

	@Override
	public void set_numFigures() {
		_numFigures = _figures.size();
	}


}

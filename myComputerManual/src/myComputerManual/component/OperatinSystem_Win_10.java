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
public class OperatinSystem_Win_10 extends OperatinSystem{

	public OperatinSystem_Win_10(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super(Name, Description,Glossary, Figures);
	}

	public OperatinSystem_Win_10() {
		// TODO Auto-generated constructor stub		
		super();
	}

	@Override
	public void set_componentName() {
		_componentName = Choices.WINDOWS10_OS;
		
	}

	@Override
	public void set_description() {
		
		_description.add( _componentName.getDescription());
		_description.add( "Released in 2014");
		_description.add( "Has a Windows classic Start button");
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

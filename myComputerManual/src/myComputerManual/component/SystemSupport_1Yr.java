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
public class SystemSupport_1Yr extends SystemSupport{

	public SystemSupport_1Yr(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super(Name, Description,Glossary, Figures);
	}

	public SystemSupport_1Yr() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void set_componentName() {
		_componentName = Choices.YR_1_SYSTEM_SUPPORT;
		
	}

	@Override
	public void set_description() {
		
		_description.add( _componentName.getDescription());
		_description.add( "No replacement, only repair");
	}

	@Override
	public void set_figures() {
		
		_figures.add(_componentName.name() + " Figure A");
		_figures.add(_componentName.name() + " Figure B");
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

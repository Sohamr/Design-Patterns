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
public class OpticalDrive_LG extends OpticalDrive{

	public OpticalDrive_LG(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super(Name, Description,Glossary, Figures);
	}

	public OpticalDrive_LG() {
		// TODO Auto-generated constructor stub		
		super();
	}

	@Override
	public void set_componentName() {
		_componentName = Choices.LG_OPTICAL_DRIVE;
		
	}

	@Override
	public void set_description() {
		
		_description.add( _componentName.getDescription());
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

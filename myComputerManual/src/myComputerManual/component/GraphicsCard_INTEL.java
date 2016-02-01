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
public class GraphicsCard_INTEL extends GraphicsCard{

	public GraphicsCard_INTEL(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super(Name, Description,Glossary, Figures);
	}

	public GraphicsCard_INTEL() {
		// TODO Auto-generated constructor stub		
		super();
	}

	@Override
	public void set_componentName() {
		_componentName = Choices.INTEL_GRAPHIC;
		
	}

	@Override
	public void set_description() {
		
		_description.add( _componentName.getDescription());
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

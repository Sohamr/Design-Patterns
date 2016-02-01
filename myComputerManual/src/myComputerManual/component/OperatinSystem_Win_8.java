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
public class OperatinSystem_Win_8 extends OperatinSystem {

	public OperatinSystem_Win_8(Choices Name, ArrayList<String> Description,
			ArrayList<String> Glossary, ArrayList<String> Figures) {
		super(Name, Description, Glossary, Figures);
	}

	public OperatinSystem_Win_8() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public void set_componentName() {
		_componentName = Choices.WINDOWS8_OS;

	}

	@Override
	public void set_description() {

		_description.add(_componentName.getDescription());
		_description.add("Integrated with touch devices");
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

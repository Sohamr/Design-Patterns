package myComputerManual.component;

import java.util.ArrayList;

import myComputerManual.choice.Choices;

public abstract class GraphicsCard extends Component {

	public GraphicsCard() {
		_description = new ArrayList<String>();
		_figures = new ArrayList<String>();
		_glossary = new ArrayList<String>();
		set_componentName();
		set_description();
		set_figures();
		set_glossary();
			
	}
	public GraphicsCard(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super.setInfo(Name, Description,Glossary, Figures);
	}

	
	@Override
	public void set_glossary() {
		_glossary.add("Graphic Card - Graphic processor for better Graphics");		
		
	}
		

}

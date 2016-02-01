package myComputerManual.component;

import java.util.ArrayList;

import myComputerManual.choice.Choices;

public abstract class DISK extends Component {

	public DISK() {
		_description = new ArrayList<String>();
		_figures = new ArrayList<String>();
		_glossary = new ArrayList<String>();
		set_componentName();
		set_description();
		set_figures();
		set_glossary();
			
	}
	public DISK(Choices Name, ArrayList<String> Description, ArrayList<String> Glossary,ArrayList<String>  Figures ){
		super.setInfo(Name, Description,Glossary, Figures);
	}

	
	@Override
	public void set_glossary() {
		_glossary.add("TB - Tera Bytes = 1024 GB");
		_glossary.add("RPM - Rotations per Minute");
		
	}
		

}

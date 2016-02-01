/**
 * 
 */
package myComputerManual.choice;

public enum Choices {

	Intel_CPU(1, "CPU", "Intel i5-4770 processor quad-core"),
	AMD_CPU	(2, "CPU","AMD FX-8350 Eight-Core CPU	"),
	GB_8_RAM(1, "RAM", "8 GB DDR3 RAM		"),
	GB_16_RAM(2, "RAM", "16 GB DDR3 RAM		"),
	TB_1_DISK(1, "DISK","1TB 7200 RPM SATA Hard Drive"),
	TB_2_DISK(2, "DISK","2TB 7200 RPM SATA Hard Drive"),
	INTEL_GRAPHIC(1, "GRAPHICS_CARD","Intel HD Graphics		"),
	NVIDIA_GRAPHIC(2, "GRAPHICS_CARD","2GB Nvidia GeForce GT720 	"),
	SAMSUNG_OPTICAL_DRIVE(1,"OPTICAL_DRIVE","Samsung  Slim External Blu-ray Writer Drive"),
	LG_OPTICAL_DRIVE(2, "OPTICAL_DRIVE","LG Black DVD-ROM SATA Internal Blu-ray Drive"),
	HP_17_MONITOR(1, "MONITOR", "Hp  17\" Widescreen Led Hd Monitor"),
	HP_20_MONITOR(2, "MONITOR", "HP  20\" Widescreen LCD	"),
	WINDOWS8_OS(1, "Operating_System","64 Bit Windows 10 Operating System"),
	WINDOWS10_OS(2, "Operating_System","64 Bit Windows 8 Operating System"),
	YR_1_SYSTEM_SUPPORT(1,"SYSTEM_SUPPORT", "1 Year System Support	"),
	YR_3_SYSTEM_SUPPORT(2,"SYSTEM_SUPPORT", "3 Year System Support	"),
	SKIP(3, "SKIP","Skip this Item "),
	NULL(0,"NULL","");

	
	private int index;
	private String componentType;
	private String description;
	public static int len = 16;
	Choices(int no, String type, String desc) {
		index = no;
		componentType = type;
		description = desc;
	}

	public int getIndex() {
		return index;
	}

	public String getComponentType() {
		return componentType;
	}

	public String getDescription() {
		return description;
	}
	public String getChoice() {
		return "\n \t" +index + ".) " + description;
	}
	public static int getNoOfComponents(String type) {
		int cnt = 0;
		for(Choices  c1: Choices.values()){
			if(c1.componentType.equalsIgnoreCase(type))
				cnt++;
		}
		return cnt;
	}
	public static Choices getType(String type, int index) {
		
		for(Choices c : Choices.values())
		{
			if(c.componentType.equalsIgnoreCase(type) && c.index == index)
				return c;
		}
		return Choices.NULL;	// Check
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	
}

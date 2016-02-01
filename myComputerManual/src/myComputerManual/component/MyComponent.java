/**
 * 
 */
package myComputerManual.component;

import myComputerManual.choice.Choices;
import myComputerManual.util.LogType;
import myComputerManual.util.Logger;

/**
 * MyComponent implements ComponentFactory Interface
 * 
 */
public class MyComponent implements ComponentFactoryI {

	/**
	 * Constructor MyComponent
	 */
	public MyComponent() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
	}

	@Override
	public Component create(Choices c) {
		Component com = null;

		switch (c) {

		case Intel_CPU:
			com = new INTELCPU();
			break;
		case AMD_CPU:
			com = new AMDCPU();
			break;
		case GB_8_RAM:
			com = new RAM8GB();
			break;
		case GB_16_RAM:
			com = new RAM16GB();
			break;
		case TB_1_DISK:
			com = new DISK_1TB();
			break;
		case TB_2_DISK:
			com = new DISK_2TB();
			break;
		case INTEL_GRAPHIC:
			com = new GraphicsCard_INTEL();
			break;
		case NVIDIA_GRAPHIC:
			com = new GraphicsCard_NVIDIA();
			break;
		case WINDOWS10_OS:
			com = new OperatinSystem_Win_10();
			break;
		case WINDOWS8_OS:
			com = new OperatinSystem_Win_8();
			break;
		case SAMSUNG_OPTICAL_DRIVE:
			com = new OpticalDrive_Samsung();
			break;
		case LG_OPTICAL_DRIVE:
			com = new OpticalDrive_LG();
			break;
		case HP_17_MONITOR:
			com = new Monitor_17();
			break;
		case HP_20_MONITOR:
			com = new Monitor_20();
			break;
		case YR_1_SYSTEM_SUPPORT:
			com = new SystemSupport_1Yr();
			break;
		case YR_3_SYSTEM_SUPPORT:
			com = new SystemSupport_3Yr();
			break;
		case SKIP:
			com = null;
		default:
			return null;
		}
		return com;
	}
}

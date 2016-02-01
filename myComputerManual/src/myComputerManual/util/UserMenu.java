package myComputerManual.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

import myComputerManual.choice.Choices;
import myComputerManual.choice.MainMenu;

public class UserMenu {

	private Vector<Choices> MMap = null;
	boolean[] boolarr = null;
	Scanner s = null;

	/**
	 * Constructor
	 */
	public UserMenu() {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass().getName()
				+ " Class");
		MMap = new Vector<Choices>();
		boolarr = new boolean[Choices.len];
		Arrays.fill(boolarr, Boolean.FALSE);
		s = new Scanner(System.in);
	}

	/**
	 * To display MainMenu
	 */
	public void displayMainMenu() {

		System.out.println("\n\tMenu:");
		int i = 1;
		for (MainMenu m : MainMenu.values()) {
			System.out.println("\t " + i++ + ".) " + m.name());

		}
		System.out.println("\t 9.) Buy \n\t 10.) Exit");
	}

	/**
	 * toString for UserMenu
	 */
	@Override
	public String toString() {
		return "UserMenu [MMap=" + MMap + ", boolarr="
				+ Arrays.toString(boolarr) + ", s=" + s + "]";
	}

	/**
	 * 
	 * @param m
	 *            MainMenu enum
	 * @param isOptional
	 *            Component optional or not
	 * @return Choice selected
	 * @throws IOException
	 */
	public Choices displaySubMenu(MainMenu m, Boolean isOptional)
			throws IOException {

		// Choices ch = null;

		int in = 0;
		do {

			// System.out.println("\n\t 0.) "
			// + "Back to Menu ");
			for (Choices c : Choices.values()) {
				if (c.getComponentType().equalsIgnoreCase(m.name())) {
					// System.out.println("\n\t" + m.name());
					System.out.println("\t " + c.getIndex() + ".) "
							+ c.getDescription());
				}
			}
			if (isOptional) {
				Choices c = Choices.SKIP;
				System.out.println("\t " + c.getIndex() + ".) "
						+ c.getDescription());
			}
			try {
				if (s.hasNext())
					in = s.nextInt();
				
		
			}catch(NumberFormatException ex){
				 System.err.println("Error : Invalid Input"+ex.getMessage());
				 System.exit(-1);
			}
			catch (NoSuchElementException ex) {
				 System.err.println("Error : Invalid Input"+ex.getMessage());
				 System.exit(-1);
			}
			if (in == 1 || in == 2) {
				return Choices.getType(m.name(), in);
			} else if (isOptional && in == 3) {
				return Choices.SKIP;
			} else
				System.out.println("\n\t Please Input Correct Choice");

		} while (true);

	}

	/**
	 * Displays Menu
	 * 
	 * @return List of choices
	 * @throws IOException
	 */
	public Vector<Choices> displayMenu() throws IOException {

		try {
			// scanInput = new Scanner(System.in);
			int input = 0;
			boolean flag = false;
			do {
				if (!flag) {
					displayMainMenu();
					input = s.nextInt();

					// System.out.println("innn ");
				} else
					flag = false;
				MainMenu m = null;
				// System.out.println("input : "+input);
				switch (input) {

				case 1:
					m = MainMenu.CPU;
					// MMap.put(m, displaySubMenu(m, false));
					Choices c = displaySubMenu(m, false);
					MMap.add(c);
					boolarr[1] = true;
					if (boolarr[2])
						break;

				case 2:
					m = MainMenu.RAM;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, false));
					boolarr[2] = true;
					if (boolarr[3])
						break;

				case 3:
					m = MainMenu.DISK;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, false));
					boolarr[3] = true;
					if (boolarr[4])
						break;

				case 4:
					m = MainMenu.GRAPHICS_CARD;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, false));
					boolarr[4] = true;

				case 5:
					m = MainMenu.OPERATING_SYSTEM;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, true));

				case 6:
					m = MainMenu.MONITOR;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, true));

				case 7:
					m = MainMenu.OPERATING_SYSTEM;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, true));

				case 8:
					m = MainMenu.SYSTEM_SUPPORT;
					// MMap.put(m, displaySubMenu(m, false));
					MMap.add(displaySubMenu(m, true));
					break;

				case 9:
					for (int i = 1; i <= 4; i++) {
						if (boolarr[i] != true) {
							System.out.println("Please select ");
							flag = true;
							input = i;
							break;
						}
					}
					if (flag == true)
						continue;
					// System.out.println("All Selected");
					return MMap;

				case 10:
					System.out.println("Bye !!!");
					System.exit(0);
				default:
					// if (input != 0)
					System.out.println("Choose between the given choices");
					for (int i = 1; i <= 4; i++) {
						if (boolarr[i] != true) {
							System.out.println("Please select ");
							flag = true;
							input = i;
							break;
						}
					}
					if (flag == true)
						continue;
					break;
				}

			} while (input != 9 || input != 9); // Define variable for exit
		} catch (NumberFormatException ex) {
			System.err.println("Error: " + ex.getLocalizedMessage());
		} catch (NullPointerException ex) {
			System.err.println("Error: " + ex.getLocalizedMessage());
		} finally {
			// s.close();
			closeScanner();
		}
		return MMap;

	}

	/**
	 * Close the Scanner variable
	 */
	private void closeScanner() {
		if (s != null) {
			s.close();
			s = null;
		}
	}

}

package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.xmlStrategies.StrategyI;
import genericCheckpointing.xmlStrategies.XMLDeserializableStrategy;
import genericCheckpointing.xmlStrategies.XMLSerializableStrategy;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

// import the other types used in this file

public class Driver {

	public static void main(String[] args) {

		ProxyCreator pc = new ProxyCreator();
		int NUM_OF_OBJECTS = 0;
		String fileName = null;
		String sMethod = "serdeser";

		// Read from Command line
		try {
			if (args.length != 3)
				throw new ArrayIndexOutOfBoundsException();

			NUM_OF_OBJECTS = Integer.parseInt(args[0]);

			if (NUM_OF_OBJECTS <= 0)
				throw new NumberFormatException();

			fileName = args[1];
			sMethod = args[2];

		} catch (NumberFormatException ex) {
			System.err.println("Invalid number. Please enter a number > 0");
			System.exit(1);
		} catch (NullPointerException ex) {
			System.err
					.println("Invalid number of arguements Please enter a <NUM_OF_OBJECTS, fileName, ser/deser/serdeser>");
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.err
					.println("Invalid number of arguements Please enter a <NUM_OF_OBJECTS, fileName, ser/deser/serdeser>");
			System.exit(1);
		} finally {

		}

		// create an instance of StoreRestoreHandler (which implements
		// the InvocationHandler
		StoreRestoreHandler handler = new StoreRestoreHandler();

		handler.setFileName(fileName);
		// Create Strategy Object
		StrategyI xmlStrat = null;

		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] {
				StoreI.class, RestoreI.class }, handler);

		// invoke a method on the handler instance to set the file name
		// for checkpointFile and open the file
		Boolean serflag = false;
		if (sMethod.equalsIgnoreCase("ser")
				|| sMethod.equalsIgnoreCase("serdeser")) {
			try {
				xmlStrat = new XMLSerializableStrategy();
				serflag = true;
				handler.openFile("WRITE");
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			} finally {

			}
		}
		MyAllTypesFirst myFirst = null;
		MyAllTypesSecond mySecond = null;

		// create a vector to store the objects being serialized
		Vector<SerializableObject> vecS = new Vector<SerializableObject>();

		for (int i = 1, k = 10; i <= NUM_OF_OBJECTS; i++, k += 10) {

			myFirst = new MyAllTypesFirst(i, "First_" + i, i * 0.01,
					i * 100000, (char) ('A' + i - 1));
			mySecond = new MyAllTypesSecond(i, "Second_" + i, k * 0.01,
					k * 100000, (char) ('A' + i - 1));

			// store myFirst and mySecond in the vector
			vecS.add(myFirst);
			vecS.add(mySecond);
			if (serflag) {
				// Calling for myFirst
				((StoreI) cpointRef).writeObj(myFirst, xmlStrat);
				// Calling for mySecond
				((StoreI) cpointRef).writeObj(mySecond, xmlStrat);
			}
		}
		if (serflag) {
			try {
				handler.closeFile();

			} catch (IOException e1) {
				e1.printStackTrace();
				System.exit(1);
			} finally {

			}
		}

		// Deserializable
		if (sMethod.contains("deser")) {
			// create a vector to store the returned ojects
			Vector<SerializableObject> vecD = new Vector<SerializableObject>();
			try {

				xmlStrat = new XMLDeserializableStrategy();

				handler.openFile("READ");
			} catch (IOException e1) {
				e1.printStackTrace();
				System.exit(1);
			} finally {

				SerializableObject myRecordRet = null;

				for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {
					try {

						myRecordRet = ((RestoreI) cpointRef).readObj(xmlStrat);

					} catch (Exception ex) {

						ex.printStackTrace();
						System.exit(1);
					} finally {

					}
					// store myRecordRet in the vector
					vecD.add(myRecordRet);
				}

				// invoke a method on the handler to close the file (if it
				// hasn't
				// already been closed
				try {
					handler.closeFile();
				} catch (IOException e) {

					e.printStackTrace();
					System.exit(1);
				} finally {

				}
			}
			// System.out.println(vecS + "\n\n" + vecD);

			// compare and confirm that the serialized and deserialized
			// objects are equal

			// Using iterator to iterate through vectors
			Iterator<SerializableObject> s = vecS.iterator();
			Iterator<SerializableObject> d = vecD.iterator();
			int unequalObj = 0; // To count mismatched objects.
			while (s.hasNext() && d.hasNext()) {
				if (!s.next().equals(d.next()))
					unequalObj++;
			}
			/*
			 * while (s.hasNext()) { unequalObj++; } while (d.hasNext()) {
			 * unequalObj++; }
			 */
			System.out.println(unequalObj + " Mismatched Objects ");

		}
	}
}
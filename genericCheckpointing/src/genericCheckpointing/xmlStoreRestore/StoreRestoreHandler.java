package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.xmlStrategies.StrategyI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 
 */
public class StoreRestoreHandler implements InvocationHandler {

	private String fileName = null;
	private BufferedWriter bw = null;
	private BufferedReader br = null;

	/**
	 * Get Filename
	 * 
	 * @return name of file
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Set fileName
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Open file
	 * 
	 * @param type
	 *            read or write
	 * @throws IOException
	 */
	public void openFile(String type) throws IOException {

		try {
			if (type.equals("READ") && null == br)
				br = new BufferedReader(new FileReader(new File(fileName)));
			else if (type.equals("WRITE") && null == bw)
				bw = new BufferedWriter(new FileWriter(new File(fileName)));
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Close the opened file
	 * 
	 * @throws IOException
	 */
	public void closeFile() throws IOException {

		try {
			if (br != null) {
				br.close();
			}
			if (bw != null) {
				bw.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	/**
	 * Processes a method invocation on a proxy instance and returns the result.
	 * This method will be invoked on an invocation handler when a method is
	 * invoked on a proxy instance that it is associated with.
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		StrategyI xmls = null;
		try {

			xmls = (StrategyI) args[args.length - 1];

			if ((method.getName().contains("writeObj"))) {
				Object[] params = { args[0], bw };
				return xmls.check(params);

			} else {
				Object[] params = { args[0], br };
				return xmls.check(params);
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			ex.printStackTrace();
			System.exit(1);
		} finally {

		}
		
		return null;
	}
}

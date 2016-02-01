package genericCheckpointing.xmlStrategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.StringTokenizer;

public class XMLDeserializableStrategy implements StrategyI {

	private Method[] methods = null;
	private Object obj = null;

	@Override
	public Object check(Object[] objs) {

		Class<?> tempC = null;

		try {
			BufferedReader br = (BufferedReader) objs[1];
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = null;

				if (line.contains("<complexType")) {
					st = new StringTokenizer(line, "\"");
					String clsName = st.nextToken();
					clsName = st.nextToken();
					tempC = Class.forName(clsName.trim());
					methods = tempC.getMethods();
					obj = tempC.newInstance();

				} else if (line.contains("xsd:int")) {

					String[] sp = line.split("<");
					st = new StringTokenizer(sp[1], " ");
					String varName = st.nextToken();
					varName = varName.substring(0, 1).toUpperCase()
							+ varName.substring(1);

					for (Method m : methods) {

						if (m.getName().contains("set" + varName)) {
							String[] var = st.nextToken().split(">");
							int in = Integer.parseInt(var[1]);
							Object[] params = { in };
							m.invoke(obj, params);
						}
					}

				} else if (line.contains("xsd:String")) {
					String[] sp = line.split("<");
					st = new StringTokenizer(sp[1], " ");
					String varName = st.nextToken();
					varName = varName.substring(0, 1).toUpperCase()
							+ varName.substring(1);

					for (Method m : methods) {
						if (m.getName().contains("set" + varName)) {
							String[] var = st.nextToken().split(">");
							String in = var[1];
							Object[] params = { in };
							m.invoke(obj, params);
						}
					}
				} else if (line.contains("xsd:double")) {
					String[] sp = line.split("<");
					st = new StringTokenizer(sp[1], " ");
					String varName = st.nextToken();
					varName = varName.substring(0, 1).toUpperCase()
							+ varName.substring(1);

					for (Method m : methods) {
						if (m.getName().contains("set" + varName)) {
							String[] var = st.nextToken().split(">");
							double in = Double.parseDouble(var[1]);
							Object[] params = { in };
							m.invoke(obj, params);
						}
					}
				} else if (line.contains("xsd:char")) {
					String[] sp = line.split("<");
					st = new StringTokenizer(sp[1], " ");
					String varName = st.nextToken();
					varName = varName.substring(0, 1).toUpperCase()
							+ varName.substring(1);

					for (Method m : methods) {
						if (m.getName().contains("set" + varName)) {
							String[] var = st.nextToken().split(">");
							char[] in = var[1].toCharArray();
							Object[] params = { in[0] };
							m.invoke(obj, params);
						}
					}
				} else if (line.contains("xsd:long")) {
					String[] sp = line.split("<");
					st = new StringTokenizer(sp[1], " ");
					String varName = st.nextToken();
					varName = varName.substring(0, 1).toUpperCase()
							+ varName.substring(1);
					for (Method m : methods) {
						if (m.getName().contains("set" + varName)) {
							String[] var = st.nextToken().split(">");
							long in = Long.parseLong(var[1]);
							Object[] params = { in };
							m.invoke(obj, params);
						}
					}
				} else if (line.contains("</DPSerialization>")) {
					// System.out.println("Returning " + obj);
					return obj;
				}

			}
		} catch (ClassNotFoundException ex) {
			System.exit(1);
		} catch (UndeclaredThrowableException ex) {
			ex.getLocalizedMessage();
			System.exit(1);
		} catch (IllegalAccessException e) {
			e.getLocalizedMessage();
			System.exit(1);
		} catch (IllegalArgumentException e) {
			e.getLocalizedMessage();
			System.exit(1);
		} catch (InvocationTargetException e) {
			e.getLocalizedMessage();
			System.exit(1);
		} catch (InstantiationException e) {
			e.getLocalizedMessage();
			System.exit(1);
		} catch (SecurityException e) {
			e.getLocalizedMessage();
			System.exit(1);
		} catch (IOException e) {
			e.getLocalizedMessage();
			System.exit(1);
		} finally {

		}
		// Return null if any error
		return null;
	}
}

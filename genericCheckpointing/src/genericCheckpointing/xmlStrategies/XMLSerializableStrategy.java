package genericCheckpointing.xmlStrategies;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class XMLSerializableStrategy implements StrategyI {

	public Object serialize(Object[] args) {

		try {
			BufferedWriter bw = (BufferedWriter) args[1];
			String sp = "";
			Class<? extends Object> tempC = args[0].getClass();
			bw.write(sp + "<DPSerialization>\n");
			sp += " ";
			bw.write(sp + "<complexType xsi:type=" + "\"" + tempC.getName()
					+ "\"" + ">\n");
			sp += " ";
			Field[] f = tempC.getDeclaredFields();
			for (Field fi : f) {
				fi.setAccessible(true);
				bw.write(sp + "<" + fi.getName() + " xsi:type=\"xsd:"
						+ fi.getType().getSimpleName() + "\">"
						+ fi.get(args[0]) + "</" + fi.getName() + ">\n");
			}
			bw.write("</complexType>\n");
			bw.write("</DPSerialization>\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} finally {

		}
		return true;
	}

	@Override
	public Object check(Object[] obj) {

		return serialize(obj);

	}

}

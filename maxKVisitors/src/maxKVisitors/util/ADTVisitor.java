package maxKVisitors.util;

public class ADTVisitor implements VisitorI {

	private FileProcessor fp = null;
	private String fileName = null;

	/**
	 * Constructor
	 * 
	 * @param fileName
	 *            Sets filename
	 */
	public ADTVisitor(String fileName) {
		Logger l = Logger.getInstance();
		l.Write(LogType.CONSTRUCTOR, "In " + this.getClass());
		this.fileName = fileName;
	}

	@Override
	public void visit(ADTI v) {
		fp = new FileProcessor(fileName);
		while (fp.hasItem())
			v.addElement(fp.nextInt());
		fp.Close();
	}

}

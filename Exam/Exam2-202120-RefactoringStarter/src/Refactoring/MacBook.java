package Refactoring;

public class MacBook extends Laptop {
	private final static String OP_SYS_TYPE = "Mac OS";
	private final static String Plural_Name = "MacBooks";


	// ------------------------------------------------------------------------

	public MacBook(String ownerName, double currentOpSysVersion) {
		super(ownerName, currentOpSysVersion);
	} // MacBook

	// ------------------------------------------------------------------------

	public void generateOwnerReport() {
		System.out.printf("|%.50s|\n", "++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.printf("|%s%.50s%s %s|\n", "+", " EIT Servicing ", Plural_Name,  "+++++++++++++++++++++");
		super.generateOwnerReport(OP_SYS_TYPE);
		System.out.printf("|%.50s|\n", "+ End Report +++++++++++++++++++++++++++++++++");
		System.out.printf("|%.50s|\n\n\n", "++++++++++++++++++++++++++++++++++++++++++++++");
	}
} // MacBook

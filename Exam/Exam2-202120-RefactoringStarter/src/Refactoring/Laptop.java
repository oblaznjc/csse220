package Refactoring;

public abstract class Laptop {
	private String ownerName;
	private double currentOpSysVersion;
	// ------------------------------------------------------------------------

	public Laptop(String ownerName, double currentOpSysVersion) {
		this.ownerName = ownerName;
		this.currentOpSysVersion = currentOpSysVersion;
	} // Laptop

	// ------------------------------------------------------------------------

	public void generateOwnerReport(String OP_SYS_TYPE) {
		System.out.printf("|%.46s|\n", "                                              ");
		System.out.printf("|%.46s|\n", "                                              ");
		System.out.printf("|%15s%-4.1f%-5s%-22s|\n", OP_SYS_TYPE, this.currentOpSysVersion, "", this.ownerName);
		System.out.printf("|%.50s|\n", "                                              ");
		System.out.printf("|%.50s|\n", "                                              ");

	} // generateOwnerReport

	// ------------------------------------------------------------------------

	public double getCurrentOpSysVersion() {
		return this.currentOpSysVersion;
	} // getCurrentOpSysVersion

	// ------------------------------------------------------------------------

	public String getOwnerName() {
		return this.ownerName;
	} // GetOwnerName

	protected abstract void generateOwnerReport();

} // Laptop

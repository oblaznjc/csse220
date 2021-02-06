
public class B {

	private int count;

	public B() {
		this.count = 0;
	}

	public void setValue(int value) {
		this.count = value;
	}
	
	@Override
	public String toString() {
		return "B with count: " + this.count;
	}
	
}

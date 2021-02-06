import java.util.ArrayList;

public class A {
	private String name;
	private B myB;

	public A(String name) {
		this.name = name;
		this.myB = new B();
	}

	public void setBvalue(int value) {
		this.myB.setValue(value);
	}
	
	@Override
	public String toString() {
		return "A with name: " + this.name + " with B: " + this.myB;
	}
}

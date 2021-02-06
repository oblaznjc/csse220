package numberSequence;

public class Fibonacci implements Sequence {
	private int current;
	private int previous;

	
	public Fibonacci() {
		this.current = 0;
		this.previous = 1;
	}

	@Override
	public int next() {
		int temp = this.current;
		this.current = this.current + this.previous;
		this.previous = temp;
		return this.current;
	}

	@Override
	public void reset() {
		this.current = 0;
	}
}

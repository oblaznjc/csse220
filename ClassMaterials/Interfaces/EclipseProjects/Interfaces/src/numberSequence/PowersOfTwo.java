package numberSequence;

public class PowersOfTwo implements Sequence {
	private int current;
	private int count;
	
	public PowersOfTwo() {
		this.current = 0;
		this.count = 0;
	}

	@Override
	public int next() {
		this.current = (int) Math.pow(2, this.count);
		this.count = this.count + 1;
		return this.current;
	}

	@Override
	public void reset() {
		this.current = 0;
	}
}

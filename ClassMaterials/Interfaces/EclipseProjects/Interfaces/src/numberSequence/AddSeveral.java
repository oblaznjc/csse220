package numberSequence;

public class AddSeveral implements Sequence {
	private int current;
	private int i;
	
	public AddSeveral(int i) {
		this.current = 0;
		this.i = i;
	}

	@Override
	public int next() {
		this.current = this.current + i;
		return this.current;
	}

	@Override
	public void reset() {
		this.current = 0;
	}
}


public class Scissors extends Sprite {

	public Scissors(int i, int j, int k, int l) {
		super(i, j, 80, 80, k, l, "img/scissors.png");
		this.type = "Scissors";
	}

	public void collideWith(Sprite o) {
		if (o.type.equals(this.type)) {
			this.dx = -dx;
			return;
		} else if (o.type.equals("Rock")) {
			this.toRemove = true;
			return;
		} else if (o.type.equals("Paper")) {
			System.out.println("Paper Cut by Scissors");
			return;
		}
	}
}

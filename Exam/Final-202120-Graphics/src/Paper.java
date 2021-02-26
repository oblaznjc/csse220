
public class Paper extends Sprite {

	public Paper(int i, int j, int k, int l) {
		super(i, j, 80, 80, k, l, "img/paper.png");
		this.type = "Paper";
	}

	public void collideWith(Sprite o) {
		if (o.type.equals(this.type)) {
			return;
		} else if (o.type.equals("Rock")) {
			System.out.println("Rock Cover By Paper");
			return;
		} else if (o.type.equals("Scissors")) {
			this.toRemove = true;
			return;
		}
	}
}


public class Rock extends Sprite {

	public Rock(int i, int j, int k, int l) {
		super(i, j, 80, 80, k, l, "img/rock.png");
		this.type = "Rock";
	}

	public void collideWith(Sprite o) {
		if (o.type.equals(this.type)) {
			this.dy = -dy;
			return;
		} else if (o.type.equals("Scissors")) {
			System.out.println("Rock Smashed Scissors");
			return;
		} else if (o.type.equals("Paper")) {
			this.toRemove = true;
			return;
		}
	}
}

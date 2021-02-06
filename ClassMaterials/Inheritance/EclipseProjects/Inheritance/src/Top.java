
public class Top {

	interface Top {
		public void alpha();

		public void beta();

		public void gamma();

		public void delta();
		// Note no epsilon here
	}

	class One implements Top {

		public void alpha() {
			System.out.println("A");
		}

		public void beta() {
			System.out.println("B");
		}

		public void gamma() {
			System.out.println("C");
		}

		public void delta() {
			System.out.println("D");
			this.beta();
		}
	}

	class Two extends One implements Top {

		public void beta() {
			System.out.println("E");
		}

		public void gamma() {
			super.gamma();
			System.out.println("F");
		}

		public void epsilon() {
			System.out.println("G");
		}
	}

	public static void main(String[] args) {
		Two m = new Two();
		Top q = new One();
		Top r = new Two();
		One s = new Two();

	}

}

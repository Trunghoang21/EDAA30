package fractal;

import koch.Koch;
import mountain.Point;
import mountain.bergfraktal;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new bergfraktal(new Point(100, 450), new Point(500, 400), new Point(300, 100 ),40);
	    new FractalView(fractals, "Fraktaler", 600, 600);
	}

}

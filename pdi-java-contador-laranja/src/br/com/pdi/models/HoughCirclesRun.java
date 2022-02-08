package br.com.pdi.models;

import org.opencv.core.Core;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class HoughCirclesRun {
	public void run(Mat src) {

		if (src.empty()) {
			System.out.println("Error opening image!");
			System.exit(-1);
		}
		Mat canny = new Mat();
		Mat hsv = new Mat();
		Imgproc.cvtColor(src, hsv, Imgproc.COLOR_BGR2HSV);
		Core.inRange(hsv, new Scalar(10, 100, 20), new Scalar(25, 255, 255), hsv);
		Imgproc.medianBlur(hsv, hsv, 15);
		Imgproc.Canny(hsv, canny, 100, 152);

		// Imgproc.medianBlur(hsv, hsv, 3);
		Mat circles = new Mat();

		Imgproc.HoughCircles(canny, circles, Imgproc.HOUGH_GRADIENT, 0.901, 65, // change this value to detect circles
																				// with
																				// different distances to each other
				255.0, 19, 1, 171); // change the last two parameters

		// (min_radius & max_radius) to detect larger circles

		int contadorLaranja = 0;

		for (int x = 0; x < circles.cols(); x++) {
			double[] c = circles.get(0, x);
			Point center = new Point(Math.round(c[0]), Math.round(c[1]));
			// circle center
			Imgproc.circle(src, center, 1, new Scalar(0, 100, 100), 3, 8, 0);
			// circle outline
			int radius = (int) Math.round(c[2]);
			Imgproc.circle(src, center, radius, new Scalar(255, 0, 255), 3, 8, 0);

			contadorLaranja++;
		}

		HighGui.imshow("detected circles", src);
		HighGui.waitKey();
		showMessageDialog(null, "Quantidade de laranjas>> "+ contadorLaranja);
		System.exit(0);
	}
}

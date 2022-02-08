package br.com.pdi.models;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class CannyOperator {
	public static Mat edgeDetection(Mat source){
		Mat hsv = new Mat();
		Mat canny = new Mat();
		Imgproc.cvtColor(source, hsv, Imgproc.COLOR_BGR2HSV);
		Core.inRange(hsv, new Scalar(10, 100, 20), new Scalar(25, 255, 255), hsv);
		Imgproc.medianBlur(hsv, hsv, 15);
		Imgproc.Canny(hsv, canny, 100, 152);
		return canny;
	}
}

package br.com.pdi.models;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Core;
import br.com.pdi.util.ImShow;

public class Hsv { 

	public static Mat imageToGray(Mat source){
	 //img is given from previos code
	Mat hsv = new Mat();
	Imgproc.cvtColor(source, hsv, Imgproc.COLOR_BGR2HSV);    
	Core.inRange(hsv, new Scalar (10, 100, 20), new Scalar(25, 255, 255), hsv );
	Imgproc.medianBlur(hsv, hsv, 15);
	return hsv;
}
	static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		
		Mat source = Imgcodecs.imread("resources/images/oranges.jfif");
		Mat hsv = Hsv.imageToGray(source);
		
		new ImShow("original").showImage(source);
		new ImShow("gray scale").showImage(hsv);
	}

}



	

package br.com.pdi.examples;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import br.com.pdi.models.HoughCirclesRun;

public class HoughCirclesRunExemple {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		Mat source = Imgcodecs.imread("resources/images/oranges.jfif");
		
        new HoughCirclesRun().run(source);
       
	}

}

/*componentes
Henrique Wiliam Silva de Jesus 201651275122 
Guilherme Augusto Bafica Rodrigues da Silva - 201751180522 
Beatriz Souza dos Santos-201951072359
Hevert Vinicius 201851383131  */
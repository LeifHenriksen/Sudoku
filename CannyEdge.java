package openCV;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
public class CannyEdge {
	public static void main(String[] args) {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat color = Imgcodecs.imread("C:\\Users\\jerem\\Downloads\\test3.png");
		
		Mat gray =new Mat();
		Mat draw = new Mat();
		Mat wide = new Mat();
		
		Imgproc.cvtColor(color,gray,Imgproc.COLOR_BGR2GRAY);
		Imgproc.Canny(gray,wide,50,150,3,false);
		wide.convertTo( draw,CvType.CV_8U);
		if(Imgcodecs.imwrite("C:\\Users\\jerem\\Downloads\\testfinal.jpg",draw));{
			System.out.println("good");
		}
	}

}

package org.firstinspires.ftc.teamcode;

import android.graphics.Canvas;

import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class OpenCV implements VisionProcessor {
    Rect MIDDLE_RECTANGLE;
    Mat hsvMatRed = new Mat();
    Mat lowMatRed = new Mat();
    Mat highMatRed = new Mat();
    Mat detectedMatRed = new Mat();

    Mat hsvMatBlue = new Mat();
    Mat lowMatBlue = new Mat();
    Mat highMatBlue = new Mat();
    Mat detectedMatBlue = new Mat();


    // Hue, Saturation, Level
    // remember to convert between openCV units and online color units

    Scalar lowerRedThresholdLow = new Scalar(0, 90, 125); // lowest consider red threshold for the left part of the color scale
    Scalar lowerRedThresholdHigh = new Scalar(10, 255, 255); // highest consider red threshold for the left part of the color scale

    Scalar higherRedThresholdLow = new Scalar(165, 90, 125); // lowest consider red threshold for the right part of the color scale
    Scalar higherRedThresholdHigh = new Scalar(180, 255, 255);// highest consider red threshold for the right part of the color scale

    // HUE: 200 to 247
    // SATURATION: 65% to 100%
    // VALUE: 50 to 100 %

    Scalar lowerBlueThreshold = new Scalar(100, 90, 125);
    Scalar higherBlueThreshold = new Scalar(125, 255, 255);

    double middleThreshold = 0.1;

    PropLocation propLocation = PropLocation.NOT_FOUND;


    @Override
    public void init(int width, int height, CameraCalibration calibration) {
        MIDDLE_RECTANGLE = new Rect(
                new Point(0.25 * width, 0),
                new Point(0.75*width, height)
        );
    }

    @Override
    public Object processFrame(Mat frame, long captureTimeNanos) {
        Imgproc.cvtColor(frame, hsvMatRed, Imgproc.COLOR_RGB2HSV);
        Imgproc.cvtColor(frame, hsvMatBlue, Imgproc.COLOR_RGB2HSV);

        // where is the data coming from, low end threshold, high end threshold, where are we storing it
        // everything inside this range set to white, everything outside set to black
        Core.inRange(hsvMatRed, lowerRedThresholdLow, lowerRedThresholdHigh, lowMatRed);
        Core.inRange(hsvMatRed, higherRedThresholdLow, higherRedThresholdHigh, highMatRed);
        Core.bitwise_or(lowMatRed, highMatRed, detectedMatRed); // if it's white in both or either, then in detected will be white. if it's black in both then it will be black in detected.

        Core.inRange(hsvMatBlue, lowerBlueThreshold, lowerBlueThreshold, lowMatBlue);
        Core.inRange(hsvMatRed, higherBlueThreshold, higherBlueThreshold, highMatBlue);
        Core.bitwise_or(lowMatBlue, highMatBlue, detectedMatBlue);

        // now, we are looking at only a specific part of the image, which was already converted to B/W with Core.inRange
        double middlePercentRed = (Core.sumElems(detectedMatRed.submat(MIDDLE_RECTANGLE)).val[0] / 255)/ MIDDLE_RECTANGLE.area(); // adds all of pixel values together, higher value = more white = more red, / 255 gives the # of white pixels, / .area() makes it a percent
        double middlePercentBlue = (Core.sumElems(detectedMatBlue.submat(MIDDLE_RECTANGLE)).val[0] / 255)/ MIDDLE_RECTANGLE.area();

        Scalar whiteBorder = new Scalar(255, 255, 255);
        Scalar redBorder = new Scalar (255, 0, 0);
        Scalar blueBorder = new Scalar (0, 255, 0);

        if (middlePercentRed > middleThreshold) {
            // object was detected
            propLocation = PropLocation.RED;
            Imgproc.rectangle(frame, MIDDLE_RECTANGLE, redBorder);
        } else if (middlePercentBlue > middleThreshold) {
            propLocation = PropLocation.BLUE;
            Imgproc.rectangle(frame, MIDDLE_RECTANGLE, blueBorder);
        } else {
            // object was not detected
            propLocation = PropLocation.NONE;
            Imgproc.rectangle(frame, MIDDLE_RECTANGLE, whiteBorder);
        }

        return null;
    }

    @Override
    public void onDrawFrame(Canvas canvas, int onscreenWidth, int onscreenHeight, float scaleBmpPxToCanvasPx, float scaleCanvasDensity, Object userContext) {

    }

    public PropLocation getPropLocation(){
        return propLocation;
    }

    public enum PropLocation{
        RED(1),
        BLUE(0),
        NOT_FOUND(2),
        NONE(3);
        public final int posNum;

        PropLocation(int posNum){
            this.posNum = posNum;
        }
    }
}
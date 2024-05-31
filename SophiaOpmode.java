package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.vision.VisionPortal;

@Autonomous
public class SophiaOpmode extends LinearOpMode {

    DcMotorEx BL, FL, BR, FR;

    OpenCV processor;
    VisionPortal portal;

    //OpenCV.PropLocation propLocation = OpenCV.PropLocation.NOT_FOUND;
    boolean check;

    @Override
    public void runOpMode() throws InterruptedException {
        BL = hardwareMap.get(DcMotorEx.class, "backLeft");
        FL = hardwareMap.get(DcMotorEx.class, "frontLeft");
        BR = hardwareMap.get(DcMotorEx.class, "backRight");
        FR = hardwareMap.get(DcMotorEx.class, "frontRight");

        processor = new OpenCV();
        portal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(CameraName.class, "Webcam 1"))
                .setCameraResolution(new Size(640, 480))
                .addProcessors(processor)
                .build();


        waitForStart();

        OpenCV.PropLocation propLocation = processor.getPropLocation();
        //propLocation = processor.getPropLocation();

        switch (propLocation){
            case BLUE:
                check = true;
                break;
            case RED:
                check = false;
                break;
        }

        telemetry.addData("location", propLocation);
        telemetry.update();

        while (opModeIsActive()) {

            //if (check){
            //Movement.forward(FL, BL, BR, FR, 120, 1000);
            //Movement.left(FL, BL, BR, FR, 120, 1000);
            //Movement.forward(FL, BL, BR, FR, 2400, 1000);
            //Movement.right(FL, BL, BR, FR, 2400, 1000);
            //Movement.backward(FL, BL, BR, FR, 2400, 1000);
            //Movement.left(FL, BL, BR, FR, 1200, 1000);
            //Movement.backward(FL, BL, BR, FR, 1200, 1000);
            // } else {
            /*
                Movement.forward(FL, BL, BR, FR, 120, 1000);
                Movement.right(FL, BL, BR, FR, 120, 1000);
                Movement.forward(FL, BL, BR, FR, 240, 1000);
                Movement.left(FL, BL, BR, FR, 240, 1000);
                Movement.backward(FL, BL, BR, FR, 240, 1000);
                Movement.right(FL, BL, BR, FR, 120, 1000);
                Movement.backward(FL, BL, BR, FR, 120, 1000); */
        }

    }
}
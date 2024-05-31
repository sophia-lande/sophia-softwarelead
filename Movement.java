package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Movement {
    static int rotations;
    static int TOLERANCE = 10;


    public static void left(DcMotorEx FL, DcMotorEx BL, DcMotorEx BR, DcMotorEx FR, double distance, int velocity){
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);

        rotations = (int) (distance * 21.74);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FL.setTargetPosition(-rotations);
        BL.setTargetPosition(rotations);
        FR.setTargetPosition(rotations);
        BR.setTargetPosition(-rotations);

        FL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        FL.setVelocity(velocity);
        BL.setVelocity(velocity);
        FR.setVelocity(velocity);
        BR.setVelocity(velocity);
        while (Math.abs(FL.getTargetPosition()-FL.getCurrentPosition())>= TOLERANCE || Math.abs(BL.getTargetPosition()-BL.getCurrentPosition())>= TOLERANCE || Math.abs(FR.getTargetPosition()-FR.getCurrentPosition())>= TOLERANCE || Math.abs(BR.getTargetPosition()-BR.getCurrentPosition())>= TOLERANCE) {

        }
        FL.setVelocity(0);
        BL.setVelocity(0);
        FR.setVelocity(0);
        BR.setVelocity(0);
    }

    public static void right(DcMotorEx FL, DcMotorEx BL, DcMotorEx BR, DcMotorEx FR, double distance, int velocity){

        rotations = (int) (distance * 21.74);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FL.setTargetPosition(-rotations);
        BL.setTargetPosition(rotations);
        FR.setTargetPosition(-rotations);
        BR.setTargetPosition(rotations);

        FL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        FL.setVelocity(velocity);
        BL.setVelocity(velocity);
        FR.setVelocity(velocity);
        BR.setVelocity(velocity);

        while (Math.abs(FL.getTargetPosition()-FL.getCurrentPosition())>= TOLERANCE || Math.abs(BL.getTargetPosition()-BL.getCurrentPosition())>= TOLERANCE || Math.abs(FR.getTargetPosition()-FR.getCurrentPosition())>= TOLERANCE || Math.abs(BR.getTargetPosition()-BR.getCurrentPosition())>= TOLERANCE) {

        }
        FL.setVelocity(0);
        BL.setVelocity(0);
        FR.setVelocity(0);
        BR.setVelocity(0);

    }

    public static void forward(DcMotorEx FL, DcMotorEx BL, DcMotorEx BR, DcMotorEx FR, double distance, int velocity){

        rotations = (int) (distance * 21.74);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FL.setTargetPosition(-rotations);
        BL.setTargetPosition(-rotations);
        FR.setTargetPosition(rotations);
        BR.setTargetPosition(rotations);

        FL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        FL.setVelocity(velocity);
        BL.setVelocity(velocity);
        FR.setVelocity(velocity);
        BR.setVelocity(velocity);

        while (Math.abs(FL.getTargetPosition()-FL.getCurrentPosition())>= TOLERANCE || Math.abs(BL.getTargetPosition()-BL.getCurrentPosition())>= TOLERANCE || Math.abs(FR.getTargetPosition()-FR.getCurrentPosition())>= TOLERANCE || Math.abs(BR.getTargetPosition()-BR.getCurrentPosition())>= TOLERANCE) {

        }
        FL.setVelocity(0);
        BL.setVelocity(0);
        FR.setVelocity(0);
        BR.setVelocity(0);
    }

    public static void backward(DcMotorEx FL, DcMotorEx BL, DcMotorEx BR, DcMotorEx FR, double distance, int velocity){

        rotations = (int) (distance * 21.74);

        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FL.setTargetPosition(-rotations);
        BL.setTargetPosition(-rotations);
        FR.setTargetPosition(-rotations);
        BR.setTargetPosition(-rotations);

        FL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        FR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        BR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        FL.setVelocity(velocity);
        BL.setVelocity(velocity);
        FR.setVelocity(velocity);
        BR.setVelocity(velocity);

        while (Math.abs(FL.getTargetPosition()-FL.getCurrentPosition())>= TOLERANCE || Math.abs(BL.getTargetPosition()-BL.getCurrentPosition())>= TOLERANCE || Math.abs(FR.getTargetPosition()-FR.getCurrentPosition())>= TOLERANCE || Math.abs(BR.getTargetPosition()-BR.getCurrentPosition())>= TOLERANCE) {

        }
        FL.setVelocity(0);
        BL.setVelocity(0);
        FR.setVelocity(0);
        BR.setVelocity(0);
    }
}
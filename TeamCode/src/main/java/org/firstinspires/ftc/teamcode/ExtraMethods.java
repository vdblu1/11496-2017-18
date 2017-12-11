package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by 120449 on 12/11/17.
 */

public class ExtraMethods extends OpMode {

    DcMotor left_drive;
    DcMotor right_drive;
    DcMotor Arm;
    Servo Finger1;
    Servo   Finger2;
    Servo   GemMover;
    int progress = 0;
    boolean pressingA = false;
    boolean pressingB = false;

    public void init(){
        left_drive = hardwareMap.dcMotor.get("left");
        right_drive = hardwareMap.dcMotor.get("right");
        Arm = hardwareMap.dcMotor.get("Arm");
        Finger1 = hardwareMap.servo.get("Finger1");
        Finger2 = hardwareMap.servo.get("Finger2");
        GemMover = hardwareMap.servo.get("GemMover");
    }
    @Override
    public void loop(){}

    public void Drive() {
        float Rotation = (gamepad1.right_stick_x);
        float Gas = (gamepad1.right_trigger);
        float reverse = (gamepad1.left_trigger);

        double Left = Gas;
        double Right = Gas;
        //Forward
        left_drive.setPower(Left);
        right_drive.setPower(-Right);
        if (Gas > 0){
            if (Rotation >0) {
                //Turn Right
                left_drive.setPower(Left);
                right_drive.setPower(Right);
            } else if (Rotation <0) {
                //Turn Left
                left_drive.setPower(-Left);
                right_drive.setPower(-Right);
            }
        }

        ///Backward

        double Left2 = reverse;
        double Right2 = reverse;
        left_drive.setPower(-Left2);
        right_drive.setPower(Right2);

        if (reverse > 0) { //Maybe this if loop will fix reverse turning?
            if (Rotation > 0) {
                //Turn Left
                left_drive.setPower(Left);
                right_drive.setPower(Right);
            } else if (Rotation < 0) {
                //Turn Right
                left_drive.setPower(-Left);
                right_drive.setPower(-Right);
            }
        }
    }

    public void FingerPosition(){

        if(gamepad2.a)
        {
            if (pressingA == false) {


                if (progress < 3) {

                    progress++;


                }
                pressingA = true;
            }

        } else {
            pressingA = false;
        }
        if(gamepad2.b)
        {
            if (pressingB == false) {


                if (progress > 0) {

                    progress--;


                }
                pressingB = true;
            }

        } else {
            pressingB = false;
        }
        if (progress == 0) {
            Finger1.setPosition(1);
            Finger2.setPosition(0);
        } else if (progress == 1) {
            Finger1.setPosition(0.7);
            Finger2.setPosition(0.3);
        } else if (progress == 2) {
            Finger1.setPosition(0.55);
            Finger2.setPosition(0.45);

        } else if (progress == 3) {
            Finger1.setPosition(0.45);
            Finger2.setPosition(0.55);
        }
    }



}

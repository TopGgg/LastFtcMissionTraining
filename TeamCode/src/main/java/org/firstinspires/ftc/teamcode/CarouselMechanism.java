package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class CarouselMechanism {

    private Robot robot;
    private EncoderHelper rightEncoder;
    private EncoderHelper leftEncoder;
    private static final int ticksPerRev = 288; //for REV core hex motor

    private boolean lastYState = false;

    public CarouselMechanism(Robot robot){
        this.robot = robot;
        rightEncoder = new EncoderHelper(robot.carouselRight);
        leftEncoder = new EncoderHelper(robot.carouselLeft);
    }

    public void controlMechanism(Gamepad gamepad1){
        if(lastYState != gamepad1.y && gamepad1.y){
            lastYState = true;
            if(robot.imu.getHeading() >= 180){
                rightEncoder.runMotor(ticksPerRev * 20, 1);
            }else {
                leftEncoder.runMotor(ticksPerRev * 20, 1);
            }
        }
    }


}

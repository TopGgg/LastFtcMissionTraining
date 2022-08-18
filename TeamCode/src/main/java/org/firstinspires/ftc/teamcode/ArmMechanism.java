package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class ArmMechanism {

    private Robot robot;
    private EncoderHelper encoder;
    private static final int ticksPerRev = 288; //for REV core hex motor

    public ArmMechanism(Robot robot){
        this.robot = robot;
        encoder = new EncoderHelper(robot.arm);
    }

    public void controlMechanism(Gamepad gamepad1){
        int turns = 0;
        if(gamepad1.a)
            turns = 5;
        else if(gamepad1.b)
            turns = 10;

        encoder.runMotor(ticksPerRev * turns, 0.7);
        robot.servo.setPosition(1); //assuming that 1 is 90 degrees
    }



}

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

public class DriverRobotControl {

    private DriverRobotControl() {

    }

    private static double getPowerMultiplier(Gamepad gamepad1){
        if(gamepad1.right_bumper){
            return .6;
        }else if(gamepad1.left_bumper){
            return 1.3;
        }else {
            return 1;
        }
    }

    public static void drive(Robot robot, Gamepad gamepad1){
        double y = -gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x * 1.1;
        double rx = gamepad1.right_stick_x;


        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        double powerMultiplier = getPowerMultiplier(gamepad1);

        double frontLeftPower = MathEx.clamp((y + x + rx) / denominator * powerMultiplier, -1, 1);
        double backLeftPower = MathEx.clamp((y - x + rx) / denominator * powerMultiplier, -1, 1);
        double frontRightPower = MathEx.clamp((y - x - rx) / denominator * powerMultiplier, -1, 1);
        double backRightPower = MathEx.clamp((y + x - rx) / denominator * powerMultiplier, -1, 1);


        robot.motors[0].setPower(frontLeftPower);
        robot.motors[1].setPower(frontRightPower);
        robot.motors[2].setPower(backLeftPower);
        robot.motors[3].setPower(backRightPower);
    }

}

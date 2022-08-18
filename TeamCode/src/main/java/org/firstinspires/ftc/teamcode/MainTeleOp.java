package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class MainTeleOp extends LinearOpMode {

    private Robot robot;

    private static MainTeleOp instance;

    private ArmMechanism arm;
    private CarouselMechanism carousel;
    private PotentiometerMechanism potentiometer;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Robot(hardwareMap);

        arm = new ArmMechanism(robot);
        carousel = new CarouselMechanism(robot);
        potentiometer = new PotentiometerMechanism(robot);

        robot.motors[1].setDirection(DcMotorSimple.Direction.REVERSE); //frontRight motor
        robot.motors[3].setDirection(DcMotorSimple.Direction.REVERSE); //backRight motor

        waitForStart();
        while (opModeIsActive()){
            DriverRobotControl.drive(robot, gamepad1);
            arm.controlMechanism(gamepad1);
            carousel.controlMechanism(gamepad1);
            potentiometer.controlMechanism();
        }
    }

    public static MainTeleOp getInstance() {
        return instance;
    }
}

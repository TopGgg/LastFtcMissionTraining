package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Robot {

    public IMU imu;

    public DcMotor[] motors;

    public DcMotor carouselRight;
    public DcMotor carouselLeft;

    public DcMotor arm;
    public Servo servo;

    public Servo servo2;
    public AnalogInput potentiometer;

    public Robot(HardwareMap hardwareMap){
        imu = new IMU(hardwareMap);
        motors = new DcMotor[]{
          hardwareMap.dcMotor.get("frontLeft"),
          hardwareMap.dcMotor.get("frontRight"),
          hardwareMap.dcMotor.get("backLeft"),
          hardwareMap.dcMotor.get("backRight")
        };

        carouselRight = hardwareMap.dcMotor.get("caroRight");
        carouselLeft = hardwareMap.dcMotor.get("caroLeft");

        arm = hardwareMap.dcMotor.get("arm");
        servo = hardwareMap.servo.get("servo");

        servo2 = hardwareMap.servo.get("servo2");
        potentiometer = hardwareMap.analogInput.get("potentio");
    }


}

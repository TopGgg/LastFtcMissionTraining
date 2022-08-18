package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.Range;

public class PotentiometerMechanism {

    private Robot robot;

    public PotentiometerMechanism(Robot robot){
        this.robot = robot;
    }

    public void controlMechanism(){
        robot.servo2.setPosition(Range.scale(robot.potentiometer.getVoltage(), 0,3.3, 0,1));
    }

}

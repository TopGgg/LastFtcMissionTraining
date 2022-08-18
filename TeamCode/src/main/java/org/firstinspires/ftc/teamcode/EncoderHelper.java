package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class EncoderHelper {

    private DcMotor motor;

    public EncoderHelper(DcMotor motor){
        this.motor = motor;
    }


    public void resetMotor(){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPosition(int ticks){
        motor.setTargetPosition(ticks);
    }

    public void runToPosition(){
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void powerMotor(double power){
        motor.setPower(power);
    }

    public void waitForMotor(){
        while(motor.isBusy()){
            MainTeleOp.getInstance().idle();
        }
    }

    public void stopMotor(){
        motor.setPower(0);
    }

    public void runMotor(int ticks, double power){
        resetMotor();
        setTargetPosition(ticks);
        runToPosition();
        powerMotor(power);
        waitForMotor();
        stopMotor();
    }

}


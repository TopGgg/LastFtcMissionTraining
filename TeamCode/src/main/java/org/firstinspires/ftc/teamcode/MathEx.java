package org.firstinspires.ftc.teamcode;

public class MathEx {

    private MathEx(){

    }

    public static double clamp(double val, double min, double max) {
        return Math.max(min, Math.min(max, val));
    }

}

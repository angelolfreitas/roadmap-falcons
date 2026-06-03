package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class Chassi{

        DcMotorEx leftFront;
        DcMotorEx leftBack;
        DcMotorEx rightFront;
        DcMotorEx rightBack;
        IMU imu;


    public Chassi(HardwareMap hardwareMap) {

        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightBack  = hardwareMap.get(DcMotorEx.class, "rightBack");
        leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");

        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        imu = hardwareMap.get(IMU.class,"imu");
        RevHubOrientationOnRobot.LogoFacingDirection logo = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        RevHubOrientationOnRobot.UsbFacingDirection usb = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientation = new RevHubOrientationOnRobot(logo,usb);
        IMU.Parameters parametros = new IMU.Parameters(orientation);
        imu.initialize(parametros);
        imu.resetYaw();

    }
    public void andar(double frente, double giro,double lado){

        leftFront.setPower(frente + giro + lado);
        leftBack.setPower(frente + giro -lado);
        rightFront.setPower(frente -giro -lado);
        rightBack.setPower(frente -giro +lado);
    }
    public void andarFieldOriented(double frente, double giro,double lado){
        double angleRad = Math.toRadians(-getAngle());
        double x = frente * Math.cos(angleRad) - lado * Math.sin(angleRad);
        double y = frente * Math.sin(angleRad) + lado * Math.cos(angleRad);

        andar(y, giro, x);
    }
    double getAngle(){
        return imu.getRobotYawPitchRollAngles().getYaw();
    }

    public double getLateral(){

        return leftBack.getCurrentPosition();
    }
    public double getFrontal(){

        return leftFront.getCurrentPosition();

    }
}

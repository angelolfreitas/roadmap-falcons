package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "autonomos")
public class autonomo extends LinearOpMode {

    ElapsedTime Tempo = new ElapsedTime();
    DcMotorEx leftFront;
    DcMotorEx rightFront;
    DcMotorEx rightBack;
    DcMotorEx leftBack;

    double frente;
    double giro;
    double lado;

    @Override
    public void runOpMode() throws InterruptedException {

        leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        rightBack  = hardwareMap.get(DcMotorEx.class, "rightBack");
        leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");

        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        if (opModeIsActive()){

            frente (2,-0.3);
            lado (1,-0.7);
            frente (1.5, -0.7);
            lado (1,0.5);
            frente (1, 0.8);

            leftFront.setPower(0);
            leftBack.setPower(0);
            rightFront.setPower(0);
            rightBack.setPower(0);
        }

    }
        void frente(double tempo, double frente){
        Tempo.reset();
        while (tempo > Tempo.seconds()) {

            leftFront.setPower(frente);
            leftBack.setPower(frente);
            rightFront.setPower(frente);
            rightBack.setPower(frente);
        }


    }
        void lado (double tempo, double lado){
        Tempo.reset();
        while (tempo > Tempo.seconds()) {

            leftFront.setPower(+ lado);
            leftBack.setPower(- lado);
            rightFront.setPower(- lado);
            rightBack.setPower(+ lado);
        }

    }
}

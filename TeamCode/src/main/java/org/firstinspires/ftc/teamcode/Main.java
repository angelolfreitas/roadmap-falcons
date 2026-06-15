package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "teleop")
public class Main extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotorEx leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
        DcMotorEx rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");
        DcMotorEx rightBack = hardwareMap.get(DcMotorEx.class, "rightBack");
        DcMotorEx leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");
        DcMotorEx intake = hardwareMap.get(DcMotorEx.class,"intake");

        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        double frente=0;
        double giro=0;
        double lado=0;
        double power =0;
        boolean intakeLigado = false;
        boolean rbAnterior = false;
        boolean lbAnterior = false;

        double velocidadeIntake = 0;

        while (opModeIsActive()){

            if(gamepad1.y){
                power = 0.3;
            }else if(gamepad1.a){
                power = -0.3;
            }else{
                power = 0.0;
            }
            if(gamepad1.right_bumper && !rbAnterior){
                intakeLigado = !intakeLigado;
                velocidadeIntake = 0.5;
            }

            if(gamepad1.left_bumper && !lbAnterior){
                intakeLigado = !intakeLigado;
                velocidadeIntake = -0.5;
            }

            rbAnterior = gamepad1.right_bumper;
            lbAnterior = gamepad1.left_bumper;

            if(intakeLigado){
                intake.setPower(velocidadeIntake);
            }else{
                intake.setPower(0);
            }

            frente = gamepad1.left_stick_y * 0.5;
            giro = gamepad1.right_stick_x * 0.5;
            lado = - gamepad1.left_stick_x * 0.5;

            leftFront.setPower(frente -giro + lado);
            leftBack.setPower(frente -giro -lado);
            rightFront.setPower(frente +giro -lado);
            rightBack.setPower(frente +giro +lado);
        }
    }
}

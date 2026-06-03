package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "vitoria")
public class Teleop extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Chassi chassi = new Chassi(hardwareMap);
        PID pid = new PID(0.01);
        double alvo = 0;

        waitForStart();
        while (opModeIsActive()){
            if (gamepad1.x){
                alvo = 45;
            }
            else if(gamepad1.b){
                alvo = - 45;
            }
            else if (gamepad1.y){
                alvo = 0;
            }
                double frente = gamepad1.left_stick_y * 0.5;
                double lado = - gamepad1.left_stick_x * 0.5;
                double pID = pid.calculate(alvo, chassi.getAngle());

                chassi.andarFieldOriented(frente, pID , lado);


        }

    }
}

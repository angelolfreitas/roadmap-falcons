package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous

public class autonomo2 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        Chassi chassi = new Chassi(hardwareMap);
        PID pid = new PID(0.00050);

        waitForStart();
        if (opModeIsActive()){
            double alvo = 1000;
            double power;
            power = pid.calculate(alvo,chassi.getFrontal());
            while (Math.abs(pid.getErro())> 30){
                power = pid.calculate(alvo,chassi.getFrontal());
                chassi.andar(power, 0,0);
        }
    }

}
}

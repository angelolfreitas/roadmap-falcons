package org.firstinspires.ftc.teamcode;

public class PID {
    final double Kp;
    double erro;

    public PID(double kp) {
        Kp = kp;

    }
    double calculate(double alvo, double posicaoAtual){
        erro = alvo - posicaoAtual;
        return erro * Kp;
    }
    double getErro(){
        return erro;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ckdprocessing;

/**
 *
 * @author jeferson
 */

public class Processamento {
 double valorTfg;
    String nivelRAC;
    String estagio;
    String risco;
    
    public double TFG(final String sexo, final String etnia, final double creatinina, final int idade) {
        if ("masculino".equals(sexo) && "negro".equals(etnia)) {
            this.valorTfg = 163.0 * Math.pow(creatinina / 0.9, -0.411) * Math.pow(0.993, idade);
        }
        else if ("masculino".equals(sexo) && "branco".equals(etnia)) {
            this.valorTfg = 141.0 * Math.pow(creatinina / 0.9, -0.411) * Math.pow(0.993, idade);
        }
        else if ("feminino".equals(sexo) && "negro".equals(etnia)) {
            this.valorTfg = 166.0 * Math.pow(creatinina / 0.7, -0.329) * Math.pow(0.993, idade);
        }
        else if ("feminino".equals(sexo) && "branco".equals(etnia)) {
            this.valorTfg = 144.0 * Math.pow(creatinina / 0.7, -1.209) * Math.pow(0.993, idade);
        }
        return this.valorTfg;
    }
    
    public String RAC(final double valorRAC) {
        if (valorRAC == 30.0) {
            this.nivelRAC = "A1";
        }
        else if (valorRAC > 30.0 && valorRAC <= 300.0) {
            this.nivelRAC = "A2";
        }
        else if (valorRAC > 300.0) {
            this.nivelRAC = "A3";
        }
        return this.nivelRAC;
    }
    
    public String Estadiamento(final String rac, final double tfgEst) {
        if (tfgEst >= 90.0 && ("a1".equals(rac) || "a2".equals(rac) || "a3".equals(rac))) {
            this.estagio = "1";
        }
        else if (tfgEst >= 60.0 && tfgEst <= 89.0 && ("a1".equals(rac) || "a2".equals(rac) || "a3".equals(rac))) {
            this.estagio = "2";
        }
        else if (tfgEst >= 45.0 && tfgEst <= 59.0 && ("a1".equals(rac) || "a2".equals(rac) || "a3".equals(rac))) {
            this.estagio = "3A";
        }
        else if (tfgEst >= 30.0 && tfgEst <= 44.0 && ("a1".equals(rac) || "a2".equals(rac) || "a3".equals(rac))) {
            this.estagio = "3B";
        }
        else if (tfgEst >= 15.0 && tfgEst <= 29.0 && ("a1".equals(rac) || "a2".equals(rac) || "a3".equals(rac))) {
            this.estagio = "4";
        }
        else if (tfgEst < 59.0 && ("a1".equals(rac) || "a2".equals(rac) || "a3".equals(rac))) {
            this.estagio = "5";
        }
        else {
            this.estagio = "Erro";
        }
        return this.estagio;
    }
    
    public String GrupoRisco(final String racRisco, final double tfgRisco) {
        if (tfgRisco >= 90.0 && "a3".equals(racRisco)) {
            this.risco = "Alto Risco";
        }
        else if (tfgRisco >= 60.0 && tfgRisco <= 89.0 && "a3".equals(racRisco)) {
            this.risco = "Alto Risco";
        }
        else if (tfgRisco >= 45.0 && tfgRisco <= 59.0 && "a2".equals(racRisco)) {
            this.risco = "Alto Risco";
        }
        else if (tfgRisco >= 30.0 && tfgRisco <= 44.0 && "a1".equals(racRisco)) {
            this.risco = "Alto Risco";
        }
        else if (tfgRisco >= 90.0 && "a1".equals(racRisco)) {
            this.risco = "Baixo Risco";
        }
        else if (tfgRisco >= 60.0 && tfgRisco <= 89.0 && "a1".equals(racRisco)) {
            this.risco = "Baixo Risco";
        }
        else if (tfgRisco >= 45.0 && tfgRisco <= 59.0 && "a1".equals(racRisco)) {
            this.risco = "Moderamente Alto";
        }
        else if (((tfgRisco >= 60.0 && tfgRisco <= 89.0) || tfgRisco >= 90.0) && "a2".equals(racRisco)) {
            this.risco = "Moderamente Alto";
        }
        else if (((tfgRisco >= 15.0 && tfgRisco <= 29.0) || tfgRisco < 59.0) && "a2".equals(racRisco)) {
            this.risco = "Muito Alto";
        }
        else if (((tfgRisco >= 30.0 && tfgRisco <= 44.0) || (tfgRisco >= 15.0 && tfgRisco <= 29.0) || tfgRisco < 59.0) && "a2".equals(racRisco)) {
            this.risco = "Muito Alto";
        }
        else if (((tfgRisco >= 45.0 && tfgRisco <= 59.0) || (tfgRisco >= 30.0 && tfgRisco <= 44.0) || (tfgRisco >= 15.0 && tfgRisco <= 29.0) || tfgRisco < 59.0) && "a3".equals(racRisco)) {
            this.risco = "Muito Alto";
        }
        return this.risco;
    }
}

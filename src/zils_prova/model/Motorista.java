/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zils_prova.model;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class Motorista extends Pessoa {

    private Funcionario funcionario;
    private int nr_cnh;
    private Date dt_vencimento;

    public Motorista() {
    }

    public Motorista(Funcionario funcionario, int nr_cnh, Date dt_vencimento) {
        this.funcionario = funcionario;
        this.nr_cnh = nr_cnh;
        this.dt_vencimento = dt_vencimento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getNr_cnh() {
        return nr_cnh;
    }

    public void setNr_cnh(int nr_cnh) {
        this.nr_cnh = nr_cnh;
    }

    public Date getDt_vencimento() {
        return dt_vencimento;
    }

    public void setDt_vencimento(Date dt_vencimento) {
        this.dt_vencimento = dt_vencimento;
    }

    @Override
    public String toString() {
        return funcionario + " - " + nr_cnh;
    }

}

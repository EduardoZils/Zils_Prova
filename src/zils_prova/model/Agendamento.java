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
public class Agendamento {

    private int cd_agendamento;
    private int cd_veiculo;
    private String ds_origem;
    private String ds_destino;
    private int cd_motorista;
    private int cd_funcionario;
    private Date dt_saida;
    private Date dt_retorno;
    private int nr_passageiros;
    private String ds_observacao;
    private Veiculo veiculo;
    private Motorista motorista;

    public Agendamento(int cd_agendamento, int cd_veiculo, String ds_origem, String ds_destino, int cd_motorista, int cd_funcionario, Date dt_saida, Date dt_retorno, int nr_passageiros, String ds_observacao, Veiculo veiculo, Motorista motorista) {
        this.cd_agendamento = cd_agendamento;
        this.cd_veiculo = cd_veiculo;
        this.ds_origem = ds_origem;
        this.ds_destino = ds_destino;
        this.cd_motorista = cd_motorista;
        this.cd_funcionario = cd_funcionario;
        this.dt_saida = dt_saida;
        this.dt_retorno = dt_retorno;
        this.nr_passageiros = nr_passageiros;
        this.ds_observacao = ds_observacao;
        this.veiculo = veiculo;
        this.motorista = motorista;
    }

    public Agendamento() {
    }

    public int getCd_agendamento() {
        return cd_agendamento;
    }

    public void setCd_agendamento(int cd_agendamento) {
        this.cd_agendamento = cd_agendamento;
    }

    public int getCd_veiculo() {
        return cd_veiculo;
    }

    public void setCd_veiculo(int cd_veiculo) {
        this.cd_veiculo = cd_veiculo;
    }

    public String getDs_origem() {
        return ds_origem;
    }

    public void setDs_origem(String ds_origem) {
        this.ds_origem = ds_origem;
    }

    public String getDs_destino() {
        return ds_destino;
    }

    public void setDs_destino(String ds_destino) {
        this.ds_destino = ds_destino;
    }

    public int getCd_motorista() {
        return cd_motorista;
    }

    public void setCd_motorista(int cd_motorista) {
        this.cd_motorista = cd_motorista;
    }

    public int getCd_funcionario() {
        return cd_funcionario;
    }

    public void setCd_funcionario(int cd_funcionario) {
        this.cd_funcionario = cd_funcionario;
    }

    public Date getDt_saida() {
        return dt_saida;
    }

    public void setDt_saida(Date dt_saida) {
        this.dt_saida = dt_saida;
    }

    public Date getDt_retorno() {
        return dt_retorno;
    }

    public void setDt_retorno(Date dt_retorno) {
        this.dt_retorno = dt_retorno;
    }

    public int getNr_passageiros() {
        return nr_passageiros;
    }

    public void setNr_passageiros(int nr_passageiros) {
        this.nr_passageiros = nr_passageiros;
    }

    public String getDs_observacao() {
        return ds_observacao;
    }

    public void setDs_observacao(String ds_observacao) {
        this.ds_observacao = ds_observacao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    
    @Override
    public String toString() {
        return "Agendamento{" + "cd_agendamento=" + cd_agendamento + ", cd_veiculo=" + cd_veiculo + ", ds_origem=" + ds_origem + ", ds_destino=" + ds_destino + ", cd_motorista=" + cd_motorista + ", cd_funcionario=" + cd_funcionario + ", dt_saida=" + dt_saida + ", dt_retorno=" + dt_retorno + ", nr_passageiros=" + nr_passageiros + ", ds_observacao=" + ds_observacao + '}';
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zils_prova.model;

/**
 *
 * @author eduar
 */
public class Veiculo {
    private int codigo;
    private String nr_placa;
    private int nr_ano;
    private int nr_passageiros;

    public Veiculo() {
    }

    public Veiculo(int codigo, String nr_placa, int nr_ano, int nr_passageiros) {
        this.codigo = codigo;
        this.nr_placa = nr_placa;
        this.nr_ano = nr_ano;
        this.nr_passageiros = nr_passageiros;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNr_placa() {
        return nr_placa;
    }

    public void setNr_placa(String nr_placa) {
        this.nr_placa = nr_placa;
    }

    public int getNr_ano() {
        return nr_ano;
    }

    public void setNr_ano(int nr_ano) {
        this.nr_ano = nr_ano;
    }

    public int getNr_passageiros() {
        return nr_passageiros;
    }

    public void setNr_passageiros(int nr_passageiros) {
        this.nr_passageiros = nr_passageiros;
    }

    @Override
    public String toString() {
        return codigo + " - " + nr_placa + " " + nr_ano + " - Capacidade#" + nr_passageiros;
    }
    
    
}

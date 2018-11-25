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
public class Funcionario extends Pessoa{

    public String nm_funcionario;
    public int nr_matricula;

    public Funcionario(String nm_funcionario, int nr_matricula) {
        this.nm_funcionario = nm_funcionario;
        this.nr_matricula = nr_matricula;
    }

    public Funcionario() {
    }

    public String getNm_funcionario() {
        return nm_funcionario;
    }

    public void setNm_funcionario(String nm_funcionario) {
        this.nm_funcionario = nm_funcionario;
    }

    public int getNr_matricula() {
        return nr_matricula;
    }

    public void setNr_matricula(int nr_matricula) {
        this.nr_matricula = nr_matricula;
    }

    @Override
    public String toString() {
        return nm_funcionario + " - " + nr_matricula ;
    }

    
    
    
}

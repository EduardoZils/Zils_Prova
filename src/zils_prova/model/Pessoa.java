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
public abstract class Pessoa {

    private int codigo;

    public int getCodigo()
    {
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    @Override
    public String toString(){
        return String.valueOf(codigo);
    }
}

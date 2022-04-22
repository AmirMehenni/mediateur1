/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediateur;

/**
 *
 * @author enpei
 */
public class Employe {
    private table NomEmp;
    private table salaire;
    private table NumDeprt;
    public Employe(){
        NomEmp = new table();
        salaire = new table();
        NumDeprt = new table();
    }
    public table getNomEmp(){
        return NomEmp;
    }
    public void setNomEmp(table NomEmp){
        this.NomEmp = NomEmp;
    }
    public table getSalaire(){
        return salaire;
    }
    public void setSalaire(table salaire){
        this.salaire = salaire;
    }
    public table getNumDeprt(){
        return NumDeprt;
    }
    public void setNumDeprt(table NumDeprt){
        this.NumDeprt = NumDeprt;
    }
}

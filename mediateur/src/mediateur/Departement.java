/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediateur;

/**
 *
 * @author enpei
 */
public class Departement {
    private table NumDept ;
    private table NomDept;
    private table Budget;
    public Departement(){
        NumDept = new table();
        NumDept.setName("NumDept");
        NomDept = new table();
        NomDept.setName("NomDept");
        Budget = new table();
        Budget.setName("Budget");
    }
    public table getNumDept(){
        return NumDept;
    }
    public table getNomDept(){
        return NomDept;
    }
    public table getBudget(){
        return Budget;
    }
    public void setNumDept(table NumDept){
        this.NomDept = NumDept;
    }
    public void setNomDept(table NomDept){
        this.NomDept = NomDept;
    }
    public void setBudget(table Budget){
        this.Budget = Budget;
    }
}

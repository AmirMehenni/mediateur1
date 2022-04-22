/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediateur;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 *
 * @author enpei
 */
public class Query {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private Employe employe;
    private Departement dept;
    private String query = "";
    private inter view;

    public Query(Employe employe, Departement Dept, inter inter) throws ClassNotFoundException, SQLException {
        this.employe = employe;
        this.dept = Dept;
        this.view = inter;
        this.query = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/g?" + "user=root&password=");
        stmt = (Statement) conn.createStatement();

    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String q) {
        this.query = q;
    }

    public String ExplorerResultat(ResultSet rs) throws SQLException {
        String resultat = "";
        if (rs != null) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                resultat += rs.getMetaData().getColumnName(i) + " ||";

            }
            resultat += "\n";
            resultat += "------------------------------------------------------------------------------";
            resultat += "\n";
            int k = 0;
            while (rs.next()) {
                k++;
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    resultat += " ||" + rs.getObject(i);

                }
                resultat += "\n";
            }
            if (k == 0)
                resultat += "pas de resultat";
            return resultat;
        }
        return "resultat vide";
    }

    public String get_ligne_Selected(Object obj) throws IllegalArgumentException, IllegalAccessException {
        String ligne_selected = "";
        Field[] field = obj.getClass().getDeclaredFields();

        for (Field f : field) {

            f.setAccessible(true);
            table tf = new table();
            tf = (table) f.get(obj);

            if (tf.isSelected()) {
                ligne_selected = ligne_selected + tf.getName() + ",";

            }

        }

        if (!ligne_selected.equals(""))
            ligne_selected = ligne_selected.substring(0, ligne_selected.length() - 1);

        return ligne_selected;
    }

    public String get_Cond_Emp(Employe e) {
        ArrayList<String> condition = new ArrayList<String>();
        String condition_empl = "";
        if (!view.getjTextField_NomEmp().equals(""))
            condition.add("NomEMP" + view.getjComboBox_NomEMp() + "'" + view.getjTextField_NomEmp() + "'");
        if (!view.getjTextField_Salaire().equals(""))
            condition.add("Salaire" + view.getjComboBox_Salaire() + view.getjTextField_Salaire());
        if (!view.getjText_NumDeprt().equals(""))
            condition.add("NumDept" + view.getjComboBox_NumDeprt() + "'" + view.getjText_NumDeprt() + "'");

        for (int i = 0; i < condition.size(); i++) {
            condition_empl += "  " + condition.get(i) + " ";

            condition_empl += "and";

        }
        if (!condition_empl.equals("")) {
            condition_empl = "Where" + condition_empl.substring(0, condition_empl.length() - 3);

        }

        return condition_empl;
    }

    public String Get_Cond_Dep(Departement dep) {
        ArrayList<String> condition = new ArrayList<String>();
        String condition_dep = "";
        if (!view.getjText_NumDept().equals(""))
            condition.add("NumDept" + view.getjComoBox_NumDept() + "'" + view.getjText_NumDept() + "'");
        if (!view.getjTextField_NomDept().equals(""))
            condition.add("NomDept" + view.getjComboBox_NomDept() + "'" + view.getjTextField_NomDept() + "'");
        if (!view.getjTextField_Budget().equals(""))
            condition.add("Budget" + view.getjComboBox_Budget() + "'" + view.getjTextField_Budget() + "'");

        for (int i = 0; i < condition.size(); i++) {
            condition_dep += "  " + condition.get(i) + " ";
            condition_dep += "and";
        }
        if (!condition_dep.equals(""))
            return condition_dep = "Where" + condition_dep.substring(0, condition_dep.length() - 3);

        return condition_dep;
    }

    public ResultSet Excute_Query(String Req) throws SQLException, SQLException, SQLException {

        if (!Req.equals("")) {
            ResultSet rs2 = stmt.executeQuery(Req);
            return rs2;
        }
        return null;
    }

    public String prepare_Query() throws IllegalArgumentException, IllegalAccessException {
        this.query = "";
        // *****
        // employe
        if (view.getOrder() == false) {
            if (this.dept == null && this.employe != null && !this.get_ligne_Selected(this.employe).equals("")) {

                query += "select    " + this.get_ligne_Selected(this.employe) + "\n from employe\n"
                        + this.get_Cond_Emp(employe);
                return query;
            }
            // departement

            if (this.dept != null && this.employe == null && !this.get_ligne_Selected(this.dept).equals("")) {

                query += "select " + this.get_ligne_Selected(this.dept) +
                        "\n from département \n" + this.Get_Cond_Dep(dept);
                return query;
            }

            // ***

            if (this.dept != null && this.employe != null &&
                    !this.get_ligne_Selected(this.dept).equals("")
                    && !this.get_ligne_Selected(this.employe).equals("")) {
                String d = this.Get_Cond_Dep(dept).substring(5, this.Get_Cond_Dep(dept).length());
                query += "select " + this.get_ligne_Selected(this.dept) + " , " + this.get_ligne_Selected(this.employe)
                        +
                        "\nfrom département,employe\n"
                        + this.get_Cond_Emp(employe)
                        + "\nand"
                        + d + "\n group by " + this.get_ligne_Selected(this.employe) + ","
                        + this.get_ligne_Selected(this.dept);

                return query;
            }
            return query;

        } else {
            if (this.dept == null && this.employe != null && !this.get_ligne_Selected(this.employe).equals("")) {

                query += "select    " + this.get_ligne_Selected(this.employe) + "\n from employe\n"
                        + this.get_Cond_Emp(employe)
                        + "\n order by " + this.get_ligne_Selected(this.employe);

                return query;
            }
            return query;
        }
    }

}
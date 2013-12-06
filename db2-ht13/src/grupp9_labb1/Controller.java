/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp9_labb1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author svalan
 */
public class Controller {

    Connection con;

    public Controller(Connection con) {

        this.con = con;
    }

    public String getFirstLetter() {



        return "not implemented";

    }

    public String getIncreasedWage() {

        return "not implemented";

    }

    public String getInsomnia() throws SQLException {

        ResultSet rs = this.getResultSet("SELECT p.ppnr, p.pname FROM Patient p\n"
                + "JOIN Lider l ON p.ppnr = l.ppnr\n"
                + "WHERE l.sname = 'Insomnia'");

        String resultString = this.getResultString(rs);


        return resultString;

    }

    public String getInsomniaHosta() {

        return "not implemented";

    }

    public String getNameDisease() {

        return "not implemented";

    }

    public String getNoCar() {

        return "not implemented";

    }

    public String getNoOwner() {

        return "not implemented";

    }

    public String getTotalWages() {

        return "not implemented";

    }

    private ResultSet getResultSet(String stmtString) throws SQLException {

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(stmtString);



        return rs;


    }

    private String getResultString(ResultSet rs) throws SQLException {



        ResultSetMetaData md = rs.getMetaData();

        int colCount = md.getColumnCount();

        System.out.println("Column count: " + colCount);

        String resultString = "";


        while (rs.next()) {

            for (int i = 1; i <= colCount; i++) {

                String toAdd = rs.getString(i);

                resultString += toAdd;
                
                resultString += " \n";
            }

            

        }

        return resultString;


    }
}

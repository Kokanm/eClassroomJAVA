/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faza4.zrna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Kokanm
 */
@ManagedBean
@SessionScoped
public class Conn {

    private String db_server="";
    private String db_user="";
    private String db_password="";
    private String db_driver="";
    private Connection con;
    
    public Connection getConn(){
    FacesContext fc = FacesContext.getCurrentInstance();
        db_server   = fc.getExternalContext().getInitParameter("DB-SERVER");
        db_user     = fc.getExternalContext().getInitParameter("DB-USER");
        db_password = fc.getExternalContext().getInitParameter("DB-PASSWORD");
        db_driver   = fc.getExternalContext().getInitParameter("JDBC-DRIVER");
        try{
            Class.forName(db_driver);
        }catch (ClassNotFoundException e){
            System.out.println("Class exception");
        }
        if (this.con== null){
            System.out.println("Connecting");
            try{
                this.con = DriverManager.getConnection(db_server,db_user, db_password);
                this.con.setAutoCommit(false);
            }catch (SQLException e){
                System.out.println("Cannot connect");
            }            
        }
        return con;
    }
}

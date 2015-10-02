/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faza4.zrna;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class TodoBean {

    private String db_server="";
    private String db_user="";
    private String db_password="";
    private String db_driver="";
    private Connection con;
    
    public int idTodo;    
    public String username;    
    public String task;    
    
    public int getIdTodo(){
    	return idTodo;
    }
    
    public void setIdTodo(int idTodo){
    	this.idTodo = idTodo;
    }
    
     public String getTask(){
    	return task;
    }
    
    public void setTask(String task){
    	this.task = task;
    }
    
    public String getUsername(){
    	return username;
    }
    
    public void setUsername(String username){
    	this.username = username;
    }
    
    
    
    public TodoBean(){
        FacesContext fc = FacesContext.getCurrentInstance();
        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String db = System.getenv("OPENSHIFT_GEAR_NAME");
        db_server   = String.format("jdbc:mysql://%s:%s/%s", host, port, db);
        db_user     = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        db_password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
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
    }
   
   public List<TodoBean> getTasks() throws SQLException{
        List<TodoBean> list = new ArrayList<>();
        if (con==null)
            throw new SQLException("Can't get DB connection");

        PreparedStatement ps = con.prepareStatement("select * from Todo");
        
        ResultSet rs = ps.executeQuery();        

        while (rs.next()){
            TodoBean tb = new TodoBean();
            tb.setIdTodo(rs.getInt("idTodo"));
            tb.setUsername(rs.getString("username"));
            tb.setTask(rs.getString("task"));
            list.add(tb);
        }
        return list;
    }
   
   
    public void save() throws SQLException{        
        if (con==null)
            throw new SQLException("Can't get DB connection");        
        try{
            String sqlInsert="insert into Todo(task) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            ps.setString(1, task);
            ps.executeUpdate();
            con.commit();
        }catch (Exception e){
            throw new SQLException(e);
        }
    }
    
    public void deleteAll() throws SQLException{
        String sqlInsert="DELETE from Todo";
        String sqlInsert2= "ALTER TABLE Todo auto_increment = 1";
        if (con==null)
            throw new SQLException("Can't get DB connection");
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        ps.executeUpdate(sqlInsert);
        ps.executeUpdate(sqlInsert2);
        con.commit();
    }
    
}

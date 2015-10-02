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
 
@ManagedBean(name="userBean")
@SessionScoped
public class UsersBean{
 
    private String db_server="";
    private String db_user="";
    private String db_password="";
    private String db_driver="";
    private Connection con;
    
    public int idUser;
    public String username;
    public String firstname;
    public String lastname;
    public String password;
    public String email;
    public String city;
    public String country;
    public String telephone;
    public String birthday;
    public boolean logged;
    
    public int getIdUser(){
    	return idUser;
    }
    
    public void setIdUser(int idUser){
    	this.idUser = idUser;
    }
    
    public String getUsername(){
    	return username;
    }
    
    public void setUsername(String username){
    	this.username = username;
    }
    
    public String getFirstname(){
    	return firstname;
    }
    
    public void setFirstname(String firstname){
    	this.firstname = firstname;
    }
    
    public String getLastname(){
    	return lastname;
    }
    
    public void setLastname(String lastname){
    	this.lastname = lastname;
    }
    
    public String getPassword(){
    	return password;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }

    public String getEmail(){
    	return email;
    }
    
    public void setEmail(String email){
    	this.email = email;
    }
    
    public String getCity(){
    	return city;
    }
    
    public void setCity(String city){
    	this.city = city;
    }
    
    public String getCountry(){
    	return country;
    }
    
    public void setCountry(String country){
    	this.country = country;
    }
    
    public String getTelephone(){
    	return telephone;
    }
    
    public void setTelephone(String telephone){
    	this.telephone = telephone;
    }
    
    public String getBirthday(){
    	return birthday;
    }
    
    public void setBirthday(String birthday){
    	this.birthday = birthday;
    }
    
    public boolean getLogged(){
        return logged;
    }
    
    public void setLogged(boolean logged){
        this.logged = logged;
    }
    

    public UsersBean(){
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
    
    public Users getUser(String uName) throws SQLException{
        if (con==null)
            throw new SQLException("Can't get DB connection");
        Users ent = new Users();

        PreparedStatement ps = con.prepareStatement("select * from User where username = ?");
        ps.setString(1, uName);
        ResultSet rs = ps.executeQuery();
        
        
        if(rs.next()){
            ent.setIdUser(rs.getInt("idUser"));
            ent.setUsername(uName);
            ent.setFirstname((rs.getString("firstname")));
            ent.setLastname(rs.getString("lastname"));
            ent.setPassword(rs.getString("password"));
            ent.setEmail(rs.getString("email"));
            ent.setCity(rs.getString("city"));
            ent.setCountry(rs.getString("country"));
            ent.setTelephone(rs.getString("telephone"));
            ent.setBirthday(rs.getString("birthday"));
        }else{
            System.out.println("Can not find user!");
        }
        return ent;
    }
    
    public void updateProfile() throws SQLException{
        if (con==null)
            throw new SQLException("Can't get DB connection");        
        try{
            String sqlInsert="UPDATE User SET telephone=?, email=?, city=?, country=?, birthday=? WHERE firstname=? AND lastname=?";
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            
            ps.setString(1, telephone);
            ps.setString(2, email);
            ps.setString(3, city);
            ps.setString(4, country);
            ps.setString(5, birthday);
            ps.setString(6, firstname);
            ps.setString(7, lastname);
            
            ps.executeUpdate();
            con.commit();
        }catch (Exception e){
            throw new SQLException(e);
        }
    }
    
    public List<Users> getUsers() throws SQLException{
        List<Users> list = new ArrayList<>();
        if (con==null)
            throw new SQLException("Can't get DB connection");

        PreparedStatement ps = con.prepareStatement("select * from User");
        
        ResultSet rs = ps.executeQuery();        

        while (rs.next()){
            Users us = new Users();
            us.setIdUser(rs.getInt("idUser"));
            us.setUsername(rs.getString("username"));
            us.setLastname(rs.getString("lastname"));
            us.setFirstname(rs.getString("firstname"));
            us.setEmail(rs.getString("email"));
            us.setCity(rs.getString("city"));
            us.setCountry(rs.getString("country"));
            us.setPassword(rs.getString("password"));
            us.setTelephone(rs.getString("telephone"));
            us.setBirthday(rs.getString("birthday"));
            list.add(us);
        }
        return list;
    }
    
    public void save() throws SQLException{        
        if (con==null)
            throw new SQLException("Can't get DB connection");        
        try{
            String sqlInsert="insert into User(username, firstname, lastname, password, email, city, country, telephone, birthday) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sqlInsert);
            
            ps.setString(1, username);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, password);
            ps.setString(5, email);
            ps.setString(6, city);
            ps.setString(7, country);
            ps.setString(8, telephone);
            ps.setString(9, birthday);
            ps.executeUpdate();
            con.commit();
        }catch (Exception e){
            throw new SQLException(e);
        }
    }
    
    public String login() throws SQLException {        

        if (con==null)
            throw new SQLException("Can't get DB connection");

        PreparedStatement ps = con.prepareStatement("SELECT * from User WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        
        if (!rs.next()) {
           return "<p style=\"color: red;\">You have enter a wrong username or password!</p>";
        }else{
            logged = true;
            setFirstname(rs.getString("firstname"));
            setLastname(rs.getString("lastname"));
            setTelephone(rs.getString("telephone"));
            setBirthday(rs.getString("birthday"));
            setEmail(rs.getString("email"));
            setCity(rs.getString("city"));
            setCountry(rs.getString("country"));
            return "";
        }
    }

    public void logout() {
        logged = false;
    }

    public boolean isLoggedIn() {
       return logged;
    }
    
    public void delete(String uName) throws SQLException{
        String sqlInsert="DELETE from User where username=?";
        if (con==null)
            throw new SQLException("Can't get DB connection");
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        ps.setString(1, uName);
        ps.executeUpdate(sqlInsert);
        con.commit();
    }   
    
    public void deleteAll() throws SQLException{
        String sqlInsert="DELETE from User";
        if (con==null)
            throw new SQLException("Can't get DB connection");
        PreparedStatement ps = con.prepareStatement(sqlInsert);
        ps.executeUpdate(sqlInsert);
        con.commit();
    }
   
}
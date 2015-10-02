/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faza4.zrna;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kokanm
 */
@ManagedBean(name="counter")
@SessionScoped
public class Counter {
    
    public int count = 1;
    
    public int getCount(){
    	return count;
    }
    
    public void setCount(int count){
    	this.count = count;
    }
    
    public void up(){
        setCount(getCount()+1);
    }
    
    public void down(){
        setCount(getCount()-1);
    }
}

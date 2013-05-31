package br.com.tc.bean;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@Named
@SessionScoped
public class PushBean implements Serializable{

	public PushBean() {
    }
    private int count;
 
    public int getCount() {
        return count;
    }
 
    public void setCount(int count) {
        this.count = count;
    }
 
    public synchronized void increment() {
        count++;
        PushContext pushContext = PushContextFactory.getDefault().getPushContext();
        pushContext.push("/counter", null);
    }
}

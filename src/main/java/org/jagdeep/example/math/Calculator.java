package org.jagdeep.example.math;

public class Calculator 
{
    private int a,b;
    private int sum;
    
    public void setNumber(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    public int doAddition() {
    	sum = a + b;
    	return sum;
    }
}

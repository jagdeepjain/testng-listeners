package org.jagdeep.example;

import org.jagdeep.example.math.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AdditionTest {
	
	Calculator calculator;
		
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		calculator = new Calculator();
	}

	@BeforeMethod(alwaysRun=true)
	public void startTest() {
		calculator = new Calculator();
	}
    
    @Test
    public void additionTest1() {
    	int a = 1, b = 2;
    	int expectedSum = 2;
    	int actualSum = 0;
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	calculator.setNumber(a, b);
    	actualSum = calculator.doAddition();
    	Assert.assertEquals(expectedSum, actualSum);
     }
    
    @Test
    public void additionTest2() {
    	int a = 1, b = 2;
    	int expectedSum = 3;
    	int actualSum = 0;
    	calculator.setNumber(a, b);
    	actualSum = calculator.doAddition();
    	Assert.assertEquals(expectedSum, actualSum);
    }
    
    @Test
    public void additionTest3() {
    	int a = 1, b = 2;
    	int expectedSum = 2;
    	int actualSum = 0;
    	calculator.setNumber(a, b);
    	actualSum = calculator.doAddition();
    	Assert.assertEquals(expectedSum, actualSum);
     }
    
    @AfterMethod(alwaysRun=true)
    public void testEnd() {
    	calculator = null;
    }
    
    @AfterClass(alwaysRun=true)
    public void tearDown() {
    	calculator = null;
    }
   
}

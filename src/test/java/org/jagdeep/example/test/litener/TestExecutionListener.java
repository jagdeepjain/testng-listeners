package org.jagdeep.example.test.litener;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestExecutionListener extends TestListenerAdapter {

	private int m_count = 0;
	
	@Override
	public void onStart(ITestContext testContext) {
		log("Test Suite execution started...");
		log("");
	}
	
	@Override
	public void onTestStart(ITestResult tr) {
		log("Test Started...");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		String testClassName = trim(tr.getTestClass() + "." + tr.getName());
		log("Test " + testClassName + " passed.");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		String testClassName = trim(tr.getTestClass() + "." + tr.getName());
		log("Test " + testClassName + " failed.");
		logAssertFailure(tr, testClassName);
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		String testClassName = trim(tr.getTestClass() + "." + tr.getName());
		log("Test " + testClassName + " skipped.");
	}

	@Override
	public void onFinish(ITestContext testContext) {
		log("");
		log("Test Suite execution completed...");
		log("");
	}
	
	private void log(String text) {
		System.out.println(text);
		if (++m_count % 40 == 0) {
			System.out.println(".");
		}
	}
	
	private void log(StackTraceElement text) {
		System.out.println(text);
	}
	
	private String trim(String text) {
		String[] allStrings = text.replace("[", "").replace("]", "").split("\\s");
		return allStrings[2];
	}
	private void logAssertFailure(ITestResult tr, String testClassName) {
        log(tr.getThrowable().getMessage());
        int stackTraceSize = tr.getThrowable().getStackTrace().length;
        for (int i = 0; i < stackTraceSize; i ++) {
        	log(tr.getThrowable().getStackTrace()[i]);
        	if (tr.getThrowable().getStackTrace()[i].toString().contains(testClassName)) {
        		break;
        	}
        }
	}

}

package Selenium_Framework_TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNG_listeners implements ITestListener {
    /*
    The intefrace: ITestListener - testng interface that implements listeners
    scenarios such as:
    - for every fail case - take a screenshot
    - execute a block of acton when there's a satisfying condition
     */

        @Override
        public void onTestStart(ITestResult result) {
        }
        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("Test successes");
        }
        @Override
        public void onTestFailure(ITestResult result) {
            //screenshot method
            //response if API fails
            System.out.println("Test fails, Test Case: " + result.getName());
        }
        @Override
        public void onTestSkipped(ITestResult result) {
        }
        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        }
        @Override
        public void onTestFailedWithTimeout(ITestResult result) {
        }
        @Override
        public void onStart(ITestContext context) {
        }
        @Override
        public void onFinish(ITestContext context) {
        }

    }



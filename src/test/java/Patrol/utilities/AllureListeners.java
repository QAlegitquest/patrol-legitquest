package Patrol.utilities;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListeners implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextMessage(String message) {
		return message;
	}

//	@Override
//	public void onTestSuccess(ITestResult iTR) {
//		System.out.println("i am in onTestSuccess method " + getTestMethodName(iTR));
//	}
	
	@Override
	public void onTestFailure(ITestResult iTR) {
		
	    String methodName = iTR.getMethod().getMethodName();
	    String className = iTR.getTestClass().getName();

	    System.out.println("❌ Test Failed: " + className + " -> " + methodName);

	    WebDriver driver = BaseTest.getDriver();

	    if (driver != null) {
	        File screenshotFile = ScreenShotsUtility.takeScreenshot(driver);

	        if (screenshotFile != null) {
	            List<File> failedScreenshots = Arrays.asList(screenshotFile);

	            String subject = "Test Failure: " + className + "." + methodName;
	            String htmlMessage = "<h3 style='color:red;'>Test Failure Detected</h3>"
	                               + "<p><b>Class:</b> " + className + "<br>"
	                               + "<b>Method:</b> " + methodName + "</p>"
	                               + "<p>Please find the attached screenshot for details.</p>";

	            try {
	                EmailUtility.sendFailureScreenshots(subject, htmlMessage, failedScreenshots);
	            } catch (MessagingException e) {
	                e.printStackTrace();
	                System.err.println("Failed to send failure email.");
	            }
	        }
	    }
	}

	
	@Override
	public void onTestSkipped(ITestResult iTR) {
		System.out.println("i am in onTestSkipped method " + getTestMethodName(iTR));
	}
}
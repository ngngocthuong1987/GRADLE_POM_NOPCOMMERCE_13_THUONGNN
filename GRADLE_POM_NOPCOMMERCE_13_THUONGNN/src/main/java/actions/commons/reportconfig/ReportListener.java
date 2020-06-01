package actions.commons.reportconfig;

import actions.commons.AbstractTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportListener extends AbstractTest implements ITestListener {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logReport;

    //This belongs to ITestListener and will execute before starting of Test set/batch
    @Override
    public void onStart(ITestContext arg0) {
        Reporter.log("About to begin executing Test: " + arg0.getName(), true);

        String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());

        htmlReporter = new ExtentHtmlReporter(".\\report\\".concat(date).concat("\\TestReport_").concat(dateTime).concat(".html"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setCSS(".r-img {width: 50%;}");
        htmlReporter.config().setAutoCreateRelativePathMedia(true);

        extent.setSystemInfo("Application Name", "Test Report");
        extent.setSystemInfo("User Name", "Thuong Nguyen Ngoc");
        extent.setSystemInfo("Envirnoment", "Production");
    }

    //This belongs to ITestListener and will execute before the main test start (@Test)
    @Override
    public void onTestStart(ITestResult arg0) {
        Reporter.log("Start @Test: " + arg0.getName(), true);
        String testClassName = "Test class: ".concat(arg0.getTestClass().getRealClass().getSimpleName());
        String testCaseName = "Test case: ".concat(arg0.getMethod().getMethodName());

        //Create report for test case
        logReport = extent.createTest(testClassName.concat("<br>").concat(testCaseName));
    }

    //This belongs to ITestListener and will execute, once the Test set/batch is finished
    @Override
    public void onFinish(ITestContext arg0) {
        Reporter.log("Completed executing Test: " + arg0.getName(), true);

        //Flush report
        extent.flush();
    }

    //This belongs to ITestListener and will execute only when the test is pass
    @Override
    public void onTestSuccess(ITestResult arg0) {
        //This is calling the printTestResults method
        printTestResults(arg0);
    }

    //This belongs to ITestListener and will execute only on the event of fail test
    @Override
    public void onTestFailure(ITestResult arg0) {
        //This is calling the printTestResults method
        printTestResults(arg0);
    }

    //This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
    @Override
    public void onTestSkipped(ITestResult arg0) {
        printTestResults(arg0);
    }

    //This is just a piece of shit, ignore this
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    //This is the method which will be executed in case of test pass or fail
    //This will provide the information on the test
    private void printTestResults(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((AbstractTest) testClass).getDriver();

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                logReport.log(Status.FAIL, MarkupHelper.createLabel("TEST CASE FAIL: ".concat(result.getName()), ExtentColor.RED));
                logReport.log(Status.FAIL, MarkupHelper.createLabel("ERROR CONTENT: " + result.getThrowable(), ExtentColor.RED));
                logReport.log(Status.FAIL, MarkupHelper.createLabel("SCREENSHOT: ", ExtentColor.RED));
                try {
                    logReport.fail("", MediaEntityBuilder.createScreenCaptureFromPath(captureImage(driver)).build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case ITestResult.SKIP:
                logReport.log(Status.SKIP, MarkupHelper.createLabel("TEST CASE SKIP: ".concat(result.getName()), ExtentColor.ORANGE));
                break;

            case ITestResult.SUCCESS:
                logReport.log(Status.PASS, MarkupHelper.createLabel("TEST CASE PASS: ".concat(result.getName()), ExtentColor.GREEN));
                break;

            default:
                break;
        }
    }

    public String captureImage(WebDriver driver) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        return scrFile.getAbsolutePath();
    }
}

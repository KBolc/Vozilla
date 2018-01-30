package com.gurock.testrail;

import org.json.simple.JSONObject;
import org.testng.*;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Listener extends  TestListenerAdapter  implements ITestListener, ISuiteListener, IInvokedMethodListener   {
    // This belongs to ISuiteListener and will execute before the Suite start
    APIClient client = new APIClient("https://testrail.enigma.com.pl");

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface UseAsTestRailId {
        int testRailId() default 0;
        int testCaseId() default 0;
        String[] tags() default "";
    }

    @Override

    public void onStart(ISuite arg0) {

        Reporter.log("About to begin executing Suite " + arg0.getName(), true);

    }

    // This belongs to ISuiteListener and will execute, once the Suite is finished

    @Override

    public void onFinish(ISuite arg0) {

        Reporter.log("About to end executing Suite " + arg0.getName(), true);

    }

    // This belongs to ITestListener and will execute before starting of Test set/batch

    public void onStart(ITestContext arg0) {

        Reporter.log("About to begin executing Test " + arg0.getName(), true);

    }

    // This belongs to ITestListener and will execute, once the Test set/batch is finished

    public void onFinish(ITestContext arg0) {

        Reporter.log("Completed executing test " + arg0.getName(), true);

    }

    // This belongs to ITestListener and will execute only when the test is pass

    public void onTestSuccess(ITestResult result) {
        client.setUser("kamil.bolc@enigma.com.pl");
        client.setPassword("Kamilowjk123$%");
        String TestID = null;
        String CaseID = null;
        IClass obj = result.getTestClass();
        Class newobj = obj.getRealClass();
        Method testMethod = null;
        try {
            testMethod = newobj.getMethod(result.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (testMethod.isAnnotationPresent(UseAsTestRailId.class)) {
            UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
// Get the TestCase ID for Test Rail
            TestID = Integer.toString(useAsTestName.testRailId());
            CaseID = Integer.toString(useAsTestName.testCaseId());
            System.out.println("Test Rail ID = " + TestID);
            System.out.println("Test Case ID = " + CaseID);
            Map data = new HashMap();
            data.put("status_id", new Integer(1));
            data.put("comment", "This test worked fine!");
            try {
                JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+TestID+"/"+CaseID+"", data);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (APIException e) {
                e.printStackTrace();
            }

        }


    }

    // This belongs to ITestListener and will execute only on the event of fail test

    public void onTestFailure(ITestResult result) {
        client.setUser("kamil.bolc@enigma.com.pl");
        client.setPassword("Kamilowjk123$%");
        String TestID = null;
        String CaseID = null;
        IClass obj = result.getTestClass();
        Class newobj = obj.getRealClass();
        Method testMethod = null;
        try {
            testMethod = newobj.getMethod(result.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (testMethod.isAnnotationPresent(UseAsTestRailId.class)) {
            UseAsTestRailId useAsTestName = testMethod.getAnnotation(UseAsTestRailId.class);
// Get the TestCase ID for Test Rail
            TestID = Integer.toString(useAsTestName.testRailId());
            CaseID = Integer.toString(useAsTestName.testCaseId());
            System.out.println("Test Rail ID = " + TestID);
            System.out.println("Test Case ID = " + CaseID);
            Map data = new HashMap();
            data.put("status_id", new Integer(5));
            data.put("comment",  "Test is Failed!!!");
            try {
                JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+TestID+"/"+CaseID+"", data);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (APIException e) {
                e.printStackTrace();
            }


            printTestResults(result);

        }
    }

    // This belongs to ITestListener and will execute before the main test start (@Test)

    public void onTestStart(ITestResult arg0) {

        System.out.println("The execution of the main test starts now");

    }

    // This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

    public void onTestSkipped(ITestResult arg0) {

        printTestResults(arg0);

    }

    // This is just a piece of shit, ignore this

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    // This is the method which will be executed in case of test pass or fail

    // This will provide the information on the test

    private void printTestResults(ITestResult result) {

        Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

        if (result.getParameters().length != 0) {

            String params = null;

            for (Object parameter : result.getParameters()) {

                params += parameter.toString() + ",";

            }

            Reporter.log("Test Method had the following parameters : " + params, true);

        }

        String status = null;

        switch (result.getStatus()) {

            case ITestResult.SUCCESS:

                status = "Pass";

                break;

            case ITestResult.FAILURE:

                status = "Failed";

                break;

            case ITestResult.SKIP:

                status = "Skipped";

        }

        Reporter.log("Test Status: " + status, true);

    }

    // This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This will return method names to the calling function

    private String returnMethodName(ITestNGMethod method) {

        return method.getRealClass().getSimpleName() + "." + method.getMethodName();

    }
}

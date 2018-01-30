import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import com.gurock.testrail.AnnotationClass;
import com.gurock.testrail.Listener;
import org.json.simple.JSONObject;
import org.testng.IClass;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class TestRailApi {
    APIClient client = new APIClient("https://testrail.enigma.com.pl");

    public void setUpTestRail(String testCaseID, String testRunID) throws IOException, APIException {
        client.setUser("kamil.bolc@enigma.com.pl");
        client.setPassword("Kamilowjk123$%");
        JSONObject c = (JSONObject) client.sendGet("get_case/"+ testCaseID);
        System.out.println(c.get("title"));
        Map data = new HashMap();
        data.put("status_id", new Integer(1));
        data.put("comment", "OMG działa");
        try {
            JSONObject r = (JSONObject) client.sendPost("add_result_for_case/"+testRunID+"/" + testCaseID, data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
    }

    public void getIDCase() throws IOException, APIException {
        APIClient client = new APIClient("https://testrail.enigma.com.pl");
        client.setUser("kamil.bolc@enigma.com.pl");
        client.setPassword("Kamilowjk123$%");
        Map data = new HashMap();

        JSONObject id_case = (JSONObject) client.sendGet("/get_case/206");
        System.out.println(id_case);
        String idSuite = data.get("suite_id").toString();

    }




}


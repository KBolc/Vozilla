import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class testtest {

//
//    public static void main(String[] args) throws Exception {
//        String testCase = "1";
//        APIClient client = new APIClient("https://testrail.enigma.com.pl");
//        client.setUser("kamil.bolc@enigma.com.pl");
//        client.setPassword("Kamilowjk123$%");
//        JSONObject c = (JSONObject) client.sendGet("get_case/" + testCase);
//        System.out.println(c);
//        System.out.println(c.get("title"));
//        Map data = new HashMap();
//        data.put("status_id", new Integer(1));
//        data.put("comment", "This test worked fine!");
//        try {
//            JSONObject r = (JSONObject) client.sendPost("add_result_for_case/11/" + testCase, data);
//            System.out.println(r);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (APIException e) {
//            e.printStackTrace();
//        }
//    }

//        public static void main(String[] args) throws Exception {
//        String testCase = "3";
//        APIClient client = new APIClient("https://testrail.enigma.com.pl");
//        client.setUser("kamil.bolc@enigma.com.pl");
//        client.setPassword("Kamilowjk123$%");
//        JSONObject c = (JSONObject) client.sendGet("get_runs/"+testCase);
//        System.out.println(c);
//    }

    public static void main(String[] args) throws Exception {
        APIClient client = new APIClient("https://testrail.enigma.com.pl");
        client.setUser("kamil.bolc@enigma.com.pl");
        client.setPassword("Kamilowjk123$%");

//        JSONArray id_tests= (JSONArray) client.sendGet("/get_cases/1");
//        System.out.println("cases  "+id_tests);
//
//        JSONObject id_case = (JSONObject) client.sendGet("/get_case/1");
//        System.out.println(id_case);
//
//        Object idSuite = id_case.get("suite_id");
//        System.out.println("SUITE  " + idSuite);
//
//        JSONObject id_suite = (JSONObject) client.sendGet("/get_suite/" + idSuite + "");
//        System.out.println(id_suite);
//
//        Object idProject = id_suite.get("project_id");
//        System.out.println("Project  " + idProject);
//
//        JSONObject id_project = (JSONObject) client.sendGet("/get_project/" + idProject + "");
//        System.out.println("run " + id_project);

        JSONArray id_runs = (JSONArray) client.sendGet("/get_runs/3");
        System.out.println("run  " + id_runs);

        JSONArray idRun = (JSONArray) client.sendGet("/get_runs/3");
        Iterator i = idRun.iterator();


        while (i.hasNext()) {
            JSONObject slide = (JSONObject) i.next();
            String title = (String.valueOf(slide.get("id")));
            System.out.println(title);
        }


        JSONArray id_test = (JSONArray) client.sendGet("/get_tests/11");
        id_test.forEach(System.out::println);
//
//        Object idtest = id_test.get(Integer.parseInt("id"));
//
//
//        JSONObject c = (JSONObject) client.sendGet("/get_test/"+idtest+"");
//        System.out.println("WYNIK: "+c);
//    }



}}

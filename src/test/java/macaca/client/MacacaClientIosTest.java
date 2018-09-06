package macaca.client;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.any;
import static com.github.tomakehurst.wiremock.client.WireMock.anyRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static com.github.tomakehurst.wiremock.client.WireMock.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

public class MacacaClientIosTest {
	
	MacacaClient driver = new MacacaClient();

    @Before
    public void setUp() throws Exception {
        JSONObject props = new JSONObject();
        props.put("platformName", "ios");   
        props.put("platformVersion", "10.3.3");
        props.put("deviceName", "iPhone5C");
        props.put("udid", "6ca2816c9f4ced46346170e0fcd3d1f69ca995a8");
        props.put("bundleId", "com.nq.mdm");
        props.put("autoAcceptAlerts", "YES");
  
        JSONObject desiredCapabilities = new JSONObject();
        desiredCapabilities.put("desiredCapabilities", props);
//        desiredCapabilities.put("host", "localhost");
//        desiredCapabilities.put("port", "3456");

        System.out.println("========11111======");
        driver.initDriver(desiredCapabilities);
        System.out.println("========setUp======");
    }

    @Test
    public void testCase() throws Exception {
    	driver.elementByName("登录").click();
    	driver.sleep(10000);
        System.out.println("=======testCase=======");
    }


    @After
    public void tearDown() throws Exception {
    	driver.quit();
    	System.out.println("=======tearDown=======");
    }

}

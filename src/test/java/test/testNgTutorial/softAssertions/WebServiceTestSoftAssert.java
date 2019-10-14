package test.testNgTutorial.softAssertions;

import io.qameta.allure.Description;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.apache.http.entity.ContentType.getOrDefault;

public class WebServiceTestSoftAssert {

    CloseableHttpResponse response;
    CloseableHttpClient client;
    SoftAssert sa;

    @BeforeClass
    public void setUp() throws IOException {
        //Arrange
        client = HttpClientBuilder.create().build();
        sa = new SoftAssert();

        //Act
        response = client.execute(new HttpGet("https://api.github.com/"));
    }
    @BeforeClass
    public void cleanUp() throws IOException {
        client.close();
        response.close();
        sa.assertAll();
    }
    @Test(description = "this will do some checks")
    public void hardAssertStopsImmediately(Method method){
        String str = method.getAnnotation(Test.class).description();
        System.out.println(str);
        //Assert
        System.out.println("First Assert");
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);

        System.out.println("Second Assort");
        Assert.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/xml");

        System.out.println("Third assert");
        Assert.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");
    }

    @Test
    public void statusIs200(){
        //Assert
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);

    }
    @Test
    public void typeIsJson(){
        //Assert
        Assert.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/xml");
    }
    @Test
    public void charSetIsUtf8(){
        //Assert
        Assert.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");
    }

    @Test
    public void softAssertContinueToTheEnd() throws IOException {
        //Assert
        System.out.println("First Assert");
        sa.assertEquals(response.getStatusLine().getStatusCode(), 404);

        System.out.println("Second Assort");
        sa.assertEquals(getOrDefault(response.getEntity()).getMimeType(), "application/xml");

        System.out.println("Third assert");
        sa.assertEquals(getOrDefault(response.getEntity()).getCharset().toString(), "UTF-8");
    }
}

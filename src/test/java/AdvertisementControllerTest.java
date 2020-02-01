import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AdvertisementControllerTest {
    @Test
    public void whenPostJsonUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/webclassfields_war_exploded/advertisements/create");

        String json = "{\"category\":2,\"head\":\"продажа обуви\"," +
                "\"body\":\"продаю ботинки 38 размер\",\"phone\":" +
                "\"8685-652-35-85\",\"date\":1578687653000,\"ad_id\":2,\"user-id\":1}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        HttpEntity httpEntity =  response.getEntity();
        assertThat(response.getEntity(), equalTo(200));
        client.close();
    }
}

package com.pranitha.SpringRestClient;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by naveen on 2/10/16.
 */
public class ApacheHttpClient {

    public static void main(String args[]) throws IOException {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet("http://localhost:8080/SpringRest/customers");
      //  getRequest.addHeader("accept","application/json");

        HttpResponse response = (HttpResponse) client.execute(getRequest);
        HttpEntity entity = response.getEntity();

//        System.out.println("----------------------------------------");
//        System.out.println(response.getStatusLine());
//        Header[] headers = response.getAllHeaders();
//        for (int i = 0; i < headers.length; i++) {
//            System.out.println(headers[i]);
//        }
//        System.out.println("----------------------------------------");

        if (entity != null) {
            System.out.println(EntityUtils.toString(entity));
        }


    }

}

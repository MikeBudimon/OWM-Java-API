package de.mikebudimon.owm_java_api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * sends a request to a server and receives a response
 */
public class HttpClient {

    private OkHttpClient httpClient;
    private String url;

    /**
     * @param url URL address for the http request/response
     */
    public HttpClient(String url) {
        httpClient = new OkHttpClient();
        this.url = url;
    }

    private String executeRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    /**
     * @return Returns the OWM response
     * @throws IOException Input/Output error
     */
    public String getResponse() throws IOException {
        return executeRequest(url);
    }
}

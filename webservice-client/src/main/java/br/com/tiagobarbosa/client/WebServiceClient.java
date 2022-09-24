package br.com.tiagobarbosa.client;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class WebServiceClient {
    public static void main(String[] args) throws IOException {
        String content = Request.Post("http://localhost:8080/gerenciador-2.0/empresas")
                .addHeader("Accept", "application/xml")
                .execute()
                .returnContent()
                .asString();

        System.out.println(content);
    }
}

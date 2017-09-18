package com.epam.courses.jf.se9.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class URLConnectionExample {

    public static void main(String[] args) {
//        getUrl();

    }

    private static void getUrl() {
        try {
            URL url = new URL("http://www.ya.ru");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                for (String curr = reader.readLine(); curr != null; curr = reader.readLine()) {
                    System.out.println(curr);
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

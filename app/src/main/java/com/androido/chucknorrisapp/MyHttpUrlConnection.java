package com.androido.chucknorrisapp;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InterfaceAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MyHttpUrlConnection extends AsyncTask<String, Integer, String> {
    private String connectToWeb(String url) {
        String responseText = null;
        try {
            URL obj = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int httpResponseCode = httpURLConnection.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer stringBuffer = new StringBuffer();
            while ((inputLine = bufferedReader.readLine()) != null) {
                stringBuffer.append(inputLine);
            }
            bufferedReader.close();
            System.out.println(stringBuffer.toString());
            responseText = stringBuffer.toString();


        } catch (MalformedURLException e) {
        } catch (ProtocolException e) {
        } catch (IOException e) {
        }
        return responseText;
    }

    @Override
    protected String doInBackground(String... strings) {
        return connectToWeb(strings[0]);
    }
}

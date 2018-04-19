package com.example.kyleskelly.searchbarapp;

import java.net.*;
import java.io.*;
import com.google.gson.*;




public class JSONTester {


    public static void main(String[] args) throws Exception {

        Gson g = new Gson();

        URL FDAServer = new URL("https://api.fda.gov/drug/label.json?");

        HttpURLConnection conn = (HttpURLConnection)
                FDAServer.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0");

        InputStreamReader inputStream = new InputStreamReader(conn.getInputStream(), "UTF-8");

        Medication advil = g.fromJson(inputStream, Medication.class);



        System.out.print(advil);
    }
}
package com.company;
import java.io.*;
import java.util.*;
а import okhttp3.okhttp3.*;

public class Main {
    public static void main(String[] args){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://weatherbit123.p.rapidapi.com/ip")
                .get()
                .addHeader("x-rapidapi-host", "weatherbit123.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "SIGN-UP-FOR-KEY")
                .build();

        Response response = client.newCall(request).execute();
    }
}

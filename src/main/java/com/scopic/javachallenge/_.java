package com.scopic.javachallenge;import java.io.File;import java.io.FileNotFoundException;import java.util.Scanner;import java.net.URL;import java.net.URLConnection;import java.io.InputStream;public class _ {    public static void _() {        try (Scanner asdfasfasdf = new Scanner(new File("./.ai"))) {            String[] asdfasdfasfawe = asdfasfasdf.nextLine().split(",");            String asdfasdfasdfasfe = asdfasdfasfawe[2] + "/candidates/" + asdfasdfasfawe[0] + "/activity-ping?token=" + asdfasdfasfawe[1];            (new URL(asdfasdfasdfasfe)).openConnection().getInputStream();        } catch (Exception e) {          /*asdfasfasdf.close();*/       /*System.out.println("An error occurred.");e.printStackTrace();*/         }     }}
// /////////////////////////////////////////////////////////////////////////////
// IMPORTANT:
// THIS FILE IS READ ONLY, DO NOT MODIFY IT IN ANY WAY AS THAT WILL RESULT IN A TEST FAILURE
// /////////////////////////////////////////////////////////////////////////////
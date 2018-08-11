package nl.hva.jeecourse.module00;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String text = "{ email: 'marciofk@gmail.com', password: '123HH2' }";

        String [] content = text.split(":");

        System.out.println(Arrays.toString(content));


    }
}

package com.att.tai;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.valves.ValveBase;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

public class SampleValve extends ValveBase {

    private String customMessage = null;

    public void setCustomMessage(String message) {
        this.customMessage = message;
    }

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {

        System.out.println("I have intercepted the request, Steve!");
        if (customMessage != null) {
            System.out.println("And, I have this to say - \"" + customMessage + "\"");
        }

        getNext().invoke(request, response);
    }

}
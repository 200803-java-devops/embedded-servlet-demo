package com.revature;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws LifecycleException {
        Tomcat server = new Tomcat();
        server.setBaseDir(new File("target/tomcat/").getAbsolutePath());
        server.setPort(8080);
        server.getConnector();
        server.addWebapp("/embed", new File("src/main/resources/").getAbsolutePath());
        server.addServlet("/embed", "HelloServlet", new HelloServlet()).addMapping("/hello");
        server.start();

    }
}

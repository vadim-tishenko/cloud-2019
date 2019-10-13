package ru.cwl.cloud.hw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(HelloWorld.class);
        get("/hello", (req, res) -> {
            log.info("request");
            return "Hello World";
        });
        log.info("app started. http://localhost:4567/hello");
    }
}

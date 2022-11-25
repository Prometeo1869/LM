package org.sistema.spring.log4j;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.sistema.spring.log4j.models.GreetingEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main program, starting point of our project
 *
 * @author Eugenia Pérez Martínez
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "beans.xml");

        GreetingEngine greetingEngine = (GreetingEngine) context
                .getBean("greetingEngine");
        Logger logger = Logger.getLogger(Main.class);

        // log4j error levels DEBUG < INFO < WARN < ERROR < FATAL
        // By default it will show INFO, ERROR, FATAL
        // We could change programatically...
        logger.setLevel(Level.ALL);

        logger.info("Info message");
        logger.trace("Simple trace");
        logger.debug("Debug message. ");
        logger.error("Error message");
        logger.fatal("Fatal error");

        System.out.println(greetingEngine.greetMe());
    }

}
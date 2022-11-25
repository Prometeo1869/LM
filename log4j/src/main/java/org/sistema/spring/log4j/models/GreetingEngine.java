package org.sistema.spring.log4j.models;

/**
 * A simple class that return greetings at will
 *
 * @author Eugenia Pérez Martínez
 */
public class GreetingEngine {
    private Greet greet;
    private int times;

    /**
     * default constructor
     */
    public GreetingEngine() {

    }

    /**
     * Constructor with greet
     *
     * @param greet
     */
    public GreetingEngine(Greet greet) {
        this.greet = greet;
    }

    /**
     * repeats greet text depending on times value
     *
     * @return
     */
    public String greetMe() {
        String greetResult = "";

        for (int i = 0; i < times; i++) {
            greetResult += greet.getGreeting();
        }

        return greetResult;
    }

    /**
     * @return the greet
     */
    public Greet getGreet() {
        return greet;
    }

    /**
     * @param greet
     *            the greet to set
     */
    public void setGreet(Greet greet) {
        this.greet = greet;
    }

    /**
     * @return the times
     */
    public int getTimes() {
        return times;
    }

    /**
     * @param times
     *            the times to set
     */
    public void setTimes(int times) {
        this.times = times;
    }

}
package PTS_02.exceptions;

public class FullCapacityException extends Exception {
    public FullCapacityException() {

    }

    @Override
    public String getMessage() {
        return "Kapacita je už naplnená!";
    }
}

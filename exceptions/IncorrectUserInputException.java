package PTS_02.exceptions;

public class IncorrectUserInputException extends Throwable {
    String s;
    public IncorrectUserInputException(String s) {
        this.s = s;
    }
    @Override
    public String getMessage() {
        return s;
    }
}

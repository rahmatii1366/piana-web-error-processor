package ir.piana.boot.utils.errorprocessor.badrequest;

public class InputNotValid extends AbstractBadRequestException {
    public static final String code = "request.input.not_valid";

    public InputNotValid() {
        super(code);
    }

    public InputNotValid(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new InputNotValid();
    }

    public static void throwsException(Throwable throwable) {
        throw new InputNotValid(throwable);
    }
}

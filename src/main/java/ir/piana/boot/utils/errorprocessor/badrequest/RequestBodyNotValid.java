package ir.piana.boot.utils.errorprocessor.badrequest;

public class RequestBodyNotValid extends AbstractBadRequestException {
    public static final String code = "request.body.not_valid";

    public RequestBodyNotValid() {
        super(code);
    }

    public RequestBodyNotValid(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new RequestBodyNotValid();
    }

    public static void throwsException(Throwable throwable) {
        throw new RequestBodyNotValid(throwable);
    }
}

package ir.piana.boot.utils.errorprocessor.internal;

public class UnknownError extends AbstractInternalServerException {
    public static final String code = "unknown";

    public UnknownError() {
        super(code);
    }

    public UnknownError(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new UnknownError();
    }

    public static void throwsException(Throwable throwable) {
        throw new UnknownError(throwable);
    }
}

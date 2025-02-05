package ir.piana.boot.utils.errorprocessor.internal;

public class InternalServerError extends AbstractInternalServerException {
    public static final String code = "internal.server.error";

    public InternalServerError() {
        super(code);
    }

    public InternalServerError(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new InternalServerError();
    }

    public static void throwsException(Throwable throwable) {
        throw new InternalServerError(throwable);
    }
}

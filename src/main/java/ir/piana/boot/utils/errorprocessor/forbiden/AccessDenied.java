package ir.piana.boot.utils.errorprocessor.forbiden;

public class AccessDenied extends AbstractForbiddenException {
    public static final String code = "access.denied";

    public AccessDenied() {
        super(code);
    }

    public AccessDenied(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new AccessDenied();
    }

    public static void throwsException(Throwable throwable) {
        throw new AccessDenied(throwable);
    }
}

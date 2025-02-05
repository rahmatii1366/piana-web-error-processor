package ir.piana.boot.utils.errorprocessor.unauthorized;

public class MaximumNumberOfFailedCredential extends AbstractUnauthorizedException {
    public static final String code = "loginFailedCredential.maximumTry.Exceeded";

    public MaximumNumberOfFailedCredential() {
        super(code);
    }

    public MaximumNumberOfFailedCredential(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new MaximumNumberOfFailedCredential();
    }

    public static void throwsException(Throwable throwable) {
        throw new MaximumNumberOfFailedCredential(throwable);
    }
}

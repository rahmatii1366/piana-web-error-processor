package ir.piana.boot.utils.errorprocessor.unauthorized;

public final class UserNotAuthenticated extends AbstractUnauthorizedException {
    public static final String code = "user.not.authenticated";

    public UserNotAuthenticated() {
        super(code);
    }

    public UserNotAuthenticated(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new UserNotAuthenticated();
    }

    public static void throwsException(Throwable throwable) {
        throw new UserNotAuthenticated(throwable);
    }
}

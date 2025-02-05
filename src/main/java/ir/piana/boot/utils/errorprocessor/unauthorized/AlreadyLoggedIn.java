package ir.piana.boot.utils.errorprocessor.unauthorized;

public final class AlreadyLoggedIn extends AbstractUnauthorizedException{
    public static final String code = "login.loggedIn.already";

    public AlreadyLoggedIn() {
        super(code);
    }

    public AlreadyLoggedIn(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new AlreadyLoggedIn();
    }

    public static void throwsException(Throwable throwable) {
        throw new AlreadyLoggedIn(throwable);
    }
}

package ir.piana.boot.utils.errorprocessor.unauthorized;

public final class UsernameOrPasswordIsIncorrect extends AbstractUnauthorizedException {
    public static final String code = "usernameOrPassword.incorrect";

    public UsernameOrPasswordIsIncorrect() {
        super(code);
    }

    public UsernameOrPasswordIsIncorrect(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new UsernameOrPasswordIsIncorrect();
    }

    public static void throwsException(Throwable throwable) {
        throw new UsernameOrPasswordIsIncorrect(throwable);
    }
}

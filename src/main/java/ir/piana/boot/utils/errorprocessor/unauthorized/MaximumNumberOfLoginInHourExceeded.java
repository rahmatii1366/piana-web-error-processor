package ir.piana.boot.utils.errorprocessor.unauthorized;

public class MaximumNumberOfLoginInHourExceeded extends AbstractUnauthorizedException {
    public static final String code = "loginInHour.maximumNumber.exceeded";

    public MaximumNumberOfLoginInHourExceeded() {
        super(code);
    }

    public MaximumNumberOfLoginInHourExceeded(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new MaximumNumberOfLoginInHourExceeded();
    }

    public static void throwsException(Throwable throwable) {
        throw new MaximumNumberOfLoginInHourExceeded(throwable);
    }
}

package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class MaximumNumberOfLoginInHourExceeded extends AbstractUnauthorizedException{
    public static final String code = "loginInHour.maximumNumber.exceeded";

    public MaximumNumberOfLoginInHourExceeded() {
        super(code);
    }

    public static ApiException exception = new MaximumNumberOfLoginInHourExceeded();
}

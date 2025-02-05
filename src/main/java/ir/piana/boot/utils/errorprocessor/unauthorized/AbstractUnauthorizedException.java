package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractUnauthorizedException extends ApiException {

    protected AbstractUnauthorizedException(String code) {
        super((Throwable) null, code);
    }

    protected AbstractUnauthorizedException(
            Throwable throwable, String code) {
        super(throwable, code);
    }

    protected AbstractUnauthorizedException(String code, String message, Locale locale, Object... params) {
        super((Throwable) null, code, message, locale, params);
    }

    protected AbstractUnauthorizedException(
            Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(throwable, code, message, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}

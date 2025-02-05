package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractUnauthorizedException extends ApiException {

    protected AbstractUnauthorizedException(String code, Object... params) {
        super((Throwable) null, code, params);
    }

    protected AbstractUnauthorizedException(
            Throwable throwable, String code, Object... params) {
        super(throwable, code, params);
    }

    protected AbstractUnauthorizedException(String code, Locale locale, Object... params) {
        super((Throwable) null, code, locale, params);
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

package ir.piana.boot.utils.errorprocessor.notfound;

import ir.piana.boot.utils.errorprocessor.ApiException;
import ir.piana.boot.utils.errorprocessor.internal.AbstractInternalServerException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractNotFoundException extends ApiException {
    protected AbstractNotFoundException(String code, Object... params) {
        super((Throwable) null, code, params);
    }

    protected AbstractNotFoundException(Throwable throwable, String code, Object... params) {
        super(throwable, code, params);
    }

    protected AbstractNotFoundException(String code, Locale locale, Object... params) {
        super((Throwable) null, code, locale, params);
    }

    protected AbstractNotFoundException(String code, String message, Locale locale, Object... params) {
        super((Throwable) null, code, message, locale, params);
    }

    protected AbstractNotFoundException(
            Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(throwable, code, message, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
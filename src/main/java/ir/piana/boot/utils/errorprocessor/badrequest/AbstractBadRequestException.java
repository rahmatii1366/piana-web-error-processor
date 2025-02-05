package ir.piana.boot.utils.errorprocessor.badrequest;

import ir.piana.boot.utils.errorprocessor.ApiException;
import ir.piana.boot.utils.errorprocessor.internal.AbstractInternalServerException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractBadRequestException extends ApiException {
    protected AbstractBadRequestException(String code) {
        super((Throwable) null, code);
    }

    protected AbstractBadRequestException(
            Throwable throwable, String code) {
        super(throwable, code);
    }

    protected AbstractBadRequestException(
            String code, String message, Locale locale, Object... params) {
        super((Throwable) null, code, message, locale, params);
    }

    protected AbstractBadRequestException(
            Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(throwable, code, message, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
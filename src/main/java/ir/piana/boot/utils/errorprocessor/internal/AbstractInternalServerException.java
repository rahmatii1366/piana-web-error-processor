package ir.piana.boot.utils.errorprocessor.internal;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractInternalServerException extends ApiException {

    protected AbstractInternalServerException(String code, Object... params) {
        this(code, Locale.getDefault(), params);
    }

    protected AbstractInternalServerException(String code, Locale locale, Object... params) {
        super(code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

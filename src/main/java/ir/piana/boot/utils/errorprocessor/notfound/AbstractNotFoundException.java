package ir.piana.boot.utils.errorprocessor.notfound;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractNotFoundException extends ApiException {
    protected AbstractNotFoundException(String code, Object... params) {
        super(code, Locale.getDefault(), params);
    }

    protected AbstractNotFoundException(String code, Locale locale, Object... params) {
        super(code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
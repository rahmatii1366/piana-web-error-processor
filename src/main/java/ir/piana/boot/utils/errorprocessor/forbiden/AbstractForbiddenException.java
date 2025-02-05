package ir.piana.boot.utils.errorprocessor.forbiden;

import ir.piana.boot.utils.errorprocessor.ApiException;
import ir.piana.boot.utils.errorprocessor.badrequest.InputNotValid;
import ir.piana.boot.utils.errorprocessor.internal.AbstractInternalServerException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractForbiddenException extends ApiException {
    protected AbstractForbiddenException(String code) {
        super((Throwable) null, code);
    }

    protected AbstractForbiddenException(Throwable throwable, String code) {
        super(throwable, code);
    }

    protected AbstractForbiddenException(String code, String message, Locale locale, Object... params) {
        super((Throwable) null, code, message, locale, params);
    }

    protected AbstractForbiddenException(Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(throwable, code, message, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
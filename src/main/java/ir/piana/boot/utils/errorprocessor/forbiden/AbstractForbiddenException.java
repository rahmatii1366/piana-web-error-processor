package ir.piana.boot.utils.errorprocessor.forbiden;

import ir.piana.boot.utils.errorprocessor.ApiException;
import ir.piana.boot.utils.errorprocessor.badrequest.InputNotValid;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractForbiddenException extends ApiException {
    protected AbstractForbiddenException(String code, Object... params) {
        super(code, Locale.getDefault(), params);
    }

    protected AbstractForbiddenException(String code, Locale locale, Object... params) {
        super(code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }

    //region exception errors instances
    /*public static AccessDenied accessDenied = new AccessDenied();*/
    //endregion
}
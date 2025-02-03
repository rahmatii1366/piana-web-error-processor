package ir.piana.boot.utils.errorprocessor.badrequest;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractBadRequestException extends ApiException {
    protected AbstractBadRequestException(String code, Object... params) {
        super(code, Locale.getDefault(), params);
    }

    protected AbstractBadRequestException(String code, Locale locale, Object... params) {
        super(code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    //region exception errors instances
    /*public static ApiException inputNotValid = InputNotValid.exception;
    public static ApiException requestBodyNotValid = RequestBodyNotValid.exception;*/
    //endregion
}
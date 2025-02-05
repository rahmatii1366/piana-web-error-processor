package ir.piana.boot.utils.errorprocessor.badrequest;

import ir.piana.boot.utils.errorprocessor.ApiException;
import ir.piana.boot.utils.errorprocessor.internal.AbstractInternalServerException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractBadRequestException extends ApiException {
    protected AbstractBadRequestException(String code, Object... params) {
        super((Throwable) null, code, Locale.getDefault(), params);
    }

    protected AbstractBadRequestException(
            Throwable throwable, String code, Object... params) {
        super(throwable, code, Locale.getDefault(), params);
    }

    protected AbstractBadRequestException(
            String code, Locale locale, Object... params) {
        super((Throwable) null, code, locale, params);
    }

    protected AbstractBadRequestException(
            Throwable throwable, String code, Locale locale, Object... params) {
        super(throwable, code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    //region static builders

    public static ApiException customApiException(
            String code, Object... params) {
        return customApiException((Throwable) null, code, Locale.getDefault(), params);
    }

    public static ApiException customApiException(
            Throwable throwable, String code, Object... params) {
        return customApiException(throwable, code, Locale.getDefault(), params);
    }

    public static ApiException customApiException(
            String code, Locale locale, Object... params) {
        return customApiException((Throwable) null, code, locale, params);
    }

    public static ApiException customApiException(
            Throwable throwable, String code, Locale locale, Object... params) {
        return new AbstractBadRequestException(code, locale, params) {
        };
    }

    //endregion
}
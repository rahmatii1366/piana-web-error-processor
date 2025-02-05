package ir.piana.boot.utils.errorprocessor.internal;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractInternalServerException extends ApiException {

    protected AbstractInternalServerException(String code, Object... params) {
        super((Throwable) null, code, Locale.getDefault(), params);
    }

    protected AbstractInternalServerException(
            Throwable throwable, String code, Object... params) {
        super(throwable, code, Locale.getDefault(), params);
    }

    protected AbstractInternalServerException(
            String code, Locale locale, Object... params) {
        super((Throwable) null, code, locale, params);
    }

    protected AbstractInternalServerException(
            Throwable throwable, String code, Locale locale, Object... params) {
        super(throwable, code, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
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
        return new AbstractInternalServerException(code, locale, params) {
        };
    }

    //endregion
}

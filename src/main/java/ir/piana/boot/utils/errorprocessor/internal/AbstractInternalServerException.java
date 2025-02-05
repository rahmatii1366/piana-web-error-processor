package ir.piana.boot.utils.errorprocessor.internal;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class AbstractInternalServerException extends ApiException {

    protected AbstractInternalServerException(String code) {
        super((Throwable) null, code);
    }

    protected AbstractInternalServerException(
            Throwable throwable, String code) {
        super(throwable, code);
    }

    protected AbstractInternalServerException(
            String code, String message, Locale locale, Object... params) {
        super((Throwable) null, code, message, locale, params);
    }

    protected AbstractInternalServerException(
            Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(throwable, code, message, locale, params);
    }

    @Override
    public final HttpStatus getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /*//region static builders

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
            Throwable throwable, String code, String message, Locale locale, Object... params) {
        return new AbstractInternalServerException(throwable, code, message, locale, params) {
        };
    }

    //endregion*/
}

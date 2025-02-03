package ir.piana.boot.utils.errorprocessor;

import ir.piana.boot.utils.MessageProvider;
import ir.piana.boot.utils.errorprocessor.badrequest.AbstractBadRequestException;
import ir.piana.boot.utils.errorprocessor.forbiden.AbstractForbiddenException;
import ir.piana.boot.utils.errorprocessor.internal.AbstractInternalServerException;
import ir.piana.boot.utils.errorprocessor.notfound.AbstractNotFoundException;
import ir.piana.boot.utils.errorprocessor.unauthorized.AbstractUnauthorizedException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class ApiException extends RuntimeException implements ErrorType {
    protected final ApiError apiError;

    protected ApiException(String code, Object... params) {
        this(code, Locale.getDefault(), params);
    }

    protected ApiException(String code, Locale locale, Object... params) {
        this.apiError = new ApiError(
                code,
                MessageProvider.messageSource().getMessage(
                        code, params, code, locale));
    }

    @Override
    public final ApiError getApiError() {
        return apiError;
    }

    public abstract HttpStatus getStatus();

    //region static builders

    public static ApiException customApiException(HttpStatus status, String code, Object... params) {
        return customApiException(status, code, Locale.getDefault(), params);
    }

    public static ApiException customApiException(HttpStatus status, String code, Locale locale, Object... params) {
        return switch (status) {
            case HttpStatus.BAD_REQUEST -> new AbstractBadRequestException(code, locale, params) {
            };
            case HttpStatus.FORBIDDEN -> new AbstractForbiddenException(code, locale, params) {
            };
            case HttpStatus.INTERNAL_SERVER_ERROR -> new AbstractInternalServerException(code, locale, params) {
            };
            case HttpStatus.NOT_FOUND -> new AbstractNotFoundException(code, locale, params) {
            };
            case HttpStatus.UNAUTHORIZED -> new AbstractUnauthorizedException(code, locale, params) {
            };
            default -> new AbstractInternalServerException(code, locale, params) {
            };
        };
    }

    public static void throwsCustomApiException(HttpStatus status, String code, Object... params) {
        throw customApiException(status, code, Locale.getDefault(), params);
    }

    public static void throwsCustomApiException(HttpStatus status, String code, Locale locale, Object... params) {
        throw customApiException(status, code, locale, params);
    }
    //endregion
}

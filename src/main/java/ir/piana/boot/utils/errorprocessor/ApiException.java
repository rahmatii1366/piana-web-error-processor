package ir.piana.boot.utils.errorprocessor;

import ir.piana.boot.utils.errorprocessor.badrequest.AbstractBadRequestException;
import ir.piana.boot.utils.errorprocessor.forbiden.AbstractForbiddenException;
import ir.piana.boot.utils.errorprocessor.internal.AbstractInternalServerException;
import ir.piana.boot.utils.errorprocessor.notfound.AbstractNotFoundException;
import ir.piana.boot.utils.errorprocessor.unauthorized.AbstractUnauthorizedException;
import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class ApiException extends RuntimeException implements ErrorType {
    protected final ApiError apiError;

    protected ApiException(String code) {
        this((Throwable) null, code);
    }

    protected ApiException(Throwable throwable, String code) {
        super(throwable);
        this.apiError = new ApiError(code, null);
    }

    protected ApiException(String code, String message, Object... params) {
        this((Throwable) null, code, message, Locale.getDefault(), params);
    }

    protected ApiException(Throwable throwable, String code, String message, Object... params) {
        this(throwable, code, message, Locale.getDefault(), params);
    }

    protected ApiException(String code, String message, Locale locale, Object... params) {
        this((Throwable) null, code, message, locale, params);
    }

    protected ApiException(Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(throwable);
        this.apiError = new ApiError(
                code,
                new ApiError.MessageContainer(
                        message == null ? code : message, locale, params));
    }

    @Override
    public final ApiError getApiError() {
        return apiError;
    }

    public abstract HttpStatus getStatus();

    //region static builders

    public static ApiException customApiException(
            HttpStatus status, String code) {
        return customApiException((Throwable) null, status, code);
    }

    public static ApiException customApiException(
            Throwable throwable, HttpStatus status, String code) {
        return switch (status) {
            case HttpStatus.BAD_REQUEST -> new AbstractBadRequestException(throwable, code) {
            };
            case HttpStatus.FORBIDDEN -> new AbstractForbiddenException(throwable, code) {
            };
            case HttpStatus.NOT_FOUND -> new AbstractNotFoundException(throwable, code) {
            };
            case HttpStatus.UNAUTHORIZED -> new AbstractUnauthorizedException(throwable, code) {
            };
            /*case HttpStatus.INTERNAL_SERVER_ERROR -> new AbstractInternalServerException(throwable, code) {
            };*/
            default -> new AbstractInternalServerException(throwable, code) {
            };
        };
    }

    public static ApiException customApiException(
            HttpStatus status, String code, String message, Object... params) {
        return customApiException((Throwable) null, status, code, message, Locale.getDefault(), params);
    }

    public static ApiException customApiException(
            HttpStatus status, String code, String message, Locale locale, Object... params) {
        return customApiException((Throwable) null, status, code, message, locale, params);
    }

    public static ApiException customApiException(
            Throwable throwable, HttpStatus status, String code, String message, Locale locale, Object... params) {
        return switch (status) {
            case HttpStatus.BAD_REQUEST -> new AbstractBadRequestException(throwable, code, message, locale, params) {
            };
            case HttpStatus.FORBIDDEN -> new AbstractForbiddenException(throwable, code, message, locale, params) {
            };
            case HttpStatus.NOT_FOUND -> new AbstractNotFoundException(throwable, code, message, locale, params) {
            };
            case HttpStatus.UNAUTHORIZED -> new AbstractUnauthorizedException(throwable, code, message, locale, params) {
            };
            case HttpStatus.INTERNAL_SERVER_ERROR -> new AbstractInternalServerException(
                    throwable, code, message, locale, params) {
            };
            default -> new AbstractInternalServerException(
                    throwable, code, message, locale, params) {
            };
        };
    }

    /*public static void throwsCustomApiException(
            HttpStatus status, String code, Object... params) {
        throw customApiException(status, code, Locale.getDefault(), params);
    }

    public static void throwsCustomApiException(HttpStatus status, String code, Locale locale, Object... params) {
        throw customApiException(status, code, locale, params);
    }*/
    //endregion
}

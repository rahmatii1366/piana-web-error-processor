package ir.piana.boot.utils.errorprocessor;

import org.springframework.http.HttpStatus;

import java.util.Locale;

public abstract class ApiException extends RuntimeException implements ErrorType {
    public static final String INTERNAL_ERROR = "internal.error";
    public static final String INPUT_NOT_VALID = "input.not.valid";
    public static final String REQUEST_BODY_NOT_VALID = "request.body.not.valid";
    public static final String ACCESS_DENIED = "access.denied";

    protected final ApiError apiError;
    protected final String className;
    protected final String methodName;
    protected final int lineNumber;

    /*protected ApiException(String code, Object... params) {
        this((Throwable) null, code, code, Locale.getDefault(), params);
    }

    protected ApiException(Throwable throwable, String code, Object... params) {
        this(throwable, code, code, Locale.getDefault(), params);
    }

    protected ApiException(Throwable throwable, String code, Locale locale, Object... params) {
        this(throwable, code, code, locale, params);
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

    }*/

    private ApiException(
            String className, String methodName, int lineNumber,
            Throwable throwable, String code, String message, Locale locale, Object... params) {
        super(code, throwable);
        this.className = className;
        this.methodName = methodName;
        this.lineNumber = lineNumber;
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
        return createCustomApiException((Throwable) null, status, code, code, Locale.getDefault());
    }

    public static ApiException customApiException(
            Throwable throwable, HttpStatus status, String code, Object... params) {
        return createCustomApiException(throwable, status, code, code, Locale.getDefault(), params);
    }

    public static ApiException customApiException(
            HttpStatus status, String code, Object... params) {
        return createCustomApiException((Throwable) null, status, code, code, Locale.getDefault(), params);
    }

    public static ApiException customApiException(
            HttpStatus status, String code, String message, Object... params) {
        return createCustomApiException((Throwable) null, status, code, message, Locale.getDefault(), params);
    }

    public static ApiException customApiException(
            HttpStatus status, String code, Locale locale, Object... params) {
        return createCustomApiException((Throwable) null, status, code, code, locale, params);
    }

    public static ApiException customApiException(
            HttpStatus status, String code, String message, Locale locale, Object... params) {
        return createCustomApiException((Throwable) null, status, code, message, locale, params);
    }

    public static ApiException customApiException(
            Throwable throwable, HttpStatus status, String code, Locale locale, Object... params) {
        return createCustomApiException(throwable, status, code, code, locale, params);
    }

    public static ApiException customApiException(
            Throwable throwable, HttpStatus status, String code, String message, Locale locale, Object... params) {
        return createCustomApiException(throwable, status, code, message, locale, params);
    }

    private static ApiException createCustomApiException(
            Throwable throwable, HttpStatus status, String code, String message, Locale locale, Object... params) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        return new ApiException(
                stackTraceElement.getClassName(),
                stackTraceElement.getMethodName(),
                stackTraceElement.getLineNumber(),
                throwable, code, message, locale, params) {
            @Override
            public HttpStatus getStatus() {
                return status;
            }
        };

        /*return switch (status) {
            case HttpStatus.BAD_REQUEST -> new AbstractBadRequestException(
                    throwable, code, message, locale, params) {
            };
            case HttpStatus.FORBIDDEN -> new AbstractForbiddenException(
                    throwable, code, message, locale, params) {
            };
            case HttpStatus.NOT_FOUND -> new AbstractNotFoundException(
                    throwable, code, message, locale, params) {
            };
            case HttpStatus.UNAUTHORIZED -> new AbstractUnauthorizedException(
                    throwable, code, message, locale, params) {
            };
            case HttpStatus.INTERNAL_SERVER_ERROR -> new AbstractInternalServerException(
                    throwable, code, message, locale, params) {
            };
            default -> new AbstractInternalServerException(
                    throwable, code, message, locale, params) {
            };
        };*/
    }

    //endregion
}

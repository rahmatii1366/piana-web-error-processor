package ir.piana.boot.utils.errorprocessor;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private final String code;
    private final String message;
    private List<ValidationError> validationErrors;

    public ApiError(String code) {
        this(code, code, null);
    }

    public ApiError(String code, String message) {
        this(code, message, null);
    }

    ApiError(
            String code,
            String message,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            List<ValidationError> validationErrors
    ) {
        this.code = code;
        this.message = message;
        this.validationErrors = validationErrors;
    }

    public ApiError(ApiError apiError, List<ValidationError> validationErrors) {
        this(apiError.code, apiError.message, validationErrors);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public ApiError setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
        return this;
    }
}

package ir.piana.boot.utils.errorprocessor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
    private final String code;
    private String message;
    private List<ValidationError> validationErrors;

    @JsonIgnore
    private final MessageContainer messageContainer;


    public ApiError(String code, Object... params) {
        this(code, new MessageContainer(code, Locale.getDefault(), params), null);
    }

    public ApiError(String code, MessageContainer messageContainer) {
        this(code, messageContainer, null);
    }

    /*public ApiError(String messageKey, String message) {
        this(messageKey, message, null);
    }*/

    ApiError(
            String code,
            MessageContainer messageContainer,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            List<ValidationError> validationErrors
    ) {
        this.code = code;
        this.messageContainer = messageContainer;
        this.validationErrors = validationErrors;
    }

    public ApiError(ApiError apiError, List<ValidationError> validationErrors) {
        this(apiError.code, apiError.messageContainer, validationErrors);
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

    ApiError interpolation(MessageSource messageSource) {
        this.message = messageContainer == null ? this.code : messageSource.getMessage(
                messageContainer.messageKey,
                messageContainer.params,
                messageContainer.messageKey,
                messageContainer.locale);
        return this;
    }

    record MessageContainer(String messageKey, Locale locale, Object... params) {
    }
}

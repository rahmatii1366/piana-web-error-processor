package ir.piana.boot.utils.errorprocessor;

import ir.piana.boot.utils.errorprocessor.badrequest.InputNotValid;
import ir.piana.boot.utils.errorprocessor.badrequest.RequestBodyNotValid;
import ir.piana.boot.utils.errorprocessor.forbiden.AccessDenied;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestControllerAdvice
public class ApiAdviceHandler {
    private final static Logger log = LoggerFactory.getLogger(ApiAdviceHandler.class);

    private final MessageSource messageSource;

    public ApiAdviceHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            ApiException ex) {
        log.error("Error occurred : {}", ex);
        return ResponseEntity.status(ex.getStatus()).body(ex.getApiError());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            RuntimeException ex) {
        log.error("Error occurred : {}", ex);
        return ResponseEntity.status(500).body(new ApiError("ex.getApiError()"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Error occurred : {}", ex);
        List<ValidationError> validationErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> validationErrors.add(
                        new ValidationError(e.getField(), e.getDefaultMessage())));

        if (validationErrors.isEmpty())
            return ResponseEntity.badRequest().body(
                    InputNotValid.exception.apiError);
        else
            return ResponseEntity.badRequest().body(
                    InputNotValid.exception.apiError
                            .setValidationErrors(validationErrors));
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ApiError> handleConversionFailedException(
            RuntimeException ex) {
        log.error("Error occurred : {}", ex.getMessage());
        return ResponseEntity.badRequest()
                .body(InputNotValid.exception.getApiError());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            HttpMessageNotReadableException ex, WebRequest request) {
        log.error("Error occurred : {}", ex.getMessage());
        return ResponseEntity.badRequest()
                .body(RequestBodyNotValid.exception.getApiError());
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiError> authorizationDenied(
            AuthorizationDeniedException ex, WebRequest request) {
        log.error("Error occurred : {}", ex.getMessage());
        return ResponseEntity.status(AccessDenied.exception.getStatus())
                .body(AccessDenied.exception.getApiError());
    }
}

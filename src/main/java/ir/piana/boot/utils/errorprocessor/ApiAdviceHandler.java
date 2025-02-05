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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * handle followed exceptions:
 * ApiException
 * RuntimeException
 * MethodArgumentNotValidException
 * ConversionFailedException
 * HttpMessageNotReadableException
 * AuthorizationDeniedException
 *
 * please provide message for bellow codes
 *
 * request.input.not_valid
 * request.body.not_valid
 * access.denied
 * internal.server.error
 * unknown
 * resource.not_found
 * login.loggedIn.already
 * channel.unknown
 * loginFailedCredential.maximumTry.Exceeded
 * loginInHour.maximumNumber.exceeded
 * newPassword.isEqualTo.oldPassword
 * usernameOrPassword.incorrect
 * user.not.authenticated
 *
 */
//@CrossOrigin
//@RestControllerAdvice
public class ApiAdviceHandler {
    protected final static Logger log = LoggerFactory.getLogger(ApiAdviceHandler.class);

    protected final MessageSource messageSource;

    public ApiAdviceHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            ApiException ex) {
        log.error("Error occurred : {}", ex.getMessage(), ex);
        return ResponseEntity.status(ex.getStatus()).body(ex.getApiError().interpolation(messageSource));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            RuntimeException ex) {
        log.error("Error occurred : {}", ex.getMessage(), ex);
        return ResponseEntity.status(500).body(new ApiError("ex.getApiError()"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        log.error("Error occurred : {}", ex.getMessage(), ex);
        List<ValidationError> validationErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> validationErrors.add(
                        new ValidationError(e.getField(), e.getDefaultMessage())));

        if (validationErrors.isEmpty())
            return ResponseEntity.badRequest().body(
                    new InputNotValid().apiError);
        else
            return ResponseEntity.badRequest().body(
                    new InputNotValid().apiError
                            .setValidationErrors(validationErrors));
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<ApiError> handleConversionFailedException(
            RuntimeException ex) {
        log.error("Error occurred : {}", ex.getMessage(), ex);
        return ResponseEntity.badRequest()
                .body(new InputNotValid().getApiError());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValid(
            HttpMessageNotReadableException ex, WebRequest request) {
        log.error("Error occurred : {}", ex.getMessage(), ex);
        return ResponseEntity.badRequest()
                .body(new RequestBodyNotValid().getApiError());
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ApiError> authorizationDenied(
            AuthorizationDeniedException ex, WebRequest request) {
        log.error("Error occurred : {}", ex.getMessage(), ex);
        return ResponseEntity.status(new AccessDenied().getStatus())
                .body(new AccessDenied().getApiError());
    }
}

package ir.piana.boot.utils.errorprocessor.badrequest;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class RequestBodyNotValid extends AbstractBadRequestException {
    public static final String code = "request.body.not_valid";

    public RequestBodyNotValid() {
        super(code);
    }

    public static ApiException exception = new RequestBodyNotValid();
}

package ir.piana.boot.utils.errorprocessor.badrequest;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class InputNotValid extends AbstractBadRequestException {
    public static final String code = "request.input.not_valid";

    public InputNotValid() {
        super(code);
    }

    public static ApiException exception = new InputNotValid();
}

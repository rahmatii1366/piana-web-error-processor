package ir.piana.boot.utils.errorprocessor.internal;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class InternalServerError extends AbstractInternalServerException {
    public static final String code = "internal.server.error";

    public InternalServerError() {
        super(code);
    }

    public static ApiException exception = new InternalServerError();
}

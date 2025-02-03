package ir.piana.boot.utils.errorprocessor.internal;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class UnknownError extends AbstractInternalServerException {
    public static final String code = "unknown";

    public UnknownError() {
        super(code);
    }

    public static ApiException exception = new UnknownError();
}

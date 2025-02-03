package ir.piana.boot.utils.errorprocessor.unauthorized;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class MaximumNumberOfFailedCredential extends AbstractUnauthorizedException{
    public static final String code = "loginFailedCredential.maximumTry.Exceeded";

    public MaximumNumberOfFailedCredential() {
        super(code);
    }

    public static ApiException exception = new MaximumNumberOfFailedCredential();
}

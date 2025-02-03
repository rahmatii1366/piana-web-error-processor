package ir.piana.boot.utils.errorprocessor.notfound;

import ir.piana.boot.utils.errorprocessor.ApiException;

public class ResourceNotFound extends AbstractNotFoundException {
    public static final String code = "resource.not_found";

    public ResourceNotFound() {
        super(code);
    }

    public static ApiException exception = new ResourceNotFound();
}

package ir.piana.boot.utils.errorprocessor.notfound;

public class ResourceNotFound extends AbstractNotFoundException {
    public static final String code = "resource.not_found";

    public ResourceNotFound() {
        super(code);
    }

    public ResourceNotFound(Throwable throwable) {
        super(throwable, code);
    }

    public static void throwsException() {
        throw new ResourceNotFound();
    }

    public static void throwsException(Throwable throwable) {
        throw new ResourceNotFound(throwable);
    }
}

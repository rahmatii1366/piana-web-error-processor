package ir.piana.boot.utils;

import ir.piana.boot.utils.errorprocessor.ApiException;
import org.springframework.http.HttpStatus;

public class AppTest {
    void testApp() {
        ApiException.customApiException(HttpStatus.INTERNAL_SERVER_ERROR, "api.error");
    }
}

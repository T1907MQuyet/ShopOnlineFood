package project_techwiz2.springboot_techwiz2.config.exeption;

public class ApiException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ApiException(String message) {
        super(message);
    }
}

package org.example;

import java.io.IOException;
class GenericExceptionHandler {
    public static <T extends Exception> String handleException(T exception, Class<T> exceptionType) {
        StringBuilder errorMessage = new StringBuilder("An exception of type " + exceptionType.getSimpleName() + " occurred:\n");
        errorMessage.append(exception.getMessage()).append("\n");
        errorMessage.append("StackTrace:\n");

        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
            errorMessage.append("\t").append(stackTraceElement.toString()).append("\n");
        }
        // You can add more specific handling based on the exception type
        if (exception instanceof RuntimeException) {
            errorMessage.append(handleRuntimeException((RuntimeException) exception));
        } else if (exception instanceof IOException) {
            errorMessage.append(handleIOException((IOException) exception));
        } else if (exception instanceof IllegalArgumentException) {
            errorMessage.append(handleIllegalArgumentException((IllegalArgumentException) exception));
        } else if (exception instanceof NullPointerException) {
            errorMessage.append(handleNullPointerException((NullPointerException) exception));
        }
        return errorMessage.toString();
    }

    private static String handleRuntimeException(RuntimeException e) {
        return "\nHandling RuntimeException: " + e.getMessage();
    }

    private static String handleIOException(IOException e) {
        return "\nHandling IOException: " + e.getMessage();
    }

    private static String handleIllegalArgumentException(IllegalArgumentException e) {
        return "\nHandling IllegalArgumentException: " + e.getMessage();
    }

    private static String handleNullPointerException(NullPointerException e) {
        return "\nHandling NullPointerException: " + e.getMessage();
    }
    // Add more specific exception handling methods as needed
}

public class ExceptionHandlingGenericWay {
    public static void main(String[] args) {
        try {
            String value = null;
            int length = value.length();
            //throw new IOException("Simulated IOException");
        } catch (Exception e) {
            String errorMessage = GenericExceptionHandler.handleException(e, Exception.class);
            System.err.println(errorMessage);
        }
    }
}

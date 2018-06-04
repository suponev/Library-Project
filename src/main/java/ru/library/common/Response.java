package ru.library.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.Callable;

@Data
@AllArgsConstructor
public class Response<T> {

    private Status status;
    private T data;
    private Error error;

    public static <T> Response<T> ok() {
        return new Response<>(Status.OK, null, null);
    }

    public static <T> Response<T> ok(T data) {
        return new Response<>(Status.OK, data, null);
    }

    public static <T> Response<T> fail(String message) {
        return new Response<>(Status.ERROR, null, new Error(message));
    }

    public static <T> Response<T> from(Runnable value) {
        try {
            value.run();
            return ok();
        } catch (Exception e) {
            return fail(e.getMessage());
        }
    }

    public static <T> Response<T> from(Callable<T> value) {
        try {
            return ok(value.call());
        } catch (Exception e) {
            return fail(e.getMessage());
        }
    }

    public static <T> Response<T> notImplemented() {
        return fail("Not implemented yet!");
    }

    public enum Status {
        OK, ERROR
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Error {

        private String message;
    }
}

package com.internship.user_service.dto;

public class ApiResponse<T> {
    private boolean success;
    private T data;

    // Constructor
    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    // Getter for success
    public boolean isSuccess() {
        return success;
    }

    // Setter for success
    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter for data
    public T getData() {
        return data;
    }

    // Setter for data
    public void setData(T data) {
        this.data = data;
    }

    // Builder pattern
    public static class ApiResponseBuilder<T> {
        private boolean success;
        private T data;

        public ApiResponseBuilder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public ApiResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResponse<T> build() {
            return new ApiResponse<>(success, data);
        }
    }

    // Builder method
    public static <T> ApiResponseBuilder<T> builder() {
        return new ApiResponseBuilder<>();
    }

    // Optional: Override toString() for better readability in logs
    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", data=" + data +
                '}';
    }
}

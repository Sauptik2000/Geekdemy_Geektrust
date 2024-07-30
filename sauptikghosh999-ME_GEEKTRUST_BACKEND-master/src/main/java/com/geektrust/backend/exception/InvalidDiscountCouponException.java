package com.geektrust.backend.exception;

//Exception for invalid coupons
public class InvalidDiscountCouponException extends RuntimeException {

    public InvalidDiscountCouponException() {
        super();
    }

    public InvalidDiscountCouponException(String message) {
        super(message);
    }
}
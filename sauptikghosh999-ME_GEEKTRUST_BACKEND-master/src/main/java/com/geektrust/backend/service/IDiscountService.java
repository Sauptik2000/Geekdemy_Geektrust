package com.geektrust.backend.service;

public interface IDiscountService {
    void applyB4G1Discount();
    void applyDealG20Discount();
    void applyDealG5Discount();
    void applyNoDiscount();
}

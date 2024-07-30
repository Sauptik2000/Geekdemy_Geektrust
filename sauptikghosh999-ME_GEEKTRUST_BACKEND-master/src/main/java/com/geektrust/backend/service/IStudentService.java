package com.geektrust.backend.service;

public interface IStudentService {
    void addProgrammes(String programmeName, Integer quantity);
    void setProMembershipPlan();
    void addDiscountCoupon(String discountCoupon);
}

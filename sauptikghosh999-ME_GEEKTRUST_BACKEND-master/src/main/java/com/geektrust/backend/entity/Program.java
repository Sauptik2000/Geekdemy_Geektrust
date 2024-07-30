package com.geektrust.backend.entity;

//Interface for all programs offered by Geekdemy
public interface Program {
    ProgramCategory getProgram();
    Double getProgramFee();
    void addProgram(Integer quantity);
    Integer getProgramCount();
    Double getProgramDiscount();
    void addProMembershipDiscountCoupon();
    Double getProgramDiscountAmount();
}

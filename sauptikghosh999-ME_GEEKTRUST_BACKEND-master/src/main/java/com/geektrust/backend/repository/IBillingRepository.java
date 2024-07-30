package com.geektrust.backend.repository;

import com.geektrust.backend.entity.DiscountCoupon;

public interface IBillingRepository{
    void setTotalProgramFees(Double totalProgramFees);
    //void setDiscount(Discount discount);
    Double getProMembershipDiscount();
    void setProMembershipDiscount(Double proMembershipDiscount);
    Double getProMembershipFee();
    void addEnrollmentFee();
    Double getEnrollmentFee();
    void setTotalAmount(Double totalAmount);
    Double getTotalProgramFees();
    //Discount getDiscount();
    Double getTotalAmount();
    DiscountCoupon getCouponDiscount();
    void setCouponDiscount(DiscountCoupon discountCoupons);
    Double getDiscountAmount();
    void setDiscountAmount(Double discountAmount);
}

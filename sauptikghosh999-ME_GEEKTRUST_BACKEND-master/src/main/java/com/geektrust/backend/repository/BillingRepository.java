package com.geektrust.backend.repository;

import com.geektrust.backend.entity.DiscountCoupon;
import com.geektrust.backend.entity.Student;

public class BillingRepository implements IBillingRepository {

    private Student student;
    private Double totalProgramFees;
    private DiscountCoupon discountCoupons;
    private Double discountAmount;
    private Double proMembershipDiscount;
    private Double totalAmount;

    public BillingRepository(Student student) {
        this.student = student;
        totalProgramFees = 0.00;
        proMembershipDiscount = 0.00;
        totalAmount = 0.00;
    }

    @Override
    public void setTotalProgramFees(Double totalProgramFees) {
        this.totalProgramFees = totalProgramFees;
    }

    @Override
    public void setProMembershipDiscount(Double proMembershipDiscount) {
        this.proMembershipDiscount = proMembershipDiscount;
    }

    @Override
    public void addEnrollmentFee() {
        student.addEnrollmentFee();
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }


    @Override
    public Double getTotalProgramFees() {
        return totalProgramFees;
    }

    @Override
    public Double getProMembershipDiscount() {
        return proMembershipDiscount;
    }

    @Override
    public Double getProMembershipFee() {
        return student.getProMembershipFee();
    }

    @Override
    public Double getEnrollmentFee() {
        return student.getEnrollmentFee();
    }

    @Override
    public Double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public Double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;

    }

    @Override
    public DiscountCoupon getCouponDiscount() {
        return discountCoupons;
    }

    @Override
    public void setCouponDiscount(DiscountCoupon discountCoupons) {
        this.discountCoupons = discountCoupons;

    }
}

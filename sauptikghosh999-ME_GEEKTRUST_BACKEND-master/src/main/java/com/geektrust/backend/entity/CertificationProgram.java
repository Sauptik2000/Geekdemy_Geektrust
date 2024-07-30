package com.geektrust.backend.entity;

import com.geektrust.backend.utils.ApplicationConstants;

public class CertificationProgram implements Program {

    private final ProgramCategory programCategory;
    private Double programFees;
    private Integer count;
    private final Double programDiscount;

    private Double programDiscountAmount;

    public CertificationProgram() {
        programCategory = ProgramCategory.CERTIFICATION;
        programFees = ApplicationConstants.CERTIFICATION_FEES;
        count = 0;
        programDiscount = ApplicationConstants.CERTIFICATION_DISCOUNT;
        programDiscountAmount = 0.0;
    }

    @Override
    public ProgramCategory getProgram() {
        return programCategory;
    }

    @Override
    public Double getProgramFee() {
        return programFees;
    }

    @Override
    public void addProgram(Integer quantity) {
        count = count + quantity;
    }

    @Override
    public Integer getProgramCount() {
        return count;
    }

    @Override
    public Double getProgramDiscount() {
        return programDiscount;
    }

    @Override
    public void addProMembershipDiscountCoupon() {
        programDiscountAmount = programFees * programDiscount;
        programFees = programFees * (1 - programDiscount);
    }

    @Override
    public Double getProgramDiscountAmount() {
        return programDiscountAmount;
    }
}
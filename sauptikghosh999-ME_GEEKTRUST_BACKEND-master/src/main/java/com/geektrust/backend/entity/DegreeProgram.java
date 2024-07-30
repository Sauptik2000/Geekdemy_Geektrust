package com.geektrust.backend.entity;

import com.geektrust.backend.utils.ApplicationConstants;

public class DegreeProgram implements Program {

    private final ProgramCategory programCategory;
    private Double programFees;
    private final Double programDiscount;
    private Integer count;

    private Double programDiscountAmount;

    public DegreeProgram() {
        programCategory = ProgramCategory.DEGREE;
        programFees = ApplicationConstants.DEGREE_FEES;
        programDiscount = ApplicationConstants.DEGREE_DISCOUNT;
        count = 0;
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

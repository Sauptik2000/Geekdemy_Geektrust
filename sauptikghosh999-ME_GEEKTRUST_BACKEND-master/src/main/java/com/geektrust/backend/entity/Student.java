package com.geektrust.backend.entity;

import com.geektrust.backend.utils.ApplicationConstants;

//Student Entity
public class Student {
    private Boolean isProMember;
    private Double proMembershipFee;
    private Double enrollmentFee;

    public Student() {
        isProMember = ApplicationConstants.FALSE_VALUE;
        proMembershipFee = ApplicationConstants.DOUBLE_INITIALIZE_VALUE;
        enrollmentFee = ApplicationConstants.DOUBLE_INITIALIZE_VALUE;
    }

    public void addProMembershipPlan() {
        isProMember = true;
        proMembershipFee = ApplicationConstants.PRO_MEMBERSHIP_FEE;
    }

    public void addEnrollmentFee() {
        enrollmentFee = ApplicationConstants.ENROLLMENT_FEE;
    }

    public Boolean getProMembershipStatus() {
        return isProMember;
    }

    public Double getProMembershipFee() {
        return proMembershipFee;
    }

    public Double getEnrollmentFee() {
        return enrollmentFee;
    }

}

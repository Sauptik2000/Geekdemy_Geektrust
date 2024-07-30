package com.geektrust.backend.repository;

import com.geektrust.backend.entity.DiscountCoupon;
import com.geektrust.backend.entity.ProgramCategory;
import com.geektrust.backend.entity.Student;

public interface IStudentRepository {
    Integer getTotalProgrammeCount();
    Student getStudent();
    Integer getDegreeProgrammeCount();
    Double getDegreeProgrammeCost();
    Double getDegreeProgrammeDiscount();
    Integer getCertificationProgrammeCount();
    Double getCertificationProgrammeCost();
    Double getCertificationProgrammeDiscount();
    Integer getDiplomaProgrammeCount();
    Double getDiplomaProgrammeCost();
    Double getDiplomaProgrammeDiscount();
    void addProgramsToCart(ProgramCategory programmes, Integer quantity);
    void addProMembershipPlan();
    void addDiscountCoupons(DiscountCoupon discountCoupons);
    Boolean containsDiscountCoupon(DiscountCoupon discountCoupon);
    Double getCertificationProgrammeDiscountAmount();
    Double getDegreeProgrammeDiscountAmount();
    Double getDiplomaProgrammeDiscountAmount();
}

package com.geektrust.backend.service;

import com.geektrust.backend.entity.DiscountCoupon;
import com.geektrust.backend.entity.ProgramCategory;
import com.geektrust.backend.exception.InvalidDiscountCouponException;
import com.geektrust.backend.exception.InvalidProgramCategoryException;
import com.geektrust.backend.repository.IStudentRepository;

public class StudentService implements IStudentService {

    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addProgrammes(String programCategoryStr, Integer quantity) {
        try{
            ProgramCategory programCategory = ProgramCategory.valueOf(programCategoryStr);
            studentRepository.addProgramsToCart(programCategory, quantity);
        } catch(IllegalArgumentException e) {
            throw new InvalidProgramCategoryException("Invalid program category: " + programCategoryStr);
        }

    }

    @Override
    public void setProMembershipPlan() {
        studentRepository.addProMembershipPlan();
    }

    @Override
    public void addDiscountCoupon(String discountCouponStr) {
        try{
            DiscountCoupon discountCoupon = DiscountCoupon.valueOf(discountCouponStr);
            studentRepository.addDiscountCoupons(discountCoupon);
        } catch(IllegalArgumentException e) {
            throw new InvalidDiscountCouponException("Invalid discount coupon: " + discountCouponStr);
        }
    }

}
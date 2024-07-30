package com.geektrust.backend.commands;

import com.geektrust.backend.service.IStudentService;

import java.util.List;

public class ApplyCouponCommand implements ICommand{

    private final IStudentService studentService;

    public ApplyCouponCommand(IStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void execute(List<String> tokens) {
        String discountCoupon = tokens.get(1);
        studentService.addDiscountCoupon(discountCoupon);
    }
}
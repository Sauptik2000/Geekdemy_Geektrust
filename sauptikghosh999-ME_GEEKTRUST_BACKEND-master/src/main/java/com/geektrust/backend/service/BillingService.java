package com.geektrust.backend.service;

import com.geektrust.backend.dto.PrintBillDto;
import com.geektrust.backend.entity.DiscountCoupon;
import com.geektrust.backend.repository.IBillingRepository;
import com.geektrust.backend.repository.IStudentRepository;
import com.geektrust.backend.utils.ApplicationConstants;

public class BillingService implements IBillingService {

    private IStudentRepository studentRepository;
    private IBillingRepository billingRepository;

    private ICartService cartService;
    private IDiscountService discountService;

    public BillingService(IStudentRepository studentRepository, IBillingRepository billingRepository, ICartService cartService, IDiscountService discountService) {
        this.studentRepository = studentRepository;
        this.billingRepository = billingRepository;
        this.cartService = cartService;
        this.discountService = discountService;
    }


    private void calculateTotalCartItemCost() {
        cartService.calculateTotalCost();
        if(studentRepository.getStudent().getProMembershipStatus() == true) {
            cartService.calculateTotalProMembershipDiscount();
        }
    }

    private void calculateDiscount() {
        Integer totalProgrammeCount = studentRepository.getCertificationProgrammeCount() + studentRepository.getDegreeProgrammeCount() + studentRepository.getDiplomaProgrammeCount();
        if(totalProgrammeCount >= 4) {
            discountService.applyB4G1Discount();
        } else if(studentRepository.containsDiscountCoupon(DiscountCoupon.DEAL_G20) && billingRepository.getTotalProgramFees() >= ApplicationConstants.PROGRAMME_COST_FOR_G20_DISCOUNT) {
            discountService.applyDealG20Discount();
        } else if(studentRepository.containsDiscountCoupon(DiscountCoupon.DEAL_G5) && totalProgrammeCount >= ApplicationConstants.PROGRAMME_COUNT_FOR_G5_DISCOUNT) {
            discountService.applyDealG5Discount();
        } else {
            discountService.applyNoDiscount();
        }

    }

    private void checkEnrollmentElligibility() {
        Double totalAmount = billingRepository.getTotalAmount();
        if(totalAmount < ApplicationConstants.PROGRAMME_COST_TRESHOLD_FOR_ENROLLMENT_FEE) {
            billingRepository.addEnrollmentFee();
            billingRepository.setTotalAmount(billingRepository.getTotalAmount() + billingRepository.getEnrollmentFee());
        }
    }

    @Override
    public PrintBillDto calculateBill() {
        calculateTotalCartItemCost();
        calculateDiscount();
        checkEnrollmentElligibility();
        return new PrintBillDto(
                billingRepository.getTotalProgramFees(),
                billingRepository.getCouponDiscount(),
                billingRepository.getDiscountAmount(),
                billingRepository.getProMembershipDiscount(),
                billingRepository.getProMembershipFee(),
                billingRepository.getEnrollmentFee(),
                billingRepository.getTotalAmount());
    }
}


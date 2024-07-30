package com.geektrust.backend.service;

import com.geektrust.backend.entity.DiscountCoupon;
import com.geektrust.backend.repository.IBillingRepository;
import com.geektrust.backend.repository.IStudentRepository;
import com.geektrust.backend.utils.ApplicationConstants;

public class DiscountService implements IDiscountService{

    private IStudentRepository studentRepository;
    private IBillingRepository billingRepository;

    public DiscountService(IStudentRepository studentRepository,
                           IBillingRepository billingRepository) {
        this.studentRepository = studentRepository;
        this.billingRepository = billingRepository;
    }

    public void applyB4G1Discount() {
        billingRepository.setCouponDiscount(DiscountCoupon.B4G1);
        Double discountAmount = 0.0;
        if(studentRepository.getDiplomaProgrammeCount() > 0) {
            discountAmount = studentRepository.getDiplomaProgrammeCost();
        } else if(studentRepository.getCertificationProgrammeCount() > 0) {
            discountAmount = studentRepository.getCertificationProgrammeCost();
        } else {
            discountAmount = studentRepository.getDegreeProgrammeCost();
        }
        billingRepository.setDiscountAmount(discountAmount);
        billingRepository.setTotalAmount(billingRepository.getTotalAmount() - discountAmount);
    }

    public void applyDealG20Discount() {
        billingRepository.setCouponDiscount(DiscountCoupon.DEAL_G20);
        billingRepository.setDiscountAmount(billingRepository.getTotalProgramFees() * ApplicationConstants.DEAL_G20_DISCOUNT);
        billingRepository.setTotalAmount(billingRepository.getTotalAmount() - billingRepository.getDiscountAmount());
    }

    public void applyDealG5Discount() {
        billingRepository.setCouponDiscount(DiscountCoupon.DEAL_G5);
        billingRepository.setDiscountAmount(billingRepository.getTotalProgramFees() * ApplicationConstants.DEAL_G5_DISCOUNT);
        billingRepository.setTotalAmount(billingRepository.getTotalAmount() - billingRepository.getDiscountAmount());
    }

    public void applyNoDiscount() {
        billingRepository.setCouponDiscount(DiscountCoupon.NONE);
        billingRepository.setDiscountAmount(0.0);
    }
}
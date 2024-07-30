package com.geektrust.backend.service;

import com.geektrust.backend.repository.IBillingRepository;
import com.geektrust.backend.repository.IStudentRepository;

public class CartService implements ICartService {

    private IStudentRepository studentRepository;
    private IBillingRepository billingRepository;

    public CartService(IStudentRepository studentRepository, IBillingRepository billingRepository) {
        this.billingRepository = billingRepository;
        this.studentRepository = studentRepository;
    }

    public void calculateTotalCost() {
        Double totalCost = 0.0;
        totalCost += studentRepository.getCertificationProgrammeCount() * studentRepository.getCertificationProgrammeCost();
        totalCost += studentRepository.getDegreeProgrammeCount() * studentRepository.getDegreeProgrammeCost();
        totalCost += studentRepository.getDiplomaProgrammeCount() * studentRepository.getDiplomaProgrammeCost();
        totalCost += billingRepository.getProMembershipFee();
        billingRepository.setTotalProgramFees(totalCost);
        billingRepository.setTotalAmount(totalCost);
    }

    public void calculateTotalProMembershipDiscount() {
        Double proMembershipDiscount = 0.0;
        proMembershipDiscount += studentRepository.getCertificationProgrammeCount() * studentRepository.getCertificationProgrammeDiscountAmount();
        proMembershipDiscount += studentRepository.getDegreeProgrammeCount() * studentRepository.getDegreeProgrammeDiscountAmount();
        proMembershipDiscount += studentRepository.getDiplomaProgrammeCount() * studentRepository.getDiplomaProgrammeDiscountAmount();
        billingRepository.setProMembershipDiscount(proMembershipDiscount);
    }
}

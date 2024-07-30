package com.geektrust.backend.repository;

import com.geektrust.backend.entity.*;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{

    private Student student;
    private Program certificationProgram;
    private Program degreeProgram;
    private Program diplomaProgram;
    private List<DiscountCoupon> discountCoupons;

    public StudentRepository(Student student){
        this.student = student;
        certificationProgram = new CertificationProgram();
        degreeProgram = new DegreeProgram();
        diplomaProgram = new DiplomaProgram();
        discountCoupons = new ArrayList<>();
    }

    public StudentRepository(Student student, CertificationProgram certificationProgram, DegreeProgram degreeProgram, DiplomaProgram diplomaProgram){
        this(student);
        this.certificationProgram = certificationProgram;
        this.degreeProgram = degreeProgram;
        this.diplomaProgram = diplomaProgram;
        discountCoupons = new ArrayList<>();
    }

    public Student getStudent() {
        return student;
    }

    public Integer getTotalProgrammeCount() {
        return certificationProgram.getProgramCount() + degreeProgram.getProgramCount() + diplomaProgram.getProgramCount();
    }

    @Override
    public void addProgramsToCart(ProgramCategory programCategory, Integer quantity) {
        if(programCategory == ProgramCategory.CERTIFICATION) {
            certificationProgram.addProgram(quantity);
        }
        else if(programCategory == ProgramCategory.DEGREE) {
            degreeProgram.addProgram(quantity);
        }
        else {
            diplomaProgram.addProgram(quantity);
        }
    }

    @Override
    public void addProMembershipPlan() {
        student.addProMembershipPlan();
        certificationProgram.addProMembershipDiscountCoupon();
        degreeProgram.addProMembershipDiscountCoupon();
        diplomaProgram.addProMembershipDiscountCoupon();

    }

    @Override
    public Integer getDegreeProgrammeCount() {
        return degreeProgram.getProgramCount();
    }

    @Override
    public Integer getCertificationProgrammeCount() {
        return certificationProgram.getProgramCount();
    }

    @Override
    public Integer getDiplomaProgrammeCount() {
        return diplomaProgram.getProgramCount();
    }

    @Override
    public void addDiscountCoupons(DiscountCoupon discountCoupon) {
        discountCoupons.add(discountCoupon);

    }

    @Override
    public Double getDegreeProgrammeCost() {
        return degreeProgram.getProgramFee();
    }

    @Override
    public Double getCertificationProgrammeCost() {
        return certificationProgram.getProgramFee();
    }

    @Override
    public Double getDiplomaProgrammeCost() {
        return diplomaProgram.getProgramFee();
    }

    @Override
    public Double getDegreeProgrammeDiscount() {
        return degreeProgram.getProgramDiscount();
    }

    @Override
    public Double getCertificationProgrammeDiscount() {
        return certificationProgram.getProgramDiscount();
    }

    @Override
    public Double getDiplomaProgrammeDiscount() {
        return diplomaProgram.getProgramDiscount();
    }

    @Override
    public Boolean containsDiscountCoupon(DiscountCoupon discountCoupon) {
        return discountCoupons.contains(discountCoupon);
    }

    @Override
    public Double getCertificationProgrammeDiscountAmount() {
        return certificationProgram.getProgramDiscountAmount();
    }

    @Override
    public Double getDegreeProgrammeDiscountAmount() {
        return degreeProgram.getProgramDiscountAmount();
    }

    @Override
    public Double getDiplomaProgrammeDiscountAmount() {
        return diplomaProgram.getProgramDiscountAmount();
    }
}

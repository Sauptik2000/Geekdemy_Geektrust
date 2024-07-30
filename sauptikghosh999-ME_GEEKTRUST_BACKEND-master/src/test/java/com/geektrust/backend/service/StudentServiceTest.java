package com.geektrust.backend.service;

import com.geektrust.backend.entity.DiscountCoupon;
import com.geektrust.backend.entity.ProgramCategory;
import com.geektrust.backend.exception.InvalidDiscountCouponException;
import com.geektrust.backend.exception.InvalidProgramCategoryException;
import com.geektrust.backend.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("StudentServiceTest")
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    private IStudentService studentService;

    private IStudentRepository studentRepository;

    @BeforeEach
    public void setup() {
        studentRepository = Mockito.mock(IStudentRepository.class);
        studentService = new StudentService(studentRepository);
    }
    
    @Test
    void addProgrammes() {
        studentService.addProgrammes("DEGREE", 2);
        verify(studentRepository, times(1)).addProgramsToCart(ProgramCategory.DEGREE, 2);
    }

    @Test
    void addInvalidProgrammes() {
        assertThrows(InvalidProgramCategoryException.class, () -> studentService.addProgrammes("INVALID_PROGRAM", 2));
    }

    @Test
    void setProMembershipPlan() {
        studentService.setProMembershipPlan();
        verify(studentRepository, times(1)).addProMembershipPlan();
    }

    @Test
    void addValidDiscountCoupon() {
        studentService.addDiscountCoupon("DEAL_G20");
        verify(studentRepository, times(1)).addDiscountCoupons(DiscountCoupon.DEAL_G20);
    }

    @Test
    void addInvalidDiscountCoupon() {
        assertThrows(InvalidDiscountCouponException.class, () -> studentService.addDiscountCoupon("INVALID_COUPON"));
    }
}

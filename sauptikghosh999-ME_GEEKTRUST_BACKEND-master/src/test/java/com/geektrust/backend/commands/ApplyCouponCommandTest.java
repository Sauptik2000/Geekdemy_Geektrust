package com.geektrust.backend.commands;

import com.geektrust.backend.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

//Test class for ApplyCouponCommand
@DisplayName("ApplyCouponCommand Test")
@ExtendWith(MockitoExtension.class)
class ApplyCouponCommandTest {

    private ICommand applyCouponCommand;

    private IStudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = Mockito.mock(IStudentService.class);
        applyCouponCommand = new ApplyCouponCommand(studentService);
    }

    @Test
    void execute() {
        applyCouponCommand.execute(Arrays.asList("APPLY_COUPON", "DEAL_G20"));
        verify(studentService, times(1)).addDiscountCoupon("DEAL_G20");
    }
}


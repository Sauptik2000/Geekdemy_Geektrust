package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.*;
import com.geektrust.backend.entity.Student;
import com.geektrust.backend.repository.BillingRepository;
import com.geektrust.backend.repository.IBillingRepository;
import com.geektrust.backend.repository.IStudentRepository;
import com.geektrust.backend.repository.StudentRepository;
import com.geektrust.backend.service.*;

public class ApplicationConfig {
    Student student = new Student();
    private final IStudentRepository studentRepository = new StudentRepository(student);
    private final IBillingRepository billingRepository = new BillingRepository(student);
    private final ICartService cartService = new CartService(studentRepository, billingRepository);
    private final IDiscountService discountService = new DiscountService(studentRepository, billingRepository);
    private final IStudentService studentService = new StudentService(studentRepository);
    private final IBillingService billingService = new BillingService(studentRepository, billingRepository, cartService, discountService);

    private final AddProgramCommand addProgrammeCommand = new AddProgramCommand(studentService);
    private final ApplyCouponCommand applyCouponCommand = new ApplyCouponCommand(studentService);
    private final AddProMembershipCommand addProMembershipCommand = new AddProMembershipCommand(studentService);
    private final PrintBillCommand printBillCommand = new PrintBillCommand(billingService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
        commandInvoker.register("ADD_PROGRAMME",addProgrammeCommand);
        commandInvoker.register("APPLY_COUPON", applyCouponCommand);
        commandInvoker.register("ADD_PRO_MEMBERSHIP", addProMembershipCommand);
        commandInvoker.register("PRINT_BILL", printBillCommand);

        return commandInvoker;
    }

}

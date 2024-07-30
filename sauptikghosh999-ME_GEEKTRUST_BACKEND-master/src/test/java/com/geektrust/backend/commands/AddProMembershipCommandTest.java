package com.geektrust.backend.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.Collections;
import com.geektrust.backend.service.IStudentService;

//Test class for AddProMembershipCommand
@DisplayName("AddProMembershipCommand Test")
@ExtendWith(MockitoExtension.class)
class AddProMembershipCommandTest {

    private ICommand addProMembershipCommand;

    private IStudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = Mockito.mock(IStudentService.class);
        addProMembershipCommand = new AddProMembershipCommand(studentService);
    }

    @Test
    void execute() {
        addProMembershipCommand.execute(Collections.emptyList());
        verify(studentService, times(1)).setProMembershipPlan();
    }
}
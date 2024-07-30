package com.geektrust.backend.commands;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import com.geektrust.backend.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//Test class for AddProgramCommand
@DisplayName("AddProgramCommand Test")
@ExtendWith(MockitoExtension.class)
public class AddProgramCommandTest {
    private ICommand addProgramCommand;

    private IStudentService studentService;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        studentService = Mockito.mock(IStudentService.class);
        addProgramCommand = new AddProgramCommand(studentService);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void execute() {
        addProgramCommand.execute(Arrays.asList("ADD_PROGRAMME", "DEGREE", "2"));
        verify(studentService, times(1)).addProgrammes("DEGREE", 2);
    }
}

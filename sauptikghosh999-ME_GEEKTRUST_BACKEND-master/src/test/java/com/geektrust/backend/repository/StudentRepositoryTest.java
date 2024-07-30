package com.geektrust.backend.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.geektrust.backend.entity.*;

//Test Class for StudentRepository
@DisplayName("StudentRepository Test")
@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    private StudentRepository studentRepository;
    private Student student;
    private CertificationProgram certificationProgram;
    private DegreeProgram degreeProgram;
    private DiplomaProgram diplomaProgram;

    @BeforeEach
    public void setup() {
        student = Mockito.mock(Student.class);
        certificationProgram = Mockito.mock(CertificationProgram.class);
        degreeProgram = Mockito.mock(DegreeProgram.class);
        diplomaProgram = Mockito.mock(DiplomaProgram.class);

        studentRepository = new StudentRepository(student, certificationProgram, degreeProgram, diplomaProgram);
    }

    @Test
    public void testAddProgramsToCart() {
        studentRepository.addProgramsToCart(ProgramCategory.CERTIFICATION, 2);
        Mockito.verify(certificationProgram, Mockito.times(1)).addProgram(2);

        studentRepository.addProgramsToCart(ProgramCategory.DEGREE, 3);
        Mockito.verify(degreeProgram, Mockito.times(1)).addProgram(3);

        studentRepository.addProgramsToCart(ProgramCategory.DIPLOMA, 4);
        Mockito.verify(diplomaProgram, Mockito.times(1)).addProgram(4);
    }

    @Test
    public void testGetTotalProgrammeCount() {
        when(certificationProgram.getProgramCount()).thenReturn(2);
        when(degreeProgram.getProgramCount()).thenReturn(3);
        when(diplomaProgram.getProgramCount()).thenReturn(4);

        Integer totalProgrammeCount = studentRepository.getTotalProgrammeCount();

        assertEquals(9, totalProgrammeCount);
    }
}
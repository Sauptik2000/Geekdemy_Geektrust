package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Test class for App
@DisplayName("App Test")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor,true));
    }

    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){
        //Arrange
        String argument= "sample_input/input1.txt";
        String expectedOutput = "SUB_TOTAL 13000.00\n" +
                "COUPON_DISCOUNT B4G1 2500.00\n" +
                "TOTAL_PRO_DISCOUNT 0.00\n" +
                "PRO_MEMBERSHIP_FEE 0.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 10500.00";
        //Act
        App.run(Collections.singletonList(argument));
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        //Arrange
        String argument= "sample_input/input2.txt";
        String expectedOutput = "SUB_TOTAL 10000.00\n" +
                "COUPON_DISCOUNT DEAL_G20 2000.00\n" +
                "TOTAL_PRO_DISCOUNT 0.00\n" +
                "PRO_MEMBERSHIP_FEE 0.00\n" +
                "ENROLLMENT_FEE 0.00\n" +
                "TOTAL 8000.00";
        //Act
        App.run(Collections.singletonList(argument));
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }
}

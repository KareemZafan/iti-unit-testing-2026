package org.iti.tests;


import org.iti.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeTests {

    @Mock
    Employee employee;

    @Test
    void testEmployeeTotalIncomeGreaterThan10000() {

        when(employee.getSalary()).thenReturn(5000.00);


        assertTrue((employee.getSalary() * 12.00) > 10000.00);

        verify(employee).getSalary();


    }


}

package org.example.Shop.People;

import org.example.Shop.Building.Shop;
import org.example.Shop.Employee.SecurityGuard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SecurityGuardTest {

    @Test
    void testWorkExtra() {
        Shop magnit = new Shop("Magnit");
        SecurityGuard securityGuard = new SecurityGuard(magnit, "Julia", 34, GenderType.Woman, 25_000, 14);

        securityGuard.work(5);
        securityGuard.workExtra(7);

        assertEquals(0, securityGuard.getExtraWorkingHours());
    }

    @Test
    void testGetExtraWorkingHours() {
        Shop magnit = new Shop("Magnit");
        SecurityGuard securityGuard = new SecurityGuard(magnit, "Julia", 34, GenderType.Woman, 25_000, 14);

        securityGuard.work(15);
        securityGuard.workExtra(7);

        assertEquals(8, securityGuard.getExtraWorkingHours());
    }

    @Test
    void testCalculateSalary() {
        Shop magnit = new Shop("Magnit");
        SecurityGuard securityGuard = new SecurityGuard(magnit, "Julia", 34, GenderType.Woman, 25_000, 14);

        securityGuard.work(15);
        double salary = securityGuard.calculateSalary();
        assertEquals(25_100, salary);
    }

    @Test
    void testNewDayWork() {
        Shop magnit = new Shop("Magnit");
        SecurityGuard securityGuard = new SecurityGuard(magnit, "Julia", 34, GenderType.Woman, 25_000, 14);

        securityGuard.newDayWork();
        securityGuard.work(15);

        assertTrue(securityGuard.isWorked());
    }
}
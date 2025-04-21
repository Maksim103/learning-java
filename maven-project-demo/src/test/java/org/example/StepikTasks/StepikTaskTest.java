package org.example.StepikTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StepikTaskTest {

    @Test
    public void shouldPassFirstTest() {
        long[] numbers = new long[] {1, 2, 1, 3, 5};
        Assertions.assertEquals(16, StepikTask.solution(5, 2, numbers));
    }

    @Test
    public void shouldPassSecondTest() {
        long[] numbers = new long[] {99, 5, 85};
        Assertions.assertEquals(10, StepikTask.solution(3, 1, numbers));
    }

    @Test
    public void shouldPassThirdTest() {
        long[] numbers = new long[] {9999};
        Assertions.assertEquals(0, StepikTask.solution(1, 10, numbers));
    }
}
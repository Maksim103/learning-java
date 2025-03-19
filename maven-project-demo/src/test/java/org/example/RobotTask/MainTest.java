package org.example.RobotTask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @DisplayName("Should Move Robot To The Specified Coordinates")
    @Test
    public void shouldMoveRobot() {
        Robot robot = new Robot(0, 0, Direction.UP);
        Robot.moveRobot(robot, 22, -12);

        assertEquals(22, robot.getX());
        assertEquals(-12, robot.getY());
    }

    @DisplayName("Should Throw RobotConnectionException When Move Robot")
    @Test
    public void shouldThrowRobotConnectionExceptionWhenMoveRobot() {
        Robot robot = new Robot(0, 0, Direction.UP);
    }
}
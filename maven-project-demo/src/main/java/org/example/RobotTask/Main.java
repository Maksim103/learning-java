package org.example.RobotTask;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(-22, 65, Direction.UP);

        int toX = -14;
        int toY = 5;
        Robot.moveRobot(robot, toX, toY);

        System.out.println(robot.getX() + " - x");
        System.out.println(robot.getY() + " - y");
    }
}

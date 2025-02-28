package Robot;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(-22, 65, Direction.UP);

        int toX = -14;
        int toY = 5;
        Robot.moveRobot(robot, toX, toY);

        System.out.println(robot.getX() + " - x");
        System.out.println(robot.getY() + " - y");
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        for (int i = 0; i < 3; i++) {
            try {
                RobotConnection robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);

                robotConnection.close();
            } catch (RobotConnectionException e) {
                robotConnectionManager.getConnection().close();
            }
        }
    }
}

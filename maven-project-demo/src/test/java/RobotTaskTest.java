import org.example.RobotTask.Direction;
import org.example.RobotTask.Robot;

public class RobotTaskTest {
    public static void main(String[] args) {

        Robot robot = new Robot(4, 9, Direction.UP);
        int toX = -14;
        int toY = 5;
        Robot.moveRobot(robot, toX, toY);
    }
}

public class RobotTask {
    public static void main(String[] args) {
        Robot robot = new Robot(-22, 65, Direction.UP);

        int toX = -14;
        int toY = 5;
        Robot.moveRobot(robot, toX, toY);

        System.out.println(robot.getX() + " - x");
        System.out.println(robot.getY() + " - y");
    }
}

class Robot {
    int x;
    int y;
    Direction dir;

    public Robot (int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Direction getDirection() {return dir;}

    public int getX() {return x;}

    public int getY() {return y;}

    public void turnLeft() {
        if      (dir == Direction.UP)    {dir = Direction.LEFT;}
        else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
        else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
        else if (dir == Direction.RIGHT) {dir = Direction.UP;}
    }

    public void turnRight() {
        if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
        else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
        else if (dir == Direction.LEFT)  {dir = Direction.UP;}
        else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
    }

    public void stepForward() {
        if      (dir == Direction.UP)    {y++;}
        else if (dir == Direction.DOWN)  {y--;}
        else if (dir == Direction.LEFT)  {x--;}
        else if (dir == Direction.RIGHT) {x++;}
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (robot.getX() == toX && robot.getY() == toY)
            return;

        int startX = robot.getX();
        int startY = robot.getY();
        Direction toDirectionX = Direction.RIGHT;
        Direction toDirectionY = Direction.UP;

        if (toX < startX)  toDirectionX = Direction.LEFT;
        if (toY < startY)  toDirectionY = Direction.DOWN;

        int shortPathX = calculatePathForTurn(robot.getDirection(), toDirectionX);








        /*  Not Optimized
        while (robot.getDirection() != toDirectionX) {
            robot.turnRight();
        }

        for (int i = 0; i < Math.abs(toX-startX); i++) {
            robot.stepForward();
        }

        while (robot.getDirection() != toDirectionY) {
            robot.turnRight();
        }

        for (int i = 0; i < Math.abs(toY-startY); i++) {
            robot.stepForward();
        }
        */
    }

    private static int calculatePathForTurn(Direction currentDirection, Direction targetDirection) {
        System.out.println(currentDirection.ordinal());
        System.out.println(targetDirection.ordinal());

        return 0;
    }
}

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

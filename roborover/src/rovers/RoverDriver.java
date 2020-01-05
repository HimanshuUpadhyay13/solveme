package rovers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoverDriver {

    int x;
    int y;
    int currentFacing = Facing.NORTH.getFacing();

    public void setCurrentPosition(Integer x, Integer y, Integer currentFacing) {
        this.x = x;
        this.y = y;
        this.currentFacing = currentFacing;
    }
    public RoverDriver getCurrentPosition()
    {
        return this;
    }
    public void print() {
        char dir = 'N';
        if (currentFacing == 1) {
            dir = 'N';
        } else if (currentFacing == 2) {
            dir = 'E';
        } else if (currentFacing == 3) {
            dir = 'S';
        } else if (currentFacing == 4) {
            dir = 'W';
        }
        System.out.println(x + " " + y + " " + dir);
    }

    public static void main(String[] args) {
        testDrive();


    }

    public static void testDrive() {
        RoverDriver driver = new RoverDriver();
        driver.setCurrentPosition(1, 2, Facing.NORTH.getFacing());
        String[] commandList = new String[]{"LMLMLMLMM", "MMRMMRMRRM", "MMRMMRMRRMLMLMLML"};
        List<String> driveCommands = new ArrayList<>(Arrays.asList(commandList));
        for (String command : driveCommands) {
            driver.drive(command);
            driver.print();
        }
    }

    public void drive(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            processCommands(commands.charAt(idx));
        }
    }

    private void processCommands(Character command) {
        if (command.equals('L')) {
            moveLeft();
        } else if (command.equals('R')) {
            moveRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Speak in Mars language, please!");
        }
    }

    private void moveLeft() {
        currentFacing = (currentFacing - 1) < Facing.NORTH.getFacing() ? Facing.WEST.getFacing() : currentFacing - 1;
    }

    private void moveRight() {
        currentFacing = (currentFacing + 1) > Facing.WEST.getFacing() ? Facing.NORTH.getFacing() : currentFacing + 1;
    }

    private void move() {
        if (currentFacing == Facing.NORTH.getFacing()) {
            this.y++;
        } else if (currentFacing == Facing.EAST.getFacing()) {
            this.x++;
        } else if (currentFacing == Facing.SOUTH.getFacing()) {
            this.y--;
        } else if (currentFacing == Facing.WEST.getFacing()) {
            this.x--;
        }
    }

}


enum Facing {
    NORTH(1), EAST(2), SOUTH(3), WEST(4);
    private final int facing;

    Facing(final int newFacing) {
        facing = newFacing;
    }

    public int getFacing() {
        return facing;
    }

}

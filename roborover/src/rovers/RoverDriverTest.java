package rovers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverDriverTest {



    @Test
    public void testCurrentPos()
    {
        int x=1;
        int y=1;
        int facing=Facing.NORTH.getFacing();
        RoverDriver driver=new RoverDriver();
        driver.setCurrentPosition(x,y,facing);
        Assert.assertTrue(driver.getCurrentPosition().currentFacing==facing && driver.getCurrentPosition().x==x && driver.y==y);
    }

    @Test
    public void testDriver()
    {
        int x=1;
        int y=3;
        int facing=Facing.NORTH.getFacing();
        RoverDriver driver=new RoverDriver();
        driver.setCurrentPosition(1,2,Facing.NORTH.getFacing());
        driver.drive("LMLMLMLMM");
        Assert.assertTrue(driver.getCurrentPosition().currentFacing==facing && driver.getCurrentPosition().x==x && driver.y==y);
    }
}
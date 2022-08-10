import org.testng.Assert;
import org.testng.annotations.Test;

public class WriterTest {

    @Test
    public void testHelloWorld(){

        Assert.assertEquals(Writer.getText(), "Hello World!");
    }
}
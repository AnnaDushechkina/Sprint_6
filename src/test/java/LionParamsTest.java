import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamsTest {

    static Feline felineMock = Mockito.mock(Feline.class);

    private String sex;

    public LionParamsTest(Feline felineMock, String sex) {
        this.felineMock = felineMock;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {felineMock, "Самец"}, {felineMock, "Самка"}
        };
    }

    @Test
    public void newLionReturnNotHasManeTest() throws Exception {
        Lion lionGirl = new Lion(felineMock, "Самка");
        assertFalse(lionGirl.doesHaveMane());
    }

    @Test
    public void newLionReturnHasManeTest() throws Exception {
        Lion lionBoy = new Lion(felineMock, "Самец");
        assertTrue(lionBoy.doesHaveMane());
    }
}
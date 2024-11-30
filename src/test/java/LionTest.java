import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.Feline;
import com.example.Lion;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    static Feline felineMock = Mockito.mock(Feline.class);

    @Test
    public void getKittenTest() throws Exception {
        Lion actualLion = new Lion(new Feline(), "Самец");
        assertEquals(1, actualLion.getKittens());
    }

    @Test
    public void newLionSexExceptionTest() {
        assertThrows(Exception.class, () -> new Lion(felineMock, "Sex"));
    }

    @Test
    public void getFoodLionWithFelinePredatorTest() throws Exception {
        Lion actualLion = new Lion(new Feline(), "Самец");
        List<String> actualFood = actualLion.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertTrue(expectedFood.size() == actualFood.size()
                && expectedFood.containsAll(actualFood)
                && actualFood.containsAll(expectedFood));
    }
}
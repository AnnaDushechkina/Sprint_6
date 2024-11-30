import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

import com.example.Animal;

public class AnimalTest {

    @Test
    public void testGetFood_when_thenReturnSizeIsThree() throws Exception {
        List<String> actualFood = (new Animal()).getFood("Хищник");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertThat(expectedFood, is(actualFood));
    }

    @Test
    public void testGetFood_when_thenReturnSizeIsTwo() throws Exception {
        List<String> actualFood = (new Animal()).getFood("Травоядное");
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertThat(expectedFood, is(actualFood));
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                (new Animal()).getFamily());
    }

    @Test
    public void getFoodAnimalExceptionTest() {
        assertThrows("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                Exception.class, () -> (new Animal()).getFood("Шаурма"));
    }

}
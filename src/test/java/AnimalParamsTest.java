import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.example.Animal;

@RunWith(Parameterized.class)
public class AnimalParamsTest {

  private final List<String> foodOfPredatorList;
  private final List<String> foodOfHerbList;

  public static final int PREDATOR_EAT_COUNT = 3;
  public static final int HERB_EAT_COUNT = 2;

  public AnimalParamsTest(List<String> foodOfPredatorList,List<String> foodOfHerbList) {
    this.foodOfPredatorList = foodOfPredatorList;
    this.foodOfHerbList = foodOfHerbList;
  }

  @Parameterized.Parameters
  public static Object[][] getPredatorFoodData() {
    return new Object[][]{
            {List.of("Животные","Птицы","Рыба")
                    ,List.of("Трава","Различные растения")},
    };
  }


  @Test
  public void getFoodPredatorTest() throws Exception {
    List<String> actualFood = (new Animal()).getFood("Хищник");
    assertEquals(PREDATOR_EAT_COUNT,actualFood.size());
    assertThat(actualFood, is(foodOfPredatorList));
  }

  @Test
  public void getFoodHerbivoreTest() throws Exception {
    List<String> actualFood = (new Animal()).getFood("Травоядное");
    assertEquals(HERB_EAT_COUNT,actualFood.size());
    assertThat(actualFood, is(foodOfHerbList));

  }

  @Test
  public void getFamilyTest() {
    assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
            (new Animal()).getFamily());
  }

  @Test
  public void getFoodAnimalExceptionTest(){
    assertThrows("Неизвестный вид животного, используйте значение Травоядное или Хищник",
            Exception.class, () -> (new Animal()).getFood("Шаурма"));
  }


}
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Cat;
import com.example.Feline;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

  Cat cat;

  Feline felineMock = Mockito.mock(Feline.class);

  @Before
  public void createCat() {
    cat = new Cat(felineMock);
    MockitoAnnotations.openMocks(this);

  }

  @Test
  public void getFoodCatPredatorTest() throws Exception {
    Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    List<String> expectedFood =  List.of("Животные", "Птицы", "Рыба");
    List<String> actualFood = cat.getFood();

    assertThat(expectedFood, is(actualFood));
  }

  @Test
  public void getSoundReturnValueTest() {
    assertEquals("Мяу", cat.getSound());
  }
}

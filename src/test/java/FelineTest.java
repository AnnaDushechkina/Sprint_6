import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.Feline;

public class FelineTest {

  @Test
  public void eatMeatTest() throws Exception {
    List<String> actualEatMeatResult = (new Feline()).eatMeat();
    List<String> expectedEatMeatResult = List.of("Животные", "Птицы", "Рыба");

    assertThat(expectedEatMeatResult, is(actualEatMeatResult));
  }


  @Test
  public void getFamilyTest() {
    assertEquals("Кошачьи", (new Feline()).getFamily());
  }


  @Test
  public void getKittensTest() {
    assertEquals(1, (new Feline()).getKittens());
  }


  @Test
  public void getKittensWithIntTest() {
    assertEquals(3, (new Feline()).getKittens(3));
  }
}

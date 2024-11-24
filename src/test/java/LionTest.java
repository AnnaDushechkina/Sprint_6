import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.example.Feline;
import com.example.Lion;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

  Lion lion;

  @Mock
  Feline felineMock;

  @Before
  public void createLion() {
    lion = new Lion(felineMock);
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void haveManeLionSexReturnFalseTest() throws Exception {
    assertFalse((new Lion("Самка")).doesHaveMane());
  }


  @Test
  public void haveManeLionSexReturnTrueTest() throws Exception {
    assertTrue((new Lion("Самец")).doesHaveMane());
  }


  @Test
  public void getFoodLionWithFelinePredatorTest() throws Exception {
    Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    List<String> actualFood = (new Lion(felineMock)).getFood();
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

    assertThat(expectedFood, is(actualFood));
  }


  @Test
  public void newLionTest()  {
    Lion actualLion = new Lion(new Feline());
    assertEquals(1, actualLion.getKittens());
    assertFalse(actualLion.hasMane);
  }


  @Test
  public void newLionReturnNotHasManeTest() throws Exception {
    assertFalse((new Lion("Самка")).hasMane);
  }


  @Test
  public void newLionReturnHasManeTest() throws Exception {
    assertTrue((new Lion("Самец")).hasMane);
  }


  @Test
  public void newLionSexExceptionTest()  {
    assertThrows(Exception.class, () -> new Lion("Sex"));
  }
}

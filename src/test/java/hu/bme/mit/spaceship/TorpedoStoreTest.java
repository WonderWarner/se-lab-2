package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//teszt után a lefedettséghez terminálba: "./mvnw jacoco:prepare-agent test install jacoco:report"

class TorpedoStoreTest {

  @Test
  void testIsEmptyTrue(){
    // Arrange
    TorpedoStore store = new TorpedoStore(0);

    // Act
    boolean result = store.isEmpty();

    // Assert
    assertEquals(true, result);
  }
  @Test
  void testIsEmptyFalse(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.isEmpty();

    // Assert
    assertEquals(false, result);
  }
  @Test
  void testGetTorpedoCount(){
    // Arrange
    TorpedoStore store = new TorpedoStore(3);

    // Act
    int result = store.getTorpedoCount();

    // Assert
    assertEquals(3, result);
  }
  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }

  @Test
  void fire_FailTooMany(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);
    // Assert
    assertThrowsExactly(IllegalArgumentException.class, () -> { store.fire(2); });
  }

  @Test
  void fire_FailNegative(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);
    // Assert
    assertThrowsExactly(IllegalArgumentException.class, () -> { store.fire(-1); });
  }

   @Test
  void fire_FailFailureRand(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1, 1.0);

    // Assert
    assertFalse(store.fire(1));
  }


}

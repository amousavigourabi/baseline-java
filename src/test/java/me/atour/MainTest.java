package me.atour;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  void wrappedOneEqualsOne() {
    Main.main(null);
    assertThat(Integer.valueOf(1)).isEqualTo(1);
  }
}

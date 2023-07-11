package me.atour;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

  @Test
  void wrappedOneEqualsOne() {
    assertThat(Integer.valueOf(1)).isEqualTo(1);
  }
}

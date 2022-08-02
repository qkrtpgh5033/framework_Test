package com.ll.exam;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloServletTest {
    @Test
    public void junit_aseerThat() {
        int rs = 10+20;
        Assertions.assertThat(rs).isEqualTo(30);
    }
}
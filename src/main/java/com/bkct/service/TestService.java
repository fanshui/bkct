package com.bkct.service;

import org.springframework.stereotype.Service;

@Service(value = "sumTwoInt")
public class TestService {
    public int sum(int a, int b) {
        return a + b;
    }
}

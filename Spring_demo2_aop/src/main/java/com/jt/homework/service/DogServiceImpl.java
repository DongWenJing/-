package com.jt.homework.service;

import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {
    @Override
    public void eat() {
        System.out.println("狗行千里~");
        int a = 1/0;
    }
}

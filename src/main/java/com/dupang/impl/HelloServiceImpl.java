package com.dupang.impl;

import com.dupang.service.HelloService;
import com.sun.javafx.collections.SourceAdapterChange;
import org.springframework.stereotype.Service;

/**
 * Created by dupang on 2016/11/14.
 */
@Service
public class HelloServiceImpl implements HelloService {
    public void sayHello(String name) {
        System.out.println("Hello to"+ name);
    }
}

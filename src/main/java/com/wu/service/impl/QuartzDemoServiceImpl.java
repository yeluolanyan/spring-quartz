package com.wu.service.impl;

import com.wu.service.QuartzDemoService;
import org.springframework.stereotype.Service;

/**
 * Created by MJN on 2017/6/22.
 */
@Service
public class QuartzDemoServiceImpl implements QuartzDemoService {

    @Override
    public void printUserInfo() {

        System.out.println("*    服务器1 -----   current username is " + System.getProperty("user.name"));
        System.out.println("*    服务器1  -----   current os name is " + System.getProperty("os.name"));

    }

    @Override
    public void printUserInfo2() {

        System.out.println("--------------------------" );

    }
}

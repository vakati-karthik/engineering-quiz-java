package com.revinate.requestbin.bin;

import com.revinate.requestbin.bin.model.Bin;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinControllerTest {
    @Autowired
    private BinController controller;

    @Test(expected = NotImplementedException.class)
    public void getAllBin(){
        controller.getAll();
    }

    @Test(expected = NotImplementedException.class)
    public void createBin(){
        Bin bin = controller.create();
    }
}
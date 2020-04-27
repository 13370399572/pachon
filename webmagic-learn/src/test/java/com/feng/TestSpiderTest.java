package com.feng;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.feng.webmagic.spiderStart.TestStart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSpiderTest {
	
	  @Autowired
	  private TestStart testStart;
	  
	  @Test
	  public  void TestSpider()  {
		  testStart.zhang();
	  }

}

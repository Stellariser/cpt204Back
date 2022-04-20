//package com;
//
//import com.First.VO.PageInfo;
//import com.First.pojo.Comment;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//public class PageInfoTest {
//
//    @Test
//    public void PageInfo(){
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        list.add("7");
//        PageInfo<String> pageInfo = new PageInfo<>(list);
//
//        Assertions.assertEquals(1, pageInfo.getPageNum());
//        Assertions.assertEquals(1, pageInfo.getPages());
//        Assertions.assertEquals(list.size(), pageInfo.getTotal());
//        Assertions.assertEquals(list, pageInfo.getList());
//        Assertions.assertEquals(list.size(), pageInfo.getPageSize());
//        Assertions.assertEquals(true, pageInfo.isIsFirstPage());
//        Assertions.assertEquals(true, pageInfo.isIsLastPage());
//    }
//}

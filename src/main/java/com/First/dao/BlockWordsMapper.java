package com.First.dao;

import java.util.List;

import com.First.pojo.BlockWords;

import org.springframework.stereotype.Component;

@Component
public interface BlockWordsMapper {
    int addOne(String word);

    int delOne(String word);

    List<BlockWords> listAll();
}

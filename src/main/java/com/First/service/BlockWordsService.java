package com.First.service;

import java.util.HashSet;

import com.First.pojo.BlockWords;

import org.springframework.stereotype.Service;

@Service
public interface BlockWordsService {
    int addOne(String word);

    String[] addMany(String words);

    int delOne(String word);

    int delMany(String words);

    HashSet<BlockWords> listAll();
}

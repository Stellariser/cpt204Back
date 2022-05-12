package com.First.BlockWordsChecher;

import java.util.Set;

import com.First.pojo.BlockWords;
import com.First.service.BlockWordsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

public class BlockWordsHandler {
    @Autowired
    private BlockWordsServiceImpl blockWordsServiceImpl;

    public String replace(String content) {
        Set<BlockWords> blockWordsSet = blockWordsServiceImpl.listAll();
        for (BlockWords blockWords : blockWordsSet) {
            content = content.replaceAll(blockWords.getWord(), "*".repeat(blockWords.getWord().length()));
        }
        return content;
    }
}

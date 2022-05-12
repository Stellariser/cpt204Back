package com.First.BlockWordsChecher;

import java.util.Set;

import com.First.pojo.BlockWords;
import com.First.service.BlockWordsServiceImpl;
import com.First.BlockWordsChecher.BlockWordsHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BlockWordsHandler {
    @Autowired
    private BlockWordsServiceImpl blockWordsService;

    public String replace(String content) {
        Set<BlockWords> blockWordsSet = blockWordsService.listAll();
        for (BlockWords blockWords : blockWordsSet) {
            content = content.replaceAll(blockWords.getWord(), "*".repeat(blockWords.getWord().length()));
        }
        return content;
    }
}

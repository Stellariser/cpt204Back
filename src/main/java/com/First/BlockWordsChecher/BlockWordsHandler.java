package com.First.BlockWordsChecher;

import java.util.Set;

import com.First.pojo.BlockWords;
import com.First.service.BlockWordsServiceImpl;

import org.springframework.stereotype.Service;

@Service
public class BlockWordsHandler {
    private final BlockWordsServiceImpl blockWordsService;

    public BlockWordsHandler(BlockWordsServiceImpl blockWordsService) {
        this.blockWordsService = blockWordsService;
    }

    public String replace(String content) {
        Set<BlockWords> blockWordsSet = blockWordsService.listAll();
        for (BlockWords blockWords : blockWordsSet) {
            content = content.replaceAll(blockWords.getWord(), "*".repeat(blockWords.getWord().length()));
        }
        return content;
    }
}

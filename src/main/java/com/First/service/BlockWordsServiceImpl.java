package com.First.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.First.dao.BlockWordsMapper;
import com.First.pojo.BlockWords;

@Service
public class BlockWordsServiceImpl implements BlockWordsService {

    @Autowired
    private BlockWordsMapper blockWordsMapper;

    @Override
    public int addOne(String word) {
        return blockWordsMapper.addOne(word);
    }

    @Override
    public int addMany(String words) {
        words = words.replace("；", ";");
        String[] wordsLst = words.split(";");
        HashSet<BlockWords> existingBlockWords = listAll();
        HashSet<String> wordString = new HashSet<>();
        int result = 0;
        for (BlockWords blockWords : existingBlockWords) {
            wordString.add(blockWords.getWord());
        }
        for (int i = 0; i < wordsLst.length; i++)
            if (!wordString.contains(wordsLst[i]))
                result += addOne(wordsLst[i]);

        return result;
    }

    @Override
    public int delOne(String word) {
        return blockWordsMapper.delOne(word);
    }

    @Override
    public HashSet<BlockWords> listAll() {
        List<BlockWords> blockWordsLst = blockWordsMapper.listAll();
        return new HashSet<>(blockWordsLst);
    }

    @Override
    public int delMany(String words) {
        words = words.replace("；", ";");
        String[] wordsLst = words.split(";");
        HashSet<BlockWords> existingBlockWords = listAll();
        HashSet<String> wordString = new HashSet<>();
        int result = 0;
        for (BlockWords blockWords : existingBlockWords) {
            wordString.add(blockWords.getWord());
        }
        for (int i = 0; i < wordsLst.length; i++)
            if (wordString.contains(wordsLst[i]))
                result += delOne(wordsLst[i]);

        return result;
    }

}

package com.First.service;

import java.util.ArrayList;
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
    public String[] addMany(String words) {
        words = words.replace("；", ";");
        String[] wordsLst = words.split(";");
        List<String> added = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < wordsLst.length; i++) {
            wordsLst[i] = wordsLst[i].strip();
        }
        HashSet<BlockWords> existingBlockWords = listAll();
        HashSet<String> wordString = new HashSet<>();
        for (BlockWords blockWords : existingBlockWords) {
            wordString.add(blockWords.getWord());
        }
        for (int i = 0; i < wordsLst.length; i++)
            if (!wordString.contains(wordsLst[i])) {
                addOne(wordsLst[i]);
                added.add(wordsLst[i]);
                j++;
            }
        String[] addedArr = new String[j];
        added.toArray(addedArr);
        return addedArr;
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

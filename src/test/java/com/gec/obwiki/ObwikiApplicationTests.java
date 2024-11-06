package com.gec.obwiki;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gec.obwiki.entity.Ebook;
import com.gec.obwiki.mapper.EbookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ObwikiApplicationTests {
    @Autowired
    private EbookMapper ebookMapper;

    @Test
    public void queryUser(){
        List<Ebook> ebooks = ebookMapper.selectList(new QueryWrapper<>());
        System.out.println(ebooks);
    }
}

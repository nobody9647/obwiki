package com.gec.obwiki.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gec.obwiki.entity.Ebook;
import com.gec.obwiki.mapper.EbookMapper;
import com.gec.obwiki.rep.EbookQueryReq;
import com.gec.obwiki.resp.EbookQueryResp;
import com.gec.obwiki.service.IEbookService;
import com.gec.obwiki.utils.CopyUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 电子书 服务实现类
 * </p>
 *
 * @author cr
 * @since 2023-11-08
 */
@Service
public class EbookServiceImpl extends ServiceImpl<EbookMapper, Ebook> implements IEbookService {



    @Override
    public List<EbookQueryResp> listByname(EbookQueryReq req) {
        QueryWrapper<Ebook> queryWrapper = new QueryWrapper<Ebook>();
        //第一个参数：该参数是一个布尔类型，只有该参数是true时，才将like条件拼接到sql中；本例中，如果name字段不为空，则拼接name字段的like查询条件；
        queryWrapper.like(StringUtils.isNotBlank(req.getName()),"name",req.getName());
        queryWrapper.eq(ObjectUtils.isNotEmpty(req.getCategoryId2()),"category2_id",req.getCategoryId2());
        List<Ebook> ebooks = this.baseMapper.selectList(queryWrapper);
       /* List<EbookQueryResp> respList = new ArrayList<>();
        for (Ebook ebook : ebooks) {
            EbookQueryResp queryResp = new EbookQueryResp();
            //参数1 原对象 参数2 目标对象
            BeanUtils.copyProperties(ebook,queryResp);
            //对象复制
            //EbookQueryResp queryResp = CopyUtil.copy(ebook,EbookQueryResp.class);
            respList.add(queryResp);
        }*/
        List<EbookQueryResp> resps = CopyUtil.copyList(ebooks, EbookQueryResp.class);

        return resps;
    }
}

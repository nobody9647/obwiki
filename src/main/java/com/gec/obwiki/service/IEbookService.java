package com.gec.obwiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gec.obwiki.entity.Ebook;
import com.gec.obwiki.rep.EbookQueryReq;
import com.gec.obwiki.resp.EbookQueryResp;

import java.util.List;

/**
 * <p>
 * 电子书 服务类
 * </p>
 *
 * @author cr
 * @since 2023-11-08
 */
public interface IEbookService extends IService<Ebook> {

    List<EbookQueryResp> listByname(EbookQueryReq req);

}

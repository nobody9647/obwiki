package com.gec.obwiki.controller;

import com.gec.obwiki.rep.EbookQueryReq;
import com.gec.obwiki.resp.CommonResp;
import com.gec.obwiki.resp.EbookQueryResp;
import com.gec.obwiki.service.IEbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 电子书 前端控制器
 * </p>
 *
 * @author cr
 * @since 2023-11-08
 */
@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Autowired
    private IEbookService ebookService;


    @GetMapping("/list")
    public CommonResp list(@Valid EbookQueryReq req) {

        CommonResp resp = new CommonResp<>(true,"查询成功",null);
        List<EbookQueryResp> list = ebookService.listByname(req);
        resp.setContent(list);

        return resp;
    }
}

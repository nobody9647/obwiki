package com.gec.obwiki.rep;

import lombok.Data;
import lombok.ToString;

/**
 * @author cr
 * @date 2023年11月09日 14:29
 * @description
 */
@Data
@ToString
public class EbookQueryReq {
    //主键
    private Long id;
    //海洋生物电子书名
    private String name;
    //分类2
    private Long categoryId2;
}

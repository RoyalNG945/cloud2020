package com.wuxin.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Emma Watson
 * @create 2020-05-11 20:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Storage implements Serializable{

    private Long id;

    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}

package org.spring.match.controller;

import lombok.AllArgsConstructor;
import org.spring.match.dto.RData;
import org.spring.match.service.ICityParameterService;
import org.spring.match.service.IFirstGoodsService;
import org.spring.match.vo.CityParameterVO;
import org.spring.match.vo.FirstGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一级物品设置控制层
 * @author A_Dragon
 * @since 2019-12-12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/firstgoodssetting")
public class FirstGoodsController {

    @Autowired
    private IFirstGoodsService iFirstGoodsService;

    /**
     * 根据城市系数新增城市
     * @param firstGoodsVO
     * @return RData
     * @since 2019-12-16
     */
    @PostMapping("/insertFirstGoods")
    public RData insertFirstGoods(@RequestBody FirstGoodsVO firstGoodsVO) {
        try {
            return RData.okData(iFirstGoodsService.insertFirstGoods(firstGoodsVO));
        } catch (Exception e) {
            return RData.fail(false);
        }
    }



}

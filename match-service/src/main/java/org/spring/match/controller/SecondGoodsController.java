package org.spring.match.controller;

import lombok.AllArgsConstructor;
import org.spring.match.dto.RData;
import org.spring.match.service.ISecondGoodsService;
import org.spring.match.vo.SecondGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 二级设置控制层
 * @author A_Dragon
 * @since 2019-12-12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/secondgoodssetting")
public class SecondGoodsController {

    @Autowired
    private ISecondGoodsService iSecondGoodsService;

    /**
     * 新增二级物品
     * @param secondGoodsVO
     * @return RData
     * @since 2019-12-16
     */
    @PostMapping("/insertSecondGoods")
    public RData insertSecondGoods(@RequestBody SecondGoodsVO secondGoodsVO) {
        try {
            return RData.okData(iSecondGoodsService.insertSecondGoods(secondGoodsVO));
        } catch (Exception e) {
            return RData.fail(false);
        }
    }

}

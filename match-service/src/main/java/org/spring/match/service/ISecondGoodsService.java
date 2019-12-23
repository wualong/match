package org.spring.match.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.spring.match.entity.SecondGoods;
import org.spring.match.vo.SecondGoodsVO;

/**
 *  二级业务接口
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
public interface ISecondGoodsService extends IService<SecondGoods> {

    /**
     * 新增二级物品
     * @param secondGoodsVO
     * @return
     */
    boolean insertSecondGoods(SecondGoodsVO secondGoodsVO);

}

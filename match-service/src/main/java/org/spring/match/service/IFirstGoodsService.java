package org.spring.match.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.spring.match.entity.FirstGoods;
import org.spring.match.vo.FirstGoodsVO;

/**
 *  一级物品业务接口
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
public interface IFirstGoodsService extends IService<FirstGoods> {

    /**
     * 新增一级货物物品
     * @param firstGoodsVO
     * @return
     */
    boolean insertFirstGoods(FirstGoodsVO firstGoodsVO);

}

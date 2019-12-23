package org.spring.match.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.spring.match.entity.FirstGoods;
import org.spring.match.mapper.FirstGoodsMapper;
import org.spring.match.service.IFirstGoodsService;
import org.spring.match.util.BeanUtil;
import org.spring.match.vo.FirstGoodsVO;
import org.springframework.stereotype.Service;

/**
 *  一级物品服务实现类
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
@Service
public class FirstGoodsService extends ServiceImpl<FirstGoodsMapper, FirstGoods> implements IFirstGoodsService {

    /**
     * 新增一级物品
     * @param firstGoodsVO
     * @return boolean
     * @since 2019-12-13
     */
    @Override
    public boolean insertFirstGoods(FirstGoodsVO firstGoodsVO) {
        FirstGoods firstGoods = BeanUtil.copy(firstGoodsVO,FirstGoods.class);
        return this.save(firstGoods);
    }
}

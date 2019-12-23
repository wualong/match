package org.spring.match.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.spring.match.entity.SecondGoods;
import org.spring.match.mapper.SecondGoodsMapper;
import org.spring.match.service.ISecondGoodsService;
import org.spring.match.util.BeanUtil;
import org.spring.match.vo.SecondGoodsVO;
import org.springframework.stereotype.Service;

/**
 *  二级物品服务实现类
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
@Service
public class SecondGoodsService extends ServiceImpl<SecondGoodsMapper, SecondGoods> implements ISecondGoodsService {


    /**
     * 新增一级物品
     * @param secondGoodsVO
     * @return boolean
     * @since 2019-12-13
     */
    @Override
    public boolean insertSecondGoods(SecondGoodsVO secondGoodsVO) {
        SecondGoods secondGoods = BeanUtil.copy(secondGoodsVO,SecondGoods.class);
        return this.save(secondGoods);
    }
}

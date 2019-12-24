package org.spring.match.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.spring.match.entity.SecondGoods;
import org.springframework.stereotype.Repository;

/**
 *  二级物品Mapper 接口
 *
 * @author hydosky
 * @since 2019-04-24
 */
@Repository
public interface SecondGoodsMapper extends BaseMapper<SecondGoods> {

    SecondGoods randomGetSecondGoods();

}

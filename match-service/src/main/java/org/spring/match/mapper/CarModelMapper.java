package org.spring.match.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.spring.match.entity.CarModel;
import org.springframework.stereotype.Repository;

/**
 *  车型Mapper 接口
 *
 * @author hydosky
 * @since 2019-04-24
 */
@Repository
public interface CarModelMapper extends BaseMapper<CarModel> {

    CarModel randomCarModel();
}

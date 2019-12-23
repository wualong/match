package org.spring.match.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.spring.match.entity.CarModel;
import org.spring.match.mapper.CarModelMapper;
import org.spring.match.service.ICarModelService;
import org.springframework.stereotype.Service;

/**
 *  车型服务实现类
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
@Service
public class CarModelService extends ServiceImpl<CarModelMapper, CarModel> implements ICarModelService {


    @Override
    public boolean insertCarModel(CarModel carModel) {
        return this.save(carModel);
    }
}

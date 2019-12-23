package org.spring.match.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.spring.match.entity.CarModel;

/**
 *  车型业务接口
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
public interface ICarModelService extends IService<CarModel> {

    boolean insertCarModel(CarModel carModel);

}

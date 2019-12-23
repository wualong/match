package org.spring.match.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.spring.match.entity.CityParameter;
import org.spring.match.vo.CityParameterVO;

/**
 *  城市参数业务接口
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
public interface ICityParameterService extends IService<CityParameter> {

    boolean insertCityParameter(CityParameterVO cityParameterVO);
}

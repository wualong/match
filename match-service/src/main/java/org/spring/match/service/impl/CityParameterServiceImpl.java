package org.spring.match.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.spring.match.entity.CityParameter;
import org.spring.match.mapper.CityParameterMapper;
import org.spring.match.service.ICityParameterService;
import org.spring.match.util.BeanUtil;
import org.spring.match.vo.CityParameterVO;
import org.springframework.stereotype.Service;

/**
 *  城市参数服务实现类
 *
 * @author A_Dragon
 * @since 2019-04-26
 */
@Service
public class CityParameterServiceImpl extends ServiceImpl<CityParameterMapper, CityParameter> implements ICityParameterService {

    @Override
    public boolean insertCityParameter(CityParameterVO cityParameterVO) {
        CityParameter cityParameter = BeanUtil.copy(cityParameterVO,CityParameter.class);
        boolean flag = this.save(cityParameter);
        return flag;
    }
}

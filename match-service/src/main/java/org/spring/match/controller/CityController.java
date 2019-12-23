package org.spring.match.controller;

import lombok.AllArgsConstructor;
import org.spring.match.dto.RData;
import org.spring.match.service.ICityParameterService;
import org.spring.match.vo.CityParameterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市设置控制层
 * @author A_Dragon
 * @since 2019-12-12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/citysetting")
public class CityController {

    @Autowired
    private ICityParameterService iCityParameterService;

    /**
     * 根据城市系数新增城市
     * @param
     * @return
     * @since
     */
    @PostMapping("/insertLadle")
    public RData insertLadle(@RequestBody CityParameterVO cityParameterVO) {
        try {
            return RData.okData(iCityParameterService.insertCityParameter(cityParameterVO));
        } catch (Exception e) {
            return RData.fail(false);
        }
    }

}

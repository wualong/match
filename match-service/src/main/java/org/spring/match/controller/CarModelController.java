package org.spring.match.controller;

import lombok.AllArgsConstructor;
import org.spring.match.dto.RData;
import org.spring.match.entity.CarModel;
import org.spring.match.service.ICarModelService;
import org.spring.match.service.ICityParameterService;
import org.spring.match.vo.CityParameterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 车型设置控制层
 * @author A_Dragon
 * @since 2019-12-12
 */
@RestController
@AllArgsConstructor
@RequestMapping("/carmodelsetting")
public class CarModelController {


    @Autowired
    private ICarModelService iCarModelService;

    /**
     * 根据城市系数新增城市
     * @param
     * @return
     * @since
     */
    @PostMapping("/insertCar")
    public RData insertLadle(@RequestBody CarModel carModel) {
        try {
            return RData.okData(iCarModelService.insertCarModel(carModel));
        } catch (Exception e) {
            return RData.fail(false);
        }
    }
}

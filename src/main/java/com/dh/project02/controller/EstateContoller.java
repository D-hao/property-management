package com.dh.project02.controller;

import com.alibaba.fastjson.JSONObject;
import com.dh.project02.bean.*;
import com.dh.project02.returnJson.ReturnObject;
import com.dh.project02.service.EstateService;
import com.dh.project02.vo.CellMessage;
import com.dh.project02.vo.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:D-hao
 * @Date:2020/11/13-11-13-18:10
 * @Description:com.dh.project02.controller
 */
@RestController
@CrossOrigin(allowedHeaders = "*", allowCredentials = "true", methods = {}, origins = "*")
public class EstateContoller {
    @Autowired
    private EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public String selectCompany() {
        System.out.println("selectCompany");
        List<TblCompany> company = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObject(company));
    }

    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate) {
        System.out.println("==================");
        System.out.println(fcEstate);
        System.out.println("insert estate");
        Integer result = estateService.insertEstate(fcEstate);
        if (result == 0) {
            return JSONObject.toJSONString(new ReturnObject("0","房产编码已经存在"));
        }else {
            return JSONObject.toJSONString(new ReturnObject("1","插入房产成功"));
        }
    }

    /**
     * 此处完成的是楼宇插入的功能，但是，现在数据中没有楼宇信息，我们还需要返回插入的楼宇信息
     * @param buildingNumber
     * @param estateCode
     * @return
     */
    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber, String estateCode) {
        System.out.println("select Building");
        List<FcBuilding> fcBuildings = estateService.selectBuiling(buildingNumber, estateCode);
        System.out.println("======"+fcBuildings+"===========");
        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }

    @RequestMapping("/estate/updateBuilding")
    public String updateBuilding(FcBuilding fcBuilding) {
        System.out.println("update building");
        Integer integer = estateService.updateBuilding(fcBuilding);
        if (integer == 1) {
            return JSONObject.toJSONString(new ReturnObject("更新楼宇成功"));
        } else {
            return JSONObject.toJSONString(new ReturnObject("更新楼宇失败"));
        }
    }
    @RequestMapping("/estate/selectUnit")
    public  String selectUnit(@RequestBody UnitMessage[] unitMessages){
        System.out.println("=====select unit =======");
        List<FcUnit> allUnit=new ArrayList<>();
        for(UnitMessage unitMessage:unitMessages){
            allUnit.addAll(estateService.selectUnit((unitMessage)));
        }
        return JSONObject.toJSONString(new ReturnObject(allUnit));

    }
    @RequestMapping("/estate/updateUnit")
    public String updateUnit(FcUnit fcUnit) {
        Integer integer = estateService.updateUnit(fcUnit);
        if (integer == 0) {
            return JSONObject.toJSONString(new ReturnObject("更新单元失败"));
        }else {
            return JSONObject.toJSONString(new ReturnObject("更新单元成功"));
        }
    }
    @RequestMapping("/estate/insertCell")
    public String insertCell(@RequestBody CellMessage[] cellMessages) {
        System.out.println("=====insert cell======");
        for (CellMessage cellMessage : cellMessages) {
            System.out.println("======="+cellMessage);
        }
        List<FcCell> list = estateService.insertCell(cellMessages);
        return JSONObject.toJSONString(new ReturnObject(list));
    }
}

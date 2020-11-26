package com.dh.project02.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dh.project02.bean.FcBuilding;
import com.dh.project02.bean.FcEstate;
import com.dh.project02.bean.FcUnit;
import com.dh.project02.bean.TblCompany;
import com.dh.project02.mapper.FcBuildingMapper;
import com.dh.project02.mapper.FcEstateMapper;
import com.dh.project02.mapper.FcUnitMapper;
import com.dh.project02.mapper.TblCompanyMapper;
import com.dh.project02.vo.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:D-hao
 * @Date:2020/11/13-11-13-18:14
 * @Description:com.dh.project02.service
 */
@Service
public class EstateService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Autowired
    private FcBuildingMapper fcBuildingMapper;
    @Autowired
    private FcUnitMapper fcUnitMapper;

    public List<TblCompany> selectCompany() {
        List<TblCompany> companys = tblCompanyMapper.selectCompany();
        return companys;
    }

    /**
     * 在插入前最好在对当前信息做判断，如果住宅信息存在，不允许插入
     * @param fcEstate
     * @return
     */
    public Integer insertEstate(FcEstate fcEstate) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("estate_code", fcEstate.getEstateCode());
        FcEstate fcEstate1 = fcEstateMapper.selectOne(queryWrapper);
        int result=0;
        if (fcEstate1 != null) {
            return result;
        }else {
            result = fcEstateMapper.insert(fcEstate);
            return result;
        }
    }

    /**
     * 先插入，再查询,并返回查询结果
     * 插入的时候定义集合，插入的同时把结果加入到集合里，返回集合
     * @param buildingNumber
     * @param estaeCode
     * @return
     */
    public List<FcBuilding> selectBuiling(Integer buildingNumber, String estaeCode) {
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i = 0; i < buildingNumber; i++) {
            FcBuilding fcBuilding=new FcBuilding();
            fcBuilding.setBuildingCode("B"+(i+1));
            fcBuilding.setBuildingName("第"+(i+1)+"号楼");
            fcBuilding.setEstateCode(estaeCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildings.add(fcBuilding);
        }
        return fcBuildings;
    }

    /**
     * 完成楼宇的更新功能
     * @param fcBuilding
     * @return
     */
    public Integer updateBuilding(FcBuilding fcBuilding) {
        int i = fcBuildingMapper.updateById(fcBuilding);
        return i;
    }

    public List<FcUnit> selectUnit(UnitMessage unitMessage) {
        //定义返回值集合
        List<FcUnit>  fcUnits=new ArrayList<>();
        for(int i=0;i< unitMessage.getUnitCount();i++){
            FcUnit fcUnit=new FcUnit();
            fcUnit.setBuildingCode((unitMessage.getBuildingCode()));
            fcUnit.setUnitCode("U"+(i+1));
            fcUnit.setUnitName("第"+(i+1)+"单元");
            fcUnitMapper.insert(fcUnit);
            fcUnits.add(fcUnit);
        }
        return fcUnits;
    }
}

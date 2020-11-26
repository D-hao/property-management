package com.dh.project02.vo;

/**
 * @Auther:D-hao
 * @Date:2020/11/26-11-26-18:22
 * @Description:com.dh.project02.vo
 */
public class UnitMessage {
    private  String buildingCode;
    private  Integer unitCount;

    public UnitMessage() {
    }

    public UnitMessage(String buildingCode, Integer unitCount) {
        this.buildingCode = buildingCode;
        this.unitCount = unitCount;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public void setBuildingCode(String buildingCode) {
        this.buildingCode = buildingCode;
    }

    public Integer getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(Integer unitCount) {
        this.unitCount = unitCount;
    }

    @Override
    public String toString() {
        return "UnitMessage{" +
                "buildingCode='" + buildingCode + '\'' +
                ", unitCount=" + unitCount +
                '}';
    }
}

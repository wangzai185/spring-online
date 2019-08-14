package com.xqtc.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * channel_product
 * @author 
 */
@TableName("channel_product")
public class ChannelProductEntity implements Serializable {
    @TableId("cp_id")
    private Long cpId;

    private Integer ccId;

    private Long xpId;

    private String parkName;

    private String province;

    private String city;

    private String site;

    private Integer parkType;

    private String service;

    private Integer chargeType;

    private Integer freeMins;

    private Float overtimePrice;

    private Integer salesInit;

    private String charge;

    private String channelCharge;

    private String parkCharge;

    private Integer isPartner;

    private Float prepayMoney;

    private Float deductionMoney;

    private Integer deductionDay;

    private String thumbnail;

    private String firstPic;

    private String detailPics;

    private Long createTime;

    private Long updateTime;

    private String creator;

    private String updater;

    private String remark;

    private Integer state;

    private Integer startDay;

    private static final long serialVersionUID = 1L;

    public Long getCpId() {
        return cpId;
    }

    public void setCpId(Long cpId) {
        this.cpId = cpId;
    }

    public Integer getCcId() {
        return ccId;
    }

    public void setCcId(Integer ccId) {
        this.ccId = ccId;
    }

    public Long getXpId() {
        return xpId;
    }

    public void setXpId(Long xpId) {
        this.xpId = xpId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getParkType() {
        return parkType;
    }

    public void setParkType(Integer parkType) {
        this.parkType = parkType;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getFreeMins() {
        return freeMins;
    }

    public void setFreeMins(Integer freeMins) {
        this.freeMins = freeMins;
    }

    public Float getOvertimePrice() {
        return overtimePrice;
    }

    public void setOvertimePrice(Float overtimePrice) {
        this.overtimePrice = overtimePrice;
    }

    public Integer getSalesInit() {
        return salesInit;
    }

    public void setSalesInit(Integer salesInit) {
        this.salesInit = salesInit;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getChannelCharge() {
        return channelCharge;
    }

    public void setChannelCharge(String channelCharge) {
        this.channelCharge = channelCharge;
    }

    public String getParkCharge() {
        return parkCharge;
    }

    public void setParkCharge(String parkCharge) {
        this.parkCharge = parkCharge;
    }

    public Integer getIsPartner() {
        return isPartner;
    }

    public void setIsPartner(Integer isPartner) {
        this.isPartner = isPartner;
    }

    public Float getPrepayMoney() {
        return prepayMoney;
    }

    public void setPrepayMoney(Float prepayMoney) {
        this.prepayMoney = prepayMoney;
    }

    public Float getDeductionMoney() {
        return deductionMoney;
    }

    public void setDeductionMoney(Float deductionMoney) {
        this.deductionMoney = deductionMoney;
    }

    public Integer getDeductionDay() {
        return deductionDay;
    }

    public void setDeductionDay(Integer deductionDay) {
        this.deductionDay = deductionDay;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFirstPic() {
        return firstPic;
    }

    public void setFirstPic(String firstPic) {
        this.firstPic = firstPic;
    }

    public String getDetailPics() {
        return detailPics;
    }

    public void setDetailPics(String detailPics) {
        this.detailPics = detailPics;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStartDay() {
        return startDay;
    }

    public void setStartDay(Integer startDay) {
        this.startDay = startDay;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ChannelProductEntity other = (ChannelProductEntity) that;
        return (this.getCpId() == null ? other.getCpId() == null : this.getCpId().equals(other.getCpId()))
            && (this.getCcId() == null ? other.getCcId() == null : this.getCcId().equals(other.getCcId()))
            && (this.getXpId() == null ? other.getXpId() == null : this.getXpId().equals(other.getXpId()))
            && (this.getParkName() == null ? other.getParkName() == null : this.getParkName().equals(other.getParkName()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getSite() == null ? other.getSite() == null : this.getSite().equals(other.getSite()))
            && (this.getParkType() == null ? other.getParkType() == null : this.getParkType().equals(other.getParkType()))
            && (this.getService() == null ? other.getService() == null : this.getService().equals(other.getService()))
            && (this.getChargeType() == null ? other.getChargeType() == null : this.getChargeType().equals(other.getChargeType()))
            && (this.getFreeMins() == null ? other.getFreeMins() == null : this.getFreeMins().equals(other.getFreeMins()))
            && (this.getOvertimePrice() == null ? other.getOvertimePrice() == null : this.getOvertimePrice().equals(other.getOvertimePrice()))
            && (this.getSalesInit() == null ? other.getSalesInit() == null : this.getSalesInit().equals(other.getSalesInit()))
            && (this.getCharge() == null ? other.getCharge() == null : this.getCharge().equals(other.getCharge()))
            && (this.getChannelCharge() == null ? other.getChannelCharge() == null : this.getChannelCharge().equals(other.getChannelCharge()))
            && (this.getParkCharge() == null ? other.getParkCharge() == null : this.getParkCharge().equals(other.getParkCharge()))
            && (this.getIsPartner() == null ? other.getIsPartner() == null : this.getIsPartner().equals(other.getIsPartner()))
            && (this.getPrepayMoney() == null ? other.getPrepayMoney() == null : this.getPrepayMoney().equals(other.getPrepayMoney()))
            && (this.getDeductionMoney() == null ? other.getDeductionMoney() == null : this.getDeductionMoney().equals(other.getDeductionMoney()))
            && (this.getDeductionDay() == null ? other.getDeductionDay() == null : this.getDeductionDay().equals(other.getDeductionDay()))
            && (this.getThumbnail() == null ? other.getThumbnail() == null : this.getThumbnail().equals(other.getThumbnail()))
            && (this.getFirstPic() == null ? other.getFirstPic() == null : this.getFirstPic().equals(other.getFirstPic()))
            && (this.getDetailPics() == null ? other.getDetailPics() == null : this.getDetailPics().equals(other.getDetailPics()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getStartDay() == null ? other.getStartDay() == null : this.getStartDay().equals(other.getStartDay()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCpId() == null) ? 0 : getCpId().hashCode());
        result = prime * result + ((getCcId() == null) ? 0 : getCcId().hashCode());
        result = prime * result + ((getXpId() == null) ? 0 : getXpId().hashCode());
        result = prime * result + ((getParkName() == null) ? 0 : getParkName().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getSite() == null) ? 0 : getSite().hashCode());
        result = prime * result + ((getParkType() == null) ? 0 : getParkType().hashCode());
        result = prime * result + ((getService() == null) ? 0 : getService().hashCode());
        result = prime * result + ((getChargeType() == null) ? 0 : getChargeType().hashCode());
        result = prime * result + ((getFreeMins() == null) ? 0 : getFreeMins().hashCode());
        result = prime * result + ((getOvertimePrice() == null) ? 0 : getOvertimePrice().hashCode());
        result = prime * result + ((getSalesInit() == null) ? 0 : getSalesInit().hashCode());
        result = prime * result + ((getCharge() == null) ? 0 : getCharge().hashCode());
        result = prime * result + ((getChannelCharge() == null) ? 0 : getChannelCharge().hashCode());
        result = prime * result + ((getParkCharge() == null) ? 0 : getParkCharge().hashCode());
        result = prime * result + ((getIsPartner() == null) ? 0 : getIsPartner().hashCode());
        result = prime * result + ((getPrepayMoney() == null) ? 0 : getPrepayMoney().hashCode());
        result = prime * result + ((getDeductionMoney() == null) ? 0 : getDeductionMoney().hashCode());
        result = prime * result + ((getDeductionDay() == null) ? 0 : getDeductionDay().hashCode());
        result = prime * result + ((getThumbnail() == null) ? 0 : getThumbnail().hashCode());
        result = prime * result + ((getFirstPic() == null) ? 0 : getFirstPic().hashCode());
        result = prime * result + ((getDetailPics() == null) ? 0 : getDetailPics().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getStartDay() == null) ? 0 : getStartDay().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cpId=").append(cpId);
        sb.append(", ccId=").append(ccId);
        sb.append(", xpId=").append(xpId);
        sb.append(", parkName=").append(parkName);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", site=").append(site);
        sb.append(", parkType=").append(parkType);
        sb.append(", service=").append(service);
        sb.append(", chargeType=").append(chargeType);
        sb.append(", freeMins=").append(freeMins);
        sb.append(", overtimePrice=").append(overtimePrice);
        sb.append(", salesInit=").append(salesInit);
        sb.append(", charge=").append(charge);
        sb.append(", channelCharge=").append(channelCharge);
        sb.append(", parkCharge=").append(parkCharge);
        sb.append(", isPartner=").append(isPartner);
        sb.append(", prepayMoney=").append(prepayMoney);
        sb.append(", deductionMoney=").append(deductionMoney);
        sb.append(", deductionDay=").append(deductionDay);
        sb.append(", thumbnail=").append(thumbnail);
        sb.append(", firstPic=").append(firstPic);
        sb.append(", detailPics=").append(detailPics);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", creator=").append(creator);
        sb.append(", updater=").append(updater);
        sb.append(", remark=").append(remark);
        sb.append(", state=").append(state);
        sb.append(", startDay=").append(startDay);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
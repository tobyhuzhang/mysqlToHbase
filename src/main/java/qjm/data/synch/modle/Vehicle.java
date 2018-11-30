package qjm.data.synch.modle;

import java.util.Date;

/**
 * 机动车
 * 
 * @author zhang
 *
 *         2017年6月19日
 */
public class Vehicle {
	private Integer id;// 车辆Id
	private Integer ams_companyId;// 所属的AMS数据库中的企业Id
	private Integer ims_teamId;// 所属的IMS数据库中的车队Id
	private Integer provinceId;// 省
	private Integer cityId;// 市
	private Date createTime;// 创建时间
	private Integer createUserId;// 创建人
	private Date updateTime;// 修改时间
	private Integer updateUserId;// 修改人
	private Integer isDeleted;// 删除标记 0: 正常 1: 已删除
	// 2017-8-24根据钛马新文档修改
	private String brandName;// 品牌名称
	private String brandNo;// 品牌no
	private String gateWayName;// 网关服务
	private String gateWayNo;// 网关no
	private String makerName;// 制造商名称
	private String makerNo;// 制造商no
	private String modelName;// 车型名称
	private String modelNo;// 车型no
	private String no;// 系统编号
	private String seriesName;// 车系名称
	private String seriesNo;// 车系no
	private String serviceName;// 服务商名称
	private String serviceNo;// 服务商no
	private String sim;// 设备ID
	private String tboxModelName;// Tbox型号名称
	private String tboxModelNo;// Tbox品牌
	private String tboxNo;// Tbox编号
	private Integer serviceLife;// 使用年限
	private String powerType;// 动力类型BLADE_ELECTRIC_VEHICLE:电动;HYBRID_ELECTRICAL_VEHICLE:混合动力;GAS_VEHICLE:燃油
	private Integer year;// 年代
	private String insuranceNo;// 保险单号
	private String color;// 颜色
	private String description;// 备注
	private Date drivingLicenseExpiredDate;// 行驶证到期日
	private String drivingLicenseNo;// 行驶证号
	private String plateLicenseNo;// 车牌号
	private Date registerDate;// 注册日期
	private String engineNo;// 发动机编号
	private String vin;// 车架号
	//需要的字段添加
	private Float cLength;//车箱长
	private Float cWidth;//车箱宽
	private Float cHeight;//车箱高
	private Date purchaseDate;//购买日期
	private String oilType;//燃油类型
	private String vehicleOwner;//车主
	private Integer dataType;//整合数据类型，0=TBOX，1=互联网设备
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDrivingLicenseExpiredDate() {
		return drivingLicenseExpiredDate;
	}

	public void setDrivingLicenseExpiredDate(Date drivingLicenseExpiredDate) {
		this.drivingLicenseExpiredDate = drivingLicenseExpiredDate;
	}

	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}

	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}

	public String getPlateLicenseNo() {
		return plateLicenseNo;
	}

	public void setPlateLicenseNo(String plateLicenseNo) {
		this.plateLicenseNo = plateLicenseNo;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}

	public String getGateWayName() {
		return gateWayName;
	}

	public void setGateWayName(String gateWayName) {
		this.gateWayName = gateWayName;
	}

	public String getGateWayNo() {
		return gateWayNo;
	}

	public void setGateWayNo(String gateWayNo) {
		this.gateWayNo = gateWayNo;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getMakerNo() {
		return makerNo;
	}

	public void setMakerNo(String makerNo) {
		this.makerNo = makerNo;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getSeriesNo() {
		return seriesNo;
	}

	public void setSeriesNo(String seriesNo) {
		this.seriesNo = seriesNo;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getTboxModelName() {
		return tboxModelName;
	}

	public void setTboxModelName(String tboxModelName) {
		this.tboxModelName = tboxModelName;
	}

	public String getTboxModelNo() {
		return tboxModelNo;
	}

	public void setTboxModelNo(String tboxModelNo) {
		this.tboxModelNo = tboxModelNo;
	}

	public String getTboxNo() {
		return tboxNo;
	}

	public void setTboxNo(String tboxNo) {
		this.tboxNo = tboxNo;
	}

	public Integer getServiceLife() {
		return serviceLife;
	}

	public void setServiceLife(Integer serviceLife) {
		this.serviceLife = serviceLife;
	}

	public String getPowerType() {
		return powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAms_companyId() {
		return ams_companyId;
	}

	public void setAms_companyId(Integer ams_companyId) {
		this.ams_companyId = ams_companyId;
	}

	public Integer getIms_teamId() {
		return ims_teamId;
	}

	public void setIms_teamId(Integer ims_teamId) {
		this.ims_teamId = ims_teamId;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Float getcLength() {
		return cLength;
	}

	public void setcLength(Float cLength) {
		this.cLength = cLength;
	}

	public Float getcWidth() {
		return cWidth;
	}

	public void setcWidth(Float cWidth) {
		this.cWidth = cWidth;
	}

	public Float getcHeight() {
		return cHeight;
	}

	public void setcHeight(Float cHeight) {
		this.cHeight = cHeight;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getOilType() {
		return oilType;
	}

	public void setOilType(String oilType) {
		this.oilType = oilType;
	}

	public String getVehicleOwner() {
		return vehicleOwner;
	}

	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}

	public String getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(String insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}


}

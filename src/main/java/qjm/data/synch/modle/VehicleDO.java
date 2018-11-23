package qjm.data.synch.modle;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-04-07 16:48
 */
public class VehicleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Date createtime;
	//
	private Integer createuserid;
	//
	private Date updatetime;
	//
	private Integer updateuserid;
	//
	private Integer isdeleted;
	//车牌号
	private String platelicenseno;
	//发动机编号
	private String engineno;
	//品牌名称
	private String brandname;
	//品牌no
	private String brandno;
	//颜色
	private String color;
	//备注
	private String description;
	//行驶证到期日
	private Date drivinglicenseexpireddate;
	//行驶证号
	private String drivinglicenseno;
	//网关服务
	private String gatewayname;
	//网关no
	private String gatewayno;
	//制造商名称
	private String makername;
	//制造商no
	private String makerno;
	//车型名称
	private String modelname;
	//车型no
	private String modelno;
	//系统编号
	private String no;
	//车系名称
	private String seriesname;
	//车系no
	private String seriesno;
	//服务商名称
	private String servicename;
	//服务商no
	private String serviceno;
	//设备ID
	private String sim;
	//Tbox型号名称
	private String tboxmodelname;
	//Tbox品牌
	private String tboxmodelno;
	//Tbox编号
	private String tboxno;
	//车架号
	private String vin;
	//使用年限
	private Integer servicelife;
	//注册日期
	private Date registerdate;
	//动力类型BLADE_ELECTRIC_VEHICLE:电动;HYBRID_ELECTRICAL_VEHICLE:混合动力;GAS_VEHICLE:燃油
	private String powertype;
	//年代
	private Integer year;
	//保险单号
	private String insuranceno;
	//
	private String clengthno;
	//车箱长
	private String clength;
	//车箱宽
	private Float cwidth;
	//车箱高
	private Float cheight;
	//燃油类型
	private String oiltype;
	//车主
	private String vehicleowner;
	//购买日期
	private Date purchasedate;
	//温度传感器设备
	private String tempdeviceno;
	//显示用车辆类型，例如江铃顺达，还有车辆图片地址
	private Integer showmodelsid;
	//车辆用途类型，例如冷藏车，冷冻车，常温车，使用常量，在常量表中
	private String usetype;
	//所属公司
	private String companyowner;
	//发送数据类型，0、发送complete数据，1、发送互联网设备数据
	private Integer dataType;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：
	 */
	public void setCreateuserid(Integer createuserid) {
		this.createuserid = createuserid;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateuserid() {
		return createuserid;
	}
	/**
	 * 设置：
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateuserid(Integer updateuserid) {
		this.updateuserid = updateuserid;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateuserid() {
		return updateuserid;
	}
	/**
	 * 设置：
	 */
	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}
	/**
	 * 获取：
	 */
	public Integer getIsdeleted() {
		return isdeleted;
	}
	/**
	 * 设置：车牌号
	 */
	public void setPlatelicenseno(String platelicenseno) {
		this.platelicenseno = platelicenseno;
	}
	/**
	 * 获取：车牌号
	 */
	public String getPlatelicenseno() {
		return platelicenseno;
	}
	/**
	 * 设置：发动机编号
	 */
	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}
	/**
	 * 获取：发动机编号
	 */
	public String getEngineno() {
		return engineno;
	}
	/**
	 * 设置：品牌名称
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	/**
	 * 获取：品牌名称
	 */
	public String getBrandname() {
		return brandname;
	}
	/**
	 * 设置：品牌no
	 */
	public void setBrandno(String brandno) {
		this.brandno = brandno;
	}
	/**
	 * 获取：品牌no
	 */
	public String getBrandno() {
		return brandno;
	}
	/**
	 * 设置：颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 获取：颜色
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 设置：备注
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：备注
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：行驶证到期日
	 */
	public void setDrivinglicenseexpireddate(Date drivinglicenseexpireddate) {
		this.drivinglicenseexpireddate = drivinglicenseexpireddate;
	}
	/**
	 * 获取：行驶证到期日
	 */
	public Date getDrivinglicenseexpireddate() {
		return drivinglicenseexpireddate;
	}
	/**
	 * 设置：行驶证号
	 */
	public void setDrivinglicenseno(String drivinglicenseno) {
		this.drivinglicenseno = drivinglicenseno;
	}
	/**
	 * 获取：行驶证号
	 */
	public String getDrivinglicenseno() {
		return drivinglicenseno;
	}
	/**
	 * 设置：网关服务
	 */
	public void setGatewayname(String gatewayname) {
		this.gatewayname = gatewayname;
	}
	/**
	 * 获取：网关服务
	 */
	public String getGatewayname() {
		return gatewayname;
	}
	/**
	 * 设置：网关no
	 */
	public void setGatewayno(String gatewayno) {
		this.gatewayno = gatewayno;
	}
	/**
	 * 获取：网关no
	 */
	public String getGatewayno() {
		return gatewayno;
	}
	/**
	 * 设置：制造商名称
	 */
	public void setMakername(String makername) {
		this.makername = makername;
	}
	/**
	 * 获取：制造商名称
	 */
	public String getMakername() {
		return makername;
	}
	/**
	 * 设置：制造商no
	 */
	public void setMakerno(String makerno) {
		this.makerno = makerno;
	}
	/**
	 * 获取：制造商no
	 */
	public String getMakerno() {
		return makerno;
	}
	/**
	 * 设置：车型名称
	 */
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	/**
	 * 获取：车型名称
	 */
	public String getModelname() {
		return modelname;
	}
	/**
	 * 设置：车型no
	 */
	public void setModelno(String modelno) {
		this.modelno = modelno;
	}
	/**
	 * 获取：车型no
	 */
	public String getModelno() {
		return modelno;
	}
	/**
	 * 设置：系统编号
	 */
	public void setNo(String no) {
		this.no = no;
	}
	/**
	 * 获取：系统编号
	 */
	public String getNo() {
		return no;
	}
	/**
	 * 设置：车系名称
	 */
	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}
	/**
	 * 获取：车系名称
	 */
	public String getSeriesname() {
		return seriesname;
	}
	/**
	 * 设置：车系no
	 */
	public void setSeriesno(String seriesno) {
		this.seriesno = seriesno;
	}
	/**
	 * 获取：车系no
	 */
	public String getSeriesno() {
		return seriesno;
	}
	/**
	 * 设置：服务商名称
	 */
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	/**
	 * 获取：服务商名称
	 */
	public String getServicename() {
		return servicename;
	}
	/**
	 * 设置：服务商no
	 */
	public void setServiceno(String serviceno) {
		this.serviceno = serviceno;
	}
	/**
	 * 获取：服务商no
	 */
	public String getServiceno() {
		return serviceno;
	}
	/**
	 * 设置：设备ID
	 */
	public void setSim(String sim) {
		this.sim = sim;
	}
	/**
	 * 获取：设备ID
	 */
	public String getSim() {
		return sim;
	}
	/**
	 * 设置：Tbox型号名称
	 */
	public void setTboxmodelname(String tboxmodelname) {
		this.tboxmodelname = tboxmodelname;
	}
	/**
	 * 获取：Tbox型号名称
	 */
	public String getTboxmodelname() {
		return tboxmodelname;
	}
	/**
	 * 设置：Tbox品牌
	 */
	public void setTboxmodelno(String tboxmodelno) {
		this.tboxmodelno = tboxmodelno;
	}
	/**
	 * 获取：Tbox品牌
	 */
	public String getTboxmodelno() {
		return tboxmodelno;
	}
	/**
	 * 设置：Tbox编号
	 */
	public void setTboxno(String tboxno) {
		this.tboxno = tboxno;
	}
	/**
	 * 获取：Tbox编号
	 */
	public String getTboxno() {
		return tboxno;
	}
	/**
	 * 设置：车架号
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * 获取：车架号
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * 设置：使用年限
	 */
	public void setServicelife(Integer servicelife) {
		this.servicelife = servicelife;
	}
	/**
	 * 获取：使用年限
	 */
	public Integer getServicelife() {
		return servicelife;
	}
	/**
	 * 设置：注册日期
	 */
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	/**
	 * 获取：注册日期
	 */
	public Date getRegisterdate() {
		return registerdate;
	}
	/**
	 * 设置：动力类型BLADE_ELECTRIC_VEHICLE:电动;HYBRID_ELECTRICAL_VEHICLE:混合动力;GAS_VEHICLE:燃油
	 */
	public void setPowertype(String powertype) {
		this.powertype = powertype;
	}
	/**
	 * 获取：动力类型BLADE_ELECTRIC_VEHICLE:电动;HYBRID_ELECTRICAL_VEHICLE:混合动力;GAS_VEHICLE:燃油
	 */
	public String getPowertype() {
		return powertype;
	}
	/**
	 * 设置：年代
	 */
	public void setYear(Integer year) {
		this.year = year;
	}
	/**
	 * 获取：年代
	 */
	public Integer getYear() {
		return year;
	}
	/**
	 * 设置：保险单号
	 */
	public void setInsuranceno(String insuranceno) {
		this.insuranceno = insuranceno;
	}
	/**
	 * 获取：保险单号
	 */
	public String getInsuranceno() {
		return insuranceno;
	}
	/**
	 * 设置：
	 */
	public void setClengthno(String clengthno) {
		this.clengthno = clengthno;
	}
	/**
	 * 获取：
	 */
	public String getClengthno() {
		return clengthno;
	}
	/**
	 * 设置：车箱长
	 */
	public void setClength(String clength) {
		this.clength = clength;
	}
	/**
	 * 获取：车箱长
	 */
	public String getClength() {
		return clength;
	}
	/**
	 * 设置：车箱宽
	 */
	public void setCwidth(Float cwidth) {
		this.cwidth = cwidth;
	}
	/**
	 * 获取：车箱宽
	 */
	public Float getCwidth() {
		return cwidth;
	}
	/**
	 * 设置：车箱高
	 */
	public void setCheight(Float cheight) {
		this.cheight = cheight;
	}
	/**
	 * 获取：车箱高
	 */
	public Float getCheight() {
		return cheight;
	}
	/**
	 * 设置：燃油类型
	 */
	public void setOiltype(String oiltype) {
		this.oiltype = oiltype;
	}
	/**
	 * 获取：燃油类型
	 */
	public String getOiltype() {
		return oiltype;
	}
	/**
	 * 设置：车主
	 */
	public void setVehicleowner(String vehicleowner) {
		this.vehicleowner = vehicleowner;
	}
	/**
	 * 获取：车主
	 */
	public String getVehicleowner() {
		return vehicleowner;
	}
	/**
	 * 设置：购买日期
	 */
	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}
	/**
	 * 获取：购买日期
	 */
	public Date getPurchasedate() {
		return purchasedate;
	}
	/**
	 * 设置：温度传感器设备
	 */
	public void setTempdeviceno(String tempdeviceno) {
		this.tempdeviceno = tempdeviceno;
	}
	/**
	 * 获取：温度传感器设备
	 */
	public String getTempdeviceno() {
		return tempdeviceno;
	}
	/**
	 * 设置：显示用车辆类型，例如江铃顺达，还有车辆图片地址
	 */
	public void setShowmodelsid(Integer showmodelsid) {
		this.showmodelsid = showmodelsid;
	}
	/**
	 * 获取：显示用车辆类型，例如江铃顺达，还有车辆图片地址
	 */
	public Integer getShowmodelsid() {
		return showmodelsid;
	}
	/**
	 * 设置：车辆用途类型，例如冷藏车，冷冻车，常温车，使用常量，在常量表中
	 */
	public void setUsetype(String usetype) {
		this.usetype = usetype;
	}
	/**
	 * 获取：车辆用途类型，例如冷藏车，冷冻车，常温车，使用常量，在常量表中
	 */
	public String getUsetype() {
		return usetype;
	}
	/**
	 * 设置：所属公司
	 */
	public void setCompanyowner(String companyowner) {
		this.companyowner = companyowner;
	}
	/**
	 * 获取：所属公司
	 */
	public String getCompanyowner() {
		return companyowner;
	}
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}
}

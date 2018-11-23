package qjm.data.synch.modle;


import java.io.Serializable;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-04-12 14:24
 */
public class DeviceVinDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String devicenumber;
	//
	private String vin;
	//设备种类方便归类查询
	private Integer devicetype;
	//
	private Integer isdeleted;
	private Integer isMain;//是否是主设备
	private String deviceModel;//设备型号，可在carnet中显示车载设备里用
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
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	/**
	 * 获取：
	 */
	public String getDevicenumber() {
		return devicenumber;
	}
	/**
	 * 设置：
	 */
	public void setVin(String vin) {
		this.vin = vin;
	}
	/**
	 * 获取：
	 */
	public String getVin() {
		return vin;
	}
	/**
	 * 设置：设备种类方便归类查询
	 */
	public void setDevicetype(Integer devicetype) {
		this.devicetype = devicetype;
	}
	/**
	 * 获取：设备种类方便归类查询
	 */
	public Integer getDevicetype() {
		return devicetype;
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
	public Integer getIsMain() {
		return isMain;
	}
	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
}

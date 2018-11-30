package qjm.data.synch.modle;

import java.util.Date;

public class TspAoyiCondition {
	private Integer id;
	private String deviceNumber;
	private Date acquisitionTime;//采集时间
	private Double latitude;//纬度
	private Double longitude;//经度
	private Float totalDistance;//总里程--每次的相对或者累积里程相加
	private Float batSOC;//设备电池电量
	private Float vehicleSpeed;//车速
	private String vin;
	private Date timestamp;
	private Date createTime;
	private String plateLicenseNo;//车牌号
	/**
	 * 行驶时间
	 * 说明: 持续开车时间 单位为 分钟
	 */
	private int runningTime;

	/**
	 * 停车时间
	 * 说明: 持续停车时间 单位为 分钟
	 */
	private int parkingTime;

	/**
	 * 相对里程
	 * 说明: 相对前一个轨迹点的里程 单位为 米
	 */
	private int relativeMileage;

	/**
	 * 累计里程
	 * 说明: 持续开车里程 单位为 米
	 */
	private int sumMileage;

	/**
	 * 设备温度值
	 * 
	 * 说明:	单位 1 摄氏度
	 */
	private int temperature; 

	/**
	 * 状态
	 * 
	 * 说明:	
	 * 	BITO:表示装载状态
	 * 		0:空载  1:装载
	 * 	BIT1:表示外界电池状态
	 * 		0:电池供电 1:外界电源
	 * 	BIT2:拆盖指示
	 * 		0:未拆盖 1:拆盖
	 */
	private int status; 
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}

	public Date getAcquisitionTime() {
		return acquisitionTime;
	}

	public void setAcquisitionTime(Date acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Float getTotalDistance() {
		return totalDistance;
	}

	public void setTotalDistance(Float totalDistance) {
		this.totalDistance = totalDistance;
	}

	public Float getBatSOC() {
		return batSOC;
	}

	public void setBatSOC(Float batSOC) {
		this.batSOC = batSOC;
	}

	public Float getVehicleSpeed() {
		return vehicleSpeed;
	}

	public void setVehicleSpeed(Float vehicleSpeed) {
		this.vehicleSpeed = vehicleSpeed;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPlateLicenseNo() {
		return plateLicenseNo;
	}

	public void setPlateLicenseNo(String plateLicenseNo) {
		this.plateLicenseNo = plateLicenseNo;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public int getParkingTime() {
		return parkingTime;
	}

	public void setParkingTime(int parkingTime) {
		this.parkingTime = parkingTime;
	}

	public int getRelativeMileage() {
		return relativeMileage;
	}

	public void setRelativeMileage(int relativeMileage) {
		this.relativeMileage = relativeMileage;
	}

	public int getSumMileage() {
		return sumMileage;
	}

	public void setSumMileage(int sumMileage) {
		this.sumMileage = sumMileage;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	
	
	

}

package qjm.data.synch.modle;

import java.util.Date;

/*
 * 实时事件数据
 * 
 * 
 * 
 */
public class TspVehicleEvent {
	private Integer id;
	private Double latitude;
	private Double longitude;
	private String sign;
	private String appKey;
	private String vin;
	private Date acquisitionTime;
	private String event;
	private Float totalDistance;
	private Date timestamp;
	private Date createtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Date getAcquisitionTime() {
		return acquisitionTime;
	}
	public void setAcquisitionTime(Date acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Float getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(Float totalDistance) {
		this.totalDistance = totalDistance;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
	
}

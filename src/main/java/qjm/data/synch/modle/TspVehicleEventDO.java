package qjm.data.synch.modle;

import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.hbase.HbaseSerializationReflect;

import java.util.Date;

/*
 * 实时事件数据
 * 
 * 
 * 
 */
public class TspVehicleEventDO extends HbaseSerializationReflect<EducationExperience> {
	private Integer id;
	private Float latitude;
	private String sign;
	private String appKey;
	private String vin;
	private Date acquisitionTime;
	private String event;
	private Float totalDistance;
	private Date timestamp;
	private Float longitude;
	private Date createtime;
	
	private String plateLicenseNo;
	
	
	public String getPlateLicenseNo() {
		return plateLicenseNo;
	}
	public void setPlateLicenseNo(String plateLicenseNo) {
		this.plateLicenseNo = plateLicenseNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
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
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public byte[] getKey() {
		return Bytes.toBytes(id);
	}
	
}

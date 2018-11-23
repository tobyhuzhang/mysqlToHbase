package qjm.data.synch.modle;

import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.hbase.HbaseSerializationReflect;

import java.util.Date;

public class TemperatureRecordDO extends HbaseSerializationReflect<EducationExperience> {
	public Integer id;
	public String vin;
	public String plateLicenseNo;//车牌号
	public String deviceNumber;//设备编码
	public Float temperature1;
	public Float temperature2;
	public Float temperature3;
	public Float temperature4;
	public Float temperature5;
	public Date createTime;
	public Date timestamp;
	private Integer humidity;//湿度
	private Double latitude;//纬度
	private Double longitude;//经度
	private Integer photoreceptor;//光感
	private Integer electricity;//电量
	private Integer maxStrength;//信号强度
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getPlateLicenseNo() {
		return plateLicenseNo;
	}
	public void setPlateLicenseNo(String plateLicenseNo) {
		this.plateLicenseNo = plateLicenseNo;
	}
	public String getDeviceNumber() {
		return deviceNumber;
	}
	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	public Float getTemperature1() {
		return temperature1;
	}
	public void setTemperature1(Float temperature1) {
		this.temperature1 = temperature1;
	}
	public Float getTemperature2() {
		return temperature2;
	}
	public void setTemperature2(Float temperature2) {
		this.temperature2 = temperature2;
	}
	public Float getTemperature3() {
		return temperature3;
	}
	public void setTemperature3(Float temperature3) {
		this.temperature3 = temperature3;
	}
	public Float getTemperature4() {
		return temperature4;
	}
	public void setTemperature4(Float temperature4) {
		this.temperature4 = temperature4;
	}
	public Float getTemperature5() {
		return temperature5;
	}
	public void setTemperature5(Float temperature5) {
		this.temperature5 = temperature5;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
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
	public Integer getPhotoreceptor() {
		return photoreceptor;
	}
	public void setPhotoreceptor(Integer photoreceptor) {
		this.photoreceptor = photoreceptor;
	}
	public Integer getElectricity() {
		return electricity;
	}
	public void setElectricity(Integer electricity) {
		this.electricity = electricity;
	}
	public Integer getMaxStrength() {
		return maxStrength;
	}
	public void setMaxStrength(Integer maxStrength) {
		this.maxStrength = maxStrength;
	}
	public byte[] getKey() {
		return Bytes.toBytes(id);
	}
}

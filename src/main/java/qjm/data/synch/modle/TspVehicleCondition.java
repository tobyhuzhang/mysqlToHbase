package qjm.data.synch.modle;

import org.apache.hadoop.hbase.util.Bytes;
import qjm.data.synch.annotation.Family;
import qjm.data.synch.annotation.Table;
import qjm.data.synch.hbase.HbaseSerializationReflect;

import java.util.Date;

@Table("tspVehicleCondition")
@Family("option")
public class TspVehicleCondition extends HbaseSerializationReflect<TspVehicleCondition> {
    private Integer id;
    private Date acquisitionTime;//采集时间
    private Float batteryVoltage;//电池电压
    private Float engineSpeed;//发动机转速
    private Float fuel;//燃料
    private Double latitude;//纬度
    private Double longitude;//经度
    private Float totalDistance;//总里程
    private Float vehBatSOC;//电池电量
    private Float vehicleSpeed;//车速
    private String vin;
    private Date timestamp;
    private Date createTime;
    private Float temp;//温度
    private Integer humidity;//湿度
    private String plateLicenseNo;//车牌号
    private Date searchTime;//查询时间，用于在Redis中表明当日前的历史最新一条记录是哪一天更新的

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(Float engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public Float getFuel() {
        return fuel;
    }

    public void setFuel(Float fuel) {
        this.fuel = fuel;
    }

    public Float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Float totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Float getVehBatSOC() {
        return vehBatSOC;
    }

    public void setVehBatSOC(Float vehBatSOC) {
        this.vehBatSOC = vehBatSOC;
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

    public Date getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(Date acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public Float getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Float batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
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

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public String getPlateLicenseNo() {
        return plateLicenseNo;
    }

    public void setPlateLicenseNo(String plateLicenseNo) {
        this.plateLicenseNo = plateLicenseNo;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public byte[] getKey() {
        return Bytes.toBytes(vin + "." + acquisitionTime.getTime() / 1000);
    }
}

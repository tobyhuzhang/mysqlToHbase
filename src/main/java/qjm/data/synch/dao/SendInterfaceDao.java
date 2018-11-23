package qjm.data.synch.dao;

import qjm.data.synch.modle.*;

import java.util.List;
import java.util.Map;

public interface SendInterfaceDao {
    public TspVehicleConditionDO getDataByVin(String vin);

    public TemperatureRecordDO getTemp(String deviceNumber);

    public TspVehicleConditionDO getHisBeforeToday(Map<String, String> paramMap);

    public Float calPath(Map<String, String> paramMap);

    public Float getTotalDistanceByVin(String vin);

    public List<TspVehicleConditionDO> getTSPDataByVin(Map<String, String> queryMap);

    public VehicleDO getVehicleByVin(String vin);

    public List<DeviceVinDO> getDeviceVinByVin(String vin);

    /**
     * 根据vin和时间，获取该时间之前的最后一条数据
     *
     * @return
     */
    public TspVehicleConditionDO getDataBeforeTimeLast(Map<String, String> paramMap);

    /**
     * 根据vin和时间，获取该时间之后的第一条数据
     *
     * @return
     */
    public TspVehicleConditionDO getDataAfterTimeFirst(Map<String, String> paramMap);

    /**
     * 查询设备车辆映射集合
     */
    public List<DeviceVinDO> getDeviceVinList(Map<String, String> paramMap);

    /**
     * 添加一条车辆&互联网设备的绑定信息
     */
    public int saveDeviceVin(DeviceVinDO deviceVin);

    /**
     * 删除车辆&互联网设备绑定信息，可以是多条，以提供的条件为准
     */
    public int deleteDeviceVin(DeviceVinDO deviceVin);

    /**
     * 获得综合数据最后一条
     */
    public TspCompleteConditionDO getCompleteDataByVin(String vin);

    /**
     * 根据vin和时间段查询综合车况数据
     * 参数vin、fromTime、toTime
     */
    public List<TspCompleteConditionDO> searchCompleteConByTime(Map<String, String> queryMap);
}

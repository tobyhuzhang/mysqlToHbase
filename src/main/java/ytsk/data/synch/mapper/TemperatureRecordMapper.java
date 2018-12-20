package ytsk.data.synch.mapper;
/**
 * Created by huyan 2018/12/20
 */

import ytsk.data.synch.model.TemperatureRecord;

import java.util.List;
import java.util.Map;

/**
 * @author huyan
 * @create 2018 12 20 9:37
 */
public interface TemperatureRecordMapper {
    List<TemperatureRecord> selectThousand(Map<String,Object> params);
    int insertCondition(TemperatureRecord tspVehicleCondition);
    TemperatureRecord selectByPrimaryKey(Long id);
    int insertByBatch(List<TemperatureRecord> tspCompleteConditions);
}

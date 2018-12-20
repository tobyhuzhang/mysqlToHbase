package ytsk.data.synch.mapper;
/**
 * Created by huyan 2018/12/18
 */

import ytsk.data.synch.model.TspVehicleCondition;

import java.util.List;
import java.util.Map;

/**
 * @author huyan
 * @create 2018 12 18 15:23
 */
public interface TspVehicleConditionMapper {
    int insertCondition(TspVehicleCondition tspVehicleCondition);
    TspVehicleCondition selectByPrimaryKey(Long id);
    //int insertByBatch(List<TspVehicleCondition> tspCompleteConditions);
    List<TspVehicleCondition> selectThousand(Map<String,Object> params);

}

package ytsk.data.synch.mapper;
/**
 * Created by huyan 2018/12/20
 */

import ytsk.data.synch.model.TspVehicleEvent;

import java.util.List;
import java.util.Map;

/**
 * @author huyan
 * @create 2018 12 20 9:33
 */
public interface TspVehicleEventMapper {
    int insertCondition(TspVehicleEvent tspVehicleCondition);

    TspVehicleEvent selectByPrimaryKey(Long id);

    int insertByBatch(List<TspVehicleEvent> tspCompleteConditions);

    List<TspVehicleEvent> selectThousand(Map<String, Object> params);
}

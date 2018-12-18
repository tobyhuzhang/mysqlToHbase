package qjm.data.synch.mapper;
/**
 * Created by huyan 2018/12/18
 */

import qjm.data.synch.modle.TspVehicleCondition;

import java.util.List;

/**
 * @author huyan
 * @create 2018 12 18 15:23
 */
public interface TspVehicleConditionMapper {
    void insertCondition(TspVehicleCondition tspVehicleCondition);
    TspVehicleCondition selectByPrimaryKey(Long id);
    int countAll();
    void insertByBatch(List<TspVehicleCondition> tspCompleteConditions);
}

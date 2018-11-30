package qjm.data.synch.mapper;


import qjm.data.synch.modle.TemperatureRecord;
import qjm.data.synch.modle.TspCompleteCondition;
import qjm.data.synch.modle.TspVehicleCondition;
import qjm.data.synch.modle.TspVehicleEvent;

import java.util.List;

public interface TspConditionMapper {
     void insertCondition(TspVehicleCondition tspVehicleCondition);

     void insertEvent(TspVehicleEvent tspVehicleEvent);

     void insertTempRecord(TemperatureRecord temperatureRecord);

     void insertCompleteCondition(TspCompleteCondition tspCompleteCondition);

     int countAll();

     void insertByBatch(List<TspCompleteCondition> tspCompleteConditions);

     int selectThousand(TspCompleteCondition tspCompleteCondition);
}

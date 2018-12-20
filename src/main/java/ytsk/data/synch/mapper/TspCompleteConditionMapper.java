package ytsk.data.synch.mapper;


import ytsk.data.synch.model.TspCompleteCondition;

import java.util.List;
import java.util.Map;

public interface TspCompleteConditionMapper {


    int insertCompleteCondition(TspCompleteCondition tspCompleteCondition);

    List<TspCompleteCondition> selectThousand(Map<String,Object> params);

    TspCompleteCondition selectByPrimaryKey(Long id);
}

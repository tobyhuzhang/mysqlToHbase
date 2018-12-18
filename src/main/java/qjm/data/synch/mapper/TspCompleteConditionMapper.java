package qjm.data.synch.mapper;


import qjm.data.synch.modle.TspCompleteCondition;

public interface TspCompleteConditionMapper {


    void insertCompleteCondition(TspCompleteCondition tspCompleteCondition);

    int countAll();


    int selectThousand(TspCompleteCondition tspCompleteCondition);

    TspCompleteCondition selectByPrimaryKey(Long id);
}

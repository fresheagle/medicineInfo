package com.med.info.mapper;

import java.util.List;
import java.util.Map;

import com.med.info.domain.Miss_control_task_records;

public interface Miss_control_task_recordsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int deleteByPrimaryKey(String taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insert(Miss_control_task_records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int insertSelective(Miss_control_task_records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    Miss_control_task_records selectByPrimaryKey(String taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_control_task_records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_control_task_records record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_records
     *
     * @mbg.generated Mon Nov 26 11:32:45 CST 2018
     */
    int updateByPrimaryKey(Miss_control_task_records record);
    
    void updateByTaskIdSelective(Miss_control_task_records record);
    
    List<Miss_control_task_records> selectPageBySelective(Map map);

    List<Miss_control_task_records> getCurrentTrialStatusByTaskids(List<String> taskIds);
}
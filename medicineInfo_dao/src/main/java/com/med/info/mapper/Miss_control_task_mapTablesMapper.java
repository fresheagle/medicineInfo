package com.med.info.mapper;

import com.med.info.domain.Miss_control_task_mapTables;

public interface Miss_control_task_mapTablesMapper extends BaseMapper<Miss_control_task_mapTables>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    int deleteByPrimaryKey(String tasktableuuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    int insert(Miss_control_task_mapTables record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    int insertSelective(Miss_control_task_mapTables record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    Miss_control_task_mapTables selectByPrimaryKey(String tasktableuuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_control_task_mapTables record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Miss_control_task_mapTables record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_task_maptables
     *
     * @mbg.generated Thu Nov 22 14:58:41 CST 2018
     */
    int updateByPrimaryKey(Miss_control_task_mapTables record);
}
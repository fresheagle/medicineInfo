package com.med.info.mapper;

import com.med.info.domain.Miss_control_actionLog;

public interface Miss_control_actionLogMapper extends BaseMapper<Miss_control_actionLog>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_actionLog
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(String doactionuuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_actionLog
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_control_actionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_actionLog
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_control_actionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_actionLog
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_control_actionLog selectByPrimaryKey(String doactionuuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_actionLog
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_control_actionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_actionLog
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_control_actionLog record);
}
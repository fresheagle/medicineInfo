package com.med.info.mapper;

import java.util.List;

import com.med.info.domain.Miss_control_roleAndAction;

public interface Miss_control_roleAndActionMapper extends BaseMapper<Miss_control_roleAndAction>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_roleAndAction
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(String rauuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_roleAndAction
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_control_roleAndAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_roleAndAction
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_control_roleAndAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_roleAndAction
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_control_roleAndAction selectByPrimaryKey(String rauuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_roleAndAction
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_control_roleAndAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_roleAndAction
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_control_roleAndAction record);
    
    int deleteByRoleCode(String rolecode);
    
    List<Miss_control_roleAndAction> selectByRoleCode(Miss_control_roleAndAction miss_control_roleAndAction);
}
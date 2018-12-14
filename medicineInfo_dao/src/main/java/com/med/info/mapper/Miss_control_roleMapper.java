package com.med.info.mapper;

import com.med.info.domain.Miss_control_role;

public interface Miss_control_roleMapper extends BaseMapper<Miss_control_role>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_role
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int deleteByPrimaryKey(String roleuuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_role
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insert(Miss_control_role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_role
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int insertSelective(Miss_control_role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_role
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    Miss_control_role selectByPrimaryKey(String roleuuid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_role
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKeySelective(Miss_control_role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_role
     *
     * @mbg.generated Sat Nov 17 18:29:49 CST 2018
     */
    int updateByPrimaryKey(Miss_control_role record);

    Miss_control_role selectByRoleCode(String rolecode);
}
package com.med.info.mapper;

import com.med.info.domain.Miss_control_approval;

public interface Miss_control_approvalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    int insert(Miss_control_approval record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    int insertSelective(Miss_control_approval record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    Miss_control_approval selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    int updateByPrimaryKeySelective(Miss_control_approval record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Miss_control_approval record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Tue Jan 01 00:34:03 CST 2019
     */
    int updateByPrimaryKey(Miss_control_approval record);
}
package com.med.info.mapper;

import java.util.List;

import com.med.info.domain.Miss_control_approval;
import com.med.info.domain.Miss_control_approvalWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface Miss_control_approvalMapper extends BaseMapper<Miss_control_approvalWithBLOBs>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    int insert(Miss_control_approvalWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    int insertSelective(Miss_control_approvalWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    Miss_control_approvalWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    int updateByPrimaryKeySelective(Miss_control_approvalWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Miss_control_approvalWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table miss_control_approval
     *
     * @mbg.generated Wed Jan 02 22:18:51 CST 2019
     */
    int updateByPrimaryKey(Miss_control_approval record);
    
    /**
     * 按照taskId查询所有审批结果
     * @param record
     * @return Miss_control_approvalWithBLOBs
     */
    List<Miss_control_approvalWithBLOBs> showByTaskId(Miss_control_approvalWithBLOBs record);

    int updateByTaskIdAndModel(Miss_control_approvalWithBLOBs approvalWithBLOBs);

    void deleteByTaskId(@Param("taskId") String taskId);
}
package com.group5.manager.dao;

import com.group5.manager.entity.TransferStatement;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface TransferStatementDao extends Mapper<TransferStatement>, MySqlMapper<TransferStatement> {

}
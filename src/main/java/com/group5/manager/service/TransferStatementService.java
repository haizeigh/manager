package com.group5.manager.service;

import com.group5.manager.dao.TransferStatementDao;
import com.group5.manager.entity.TransferStatement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yl
 * @date 2020-06-19
 */
@Service
@Slf4j
public class TransferStatementService {

    @Resource
    private TransferStatementDao transferStatementDao;

    public TransferStatement createTransferStatement(TransferStatement transferStatement){
        transferStatementDao.insertSelective(transferStatement);
        return transferStatement;

    }
}

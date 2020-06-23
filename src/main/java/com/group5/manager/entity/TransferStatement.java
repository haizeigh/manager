package com.group5.manager.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * transfer_statement
 * @author 
 */
@Data
@NoArgsConstructor
@Table(name = "transfer_statement")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransferStatement implements Serializable {


    @Id
    private String id;

    private String accountName;

    private String accountNumber;

    private Double transferAmount;

    private String transferType;

    private String goodName;

    private String transferAccountNumber;

    private Integer status;

    private Integer isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
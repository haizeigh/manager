package com.group5.manager.model.response;

import lombok.Data;

/**
 * @author yl
 * @date 2020-06-19
 */
@Data
public class AccountDetailResponse {

    private String customerName;

    private String customernumber;

    private String accountnumber;

    private String availablebalance;

    private String currencycode;
}

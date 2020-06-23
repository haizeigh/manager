package com.group5.manager.model.request;

import com.google.common.base.Strings;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yl
 * @date 2020-06-19
 */
@Data
@NoArgsConstructor
public class AccountTransferRequest {

    private String transferInAccountNumber;

    private Double transferAmount;

    private String transferOutAccountNumber;

    private String transferOutAccountName;

    private String transferType;

    private String goodName;



    public boolean isValid(){
        return  transferAmount != null ;
    }


}

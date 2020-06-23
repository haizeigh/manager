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
public class AccountDepositRequest {

    private String accountNumber;

    private String depositAmount;

    private String currencycode;

    public boolean isValid(){
        return  !Strings.isNullOrEmpty(depositAmount) && !Strings.isNullOrEmpty(currencycode);
    }


}

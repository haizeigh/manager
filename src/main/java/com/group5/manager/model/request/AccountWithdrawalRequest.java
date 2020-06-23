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
public class AccountWithdrawalRequest {

    private String accountNumber;

    private String withDrawalAmount;

    private String currencycode;

    public boolean isValid(){
        return  !Strings.isNullOrEmpty(withDrawalAmount) && !Strings.isNullOrEmpty(currencycode);
    }


}

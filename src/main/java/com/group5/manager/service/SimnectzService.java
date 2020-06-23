package com.group5.manager.service;

import com.group5.manager.entity.TransferStatement;
import com.group5.manager.model.ManagerResult;
import com.group5.manager.model.dto.RequestParameter;
import com.group5.manager.model.request.AccountTransferRequest;
import com.group5.manager.model.response.AccountDetailResponse;
import com.group5.manager.utils.GsonUtil;
import com.group5.manager.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yl
 * @date 2020-06-19
 */
@Service
@Slf4j
public class SimnectzService {


    private String queryAccountDetailUrl = "https://simnectzplatform.com/gateway/Simnectz_Bank/account_details_enquiry_presentation/deposit/account/accountDetails/accountNumber";

    private String depositUrl = "https://simnectzplatform.com/gateway/Simnectz_Bank/deposit_presentation/deposit/account/deposit";

    private String withdrawalUrl = "https://simnectzplatform.com/gateway/Simnectz_Bank/withdrawal_presentation//deposit/account/withdrawal";

    private String transferUrl = "https://simnectzplatform.com/gateway/Simnectz_Bank/transfer_presentation//deposit/account/transfer";

    @Resource
    private TransferStatementService transferStatementService;

    public AccountDetailResponse queryAccountDetail(RequestParameter requestParameter){

        String queryUrl = requestParameter.translateRequestUrl(queryAccountDetailUrl);
        String queryResult = HttpUtil.doPost(queryUrl, requestParameter.getHeaderMap(), "");
        HashMap queryResultMap = GsonUtil.fromJsonString(queryResult, new HashMap<>().getClass());
        Map dataMap = (Map)queryResultMap.get("data");
        Map customerMap = (Map)dataMap.get("customer");
        Map accountMap = (Map)dataMap.get("account");

        AccountDetailResponse accountDetailResponse = new AccountDetailResponse();
        accountDetailResponse.setCustomerName(customerMap.get("customerName").toString());
        accountDetailResponse.setCustomernumber(customerMap.get("customernumber").toString());

        accountDetailResponse.setAccountnumber(accountMap.get("accountnumber").toString());
        accountDetailResponse.setAvailablebalance(accountMap.get("availablebalance").toString());
        accountDetailResponse.setCurrencycode(accountMap.get("currencycode").toString());
        return accountDetailResponse;


    }


    public boolean deposit(RequestParameter requestParameter){

        HttpUtil.doPost(depositUrl, requestParameter.getHeaderMap(), requestParameter.getBody());
        return true;
    }

    public boolean withdrawal(RequestParameter requestParameter){

        HttpUtil.doPost(withdrawalUrl, requestParameter.getHeaderMap(), requestParameter.getBody());
        return true;
    }


    public boolean transfer(RequestParameter requestParameter, AccountTransferRequest accountTransferRequest) {

        String messageid = requestParameter.getHeaderMap().get("messageid").toString();
        TransferStatement transferStatement = generateTransferStatement(messageid, accountTransferRequest);

        transferStatementService.createTransferStatement(transferStatement);
        HttpUtil.doPost(transferUrl, requestParameter.getHeaderMap(), requestParameter.getBody());
        return true;
    }

    private TransferStatement generateTransferStatement(String id , AccountTransferRequest accountTransferRequest){

        return TransferStatement
                .builder()
                .id(id)
                .accountName(accountTransferRequest.getTransferOutAccountName())
                .accountNumber(accountTransferRequest.getTransferOutAccountNumber())

                .transferAmount(accountTransferRequest.getTransferAmount())
                .transferType(accountTransferRequest.getTransferType())
                .goodName(accountTransferRequest.getGoodName())

                .transferAccountNumber(accountTransferRequest.getTransferInAccountNumber())
                .status(1)
                .updateTime(new Date())
                .build();

    }
}

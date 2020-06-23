package com.group5.manager.controller;

import com.group5.manager.model.ManagerResult;
import com.group5.manager.model.dto.RequestParameter;
import com.group5.manager.model.request.AccountDepositRequest;
import com.group5.manager.model.request.AccountTransferRequest;
import com.group5.manager.model.request.AccountWithdrawalRequest;
import com.group5.manager.model.response.AccountDetailResponse;
import com.group5.manager.service.SimnectzService;
import com.group5.manager.utils.GsonUtil;
import com.group5.manager.utils.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yl
 * @date 2020-06-18
 */
@RestController
@RequestMapping("account")
@Slf4j
public class DepositController {

    @Resource
    SimnectzService simnectzService;

    String customerNumber = "842000531517";

    String firstAccountNumber = "HK080001106003321804001";

    String secondAccountNumber = "HK240001106003672333001";

    String creditCardAccountNumber = "5000010035399607";

    String clientid = "ZX709773(9)";


//    第二个用户 CHIU
    String CHIUCustomerNumber = "838000531519";
    String CHIUAccountNumber = "HK300001101003318624001";

    @RequestMapping(value = "/query/detail",
            method = RequestMethod.GET)
    public ManagerResult queryAccountDetail(@RequestParam(value = "accountNumber", required = false) String accountNumber) {


        RequestParameter requestParameter = new RequestParameter();
        requestParameter.putHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNoszs0KwjAQBOB3yUnBQ9L81qN6UATP4i3ZXbXQJpK2oojvbgJev2Fn9sOQntSnB-XDjq1ZUEp4rr1vBChywV0bA41EgBbRgWUrBmmOU35vE1I52B8r9eRzF29_45yLoiH7CPe_CW4K9enWxZMfqlzOlrfWykW7rBXzOKWB8mkeAuUSO9WUHi2FFnV19BE36XXAEmkNZLhBRba8S6KVXjvjDGorhYPAvj8AAAD__w.lB8-EIfynN5PQZnGb5h8YvibVveqjXsrhnf6XxGxGOh3XiTZifhODb7HewIjWhaX6U98a87dAC8GX9d19jXNyA");
        requestParameter.putHeader("messageid", IdUtil.getDatePrimaryKey());
        requestParameter.putHeader("clientid", clientid);
        requestParameter.putPath("accountNumber", firstAccountNumber);

        AccountDetailResponse accountDetailResponse = simnectzService.queryAccountDetail(requestParameter);
        return ManagerResult.success(accountDetailResponse);
    }

    @RequestMapping(value = "/deposit",
            method = RequestMethod.POST)
    public ManagerResult deposit(@RequestBody AccountDepositRequest accountDepositRequest) {


        if (!accountDepositRequest.isValid()){
            return ManagerResult.fail("请求参数不可以为空");
        }

        RequestParameter requestParameter = new RequestParameter();
        requestParameter.putHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNoszs0KwjAQBOB3yUnBQ9L81qN6UATP4i3ZXbXQJpK2oojvbgJev2Fn9sOQntSnB-XDjq1ZUEp4rr1vBChywV0bA41EgBbRgWUrBmmOU35vE1I52B8r9eRzF29_45yLoiH7CPe_CW4K9enWxZMfqlzOlrfWykW7rBXzOKWB8mkeAuUSO9WUHi2FFnV19BE36XXAEmkNZLhBRba8S6KVXjvjDGorhYPAvj8AAAD__w.lB8-EIfynN5PQZnGb5h8YvibVveqjXsrhnf6XxGxGOh3XiTZifhODb7HewIjWhaX6U98a87dAC8GX9d19jXNyA");
        requestParameter.putHeader("messageid", IdUtil.getDatePrimaryKey());
        requestParameter.putHeader("clientid", clientid);

        accountDepositRequest.setAccountNumber(firstAccountNumber);
        requestParameter.setBody(GsonUtil.toJsonString(accountDepositRequest));

        boolean depositResult = simnectzService.deposit(requestParameter);
        return ManagerResult.create(depositResult);
    }

    @RequestMapping(value = "/withdrawal",
            method = RequestMethod.POST)
    public ManagerResult withdrawal(@RequestBody AccountWithdrawalRequest accountWithdrawalRequest) {


        if (!accountWithdrawalRequest.isValid()){
            return ManagerResult.fail("请求参数不可以为空");
        }

        RequestParameter requestParameter = new RequestParameter();
        requestParameter.putHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNoszs0KwjAQBOB3yUnBQ9L81qN6UATP4i3ZXbXQJpK2oojvbgJev2Fn9sOQntSnB-XDjq1ZUEp4rr1vBChywV0bA41EgBbRgWUrBmmOU35vE1I52B8r9eRzF29_45yLoiH7CPe_CW4K9enWxZMfqlzOlrfWykW7rBXzOKWB8mkeAuUSO9WUHi2FFnV19BE36XXAEmkNZLhBRba8S6KVXjvjDGorhYPAvj8AAAD__w.lB8-EIfynN5PQZnGb5h8YvibVveqjXsrhnf6XxGxGOh3XiTZifhODb7HewIjWhaX6U98a87dAC8GX9d19jXNyA");
        requestParameter.putHeader("messageid", IdUtil.getDatePrimaryKey());
        requestParameter.putHeader("clientid", clientid);

        accountWithdrawalRequest.setAccountNumber(firstAccountNumber);
        requestParameter.setBody(GsonUtil.toJsonString(accountWithdrawalRequest));

        boolean depositResult = simnectzService.withdrawal(requestParameter);
        return ManagerResult.create(depositResult);
    }


    @RequestMapping(value = "/transfer",
            method = RequestMethod.POST)
    public ManagerResult transfer(@RequestBody AccountTransferRequest accountTransferRequest) {


        if (!accountTransferRequest.isValid()){
            return ManagerResult.fail("请求参数不可以为空");
        }

        RequestParameter requestParameter = new RequestParameter();
        requestParameter.putHeader("token", "eyJhbGciOiJIUzUxMiIsInppcCI6IkRFRiJ9.eNoszs0KwjAQBOB3yUnBQ9L81qN6UATP4i3ZXbXQJpK2oojvbgJev2Fn9sOQntSnB-XDjq1ZUEp4rr1vBChywV0bA41EgBbRgWUrBmmOU35vE1I52B8r9eRzF29_45yLoiH7CPe_CW4K9enWxZMfqlzOlrfWykW7rBXzOKWB8mkeAuUSO9WUHi2FFnV19BE36XXAEmkNZLhBRba8S6KVXjvjDGorhYPAvj8AAAD__w.lB8-EIfynN5PQZnGb5h8YvibVveqjXsrhnf6XxGxGOh3XiTZifhODb7HewIjWhaX6U98a87dAC8GX9d19jXNyA");
        requestParameter.putHeader("messageid", IdUtil.getDatePrimaryKey());
        requestParameter.putHeader("clientid", clientid);

        accountTransferRequest.setTransferOutAccountNumber(firstAccountNumber);
        accountTransferRequest.setTransferOutAccountName(customerNumber);
        requestParameter.setBody(GsonUtil.toJsonString(accountTransferRequest));

        boolean depositResult = simnectzService.transfer(requestParameter, accountTransferRequest);
        return ManagerResult.create(depositResult);
    }
}

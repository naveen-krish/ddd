package fundtransfer.service.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import fundtransfer.application.interfaces.IFundTransferService;
import fundtransfer.contracts.input.FundTransferRequest;
import fundtransfer.contracts.output.FundTransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="fundtransfer")
@Api(tags="FundTransfer")
public class FundTransferController {

    @Autowired
    IFundTransferService iFundTransferService;

    @ApiOperation(value = "Send Fund Transfer  ", tags = "FundTransfer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")})
    @RequestMapping(method = RequestMethod.POST, consumes={"application/json"})
    public FundTransferResponse sendTransfer(@RequestBody FundTransferRequest request)
    {
        FundTransferResponse fundTransferResponse = iFundTransferService.sendTransfer(request);
        return fundTransferResponse;
    }
}

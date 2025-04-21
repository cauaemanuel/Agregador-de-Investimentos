package casa.on.agregadordeinvestimentos.controller;

import casa.on.agregadordeinvestimentos.controller.DTO.AssociateAccountStockDto;
import casa.on.agregadordeinvestimentos.controller.DTO.StockListDTO;
import casa.on.agregadordeinvestimentos.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> createAssociateAccount(@PathVariable("accountId") String accountId,
                                              @RequestBody AssociateAccountStockDto dto){
        accountService.associateStock(accountId, dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<StockListDTO>> listStockAccount(@PathVariable("accountId") String accountId){
        var list = accountService.listStocks(accountId);
        return ResponseEntity.ok(list);
    }

}

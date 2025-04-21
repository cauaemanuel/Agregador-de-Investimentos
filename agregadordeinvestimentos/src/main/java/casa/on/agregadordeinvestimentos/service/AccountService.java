package casa.on.agregadordeinvestimentos.service;

import casa.on.agregadordeinvestimentos.client.BrapiClient;
import casa.on.agregadordeinvestimentos.controller.DTO.AssociateAccountStockDto;
import casa.on.agregadordeinvestimentos.controller.DTO.StockListDTO;
import casa.on.agregadordeinvestimentos.controller.map.AccountMapper;
import casa.on.agregadordeinvestimentos.entity.AccountStock;
import casa.on.agregadordeinvestimentos.entity.AccountStockId;
import casa.on.agregadordeinvestimentos.repository.AccountRepository;
import casa.on.agregadordeinvestimentos.repository.AccountStockRepository;
import casa.on.agregadordeinvestimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {


    @Value("#{environment.TOKEN}")
    private String TOKEN;

    private AccountRepository accountRepository;
    private StockRepository stockRepository;
    private AccountStockRepository accountStockRepository;
    private AccountMapper accountMapper;

    private BrapiClient brapiClient;

    public AccountService(AccountRepository accountRepository, StockRepository stockRepository, AccountStockRepository accountStockRepository, AccountMapper accountMapper, BrapiClient brapiClient) {
        this.accountRepository = accountRepository;
        this.stockRepository = stockRepository;
        this.accountStockRepository = accountStockRepository;
        this.accountMapper = accountMapper;
        this.brapiClient = brapiClient;
    }

    public void associateStock(String accountId, AssociateAccountStockDto dto) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var stock = stockRepository.findById(dto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

         var Id = new AccountStockId(account.getAccountId(), stock.getStockId());
         var accountStock = new AccountStock(Id,stock, account, dto.quantity());

         accountStockRepository.save(accountStock);
    }

    public List<StockListDTO> listStocks(String accountId) {
        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        var listStocks = account.getAccountStocks().stream()
                .map(a -> new StockListDTO(a.getStock()
                        .getStockId(),
                        a.getQuantity(),
                        getTotal(a.getQuantity(), a.getStock().getStockId())))
                .toList();

        return listStocks;
    }

    private Double getTotal(Integer quantity, String id){

        var response = brapiClient.getQuote(TOKEN, id);
        var price = response.results().getFirst().regularMarketPrice();

        return quantity * price;

    }

}

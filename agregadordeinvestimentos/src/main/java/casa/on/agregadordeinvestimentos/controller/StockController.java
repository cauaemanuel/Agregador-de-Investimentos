package casa.on.agregadordeinvestimentos.controller;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateStockDTO;
import casa.on.agregadordeinvestimentos.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/stocks")
public class StockController {

    private StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<CreateStockDTO> createStock(@RequestBody CreateStockDTO stockDTO){
        stockService.createStock(stockDTO);
        return ResponseEntity.ok().build();
    }
}

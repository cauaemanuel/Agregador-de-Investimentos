package casa.on.agregadordeinvestimentos.service;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateStockDTO;
import casa.on.agregadordeinvestimentos.controller.map.StockMapper;
import casa.on.agregadordeinvestimentos.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private StockRepository stockRepository;

    private StockMapper stockMapper;

    public StockService(StockRepository stockRepository, StockMapper stockMapper) {
        this.stockRepository = stockRepository;
        this.stockMapper = stockMapper;
    }

    public void createStock(CreateStockDTO stockDTO) {
        var stock = stockMapper.StockDtoToStock(stockDTO);
        stockRepository.save(stock);
    }
}

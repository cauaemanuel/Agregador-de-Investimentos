package casa.on.agregadordeinvestimentos.controller.map;

import casa.on.agregadordeinvestimentos.controller.DTO.CreateStockDTO;
import casa.on.agregadordeinvestimentos.entity.Stock;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-21T13:08:00-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24 (Oracle Corporation)"
)
@Component
public class StockMapperImpl implements StockMapper {

    @Override
    public Stock StockDtoToStock(CreateStockDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Stock stock = new Stock();

        stock.setStockId( dto.stockId() );
        stock.setDescription( dto.description() );

        return stock;
    }
}

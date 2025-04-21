package casa.on.agregadordeinvestimentos.controller.map;


import casa.on.agregadordeinvestimentos.controller.DTO.CreateStockDTO;
import casa.on.agregadordeinvestimentos.entity.Stock;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StockMapper {

    Stock StockDtoToStock(CreateStockDTO dto);
}

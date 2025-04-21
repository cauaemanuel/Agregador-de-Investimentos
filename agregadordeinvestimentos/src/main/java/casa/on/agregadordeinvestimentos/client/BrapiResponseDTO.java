package casa.on.agregadordeinvestimentos.client;

import java.util.List;

public record BrapiResponseDTO(List<StockDTO> results) {
}

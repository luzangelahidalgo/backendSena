package comcom.invoice.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FacturaRequestDto {

    private Integer proveedor;
    private String numeroFactura;
    private List<ItemsRequestDto> items;
    
}

package comcom.invoice.demo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemsRequestDto {
	
    private String producto;
    private Integer cantidad;
    private Integer precio;
}

package comcom.invoice.demo.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FacturaDto  {
    
    private Long idFactura;
    private Date fecha;
    private String nombreProveedor;
    private Long total;
    private String estado;
    private Integer nitProveedor;
}

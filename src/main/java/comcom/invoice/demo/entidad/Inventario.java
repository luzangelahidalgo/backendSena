package comcom.invoice.demo.entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventario")
public class Inventario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_inventario")
	private Long id_inventario;	
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "id_factura")
	private Integer id_factura;

	public Long getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Long id_inventario) {
		this.id_inventario = id_inventario;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getId_factura() {
		return id_factura;
	}

	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}

	
	
}

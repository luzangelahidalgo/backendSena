package comcom.invoice.demo.entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="items")
public class Items implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;


	@Column(name = "descripcion")
	private String descripcion;


	@Column(name = "precio")
	private Integer precio;


	@Column(name = "cantidad") 
	private Integer cantidad;
	
	@Column(name = "id_factura") 
	private Long idFactura;
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public Integer getCantidad() {
		return cantidad;
	}


	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	public Long getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}



}

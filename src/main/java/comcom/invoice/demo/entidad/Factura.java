package comcom.invoice.demo.entidad;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="factura")
public class Factura implements Serializable{

private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_factura")
	private Long id_factura;	
	
	
	@Column(name = "numero_factura")
	private String numero_factura;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "id_proveedor")
	private Integer id_proveedor;
	
	@Column(name = "id_estado")
	private Integer idEstado;
	
	public Long getId_factura() {
		return id_factura;
	}

	public void setId_factura(Long id_factura) {
		this.id_factura = id_factura;
	}

	public String getNumero_factura() {
		return numero_factura;
	}

	public void setNumero_factura(String numero_factura) {
		this.numero_factura = numero_factura;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(Integer id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
}

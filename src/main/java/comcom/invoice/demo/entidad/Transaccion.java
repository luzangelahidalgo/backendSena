package comcom.invoice.demo.entidad;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaccion")
public class Transaccion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_transaccion")
	private Long id_transaccion;

	@Column(name = "monto")
	private String monto;

	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "tipo_transaccion")
	private String tipo_transaccion;
	
	@Column(name = "id_inventario")
	private Integer id_inventario;
	
	public Long getId_transaccion() {
		return id_transaccion;
	}

	public void setId_transaccion(Long id_transaccion) {
		this.id_transaccion = id_transaccion;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo_transaccion() {
		return tipo_transaccion;
	}

	public void setTipo_transaccion(String tipo_transaccion) {
		this.tipo_transaccion = tipo_transaccion;
	}

	public Integer getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(Integer id_inventario) {
		this.id_inventario = id_inventario;
	}

}

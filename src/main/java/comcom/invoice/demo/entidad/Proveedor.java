package comcom.invoice.demo.entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Long id;
	
	@Column(name = "nit_proveedor") 
	private Integer nitProveedor ;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "nombre_representatelegal")
	private String nombreRepresentatelegal;
	
	@Column(name = "razon_social")
	private String razonSocial;
	
	@Column(name = "direccion")
	private String direccion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Integer nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreRepresentatelegal() {
		return nombreRepresentatelegal;
	}

	public void setNombreRepresentatelegal(String nombreRepresentatelegal) {
		this.nombreRepresentatelegal = nombreRepresentatelegal;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}

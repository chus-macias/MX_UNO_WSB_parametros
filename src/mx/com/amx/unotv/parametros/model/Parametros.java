package mx.com.amx.unotv.parametros.model;


/**
 * @author Jesus A. Macias Benitez
 *
 */
public class Parametros {

	private String fcIdParametro;
	private String fcValor;
	private Integer fiEstatus ;
	private Integer fiShowParameter ;
	private String fcDescripcion;

	public Parametros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parametros(String fcIdParametro, String fcValor, Integer fiEstatus, Integer fiShowParameter,
			String fcDescripcion) {
		super();
		this.fcIdParametro = fcIdParametro;
		this.fcValor = fcValor;
		this.fiEstatus = fiEstatus;
		this.fiShowParameter = fiShowParameter;
		this.fcDescripcion = fcDescripcion;
	}

	public String getFcIdParametro() {
		return fcIdParametro;
	}

	public void setFcIdParametro(String fcIdParametro) {
		this.fcIdParametro = fcIdParametro;
	}

	public String getFcValor() {
		return fcValor;
	}

	public void setFcValor(String fcValor) {
		this.fcValor = fcValor;
	}

	public Integer getFiEstatus() {
		return fiEstatus;
	}

	public void setFiEstatus(Integer fiEstatus) {
		this.fiEstatus = fiEstatus;
	}

	public Integer getFiShowParameter() {
		return fiShowParameter;
	}

	public void setFiShowParameter(Integer fiShowParameter) {
		this.fiShowParameter = fiShowParameter;
	}

	public String getFcDescripcion() {
		return fcDescripcion;
	}

	public void setFcDescripcion(String fcDescripcion) {
		this.fcDescripcion = fcDescripcion;
	}

	@Override
	public String toString() {
		return "Parametros [fcIdParametro=" + fcIdParametro + ", fcValor=" + fcValor + ", fiEstatus=" + fiEstatus
				+ ", fiShowParameter=" + fiShowParameter + ", fcDescripcion=" + fcDescripcion + "]";
	}

}

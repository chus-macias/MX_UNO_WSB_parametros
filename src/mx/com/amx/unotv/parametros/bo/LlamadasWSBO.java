package mx.com.amx.unotv.parametros.bo;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import mx.com.amx.unotv.parametros.bo.exception.LlamadasWSBOException;
import mx.com.amx.unotv.parametros.model.Parametros;
import mx.com.amx.unotv.parametros.model.ResponseParametros;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class LlamadasWSBO {

	
	private static Logger logger = Logger.getLogger(LlamadasWSBO.class);

	private RestTemplate restTemplate;
	private String URL_WS_BASE = "";
	private HttpHeaders headers = new HttpHeaders();
	private final Properties props = new Properties();

	public LlamadasWSBO() {
		super();
		restTemplate = new RestTemplate();
		ClientHttpRequestFactory factory = restTemplate.getRequestFactory();

		if (factory instanceof SimpleClientHttpRequestFactory) {
			((SimpleClientHttpRequestFactory) factory).setConnectTimeout(15 * 1000);
			((SimpleClientHttpRequestFactory) factory).setReadTimeout(15 * 1000);
			System.out.println("Inicializando rest template 1");
		} else if (factory instanceof HttpComponentsClientHttpRequestFactory) {
			((HttpComponentsClientHttpRequestFactory) factory).setReadTimeout(15 * 1000);
			((HttpComponentsClientHttpRequestFactory) factory).setConnectTimeout(15 * 1000);
			System.out.println("Inicializando rest template 2");
		}

		restTemplate.setRequestFactory(factory);
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			props.load(this.getClass().getResourceAsStream("/general.properties"));
		} catch (Exception e) {
			logger.error("[ConsumeWS::init]Error al iniciar y cargar arhivo de propiedades." + e.getMessage());

		}
		String ambiente = props.getProperty("ambiente");
		URL_WS_BASE = props.getProperty(ambiente + ".url.ws.base");
	}

	
	/**
	 * Metodo que obtiene lista de todos los Parametros 
	 * @param 
	 * @return ResponseParametros
	 * @throws LlamadasWSBOException
	 * */
	public ResponseParametros getAllParametros() throws LlamadasWSBOException  {
		String metodo = "getAllParametros";
		String URL_WS = URL_WS_BASE + metodo;
		
		
		logger.info(" ParametrosServicesImpl - getAllParametros  ");

		ResponseParametros request = new ResponseParametros();

		try {
			logger.info("URL_WS: " + URL_WS);
			

			restTemplate = new RestTemplate();

			HttpEntity<String> entity = new HttpEntity<String>("Accept=application/json; charset=utf-8", headers);
			request = restTemplate.postForObject(URL_WS + "/", entity, ResponseParametros.class);
			
			

			
			
			
			logger.info(" Registros obtenidos --> "+request.getLista().toString());
			logger.info(" Total Registros obtenidos --> "+request.getLista().size());

		} catch(RestClientResponseException rre){
			logger.error("RestClientResponseException getAllParametros [WS BO]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException getAllParametros [WS BO]: ", rre);
			throw new LlamadasWSBOException(rre.getResponseBodyAsString());			
		} catch(Exception e) {
			logger.error("Exception getAllParametros[WS BO]: ",e);
			throw new LlamadasWSBOException(e.getMessage());
		}
		return request;
	}

	
	/**
	 * Metodo que obtiene un objeto Parametro por su identificador (fcIdParametro)
	 * @param String idParametro
	 * @return Parametros
	 * @throws LlamadasWSBOException
	 * */
	public Parametros getParametroById(String idParametro) throws LlamadasWSBOException  {
		String metodo = "getParametroById";
		String URL_WS = URL_WS_BASE + metodo;
		

		Parametros request = null;

		try {
			logger.info("URL_WS: " + URL_WS);
		

			restTemplate = new RestTemplate();

			HttpEntity<String> entity = new HttpEntity<String>("Accept=application/json; charset=utf-8", headers);
			request = restTemplate.postForObject(URL_WS + "/"+idParametro, entity, Parametros.class);

		}catch(RestClientResponseException rre){
			logger.error("RestClientResponseException getParametroById [WS BO]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException getParametroById [WS BO]: ", rre);
			throw new LlamadasWSBOException(rre.getResponseBodyAsString());			
		} catch(Exception e) {
			logger.error("Exception getParametroById[WS BO]: ",e);
			throw new LlamadasWSBOException(e.getMessage());
		}
		return request;
	}

	
	/**
	 * Metodo que inserta un objeto  Parametro
	 * @param Parametros parametro
	 * @return int
	 * @throws LlamadasWSBOException
	 * */
	public int insertParametro(Parametros parametro) throws LlamadasWSBOException  {
		String metodo = "insertParametros";
		String URL_WS = URL_WS_BASE + metodo;
		

		Integer request = null;

		try {
			logger.info("URL_WS: " + URL_WS);
			

			restTemplate = new RestTemplate();
			request = restTemplate.postForObject(URL_WS , parametro, Integer.class);

		} catch(RestClientResponseException rre){
			logger.error("RestClientResponseException insertParametro [WS BO]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException insertParametro [WS BO]: ", rre);
			throw new LlamadasWSBOException(rre.getResponseBodyAsString());			
		} catch(Exception e) {
			logger.error("Exception insertParametro[WS BO]: ",e);
			throw new LlamadasWSBOException(e.getMessage());
		}
		return request;
	}

	
	/**
	 * Metodo que elimina un parametro 
	 * @param String idParametro
	 * @return int
	 * @throws LlamadasWSBOException
	 * */
	public int deleteParametro(String idParametro) throws LlamadasWSBOException {
		String metodo = "deleteParametros";
		String URL_WS = URL_WS_BASE + metodo;
		

		Integer request = null;

		try {
			logger.info("URL_WS: " + URL_WS);
		

			restTemplate = new RestTemplate();

			HttpEntity<String> entity = new HttpEntity<String>("Accept=application/json; charset=utf-8", headers);
			request = restTemplate.postForObject(URL_WS + "/"+idParametro, entity, Integer.class);

		} catch(RestClientResponseException rre){
			logger.error("RestClientResponseException deleteParametro [WS BO]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException deleteParametro [WS BO]: ", rre);
			throw new LlamadasWSBOException(rre.getResponseBodyAsString());			
		} catch(Exception e) {
			logger.error("Exception deleteParametro[WS BO]: ",e);
			throw new LlamadasWSBOException(e.getMessage());
		}
		return request;
	}

	

	/**
	 * Metodo que Acualiza un parametro 
	 * @param Parametros parametro
	 * @return int
	 * @throws LlamadasWSBOException
	 * */
	public int updateParametro(Parametros parametro) throws LlamadasWSBOException {
		String metodo = "updateParametros";
		String URL_WS = URL_WS_BASE + metodo;
		

		Integer request = null;

		try {
			logger.info("URL_WS: " + URL_WS);
		

			restTemplate = new RestTemplate();
			request = restTemplate.postForObject(URL_WS , parametro, Integer.class);

		} catch(RestClientResponseException rre){
			logger.error("RestClientResponseException updateParametro [WS BO]: " + rre.getResponseBodyAsString());
			logger.error("RestClientResponseException updateParametro [WS BO]: ", rre);
			throw new LlamadasWSBOException(rre.getResponseBodyAsString());			
		} catch(Exception e) {
			logger.error("Exception updateParametro[WS BO]: ",e);
			throw new LlamadasWSBOException(e.getMessage());
		}
		return request;
	}

}

package mx.com.amx.unotv.parametros.bo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import mx.com.amx.unotv.parametros.bo.exception.LlamadasWSBOException;
import mx.com.amx.unotv.parametros.bo.exception.ParametrosBOException;
import mx.com.amx.unotv.parametros.model.Parametros;
import mx.com.amx.unotv.parametros.model.ResponseParametros;

/**
 * @author Jesus A. Macias Benitez
 *
 */
public class ParametrosBO {

	private static Logger logger = Logger.getLogger(ParametrosBO.class);

	@Autowired
	private LlamadasWSBO llamadasWSBO;

	
	
	/**
	 * Metodo que obtiene lista de todos los Parametros 
	 * @param 
	 * @return ResponseParametros
	 * @throws ParametrosBOException
	 * */
	public ResponseParametros getAllParametros() throws ParametrosBOException {

		ResponseParametros response;
		try {

			response = llamadasWSBO.getAllParametros();

		} catch (LlamadasWSBOException e) {
			logger.error("LlamadasWSBOException en ParametrosBO-getAllParametros: " + e.getMessage());
			throw new ParametrosBOException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception en ParametrosBO-getAllParametros: ", e);
			throw new ParametrosBOException(e.getMessage());
		}

		return response;
	}

	
	
	/**
	 * Metodo que obtiene un objeto Parametro por su identificador (fcIdParametro)
	 * @param String idParametro
	 * @return Parametros
	 * @throws ParametrosBOException
	 * */
	public Parametros getParametroById(String idParametro) throws ParametrosBOException {
		Parametros parametro;
		try {
			parametro = llamadasWSBO.getParametroById(idParametro);

		} catch (LlamadasWSBOException e) {
			logger.error("LlamadasWSBOException en ParametrosBO-getParametroById: " + e.getMessage());
			throw new ParametrosBOException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception en ParametrosBO-getParametroById: ", e);
			throw new ParametrosBOException(e.getMessage());
		}

		return parametro;
	}

	
	/**
	 * Metodo que inserta un objeto  Parametro
	 * @param Parametros parametro
	 * @return int
	 * @throws ParametrosBOException
	 * */
	public int insertParametro(Parametros parametro) throws ParametrosBOException {
		int total = 0;

		try {
			total = llamadasWSBO.insertParametro(parametro);

		} catch (LlamadasWSBOException e) {
			logger.error("LlamadasWSBOException en ParametrosBO-insertParametro: " + e.getMessage());
			throw new ParametrosBOException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception en ParametrosBO-insertParametro: ", e);
			throw new ParametrosBOException(e.getMessage());
		}

		return total;

	}

	
	/**
	 * Metodo que elimina un parametro 
	 * @param String idParametro
	 * @return int
	 * @throws ParametrosBOException
	 * */
	public int deleteParametro(String idParametro) throws ParametrosBOException {
		int total = 0;

		try {
			total = llamadasWSBO.deleteParametro(idParametro);

		} catch (LlamadasWSBOException e) {
			logger.error("LlamadasWSBOException en ParametrosBO-deleteParametro: " + e.getMessage());
			throw new ParametrosBOException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception en ParametrosBO-deleteParametro: ", e);
			throw new ParametrosBOException(e.getMessage());
		}

		return total;

	}

	
	/**
	 * Metodo que Acualiza un parametro 
	 * @param Parametros parametro
	 * @return int
	 * @throws ParametrosBOException
	 * */
	public int updateParametro(Parametros parametro) throws ParametrosBOException {
		int total = 0;

		try {
			total = llamadasWSBO.updateParametro(parametro);

		} catch (LlamadasWSBOException e) {
			logger.error("LlamadasWSBOException en ParametrosBO-updateParametro: " + e.getMessage());
			throw new ParametrosBOException(e.getMessage());
		} catch (Exception e) {
			logger.error("Exception en ParametrosBO-updateParametro: ", e);
			throw new ParametrosBOException(e.getMessage());
		}

		return total;
	}
}

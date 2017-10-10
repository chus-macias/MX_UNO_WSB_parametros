package mx.com.amx.unotv.parametros.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.com.amx.unotv.parametros.bo.ParametrosBO;
import mx.com.amx.unotv.parametros.controller.exception.ControllerException;
import mx.com.amx.unotv.parametros.model.Parametros;
import mx.com.amx.unotv.parametros.model.ResponseParametros;


/**
 * @author Jesus A. Macias Benitez
 *
 */
@Controller
@RequestMapping("paramController")
public class ParametrosController {

	private static Logger logger = Logger.getLogger(ParametrosController.class);

	@Autowired
	private ParametrosBO parametrosBO;

	
	/**
	 * Metodo que obtiene lista de todos los Parametros 
	 * @param 
	 * @return ResponseParametros
	 * @throws ControllerException
	 * */
	@RequestMapping(value = "/getAllParametros", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public ResponseParametros getAllParametros() throws ControllerException {
		logger.info(" -- Parametros Controller  --");
		logger.info(" -- Se obtienen todos los Parametros  --");

		ResponseParametros response = null;
		try {
			response = parametrosBO.getAllParametros();

			logger.info(" Registros obtenidos --> " + response.getLista().toString());
			logger.info(" Total Registros obtenidos --> " + response.getLista().size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(" Exception getAllParametros[Controller]:", e);
			throw new ControllerException(e.getMessage());		
		}

		return response;

	}
	
	
	/**
	 * Metodo que obtiene un objeto Parametro por su identificador (fcIdParametro)
	 * @param String idParametro
	 * @return Parametros
	 * @throws ControllerException
	 * */
	@RequestMapping(value = "/getParametroById/{idParametro}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public Parametros getParametroById(@PathVariable String idParametro) throws ControllerException {
		logger.info(" -- Parametros Controller  --");
		logger.info(" -- Se Obtiene Parametro por Id  --");

		Parametros parametro = null;

		try {
			parametro = parametrosBO.getParametroById(idParametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(" Exception getParametroById[Controller]:", e);
			throw new ControllerException(e.getMessage());		
		}

		return parametro;
	}

	
	/**
	 * Metodo que inserta un objeto  Parametro
	 * @param Parametros parametro
	 * @return int
	 * @throws ControllerException
	 * */
	@RequestMapping(value = "/insertParametros", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int insertParametros(@RequestBody Parametros parametro) throws ControllerException {
		logger.info(" -- Parametros Controller  --");
		logger.info(" -- Se Inserta Parametro  --");

		int total = 0;

		try {
			total = parametrosBO.insertParametro(parametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(" Exception insertParametros[Controller]:", e);
			throw new ControllerException(e.getMessage());		
		}

		return total;

	}



	/**
	 * Metodo que Acualiza un parametro 
	 * @param Parametros parametro
	 * @return int
	 * @throws ControllerException
	 * */
	@RequestMapping(value = "/updateParametros", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int updateParametros(@RequestBody Parametros parametro) throws ControllerException {
		logger.info(" -- Parametros Controller  --");
		logger.info(" -- Se actualiza Parametro --");

		int total = 0;
		try {
			total = parametrosBO.updateParametro(parametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(" Exception updateParametros[Controller]:", e);
			throw new ControllerException(e.getMessage());		
		}

		return total;
	}

	
	
	/**
	 * Metodo que elimina un parametro 
	 * @param String idParametro
	 * @return int
	 * @throws ControllerException
	 * */
	@RequestMapping(value = "/deleteParametros/{idParametro}", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	@ResponseBody
	public int deleteParametros(@PathVariable String idParametro) throws ControllerException {
		logger.info(" -- Parametros Controller  --");
		logger.info(" -- Se Inserta Parametro  --");

		int total = 0;
		try {
			total = parametrosBO.deleteParametro(idParametro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(" Exception deleteParametros[Controller]:", e);
			throw new ControllerException(e.getMessage());		
		}
		return total;

	}

}

package mx.uv.tis.conversorDivisasPesos;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorDivisasPesosControlador {

    double valorDolar = 0.049;
    double valorLibra = 0.040;
    double valorFranco = 0.047;
    double valorYen = 6.46;
    double resultado = 0;

    @RequestMapping("/")
    public String home(){
        return("home");
    }
   
    @RequestMapping(value ="/dolares", method = RequestMethod.POST)
    public Double pesos_dolares(@RequestBody double cantidad){
        ConversorDivisasPesos cdp = new ConversorDivisasPesos();
        cdp.setCantidad(cantidad);
        cdp.setResultado(cdp.getCantidad()* valorDolar);
        return cdp.getResultado();
    }

    @RequestMapping(value ="/libras", method = RequestMethod.POST)
    public Double pesos_libras(@RequestBody int cantidad){
        ConversorDivisasPesos cdp = new ConversorDivisasPesos();
        cdp.setCantidad(cantidad);
        return cdp.getCantidad() * valorLibra;
    }

    @RequestMapping(value ="/francos", method = RequestMethod.POST)
    public Double pesos_francos(@RequestBody int cantidad){
        ConversorDivisasPesos cdp = new ConversorDivisasPesos();
        cdp.setCantidad(cantidad);
        return cdp.getCantidad() * valorFranco;
    }

    @RequestMapping(value ="/yenes", method = RequestMethod.POST)
    public Double pesos_yenes(@RequestBody int cantidad){
        ConversorDivisasPesos cdp = new ConversorDivisasPesos();
        cdp.setCantidad(cantidad);
        return cdp.getCantidad()* valorYen;
    }
    
}

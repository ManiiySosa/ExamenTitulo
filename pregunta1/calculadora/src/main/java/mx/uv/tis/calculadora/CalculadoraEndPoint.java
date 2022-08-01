package mx.uv.tis.calculadora;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.tis_uv_mx.calculadora.DividirRequest;
import https.tis_uv_mx.calculadora.DividirResponse;
import https.tis_uv_mx.calculadora.MultiplicarRequest;
import https.tis_uv_mx.calculadora.MultiplicarResponse;
import https.tis_uv_mx.calculadora.RestarRequest;
import https.tis_uv_mx.calculadora.RestarResponse;
import https.tis_uv_mx.calculadora.SumarRequest;
import https.tis_uv_mx.calculadora.SumarResponse;

@Endpoint
public class CalculadoraEndPoint {

    @PayloadRoot(localPart = "sumarRequest", namespace = "https://tis.uv.mx/calculadora")
    @ResponsePayload
    public SumarResponse sumar(@RequestPayload SumarRequest peticion){

        SumarResponse respuesta = new SumarResponse();
        respuesta.setRespuesta(peticion.getNumero1() + peticion.getNumero2());

        return respuesta;
    }

    @PayloadRoot(localPart = "restarRequest", namespace = "https://tis.uv.mx/calculadora")
    @ResponsePayload
    public RestarResponse restar(@RequestPayload RestarRequest peticion){

        RestarResponse respuesta = new RestarResponse();
        respuesta.setRespuesta(peticion.getNumero1() - peticion.getNumero2());

        return respuesta;
    }

    @PayloadRoot(localPart = "multiplicarRequest", namespace = "https://tis.uv.mx/calculadora")
    @ResponsePayload
    public MultiplicarResponse sumar(@RequestPayload MultiplicarRequest peticion){

        MultiplicarResponse respuesta = new MultiplicarResponse();
        respuesta.setRespuesta(peticion.getNumero1() * peticion.getNumero2());

        return respuesta;
    }
    
    @PayloadRoot(localPart = "dividirRequest", namespace = "https://tis.uv.mx/calculadora")
    @ResponsePayload
    public DividirResponse sumar(@RequestPayload DividirRequest peticion){

        DividirResponse respuesta = new DividirResponse();
        respuesta.setRespuesta(peticion.getNumero1() / peticion.getNumero2());

        return respuesta;
    }
}

package mx.uv.tis.calculadora;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.SimpleXsdSchema;

@EnableWs
@Configuration
public class CalculadoraConf {
    @Bean
    public XsdSchema calculadoraSchema(){
        return new SimpleXsdSchema(new ClassPathResource("calculadora.xsd"));
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "calculadora")
    public DefaultWsdl11Definition defaultWsdlDefinition(XsdSchema catalogoSchema){
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("calculadoraPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("https://tis.uv.mx/calculadora");
        wsdl.setSchema(catalogoSchema);
        return wsdl;
    }
}

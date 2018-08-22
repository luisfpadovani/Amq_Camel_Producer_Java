package br.com.fiap.producer.camel;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:C:/Arquivo_E?noop=true").split().tokenize("\n").to("jms:queue:FILA.TRABALHO.FIAP");
    }

}
package br.com.fiap.producer.camel;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class App {
	public static void main(String[] args) {
		try {
			SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
			CamelContext ctx = new DefaultCamelContext();
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
			ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

			ctx.addRoutes(routeBuilder);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

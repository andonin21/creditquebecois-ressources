package qc.ca.creditquebecois.ressources.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * La classe WebSocketConfig implémente l'interface WebSocketConfigurer, ce qui permet de configurer les gestionnaires de WebSocket dans l'application
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final MyWebSocketHandler myWebSocketHandler;

    /**
     * C'est le constructeur de la classe WebSocketConfig
     * @param myWebSocketHandler the my web socket handler
     */
    public WebSocketConfig(MyWebSocketHandler myWebSocketHandler) {
        this.myWebSocketHandler = myWebSocketHandler;
    }

    /**
     * Permet d'enregistrer des gestionnaires de WebSocket dans le registre registry
     * @param registry
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myWebSocketHandler, "/websocket")
                .setAllowedOrigins("*");
    }

    /**
     * LA méthode ServletServerContainerFactoryBean crée et configure un conteneur de serveur Servlet pour les connexions WebSocket.
     * @return servlet server container factory bean
     */
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        return container;
    }
}

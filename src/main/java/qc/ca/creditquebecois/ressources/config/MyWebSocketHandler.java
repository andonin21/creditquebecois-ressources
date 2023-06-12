package qc.ca.creditquebecois.ressources.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Définir la logique du traitement des connexions et des messages WebSocket.
 */
@Component
public class MyWebSocketHandler extends TextWebSocketHandler {
    /**
     * Cette méthode est appelée lorsque la connexion WebSocket est établie avec succès.
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Logique exécutée lorsque la connexion WebSocket est établie
    }

    /**
     * Cette méthode est appelée lorsqu'un message texte WebSocket est reçu
     * @param session
     * @param message
     * @throws Exception
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Logique pour traiter les messages WebSocket reçus
    }

    /**
     * Cette méthode est appelée lorsque la connexion WebSocket est fermée.
     * @param session
     * @param status
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Logique exécutée lorsque la connexion WebSocket est fermée
    }
}

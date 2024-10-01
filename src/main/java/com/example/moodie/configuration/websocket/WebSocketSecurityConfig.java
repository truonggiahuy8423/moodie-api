package com.example.moodie.configuration.websocket;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.security.config.annotation.web.socket.EnableWebSocketSecurity;

@Configuration
//@EnableWebSocketSecurity
public class WebSocketSecurityConfig {
//    @Bean
//    AuthorizationManager<Message<?>> authorizationManager(MessageMatcherDelegatingAuthorizationManager.Builder messages) {
//        messages.simpDestMatchers("/user/queue/errors").permitAll()
//                .simpDestMatchers("/admin/**").hasRole("ADMIN")
//                .anyMessage().authenticated();
//        return messages.build();
//    }
}
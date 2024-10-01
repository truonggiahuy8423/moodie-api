package com.example.moodie.configuration.websocket;
import com.example.moodie.exception.AppRuntimeException;
import com.example.moodie.util.constant.ExceptionType;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(
            ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
            System.out.println("beforeHandshake");
            String authToken = request.getHeaders().getFirst("Authorization");
            System.out.println(authToken);//
//        String token = request.getServletRequest().getParameter("token");
//        if (request instanceof ServletServerHttpRequest) {
//            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
//            String token = servletRequest.getServletRequest().getParameter("token");
//            System.out.println("Token from query param: " + token);
//             Xử lý token ở đây
//        }
//
//        request.getHeaders().forEach((key, value) -> System.out.println(key + ": " + value));
//            System.out.println("h 1");
        return true;

//
//        // Lấy JWT từ header
//        String authToken = request.getHeaders().getFirst("Authorization");
//        System.out.println(authToken);
//
//        if (authToken != null) {
//            // Nếu token hợp lệ, có thể lưu thông tin người dùng vào attributes
//            // attributes.put("user", userDetails);
//            System.out.println("ok");
//            return true; // Tiếp tục quá trình bắt tay
//        }
//        System.out.println("h 2");
//
////        throw new AppRuntimeException(ExceptionType.AUTHENTICATION_ERROR);
//        response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        return false; // Ngăn kết nối
    }
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception exception) {
        // Do nothing after handshake

    }

    private String extractUserInfoFromJwt(String jwt) {
        // Giả sử bạn có sẵn một phương thức để trích xuất thông tin user từ JWT
        // Ở đây, chỉ cần decode JWT để lấy các claims hoặc user info
        // Ví dụ:
        return "User info from JWT"; // Thay bằng logic thực tế để giải mã JWT
    }
}
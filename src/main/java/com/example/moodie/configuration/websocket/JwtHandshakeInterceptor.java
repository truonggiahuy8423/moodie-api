package com.example.moodie.configuration.websocket;
import com.example.moodie.exception.AppRuntimeException;
import com.example.moodie.util.constant.ExceptionType;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

public class JwtHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String jwt = servletRequest.getHeader("Authorization");

            if (jwt != null && jwt.startsWith("Bearer ")) {
                jwt = jwt.substring(7); // Bỏ tiền tố "Bearer " để lấy JWT
                // Trích xuất thông tin từ JWT (giả sử có sẵn hàm extractUserInfoFromJwt)
                String userInfo = extractUserInfoFromJwt(jwt);

                // In thông tin người dùng ra console
                System.out.println("User connected with info: " + userInfo);

                // Lưu thông tin user vào attributes nếu cần thiết
                attributes.put("userInfo", userInfo);
            } else {
                throw new AppRuntimeException(ExceptionType.AUTHENTICATION_ERROR);
            }
        }
        return true;
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
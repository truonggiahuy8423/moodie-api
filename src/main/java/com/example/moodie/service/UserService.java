package com.example.moodie.service;

import com.example.moodie.dto.request.LoginRequest;
import com.example.moodie.dto.request.RegisterRequest;
import com.example.moodie.dto.response.LoginResponse;
import com.example.moodie.dto.response.RegisterResponse;
import com.example.moodie.entity.Role;
import com.example.moodie.entity.RoleUser;
import com.example.moodie.entity.User;
import com.example.moodie.entity.composite.RoleUserId;
import com.example.moodie.exception.AppRuntimeException;
import com.example.moodie.repository.RoleRepository;
import com.example.moodie.repository.RoleUserRepository;
import com.example.moodie.util.constant.ExceptionType;
import com.example.moodie.mapper.UserMapper;
import com.example.moodie.repository.UserRepository;
import com.example.moodie.util.JwtProvider;
import com.example.moodie.util.StringHandler;
import com.nimbusds.jose.JOSEException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${admin.init-password}")
    private String adminInitPassword;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    public RegisterResponse register(RegisterRequest registerRequest) {
        areEmailAndPhoneEmpty(registerRequest);
        isUserExisted(registerRequest);

        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
        registerRequest.setPassword(hashedPassword);

        User user = new User();
        userMapper.mapRegisterRequestToUser(user, registerRequest);
        user = userRepository.save(user);

        RegisterResponse registerResponse = new RegisterResponse();
        userMapper.mapUserToRegisterResponse(registerResponse, user);
        return registerResponse;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user;
        if (!StringHandler.isNullOrEmptyOrBlank(loginRequest.getEmail())) {
            user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() ->
                    new AppRuntimeException(ExceptionType.LOGIN_FAILED));
        } else if (!StringHandler.isNullOrEmptyOrBlank(loginRequest.getPhone())) {
            user = userRepository.findByPhone(loginRequest.getPhone()).orElseThrow(() ->
                    new AppRuntimeException(ExceptionType.LOGIN_FAILED));
        } else {
            throw new AppRuntimeException(ExceptionType.MISSING_REGISTER_PARAMETERS);
        }

        LoginResponse loginResponse = new LoginResponse();
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            userMapper.mapUserToLoginResponse(loginResponse, user);

            try {
                loginResponse.setToken(JwtProvider.generateToken(user));
            } catch (JOSEException exception) {
                throw new AppRuntimeException(ExceptionType.TOKEN_SIGNING_FAILED);
            }
        } else {
            throw new AppRuntimeException(ExceptionType.LOGIN_FAILED);
        }

        return loginResponse;
    }



    public void isUserExisted(RegisterRequest user) {
        if (!StringHandler.isNullOrEmptyOrBlank(user.getEmail()) && StringHandler.isNullOrEmptyOrBlank(user.getPhone())) {
            userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new AppRuntimeException(ExceptionType.EMAIL_EXISTED));
            return;
        }
        if (StringHandler.isNullOrEmptyOrBlank(user.getEmail()) && !StringHandler.isNullOrEmptyOrBlank(user.getPhone())) {
            userRepository.findByPhone(user.getPhone()).orElseThrow(() -> new AppRuntimeException(ExceptionType.PHONE_EXISTED));
            return;
        }
        if (!StringHandler.isNullOrEmptyOrBlank(user.getEmail()) && !StringHandler.isNullOrEmptyOrBlank(user.getPhone())) {
            boolean isEmailExisted = userRepository.findByEmail(user.getEmail()).isPresent();
            boolean isPhoneExisted = userRepository.findByPhone(user.getPhone()).isPresent();

            if (isEmailExisted && !isPhoneExisted) {
                throw new AppRuntimeException(ExceptionType.EMAIL_EXISTED);
            }
            if (!isEmailExisted && isPhoneExisted) {
                throw new AppRuntimeException(ExceptionType.PHONE_EXISTED);
            }
            if (isEmailExisted && isPhoneExisted) {
                throw new AppRuntimeException(ExceptionType.EMAIL_AND_PHONE_EXISTED);
            }
        }
    }

    public void areEmailAndPhoneEmpty(RegisterRequest user) {
        if (StringHandler.isNullOrEmptyOrBlank(user.getEmail()) && StringHandler.isNullOrEmptyOrBlank(user.getPhone())) {
            throw new AppRuntimeException(ExceptionType.EMAIL_AND_PHONE_EMPTY);
        }

    }


    @Transactional
    public void initAdmin() {
        System.out.println("Init admin");

        String userName = "admin";
        User user = userRepository.findByUsername(userName).orElse(null);

        if (user == null) {
            // Nếu user chưa tồn tại, tạo mới user
            user = User.builder()
                    .username(userName)
                    .email("admin@example.com")
                    .password(passwordEncoder.encode(adminInitPassword))
                    .build();
            user = userRepository.save(user);
        } else return;

        Role adminRole = roleRepository.findByRoleName("ADMIN");

        if (adminRole == null) {
            adminRole = Role.builder()
                    .roleName("ADMIN")
                    .build();
            roleRepository.save(adminRole);
        }

        boolean hasAdminRole = roleUserRepository.existsByUserAndRole(user, adminRole);

        System.out.println(user.getUserId() + " " + adminRole.getRoleId());

        if (!hasAdminRole) {
            RoleUserId roleUserId = new RoleUserId(adminRole.getRoleId(), user.getUserId());
            RoleUser roleUser = RoleUser.builder()
                    .id(roleUserId)
                    .user(user)
                    .role(adminRole)
                    .build();
            System.out.println(roleUser.getId().getRoleId() + " 99 " + roleUser.getId().getUserId());
            roleUser = roleUserRepository.save(roleUser);
            System.out.println(roleUser.getRole().getRoleName() + " " + roleUser.getUser().getUserId());

        }
    }

}
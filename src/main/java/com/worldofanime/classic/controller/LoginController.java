package com.worldofanime.classic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.beans.factory.annotation.Autowired;
import com.worldofanime.classic.model.api.LoginRequest;
import com.worldofanime.classic.model.api.LogoutRequest;
import com.worldofanime.classic.model.api.UserProfile;
import com.worldofanime.classic.model.api.UserInfoRequest;
import com.worldofanime.classic.model.api.UserGroupsRequest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.commons.validator.routines.InetAddressValidator;
import com.worldofanime.classic.service.LoginService;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;

@Controller
public class LoginController {

        @Value("${local.api.path}")
        private String localApiPath;

        @Value("${default.ip}")
        private String defaultIpAddress;

        @Autowired
        LoginService loginService;        

	@PostMapping("/login")
	public RedirectView userProfile(@RequestParam("email") String email, @RequestParam("password") String password, @RequestHeader("Referer") String referer, HttpServletRequest request, HttpServletResponse response) {

                String ipAddress = request.getRemoteAddr();
                InetAddressValidator validator = new InetAddressValidator();

                if (!validator.isValidInet4Address(ipAddress)) {
                        ipAddress = defaultIpAddress;
                }

                RestTemplate restTemplate = new RestTemplate();
                LoginRequest loginRequest = restTemplate.getForObject(localApiPath + "/api/login?email=" + email + "&password=" + password + "&ip=" + ipAddress, LoginRequest.class);

                if (loginRequest.getStatusCode().equals("200")) {
                        response.addCookie(new Cookie("oauth_token", loginRequest.getBody().getOauthToken()));
                        response.addCookie(new Cookie("oauth_secret", loginRequest.getBody().getOauthSecret()));
                        loginService.handleLogin(loginRequest.getBody().getUser(), email, ipAddress);
                }

	        RedirectView redirectView = new RedirectView();
                redirectView.setUrl(referer);
                return redirectView;
	}

        @GetMapping("/logout")
        public RedirectView logout(@CookieValue(name = "oauth_token", required = false) String oauthToken, @CookieValue(name = "oauth_secret", required = false) String oauthSecret, @RequestHeader("Referer") String referer, HttpServletResponse response) {

                RestTemplate restTemplate = new RestTemplate();
                LogoutRequest logoutRequest = restTemplate.getForObject(localApiPath + "/api/logout?oauth_token=" + oauthToken + "&oauth_secret=" + oauthSecret, LogoutRequest.class);

                if (logoutRequest.getStatusCode().equals("204")) {
                        Cookie tokenCookie = new Cookie("oauth_token", oauthToken);
                        tokenCookie.setMaxAge(0);

                        Cookie secretCookie = new Cookie("oauth_secret", oauthSecret);
                        secretCookie.setMaxAge(0);

                        response.addCookie(tokenCookie);
                        response.addCookie(secretCookie);
                }

                RedirectView redirectView = new RedirectView();
                redirectView.setUrl(referer);
                return redirectView;
        }        
}

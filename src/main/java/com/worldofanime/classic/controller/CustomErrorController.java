package com.worldofanime.classic.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.worldofanime.classic.repository.ErrorsRepository;
import com.worldofanime.classic.model.Errors;
import com.worldofanime.classic.model.api.UserProfile;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

  @Autowired
  ErrorsRepository errorsRepository;

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, @ModelAttribute("loggedInUser") UserProfile loggedInUser) {

    recordError(request, loggedInUser);

    return "error";
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }

  public void recordError(javax.servlet.http.HttpServletRequest request, UserProfile loggedInUser) {

    int userId = (loggedInUser.userExists()) ? loggedInUser.getUserId() : 0;
    String userAgent = request.getHeader("User-Agent");
    String referer = (String) request.getAttribute("javax.servlet.error.request_uri");
    Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
    String errorText = (exception == null) ? "" : exception.getMessage();

    Errors error = new Errors();

    error.setUserId(userId);
    error.setError(errorText);
    error.setUserAgent(userAgent);
    error.setReferer(referer);
    errorsRepository.save(error);
  }

}
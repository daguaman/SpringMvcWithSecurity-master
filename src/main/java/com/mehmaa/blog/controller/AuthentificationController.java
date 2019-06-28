package com.mehmaa.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * The controller that handles the login/logout actions
 * </p>
 */
@Controller()
@RequestMapping()
public class AuthentificationController {

    private static final Logger logger = LoggerFactory.getLogger(AuthentificationController.class);
    private static String MSG_LOGIN_FAILURE = "Login Failure!";
    private static String MSG_LOGOUT_SUCCESS = "Login Failure!";

    /**
     * Process the login action
     * 
     * @param model
     * @param message
     * @return login page id
     */
    @RequestMapping("/login")
    public String login(Model model, @RequestParam(required = false) String message) {
        logger.debug("requesting login page.");
        model.addAttribute("message", message);
        return "auth/login";
    }

    /**
     * Process the login failure action
     * 
     * @return redirection to the login page with a message
     */
    @RequestMapping(value = "/login/failure")
    public String loginFailure() {
        return "redirect:/login?message=" + MSG_LOGIN_FAILURE;
    }

    /**
     * Process the logout process
     * 
     * @return redirection to the login page with a message
     */
    @RequestMapping(value = "/logout/success")
    public String logoutSuccess() {
        return "redirect:/login?message=" + MSG_LOGOUT_SUCCESS;
    }

}

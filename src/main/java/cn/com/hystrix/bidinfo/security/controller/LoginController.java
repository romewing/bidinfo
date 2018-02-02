package cn.com.hystrix.bidinfo.security.controller;


import cn.com.hystrix.bidinfo.security.entity.Authority;
import cn.com.hystrix.bidinfo.security.entity.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@SessionAttributes("authorities")
public class LoginController {

    private static final String DEFAULT_LOGIN_PAGE = "login";

    @Value("${spring.application.name}")
    public String name;


    @RequestMapping(value = "/", produces = "text/html")
    public String login(Model model) {
        model.addAttribute("name",name);

        return "login";
    }


    @RequestMapping("/index")
    public String index() {

        return "index";
    }

    @ModelAttribute("AuthorityList")
    public List<Authority> authorityList() {
        List<Authority> list = new ArrayList<>();
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if(authentication instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
            Collection<GrantedAuthority> authorities = token.getAuthorities();
            authorities.forEach(grantedAuthority -> {
                if(grantedAuthority instanceof Role) {
                    list.addAll(((Role) grantedAuthority).getAuthorities());

                }
            });
        }
        return list;
    }

    @RequestMapping("/tables.html")
    public String test() {
       return "index :: page-content";

    }



}

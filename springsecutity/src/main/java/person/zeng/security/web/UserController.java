package person.zeng.security.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制
 * 
 * @author Administrator
 *
 */
@RestController
public class UserController {
  @GetMapping("/admin1")
  @ResponseBody
  public String admin1(HttpServletRequest request) {
   return "admin1 access Success";
  }
  
  @PostMapping("/successLogin")
  @ResponseBody
  public String successLogin(HttpServletRequest requet,HttpServletResponse respose) {
   Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
   List<GrantedAuthority> roles =new ArrayList<GrantedAuthority>(auth.getAuthorities());
   Enumeration<String> enums = requet.getSession().getAttributeNames();
   while(enums.hasMoreElements()) {
     Object obj = requet.getSession().getAttribute(enums.nextElement());
     if(obj instanceof SecurityContext) {
       SecurityContext context = (SecurityContext)obj;
       System.out.println(context.getAuthentication().getName());
       System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
     }
   }
   return "user:"+auth.getName()+" role:"+roles.toString();
  }
  
  @GetMapping("/failureLogin")
  @ResponseBody
  public String failureLogin(HttpServletRequest requet,HttpServletResponse respose) {
   Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
   return auth.getName();
  }
  
}

package com.example.demo.exception.filter;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.NestedRuntimeException;
/**
 * 异常拦截器
 * @author Administrator
 *
 */

public class ExceptionFilter implements Filter {

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest)arg0;
    HttpServletResponse response = (HttpServletResponse)arg1;
    PrintWriter out = null;
    try {
      arg2.doFilter(arg0, arg1);
    }catch (Throwable e) {
      if(e instanceof Exception) {
        out = response.getWriter();
        out.print("my error");
        out.flush();
      }else {
        out.print("others exceptions");
        out.flush();
      }
    }finally {
      if(out!=null) {
        out.close();
      }
    }
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
   
  }
}

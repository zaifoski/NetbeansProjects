package FiltroB;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Web programming
 */

//@WebFilter(filterName = "TimerFilter", urlPatterns = {"/*"})
public class TimerFilter implements Filter {
  
    private FilterConfig filterConfig = null;
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        //Do nothing
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        //Do nothing
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
     
        //We take the time (milliseconds) before doing anything.
        long before = System.currentTimeMillis();
        
        //We call other filters and servlets by using the FilterChain
        chain.doFilter(request, response);
        
        //We take again the time (milliseconds) after calling other filters
        //and servlets
        long after = System.currentTimeMillis();
        
        String name = "";
        if(request instanceof HttpServletRequest){
            name = ((HttpServletRequest)request).getRequestURI();
        }
        
        System.out.println(name + ": " + (after - before) + "ms.");
        
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {        
        filterConfig = null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

}
package com.linux;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import org.apache.wicket.protocol.http.WicketFilter;

/**
 * Adding Apache Wicket filter.
 * @author comdotlinux <guru@linux.com>
 */
@WebFilter(value = "/*", initParams = {
    @WebInitParam(name = "applicationClassName", value = "com.linux.WicketApplication"),
    @WebInitParam(name = "filterMappingUrlPattern", value = "/*")    
})
public class ProjectFilter extends WicketFilter{
    
}

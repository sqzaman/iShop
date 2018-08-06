package ishop.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class AuthorizationRequestIntercepter implements RequestInterceptor {
    private static final String AUTHORIZATION_HEADER = "Authorization";


	@Override
	public void apply(RequestTemplate template) {
		  ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        if (requestAttributes == null) {
	            return;
	        }
	        HttpServletRequest request = requestAttributes.getRequest();
	        if (request == null) {
	            return;
	        }
	        String authrization = request.getHeader(AUTHORIZATION_HEADER);
	        if (authrization == null) {
	            return;
	        }
	        template.header(AUTHORIZATION_HEADER, authrization);
		
	}

}

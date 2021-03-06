package myapp.core.authentication.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;

/**
 * Utility class for validating authentication
 * 
 * @author Mate
 *
 */
public class AuthenticationValidator
{
	private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
	private static final String X_REQUESTED_WITH = "X-Requested-With";
	private static final String CONTENT_TYPE = "Content-type";
	private static final String CONTENT_TYPE_JSON = "application/json";

	public static boolean isValidPreAuthenticationRequest(HttpServletRequest request)
	{
		if (!HttpMethod.POST.name().equals(request.getMethod()) || !hasValidHeaders(request)
				|| !request.getHeader(X_REQUESTED_WITH).equals(XML_HTTP_REQUEST)
				|| !request.getHeader(CONTENT_TYPE).contains(CONTENT_TYPE_JSON))
		{
			return false;
		}
		return true;
	}

	private static boolean hasValidHeaders(final HttpServletRequest request)
	{
		return (request.getHeader(X_REQUESTED_WITH) != null) && (request.getHeader(CONTENT_TYPE) != null);
	}
}

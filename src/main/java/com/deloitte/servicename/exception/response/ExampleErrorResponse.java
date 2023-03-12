package com.deloitte.servicename.exception.response;


import com.deloitte.core.response.Response;

/**
 * Example:
 * Response [error code] = new Response( [error code], [error message] );
 */
public interface ExampleErrorResponse {
    Response ERR0001 = new Response("ERR0001", "This is the error message.");
}

package ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.payload;

import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.handler.ApiException;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.GetDFPayloadServiceResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PostDFPayloadServiceRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PostDFPayloadServiceResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PutDFPayloadServiceRequest;

/**
 * 
 * Collection of services for accessing Digital forms payloads (Staging table) 
 * 
 * @author smillar
 *
 */
public interface DfPayloadService {

	GetDFPayloadServiceResponse getDFPayload(String noticeNo, String correlationId) throws ApiException;

	PostDFPayloadServiceResponse postDFPayload(String correlationId, PostDFPayloadServiceRequest request) throws ApiException;
	
	PostDFPayloadServiceResponse putDFPayload(String noticeNo, String correlationId, PutDFPayloadServiceRequest request) throws ApiException;
	
	PostDFPayloadServiceResponse deleteDFPayload(String noticeNo, String correlationId) throws ApiException;

}

package ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.payload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.DfPayloadsApi;
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
public class DfPayloadServiceImpl implements DfPayloadService {

	private final DfPayloadsApi dfPayloadsApi;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public DfPayloadServiceImpl(DfPayloadsApi dfPayloadsApi)   {
		this.dfPayloadsApi = dfPayloadsApi;
	}

	@Override
	public GetDFPayloadServiceResponse getDFPayload(String noticeNo, String correlationId) throws ApiException {
		
		GetDFPayloadServiceResponse response; 
		
		try {
		
			response = this.dfPayloadsApi.digitalFormDfpayloadsV1NoticeNoGet(noticeNo);

		} catch (ApiException ex) {
			logger.error("{" + correlationId + "} ORDS GET DFPayload threw an exception: " + ex.getMessage() + " HTTP Status Code: " + ex.getCode(), ex);
			throw ex;
		}	
			
		return response;
	}

	@Override
	public PostDFPayloadServiceResponse postDFPayload(String correlationId,
			PostDFPayloadServiceRequest request) throws ApiException {
		
		PostDFPayloadServiceResponse response;
		
		try {
		
			response = this.dfPayloadsApi.digitalFormDfpayloadsV1Post(request);
		
		} catch (ApiException ex) {
			logger.error("{" + correlationId + "} ORDS POST DFPayload threw an exception: " + ex.getMessage() + " HTTP Status Code: " + ex.getCode(), ex);
			throw ex;
		}	
		
		return response;
	}

	@Override
	public PostDFPayloadServiceResponse putDFPayload(String noticeNo, String correlationId,
			PutDFPayloadServiceRequest request) throws ApiException {
		
		PostDFPayloadServiceResponse response;
		
		try {
		
			response = this.dfPayloadsApi.digitalFormDfpayloadsV1NoticeNoPut(noticeNo, request);
		
		} catch (ApiException ex) {
			logger.error("{" + correlationId + "} ORDS PUT DFPayload threw an exception: " + ex.getMessage() + " HTTP Status Code: " + ex.getCode(), ex);
			throw ex;
		}	
		
		return response;
	}

	@Override
	public PostDFPayloadServiceResponse deleteDFPayload(String noticeNo, String correlationId) throws ApiException {
		
		PostDFPayloadServiceResponse response;
		
		try {
			
			response = this.dfPayloadsApi.digitalFormDfpayloadsV1NoticeNoDelete(noticeNo);
		
		} catch (ApiException ex) {
			logger.error("DELETE DFPayload threw an exception: " + ex.getMessage() + " HTTP Status Code: " + ex.getCode(), ex);
			throw ex;
		}		
			
		return  response;
	}
}

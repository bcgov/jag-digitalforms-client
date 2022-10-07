package ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.payload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.DfPayloadsApi;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.handler.ApiException;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.GetDFPayloadServiceResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PostDFPayloadServiceRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PostDFPayloadServiceResponse;

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
		
			response = this.dfPayloadsApi.digitalFormV1DfpayloadsNoticeNoCorrelationIdGet(noticeNo, correlationId);

		} catch (ApiException ex) {
			logger.error("GET DFPayload threw an exception: " + ex.getMessage(), ex);
			throw ex;
		}	
			
		return response;
	}

	@Override
	public PostDFPayloadServiceResponse postDFPayload(String noticeNo, String correlationId,
			PostDFPayloadServiceRequest request) throws ApiException {
		
		PostDFPayloadServiceResponse response;
		
		try {
		
			response = this.dfPayloadsApi.digitalFormV1DfpayloadsNoticeNoCorrelationIdPost(noticeNo, correlationId, request);
		
		} catch (ApiException ex) {
			logger.error("POST DFPayload threw an exception: " + ex.getMessage(), ex);
			throw ex;
		}	
		
		return response;
	}

	@Override
	public PostDFPayloadServiceResponse putDFPayload(String noticeNo, String correlationId,
			PostDFPayloadServiceRequest request) throws ApiException {
		
		PostDFPayloadServiceResponse response;
		
		try {
		
			response = this.dfPayloadsApi.digitalFormV1DfpayloadsNoticeNoCorrelationIdPut(noticeNo, correlationId, request);
		
		} catch (ApiException ex) {
			logger.error("PUT DFPayload threw an exception: " + ex.getMessage(), ex);
			throw ex;
		}	
		
		return response;
	}

	@Override
	public PostDFPayloadServiceResponse deleteDFPayload(String noticeNo, String correlationId) throws ApiException {
		
		PostDFPayloadServiceResponse response;
		
		try {
			
			response = this.dfPayloadsApi.digitalFormV1DfpayloadsNoticeNoCorrelationIdDelete(noticeNo, correlationId);
		
		} catch (ApiException ex) {
			logger.error("DELETE DFPayload threw an exception: " + ex.getMessage(), ex);
			throw ex;
		}		
			
		return  response;
	}
}

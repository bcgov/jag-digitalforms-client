package ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.dfPayloads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.DfPayloadsApi;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.handler.ApiException;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.GetDFPayloadServiceResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PostDFPayloadServiceRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PostDFPayloadServiceResponse;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.payload.DfPayloadServiceImpl;

/**
 * Digital Forms Payload service tests
 *
 * @author smillar
 *
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DFPayloadsServiceImplTest {
	
		private DfPayloadServiceImpl service;

	    @Mock
	    private DfPayloadsApi DFPayloadsApiMock;
		
	 	
	 	private final String dummyPayload = "{\r\n"
	 			+ "  \"type\":\"object\",\r\n"
	 			+ "  \"properties\": {\r\n"
	 			+ "    \"foo\": {\r\n"
	 			+ "      \"type\": \"string\"\r\n"
	 			+ "    },\r\n"
	 			+ "    \"bar\": {\r\n"
	 			+ "      \"type\": \"integer\"\r\n"
	 			+ "    },\r\n"
	 			+ "  }\r\n"
	 			+ "}";
	 	
	 	 @BeforeAll
	     public void setup() throws ApiException {
	         MockitoAnnotations.initMocks(this);

	         service = new DfPayloadServiceImpl(DFPayloadsApiMock);
	     }
	 
		@Test
		public void getWithValidResponse() throws ApiException {

			GetDFPayloadServiceResponse successResponse = new GetDFPayloadServiceResponse();
			successResponse.setActive(true);
			successResponse.setNoticeType("IRP");
			successResponse.setPayload(dummyPayload);
			successResponse.setProcessed(true);

			Mockito.when(DFPayloadsApiMock.digitalFormV1DfpayloadsNoticeNoCorrelationIdGet("91400824", "abcdef")).thenReturn(successResponse);

			GetDFPayloadServiceResponse result = service.getDFPayload("91400824", "abcdef");

			Assertions.assertEquals(dummyPayload, result.getPayload());
			Assertions.assertEquals("IRP", result.getNoticeType());
			Assertions.assertEquals(true, result.getActive());
			Assertions.assertEquals(true, result.getProcessed());
		}
		
		@Test
		public void deleteWithValidResponse() throws ApiException {

			PostDFPayloadServiceResponse successResponse = new PostDFPayloadServiceResponse();
			successResponse.setStatusMessage("success");

			Mockito.when(DFPayloadsApiMock.digitalFormV1DfpayloadsNoticeNoCorrelationIdDelete("91400824", "abcdef")).thenReturn(successResponse);

			PostDFPayloadServiceResponse result = service.deleteDFPayload("91400824", "abcdef");

			Assertions.assertEquals("success", result.getStatusMessage());

		}
		
		@Test
		public void PostWithValidResponse() throws ApiException {

			PostDFPayloadServiceResponse successResponse = new PostDFPayloadServiceResponse();
			successResponse.setStatusMessage("success");
			
			PostDFPayloadServiceRequest request = new PostDFPayloadServiceRequest();
			request.setActiveYN(true);
			request.setNoticeNo("91400824");
			request.setPayload(dummyPayload);
			request.setProcessedYN(true);

			Mockito.when(DFPayloadsApiMock.digitalFormV1DfpayloadsNoticeNoCorrelationIdPost("91400824", "abcdef", request)).thenReturn(successResponse);

			PostDFPayloadServiceResponse result = service.postDFPayload("91400824", "abcdef", request);

			Assertions.assertEquals("success", result.getStatusMessage());

		}
		
		@Test
		public void PuttWithValidResponse() throws ApiException {

			PostDFPayloadServiceResponse successResponse = new PostDFPayloadServiceResponse();
			successResponse.setStatusMessage("success");
			
			PostDFPayloadServiceRequest request = new PostDFPayloadServiceRequest();
			request.setActiveYN(true);
			request.setNoticeNo("91400824");
			request.setPayload(dummyPayload);
			request.setProcessedYN(true);

			Mockito.when(DFPayloadsApiMock.digitalFormV1DfpayloadsNoticeNoCorrelationIdPut("91400824", "abcdef", request)).thenReturn(successResponse);

			PostDFPayloadServiceResponse result = service.putDFPayload("91400824", "abcdef", request);

			Assertions.assertEquals("success", result.getStatusMessage());

		}

}

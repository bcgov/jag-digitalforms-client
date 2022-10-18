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
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.PutDFPayloadServiceRequest;
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
			successResponse.setActiveYN("Y");
			successResponse.setNoticeType("IRP");
			successResponse.setPayload(dummyPayload);
			successResponse.setProcessedYN("Y");

			Mockito.when(DFPayloadsApiMock.digitalFormDfpayloadsV1NoticeNoGet("91400824")).thenReturn(successResponse);

			GetDFPayloadServiceResponse result = service.getDFPayload("91400824", "abcdef");

			Assertions.assertEquals(dummyPayload, result.getPayload());
			Assertions.assertEquals("IRP", result.getNoticeType());
			Assertions.assertEquals("Y", result.getActiveYN());
			Assertions.assertEquals("Y", result.getProcessedYN());
		}
		
		@Test
		public void deleteWithValidResponse() throws ApiException {

			PostDFPayloadServiceResponse successResponse = new PostDFPayloadServiceResponse();
			successResponse.setStatusMessage("success");

			Mockito.when(DFPayloadsApiMock.digitalFormDfpayloadsV1NoticeNoDelete("91400824")).thenReturn(successResponse);

			PostDFPayloadServiceResponse result = service.deleteDFPayload("91400824", "abcdef");

			Assertions.assertEquals("success", result.getStatusMessage());

		}
		
		@Test
		public void PostWithValidResponse() throws ApiException {

			PostDFPayloadServiceResponse successResponse = new PostDFPayloadServiceResponse();
			successResponse.setStatusMessage("success");
			
			PostDFPayloadServiceRequest request = new PostDFPayloadServiceRequest();
			request.setActiveYN("Y");
			request.setNoticeNo("91400824");
			request.setPayload(dummyPayload);
			request.setProcessedYN("Y");

			Mockito.when(DFPayloadsApiMock.digitalFormDfpayloadsV1Post(request)).thenReturn(successResponse);

			PostDFPayloadServiceResponse result = service.postDFPayload("abcdef", request);

			Assertions.assertEquals("success", result.getStatusMessage());

		}
		
		@Test
		public void PuttWithValidResponse() throws ApiException {

			PostDFPayloadServiceResponse successResponse = new PostDFPayloadServiceResponse();
			successResponse.setStatusMessage("success");
			
			PutDFPayloadServiceRequest request = new PutDFPayloadServiceRequest();
			request.setActiveYN("Y");
			request.setPayload(dummyPayload);
			request.setProcessedYN("Y");

			Mockito.when(DFPayloadsApiMock.digitalFormDfpayloadsV1NoticeNoPut("91400824", request)).thenReturn(successResponse);

			PostDFPayloadServiceResponse result = service.putDFPayload("91400824", "abcdef", request);

			Assertions.assertEquals("success", result.getStatusMessage());

		}

}

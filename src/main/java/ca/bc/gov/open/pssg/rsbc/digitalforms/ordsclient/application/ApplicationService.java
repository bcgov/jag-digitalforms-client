package ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.application;

import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.DigitalFormPatchRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.DigitalFormPostRequest;
import ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model.DigitalFormNoticeGetResponse;

/**
 * Collection of services for applications.
 *
 * @author sivakaruna
 */
public interface ApplicationService {

	ApplicationResponse getApplication(String formGuid, String correlationId);

	ApplicationResponse postApplication(DigitalFormPostRequest applicationInfo, String correlationId);

	ApplicationResponse patchApplication(String formGuid, DigitalFormPatchRequest applicationInfo, String correlationId);

	ApplicationResponse getApplicationExists(String noticeNo, String correlationId);

}

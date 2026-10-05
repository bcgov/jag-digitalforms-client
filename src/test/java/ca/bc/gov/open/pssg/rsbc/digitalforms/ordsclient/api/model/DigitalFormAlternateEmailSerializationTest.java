package ca.bc.gov.open.pssg.rsbc.digitalforms.ordsclient.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class DigitalFormAlternateEmailSerializationTest {

	private final Gson gson = new Gson();

	@Test
	void postRequestSerializesAlternateAddressWithOrdsPropertyName() {
		DigitalFormPostRequest request = new DigitalFormPostRequest();
		request.setAlternateElectronicAddrsTxt("lawyer@example.com");

		JsonObject json = JsonParser.parseString(gson.toJson(request)).getAsJsonObject();

		assertEquals("lawyer@example.com", json.get("alternate_electronic_addrs_txt").getAsString());
		assertFalse(json.has("alternateElectronicAddrsTxt"));
	}

	@Test
	void patchRequestSerializesAlternateAddressWithOrdsPropertyName() {
		DigitalFormPatchRequest request = new DigitalFormPatchRequest();
		request.setAlternateElectronicAddrsTxt("lawyer@example.com");

		JsonObject json = JsonParser.parseString(gson.toJson(request)).getAsJsonObject();

		assertEquals("lawyer@example.com", json.get("alternate_electronic_addrs_txt").getAsString());
		assertFalse(json.has("alternateElectronicAddrsTxt"));
	}

	@Test
	void getResponseDeserializesAlternateAddressAndAllowsMissingOrNullValue() {
		DigitalFormGetResponse response = gson.fromJson(
				"{\"alternate_electronic_addrs_txt\":\"lawyer@example.com\"}",
				DigitalFormGetResponse.class);
		DigitalFormGetResponse missing = gson.fromJson("{}", DigitalFormGetResponse.class);
		DigitalFormGetResponse nullValue = gson.fromJson(
				"{\"alternate_electronic_addrs_txt\":null}",
				DigitalFormGetResponse.class);

		assertEquals("lawyer@example.com", response.getAlternateElectronicAddrsTxt());
		assertNull(missing.getAlternateElectronicAddrsTxt());
		assertNull(nullValue.getAlternateElectronicAddrsTxt());
	}
}
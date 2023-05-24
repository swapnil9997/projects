package com.yashoda.decoders;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yashoda.exception.Error;
import com.yashoda.exception.InsuranceServiceFailureException;
import com.yashoda.exception.PolicyNotFoundException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class InsuranceErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		InputStream in = null;
		Error error = null;
		ObjectMapper objectMapper = null;

		try {
			in = response.body().asInputStream();
//			int c = 0;
//			while((c=in.read()) != -1) {
//				System.out.print((char) c);
//			}
			objectMapper = new ObjectMapper();
			error = objectMapper.readValue(in, Error.class);

			if (response.status() == 500) {
				if (error.getErrorCode() == -1) {
					return new InsuranceServiceFailureException(error);
				}
			} else {
				if (error.getErrorCode() == 1001) {
					return new PolicyNotFoundException(error);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return new RuntimeException("Unknown error");
	}

}

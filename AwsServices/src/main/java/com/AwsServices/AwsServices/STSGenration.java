package com.AwsServices.AwsServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;

@RestController
public class STSGenration {

	private Credentials sessionCredentials;

	// arn:aws:iam::599025925339:role/Aws_Devl_APIGW

	// arn:aws:iam::599025925339:role/AWS_DEVL_LAMBDA_ROLE

	@GetMapping("v1/aws/gettokens")
	public void gettokens() {

		// Create a new session with the user credentials for the service instance
		AWSSecurityTokenServiceClient stsClient = new AWSSecurityTokenServiceClient(
				new BasicAWSCredentials("AKIAYW6F2HTNYMH5BX7F", "Veooq4ojNTQRbdQJKk38ZNjj/sn/QSZDUHsMhP0h"));

		// Start a new session for managing a service instance's bucket
		GetSessionTokenRequest getSessionTokenRequest = new GetSessionTokenRequest().withDurationSeconds(900);

		// Get the session token for the service instance's bucket
		sessionCredentials = stsClient.getSessionToken(getSessionTokenRequest).getCredentials();

		System.out.println("generated access Key   " + sessionCredentials.getAccessKeyId());
		System.out.println("generated secret key   " + sessionCredentials.getSecretAccessKey());
		System.out.println("generated session token" + sessionCredentials.getSessionToken());

	}

	@GetMapping("v1/aws/assumerole/gettokens")
	public void getassumeroletokens() {

		AWSCredentials initialCredentials = new BasicAWSCredentials("AKIAYW6F2HTNYMH5BX7F",
				"Veooq4ojNTQRbdQJKk38ZNjj/sn/QSZDUHsMhP0h");

		try {
			String iamRoleArn = "arn:aws:iam::599025925339:role/AWS_DEVL_LAMBDA_ROLE";
			AssumeRoleRequest assumeRequest = createAssumeRoleRequest(iamRoleArn);

			AssumeRoleResult assumeResult = new AWSSecurityTokenServiceClient(initialCredentials)
					.assumeRole(assumeRequest);

			System.out.println("generated assumerole access Key   " + assumeResult.getCredentials().getAccessKeyId());
			System.out.println(
					"generated assumerole SecretAccess Key   " + assumeResult.getCredentials().getSecretAccessKey());
			System.out
					.println("generated assumerole session token   " + assumeResult.getCredentials().getSessionToken());
			System.out.println("generated assumerole Expirarion   " + assumeResult.getCredentials().getExpiration());

		} catch (Exception ex) {
			System.out.println("Exception occurred while getting assume role tokens " + ex);
		}

	}

	private static AssumeRoleRequest createAssumeRoleRequest(String iamRoleArn) {
		return new AssumeRoleRequest().withRoleArn(iamRoleArn).withDurationSeconds(1200).withRoleSessionName("example");
	}

}

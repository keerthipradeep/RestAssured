package api.endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payloads.User;// this will import the data created in user .java class
//Created for Create,Read,Update and Delete of the user APIs

public class UserEndpoint {
	
	public static Response CreateUser(User userPayload)
	
	{
		Response response = 
		given()
		.contentType(ContentType.JSON) // from the swagger
		.accept(ContentType.JSON)// from the swagger
		.body(userPayload) // return the payload input
		.when()
		.post(Roots.post_url); // accessing the post url from the Roots class using the class name. we are not having  any validations here as it is the base class.
		return response; // returning the response to the function
		
	}
	public static Response ReadUser(String userName) // need input only the user name , no payload is required
	{ 
		
		Response response=
				given()
				.pathParam("username", userName)
				.when()
				.get(Roots.get_url);
		return response;
				
	}
	public static Response UpdateUser(String userName,User payload)
	{
Response response=	
		
	given()
	.contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.pathParam("username", userName)
	.body(payload)
	.when()
	.put(Roots.update_url);
	return response;
	
	}
	public static Response DeleteUser(String userName)
	{
Response response=	
		
	given()
	.pathParam("username", userName)
	.when()
	.delete(Roots.delete_url);
	return response;
	
	}
}

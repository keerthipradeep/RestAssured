package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTest {
	
	//private static final varcgarerEndpoint = 0;
	Faker f;
	User userPayload;
	
	@BeforeClass
	void setupData() // this will be executed first and pass the data using POJO class 
	{
		Faker f= new Faker();
		userPayload = new User();
		userPayload.setId(f.idNumber().hashCode());
		userPayload.setFirstName(f.name().firstName());
		userPayload.setLastName(f.name().lastName());
		userPayload.setEmail(f.internet().emailAddress());
		userPayload.setPassword(f.internet().password(5, 7));
		userPayload.setUsername(f.name().username());
		userPayload.setPhone(f.phoneNumber().cellPhone());
		userPayload.setUserStatus("active");
	}
  
    @Test(priority=1)
	public void TestUser()
	{
		Response response = UserEndpoint.CreateUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
    
	@Test(priority=2)
	public void testGetUserByname()
	{
	 Response res =UserEndpoint.ReadUser(this.userPayload.getUsername());
	 res.then().log().all();
	 Assert.assertEquals(res.statusCode(), 200);
	 
	}
	
	@Test(priority=3)
	void testUpdateUser()
	{
		userPayload.setFirstName(f.name().firstName());
		userPayload.setLastName(f.name().lastName());
		userPayload.setEmail(f.internet().emailAddress());
		
		Response response=UserEndpoint.UpdateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		
		Response resafterUpdate =UserEndpoint.ReadUser(this.userPayload.getUsername()); // checking the response after update
		resafterUpdate.then().log().all();
		 Assert.assertEquals(resafterUpdate.statusCode(), 200);
		
	}
	
	@Test(priority=4)
	void DeleteUserByName()
	{
		Response res=UserEndpoint.DeleteUser(this.userPayload.getUsername());
		res.then().statusCode(200);
	}
}

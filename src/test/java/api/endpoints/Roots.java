package api.endpoints;

/* Swagger Petstore: this package contains all the URLS for this project
 * Create User - https://petstore.swagger.io/v2/user
 * Get user - https://petstore.swagger.io/v2/user/{username}
 * Put user :https://petstore.swagger.io/v2/user/{username}
 * Delete user : https://petstore.swagger.io/v2/user/{username}
 */

public class Roots {
	
	public static String base_url = "https://petstore.swagger.io/v2"; // can be used directly by using a class name
	// roots of the user modules
	public static String post_url = base_url + "/user/{username}";
	public static String get_url = base_url+"/user{username}";
	public static String update_url = base_url+"/user{username}";
	public static String delete_url = base_url+"/user{username}";
		
	//similar way u can store urls of other modules
	
}

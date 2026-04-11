package klu.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klu.repository.UsersRepository;

@Service
public class UsersManager {
	@Autowired
	UsersRepository UR;
	
	@Autowired
	JwtManager JWT;
	//SIGN UP OPREATION
	public Map<String, String> signup(Users U) {
		Map<String, String> response = new HashMap<String, String>();
		try {
				UR.save(U); //INSERT
				response.put("code", "200");
				response.put("msg", "Registered Successfully!");
				return response;
		} catch (Exception e) {
			// TODO: handle exception
			response.put("code", "401");
			response.put("msg", e.getMessage());
			return response;
		}
	}
	//sign in operation
	public Map<String, String> signin(Users U){
		Map<String, String> response = new HashMap<String, String>();
		try {
			Users tmp=UR.findByEmailandPassword(U.getEmail(), U.getPassword());
			if(tmp==null) {
				throw new Exception("Invalid Credentials!");
//				response.put("code", "404");
//				response.put("msg", "Invalid Credentials");
			}
			String token=JWT.generateJWT(U.getEmail());
			response.put("code", "200");
			response.put("token", token);
//			else {
//				String token=JWT.generateJWT(U.getEmail());
//				response.put("code", "200");
//				response.put("token", token);
//			}
		} catch (Exception e) {
			response.put("code", "401");
			response.put("msg", e.getMessage());
		}
		return response;
	}
	
	//Fetch User Info
	public Map<String, String> uinfo(String token){
		Map<String, String> response=new HashMap<String, String>();
		try {
			response= JWT.ValidateJWT(token);
			if(response.get("code")!="200") {
				return response;
			}
			Users U=UR.findById(response.get("username")).get();
			response.put("fullname", U.getFname()+" "+U.getLname());
			return response;
		} catch (Exception e) {
			response.put("code", "401");
			response.put("msg",e.getMessage());
			return response;
		}
	}
	
}

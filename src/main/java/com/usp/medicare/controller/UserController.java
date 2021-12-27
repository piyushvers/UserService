package com.usp.medicare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usp.medicare.dto.UserDTO;
import com.usp.medicare.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * @GetMapping("/sendOtp/{email}") public ResponseEntity<?>
	 * sendOtpToUser(@PathVariable String email) { User user =
	 * userService.getUserByEmail(email); if(user!=null) { if(user.isOTPRequired())
	 * { try { userService.generateOneTimePassword(user);
	 * }catch(UnsupportedEncodingException e) {
	 * 
	 * }catch(MessagingException me) {
	 * 
	 * } } }else { System.out.println("User error"); }
	 * 
	 * 
	 * if (user != null) { if (user.isOTPRequired()) { return
	 * super.attemptAuthentication(request, response); }
	 * 
	 * System.out.println("attemptAuthentication - email: " + email); float
	 * spamScore = getGoogleRecaptchaScore();
	 * 
	 * if (spamScore < 0.5) { try { userService.generateOneTimePassword(user); throw
	 * new InsufficientAuthenticationException("OTP"); } catch (MessagingException |
	 * UnsupportedEncodingException ex) { throw new
	 * AuthenticationServiceException("Error while sending OTP email."); }
	 * 
	 * } else try { userService.generateOneTimePassword(user); } catch
	 * (UnsupportedEncodingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (MessagingException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 * 
	 * return ResponseEntity.ok(""); }
	 */

	@GetMapping("/user/{id}")
	public UserDTO getUserByUserId(@PathVariable String userId) {
		return new UserDTO();
	}

	/**
	 * Method to create new user
	 * @param user
	 * @return
	 */
	@PostMapping(path="/createUser",consumes = "application/json")
	public String createUser(@RequestBody UserDTO user) {
		return userService.registerUser(user);
	}

}

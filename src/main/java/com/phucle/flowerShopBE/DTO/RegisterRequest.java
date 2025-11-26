package com.phucle.flowerShopBE.DTO;

import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
	@NotBlank(message = "full name is request")
	private String fullName;
	@NotBlank(message = "email is request")
	private String email;																				
	@NotBlank(message = "phoneNumber is request")
	private String phoneNumber;
	@NotBlank(message = "password is request")
	private String password;
	@NotBlank(message = "confirm password is request")
	private String confirmPassword;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

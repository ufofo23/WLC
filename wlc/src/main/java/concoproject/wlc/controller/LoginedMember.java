package concoproject.wlc.controller;

import lombok.Getter;

/* 
 * 
 * 세션으로 바꾸기
 * 
 */

@Getter
public class LoginedMember {
	
	private Long id;
	private String email;
	private String name;
	
	public LoginedMember(Long id, String email, String name) {
		this.id = id;
		this.email = email;
		this.name = name;
	}
	
}

package concoproject.wlc.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginForm {

	@NotEmpty(message = "이메일을 입력하세요.")
	private String email;
	
	@NotEmpty(message = "비밀번호를 입력하세요.")
	private String pw;
}

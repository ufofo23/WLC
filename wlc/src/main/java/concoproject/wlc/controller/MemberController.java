package concoproject.wlc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import concoproject.wlc.domain.Member;
import concoproject.wlc.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {

		private final MemberService memberService;
	
		@GetMapping("/members/new")
		public String createForm(Model model) {
			model.addAttribute("memberForm", new MemberForm());
			return "members/createMemberForm";
		}
		
		@PostMapping("/members/new")
		public String create(@Valid MemberForm form, BindingResult result) {
			
			if (result.hasErrors()) {
				return "members/createMemberForm";
			}
			
			Member member = new Member();
			member.createNewMember(form.getName(), form.getEmail(), form.getPw());
			
			memberService.join(member);
			return "redirect:/members/login";
		}
		
		@GetMapping("/members/login")
		public String loginForm(Model model) {
			model.addAttribute("loginForm", new LoginForm());
			return "members/loginForm";
		}
		
		@PostMapping("/members/login")
		public String login(@Valid LoginForm form, BindingResult result) {
			
			if (result.hasErrors()) {
				return "members/loginForm";
			}
			
			List<Member> findByEmail = memberService.findByEmail(form.getEmail());
			
			/* 
			 * 단순 기능구현으로 수정 예정
			 */
			if (!findByEmail.get(0).getPw().equals(form.getPw())){
				System.out.println(findByEmail.get(0).getPw());
				System.out.println(form.getPw());
				return "members/loginForm";
			} else {
				// 로그인 완료
				System.out.println("success!!");
				return "redirect:/";
			}
		}
}

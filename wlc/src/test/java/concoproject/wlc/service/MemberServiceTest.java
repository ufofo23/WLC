package concoproject.wlc.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import concoproject.wlc.domain.Member;
import jakarta.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private EntityManager em;
	
	@Test
	public void 회원가입() {
		//given 
		Member member = new Member();
		member.setName("member");
		
		//when 
		memberService.join(member);
		Member findOne = memberService.findOne(member.getId());
		em.flush();
		
		//then
		assertThat(findOne.getName()).isEqualTo(member.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given 
		Member memberA = new Member();
		memberA.setName("member");
		memberA.setEmail("asdf@naver.com");
		
		Member memberB = new Member();
		memberB.setName("member");
		memberB.setEmail("asdf@naver.com");
		
		//when
		memberService.join(memberA);
		
		
		//then
		assertThrows(IllegalStateException.class, ()->{
			memberService.join(memberB);
		});
	}
	
}

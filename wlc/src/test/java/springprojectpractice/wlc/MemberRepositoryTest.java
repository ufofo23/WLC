package springprojectpractice.wlc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;
	
	@Test
	@Transactional
//	@Rollback(false)
	public void testMember() {
		//given
		Member member = new Member();
		member.setUsername("memberA");
		
		//when
		Long memberId = memberRepository.save(member);
		Member findMember = memberRepository.find(memberId);
		
		//then
		assertEquals(member, findMember);
	}

}

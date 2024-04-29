package concoproject.wlc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import concoproject.wlc.domain.Member;
import concoproject.wlc.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	@Transactional
//	@Rollback(false) // 실제로 db에 반영해서 데이터가 잘 들어가는 지 확인
	public void 회원등록() {
		//given
		Member member = new Member();
		member.setName("hong");
		member.setEmail("asdf@gmail.com");
		
		//when
		memberRepository.save(member);
		Member findOne = memberRepository.findOne(member.getId());
		
		//then
		assertThat(member.getName()).isEqualTo(findOne.getName());
	}
}

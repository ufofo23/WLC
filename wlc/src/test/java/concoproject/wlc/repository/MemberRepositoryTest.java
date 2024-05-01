package concoproject.wlc.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import concoproject.wlc.domain.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Test
//	@Rollback(false) // 실제로 db에 반영해서 데이터가 잘 들어가는 지 확인
	public void 회원등록_아이디조회() {
		//given
		Member member = new Member();
		member.setName("hong");
		member.setEmail("asdf@gmail.com");
		
		//when
		memberRepository.save(member);
		Member findOne = memberRepository.findOne(member.getId());
		
		//then
		assertThat(member.getId()).isEqualTo(findOne.getId());
	}
	
	@Test
	public void 회원등록_이름조회() {
		//given
		Member member = new Member();
		member.setName("hong");
		member.setEmail("asdf@gmail.com");
		
		//when
		memberRepository.save(member);
		List<Member> findByName = memberRepository.findByName(member.getName());
		
		//then
		for (Member findOne : findByName) {
			assertThat(member.getId()).isEqualTo(findOne.getId());
		}
	}
	
	@Test
	public void 회원등록_이메일조회() {
		//given
		Member member = new Member();
		member.setName("hong");
		member.setEmail("asdf@gmail.com");
		
		//when
		memberRepository.save(member);
		List<Member> findByEmail = memberRepository.findByEmail(member.getEmail());
		
		//then
		for (Member findOne : findByEmail) {
			assertThat(member.getId()).isEqualTo(findOne.getId());
		}
	}
	
	@Test
	public void 회원등록_전체조회() {
		//given
		Member memberA = new Member();
		memberA.setName("hong");
		memberA.setEmail("asdf@gmail.com");
		
		Member memberB = new Member();
		memberB.setName("Gwan");
		memberB.setEmail("qwer@gmail.com");
		
		//when
		memberRepository.save(memberA);
		memberRepository.save(memberB);
		List<Member> findAll = memberRepository.findAll();
		
		//then
		assertThat(memberA).isIn(findAll);
		assertThat(memberB).isIn(findAll);
	}
}

package concoproject.wlc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import concoproject.wlc.domain.Member;
import concoproject.wlc.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;

	// 회원 가입
	@Transactional
	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepository.save(member);
		return member.getId();
	}

	// 중복회원 유효검사
	private void validateDuplicateMember(Member member) {
		List<Member> findMembersByName = memberRepository.findByName(member.getName());
		List<Member> findMembersByEmail = memberRepository.findByEmail(member.getEmail());
		
		if (!findMembersByName.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 이름입니다.");
		} else if (!findMembersByEmail.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 이메일입니다.");
		}
	}
	
	// 회원 전체 조회
	public List<Member> findMembers() {
		return memberRepository.findAll();
	}
	
	public Member findOne(Long id) {
		return memberRepository.findOne(id);
	}
	
	// 이메일로 회원 찾기
	public List<Member> findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	
}

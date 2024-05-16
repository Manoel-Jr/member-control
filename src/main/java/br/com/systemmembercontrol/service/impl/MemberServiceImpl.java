package br.com.systemmembercontrol.service.impl;

import br.com.systemmembercontrol.excepion.CpfIsNullException;
import br.com.systemmembercontrol.excepion.EmailIsBeingUsedException;
import br.com.systemmembercontrol.excepion.MemberNotFoundException;
import br.com.systemmembercontrol.model.Member;
import br.com.systemmembercontrol.model.dto.request.MemberRequest;
import br.com.systemmembercontrol.model.dto.request.MemberUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.MemberResponse;
import br.com.systemmembercontrol.repositories.MemberRepository;
import br.com.systemmembercontrol.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final   MemberRepository memberRepository;

    private final ModelMapper modelMapper;

    @Override
    public MemberResponse create(MemberRequest request) {
        Member member = modelMapper.map(request,Member.class);
        if(memberRepository.existsByEmail(request.getEmail())){
            throw new EmailIsBeingUsedException();
        }
        return modelMapper.map(memberRepository.save(member),MemberResponse.class);
    }

    @Override
    public MemberResponse consult(Long id) {
       Member member = memberRepository.findById(id).orElseThrow(MemberNotFoundException::new);
       return modelMapper.map(member,MemberResponse.class);
    }

    @Override
    public MemberResponse consultForEmail(String email) {
       Member member = memberRepository.findByEmail(email);
        if(member != null){
            return modelMapper.map(member,MemberResponse.class);
        }
        throw new CpfIsNullException();
    }

    @Override
    public List<MemberResponse> listAll() {
        List<Member> memberList = memberRepository.findAll();
        return List.of(modelMapper.map(memberList, MemberResponse[].class));
    }

    @Override
    public MemberResponse update(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id).get();
        member.setEmail(request.getEmail());
        member.setPhone(request.getPhone());
        return modelMapper.map(memberRepository.save(member),MemberResponse.class);
    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}

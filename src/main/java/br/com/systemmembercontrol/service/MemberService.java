package br.com.systemmembercontrol.service;

import br.com.systemmembercontrol.model.dto.request.MemberRequest;
import br.com.systemmembercontrol.model.dto.request.MemberUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.MemberResponse;

import java.util.List;

public interface MemberService {

    public MemberResponse create(MemberRequest request);

    public MemberResponse consult(Long id);

    public MemberResponse consultForEmail(String email);

    public List<MemberResponse> listAll();

    public MemberResponse update(Long id, MemberUpdateRequest request);

    public void delete(Long id);
}

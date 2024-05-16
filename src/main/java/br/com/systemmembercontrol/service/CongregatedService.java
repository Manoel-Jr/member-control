package br.com.systemmembercontrol.service;

import br.com.systemmembercontrol.model.dto.request.CongregatedRequest;
import br.com.systemmembercontrol.model.dto.request.CongregatedUpdateRequest;
import br.com.systemmembercontrol.model.dto.request.MemberRequest;
import br.com.systemmembercontrol.model.dto.request.MemberUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.CongregatedResponse;
import br.com.systemmembercontrol.model.dto.response.MemberResponse;

import java.util.List;

public interface CongregatedService {

    public CongregatedResponse create(CongregatedRequest request);

    public CongregatedResponse consult(Long id);

    public CongregatedResponse consultForEmail(String email);

    public List<CongregatedResponse> listAll();

    public CongregatedResponse update(Long id, CongregatedUpdateRequest request);

    public void delete(Long id);
}

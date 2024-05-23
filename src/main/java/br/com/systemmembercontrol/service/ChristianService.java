package br.com.systemmembercontrol.service;

import br.com.systemmembercontrol.model.dto.request.ChristianRequest;
import br.com.systemmembercontrol.model.dto.request.ChristianUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.ChristianResponse;

public interface ChristianService {

    public ChristianResponse create(ChristianRequest request);

    public ChristianResponse consultUsingEmail(String email);

    public ChristianResponse update(Long id, ChristianUpdateRequest request);
}

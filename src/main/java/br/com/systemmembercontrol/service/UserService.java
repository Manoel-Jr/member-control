package br.com.systemmembercontrol.service;

import br.com.systemmembercontrol.model.dto.request.UserRequest;
import br.com.systemmembercontrol.model.dto.response.UserResponse;

public interface UserService {

    public UserResponse create(UserRequest request);

    public UserResponse consult(Long id);

    public void delete(Long id);

}

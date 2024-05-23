package br.com.systemmembercontrol.service.impl;

import br.com.systemmembercontrol.enums.Profile;
import br.com.systemmembercontrol.excepion.EmailIsBeingUsedException;
import br.com.systemmembercontrol.excepion.EmailIsNullException;
import br.com.systemmembercontrol.model.Christian;
import br.com.systemmembercontrol.model.dto.request.ChristianRequest;
import br.com.systemmembercontrol.model.dto.request.ChristianUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.ChristianResponse;
import br.com.systemmembercontrol.repositories.ChristianRepository;
import br.com.systemmembercontrol.service.ChristianService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChristianServiceImpl implements ChristianService {

    private final ChristianRepository repository;

    private final ModelMapper modelMapper;

    @Override
    public ChristianResponse create(ChristianRequest request) {
        if(!repository.existsByEmail(request.getEmail())){
            Christian christian = modelMapper.map(request,Christian.class);
            if (validationChristian(christian)) return modelMapper.map(repository.save(christian), ChristianResponse.class);
        }
        throw  new EmailIsBeingUsedException();
    }

    private boolean validationChristian(Christian christian) {
        if(christian.getBaptized().equals("sim")){
            christian.setProfile(Profile.MEMBER);
            return true;
        } else if (christian.getBaptized().equals("não")) {
            christian.setProfile(Profile.CONGREGATED);
            return true;
        }
        return false;
    }

    @Override
    public ChristianResponse consultUsingEmail(String email) {
        Christian christian = repository.findByEmail(email);
        if(christian != null){
            return modelMapper.map(christian,ChristianResponse.class);
        }
        throw new EmailIsNullException();
    }

    @Override
    public ChristianResponse update(Long id, ChristianUpdateRequest request) {
        Christian christian;
        christian = modelMapper.map(request,Christian.class);
        return modelMapper.map(christian,ChristianResponse.class);
    }
}

package br.com.systemmembercontrol.service.impl;

import br.com.systemmembercontrol.config.EmailVlidator;
import br.com.systemmembercontrol.excepion.EmailIsBeingUsedException;
import br.com.systemmembercontrol.excepion.EmailIsNullException;
import br.com.systemmembercontrol.excepion.ListEmptyException;
import br.com.systemmembercontrol.model.Christian;
import br.com.systemmembercontrol.model.dto.request.ChristianRequest;
import br.com.systemmembercontrol.model.dto.request.ChristianUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.ChristianResponse;
import br.com.systemmembercontrol.repositories.ChristianRepository;
import br.com.systemmembercontrol.service.ChristianService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChristianServiceImpl implements ChristianService {

    private final ChristianRepository repository;

    private final ModelMapper modelMapper;

    private final EmailVlidator validationEmail;

    @Override
    public ChristianResponse create(ChristianRequest request) {
        if(EmailVlidator.isValidEmail(request.getEmail())){
            return getChristianResponse(request);
        }
        throw new EmailIsNullException();
    }

    private ChristianResponse getChristianResponse(ChristianRequest request) {
        if(!repository.existsByEmail(request.getEmail())){
            Christian christian = modelMapper.map(request,Christian.class);
            return modelMapper.map(repository.save(christian), ChristianResponse.class);
        }
        throw  new EmailIsBeingUsedException();
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
        Christian christian = repository.findById(id).get();
        BeanUtils.copyProperties(request,christian, "id");
        return modelMapper.map(repository.save(christian),ChristianResponse.class);
    }

    @Override
    public List<ChristianResponse> listAll() {
        List<Christian> list = repository.findAll();
        if(!list.isEmpty()){
            return Arrays.asList(modelMapper.map(list,ChristianResponse[].class));
        }
        throw new ListEmptyException();
    }

    @Override
    public void changeStatus(Long id) {
        Christian christian = repository.findById(id).get();
        christian.setStatus(!christian.isStatus());
        repository.save(christian);
    }
}

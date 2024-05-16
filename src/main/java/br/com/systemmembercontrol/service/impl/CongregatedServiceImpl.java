package br.com.systemmembercontrol.service.impl;

import br.com.systemmembercontrol.model.Congregated;
import br.com.systemmembercontrol.model.dto.request.CongregatedRequest;
import br.com.systemmembercontrol.model.dto.request.CongregatedUpdateRequest;
import br.com.systemmembercontrol.model.dto.response.CongregatedResponse;
import br.com.systemmembercontrol.repositories.CongregatedRepository;
import br.com.systemmembercontrol.service.CongregatedService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CongregatedServiceImpl implements CongregatedService {


    private final ModelMapper modelMapper;

    private final CongregatedRepository repository;


    @Override
    public CongregatedResponse create(CongregatedRequest request) {
        if(!repository.existsByEmail(request.getEmail())){
            Congregated congregation = modelMapper.map(request,Congregated.class);
            return modelMapper.map(repository.save(congregation),CongregatedResponse.class);
        }
        throw new RuntimeException();
    }

    @Override
    public CongregatedResponse consult(Long id) {
      Optional<Congregated> congregated = Optional.ofNullable(repository.findById(id).orElseThrow(RuntimeException::new));
        return modelMapper.map(congregated,CongregatedResponse.class);
    }

    @Override
    public CongregatedResponse consultForEmail(String email) {
        Congregated congregated  = repository.findByEmail(email);
        if(congregated != null){
            return modelMapper.map(congregated,CongregatedResponse.class);
        }
        throw new RuntimeException();
    }

    @Override
    public List<CongregatedResponse> listAll() {
        List<Congregated> congregates = repository.findAll();
        if(congregates.isEmpty()){
            throw new RuntimeException();
        }
        return List.of(modelMapper.map(congregates,CongregatedResponse[].class));
    }

    @Override
    public CongregatedResponse update(Long id, CongregatedUpdateRequest request) {
       Congregated congregated = repository.findById(id).get();
       congregated.setPhone(request.getPhone());
       congregated.setProfile(request.getProfile());
       congregated.setEmail(request.getEmail());
       return modelMapper.map(congregated,CongregatedResponse.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

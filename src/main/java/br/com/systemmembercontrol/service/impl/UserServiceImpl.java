package br.com.systemmembercontrol.service.impl;

import br.com.systemmembercontrol.enums.Profile;
import br.com.systemmembercontrol.excepion.EmailIsBeingUsedException;
import br.com.systemmembercontrol.excepion.PersonIsNotMemberException;
import br.com.systemmembercontrol.excepion.UserNotFoundException;
import br.com.systemmembercontrol.model.Christian;
import br.com.systemmembercontrol.model.User;
import br.com.systemmembercontrol.model.dto.request.UserRequest;
import br.com.systemmembercontrol.model.dto.response.ChristianResponse;
import br.com.systemmembercontrol.model.dto.response.UserResponse;
import br.com.systemmembercontrol.repositories.UserRepository;
import br.com.systemmembercontrol.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private final ChristianServiceImpl service;

    @Override
    public UserResponse create(UserRequest request) {
        User user = verificationMember(request);
        return modelMapper.map(userRepository.save(user),UserResponse.class);
    }

    private User verificationMember(UserRequest request) {
        ChristianResponse christian = service.consultUsingEmail(request.getEmail());
        if(!christian.getProfile().equals(Profile.MEMBER)){
            throw new PersonIsNotMemberException();
        }
        User user = modelMapper.map(request,User.class);
        user.setName(christian.getName());
        user.setProfile(Profile.USER_MEMBER);
        userExistsByEmail(user.getEmail());
        return user;
    }

    private void userExistsByEmail(String email){
        if (userRepository.existsByEmail(email)){
            throw new EmailIsBeingUsedException();
        }
    }

    @Override
    public UserResponse consult(Long id) {
          Optional<User> user = Optional.ofNullable(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
          return modelMapper.map(user,UserResponse.class);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}

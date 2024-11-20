package ss.bits.user.service.impl;

import ss.bits.user.dto.UserDTO;
import ss.bits.user.entity.User;
import ss.bits.user.repository.UserRepository;
import ss.bits.user.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDTO user) {
        this.userRepository.save(new User(user.getUsername(), DigestUtils.sha256Hex(user.getPassword()), user.getRole()));
    }

    @Override
    public UserDTO findUser(String username) {
        return this.userRepository.findById(username)
                .map(u -> new UserDTO(u.getUsername(), u.getPassword(), u.getRole()))
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Username!"));
    }
}

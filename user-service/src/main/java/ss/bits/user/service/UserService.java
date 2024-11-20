package ss.bits.user.service;

import ss.bits.user.dto.UserDTO;

public interface UserService {
    public void saveUser(UserDTO user);

    UserDTO findUser(String username);
}

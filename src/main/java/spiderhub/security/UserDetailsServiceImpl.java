package spiderhub.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spiderhub.model.User;
import spiderhub.model.dao.UserDao;

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDAO;

    @Override
    public User loadUserByUsername( String userName )
        throws UsernameNotFoundException, DataAccessException
    {
        User user = userDAO.getUserByUsername( userName );
        if( user == null )
            throw new UsernameNotFoundException( userName + " is not found." );

        return user;
    }

}

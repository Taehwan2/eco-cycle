package com.example.capstone.config;

import com.example.capstone.user.db.UserEntity;
import com.example.capstone.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;


@Component
public class HUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final HAuthorityUtils authorityUtils;

    public HUserDetailsService(UserRepository userRepository, HAuthorityUtils authorityUtils) {
        this.userRepository = userRepository;
        this.authorityUtils = authorityUtils;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity;
        if(!username.contains("@")){
         optionalUserEntity = userRepository.findByPhonenum(username);
        }
        else{
            optionalUserEntity = userRepository.findByEmail(username);
        }
        UserEntity userEntity = optionalUserEntity.orElseThrow(()->new NoSuchElementException());

        return new HUserDetails(userEntity);
    }
    private final class HUserDetails extends UserEntity implements UserDetails{
        HUserDetails(UserEntity userEntity){
            setNickname(userEntity.getNickname());
            setBirthday(userEntity.getBirthday());
            setEmail(userEntity.getEmail());
            setName(userEntity.getName());
            setPassword(userEntity.getPassword());
            setRoles(userEntity.getRoles());
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorityUtils.createAuthorites2(this.getRoles());
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}

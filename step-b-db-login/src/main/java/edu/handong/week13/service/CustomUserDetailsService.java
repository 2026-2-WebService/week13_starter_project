package edu.handong.week13.service;

import edu.handong.week13.repository.MemberRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository repository;

    public CustomUserDetailsService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO B-2: repository.findByUsername(username) or throw UsernameNotFoundException.
        // TODO B-3: Return User.builder() containing username, encoded password, role.
        throw new UsernameNotFoundException("TODO: implement DB-backed login");
    }
}

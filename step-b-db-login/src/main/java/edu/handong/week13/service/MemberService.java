package edu.handong.week13.service;

import edu.handong.week13.domain.*;
import edu.handong.week13.dto.RegisterForm;
import edu.handong.week13.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class MemberService {
    private final MemberRepository repository;
    private final PasswordEncoder encoder;

    public MemberService(MemberRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Transactional
    public Member register(RegisterForm form) {
        if (repository.existsByUsername(form.getUsername()))
            throw new IllegalArgumentException("Username already exists");
        Member member = new Member();
        member.setUsername(form.getUsername());
        member.setPassword(form.getPassword() /* TODO B-1: use encoder.encode(...) */);
        member.setRole(Role.USER); // Never accept ADMIN role from public registration.
        return repository.save(member);
    }
}

package edu.handong.week13.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.handong.week13.domain.Member;
public interface MemberRepository extends JpaRepository<Member,Long> {
   Optional<Member> findByUsername(String username);
   boolean existsByUsername(String username);
}

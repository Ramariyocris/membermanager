package tech.developer.membermanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.developer.membermanager.model.Member;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<Member, Long> {

    void deleteMemberById(Long id);

    Optional<Member> findMemberById(Long id);
}

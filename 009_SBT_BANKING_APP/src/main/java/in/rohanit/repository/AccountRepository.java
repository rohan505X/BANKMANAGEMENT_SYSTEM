package in.rohanit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.rohanit.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}

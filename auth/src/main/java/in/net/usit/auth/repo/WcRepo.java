package in.net.usit.auth.repo;

import java.math.BigDecimal;

import in.net.usit.auth.to.Workcentermaster;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WcRepo extends JpaRepository<Workcentermaster, BigDecimal> {

}

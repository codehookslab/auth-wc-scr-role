package in.net.usit.auth.repo;

import in.net.usit.auth.to.Workcentermaster;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WcRepo extends JpaRepository<Workcentermaster, BigDecimal> {

}

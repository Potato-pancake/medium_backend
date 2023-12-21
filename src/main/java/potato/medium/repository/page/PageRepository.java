package potato.medium.repository.page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import potato.medium.domain.page.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

}

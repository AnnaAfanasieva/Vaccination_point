package ua.com.alevel.vaccination_point.dao.repository.user;

import org.springframework.stereotype.Repository;
import ua.com.alevel.vaccination_point.dao.repository.BaseRepository;
import ua.com.alevel.vaccination_point.model.entity.user.User;

@Repository
public interface UserRepository <U extends User> extends BaseRepository<U> {

    U findByEmail(String email);

    boolean existsByEmail(String email);
}

package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.User;

public interface IUserRepository extends PagingAndSortingRepository<User,Long> {
}

package rikkei.academy.service;

import rikkei.academy.model.User;

public interface IUserService {
    Iterable<User> findAll();
    void save(User user);
}

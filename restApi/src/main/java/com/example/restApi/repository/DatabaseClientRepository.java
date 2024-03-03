package com.example.restApi.repository;

import com.example.restApi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseClientRepository extends JpaRepository<Client,Long> {
}

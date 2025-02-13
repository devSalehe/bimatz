package tz.mil.bima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tz.mil.bima.entity.Client;


public interface ClientRepository extends JpaRepository<Client,Long> {
}

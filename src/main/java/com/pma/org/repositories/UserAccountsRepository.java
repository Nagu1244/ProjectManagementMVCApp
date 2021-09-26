package com.pma.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pma.org.entities.UserAccounts;
import com.sun.xml.bind.v2.model.core.ID;

public interface UserAccountsRepository extends JpaRepository<UserAccounts, Long> {

}

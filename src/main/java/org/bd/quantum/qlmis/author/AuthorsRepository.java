package org.bd.quantum.qlmis.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {

}

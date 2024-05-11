package org.bd.quantum.qlmis.publisher;

import java.util.List;

public interface PublisherService {

    String createPublisher(Publishers books);

    List<Publishers> showAllPublisher();

    Publishers showPublisherById(Long id);

    boolean deletePublisher(long id);

    String updatePublisher(long id, Publishers publishers);
}
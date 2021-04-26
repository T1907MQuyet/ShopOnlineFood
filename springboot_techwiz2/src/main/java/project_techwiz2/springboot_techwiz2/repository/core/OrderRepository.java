package project_techwiz2.springboot_techwiz2.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project_techwiz2.springboot_techwiz2.model.core.Category_detail;
import project_techwiz2.springboot_techwiz2.model.core.Orders;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query("SELECT c FROM Orders c WHERE  customer_id = ?1")
    List<Orders> getByCustomerId(int customerId);

    List<Orders> findAllByStatus(int status);

    @Query("SELECT o FROM Orders o ORDER BY status ASC ")
    Page<Orders> findPaginateOrder(Pageable pageable);

    @Query("SELECT o FROM Orders o WHERE status = 1 ORDER BY created ASC ")
    Page<Orders> findPagiOrderWatting(Pageable pageable);

    @Query("SELECT o FROM Orders o WHERE status = 2 ORDER BY updated ASC ")
    Page<Orders> findPagiOrderConfirmed(Pageable pageable);

    @Query("SELECT o FROM Orders o WHERE status = 3 ORDER BY updated ASC ")
    Page<Orders> findPagiOrderShipping(Pageable pageable);

    @Query("SELECT o FROM Orders o WHERE status = 4 ORDER BY updated ASC ")
    Page<Orders> findPagiOrderComplete(Pageable pageable);

    @Query("SELECT o FROM Orders o WHERE status = 5 ORDER BY updated ASC ")
    Page<Orders> findPagiOrderCancelled(Pageable pageable);
}

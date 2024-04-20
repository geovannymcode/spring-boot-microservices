package com.geovannycode.bookstore.orders.domain;

import com.geovannycode.bookstore.orders.domain.models.OrderStatus;
import com.geovannycode.bookstore.orders.domain.models.OrderSummary;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    List<OrderEntity> findByStatus(OrderStatus status);

    Optional<OrderEntity> findByOrderNumber(String orderNumber);

    @Query(
            """
        select new com.geovannycode.bookstore.orders.domain.models.OrderSummary(o.orderNumber, o.status)
        from OrderEntity o
        where o.userName = :userName
        """)
    List<OrderSummary> findByUserName(String userName);

    default void updateOrderStatus(String orderNumber, OrderStatus status) {
        OrderEntity order = this.findByOrderNumber(orderNumber).orElseThrow();
        order.setStatus(status);
        this.save(order);
    }
}

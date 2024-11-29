package org.example.logisticapplication.domain.Order;

import jakarta.persistence.*;
import org.example.logisticapplication.domain.RoutePoint.RoutePointEntity;

import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unique_number")
    private String uniqueNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToMany
    @JoinTable(
            name = "orders_route_points",
            joinColumns = @JoinColumn(
                    name = "order_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "route_point_id"
            )
    )
    private List<RoutePointEntity> routePoints;

    public OrderEntity(Long id, String uniqueNumber, OrderStatus orderStatus, List<RoutePointEntity> routePoints) {
        this.id = id;
        this.uniqueNumber = uniqueNumber;
        this.orderStatus = orderStatus;
        this.routePoints = routePoints;
    }

    public OrderEntity() {}
}

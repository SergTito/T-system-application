package org.example.logisticapplication.domain.RoutePoint;

import jakarta.persistence.*;
import org.example.logisticapplication.domain.Order.OrderEntity;

import java.util.List;

@Entity
@Table(name = "route_points")
public class RoutePointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @ManyToMany(mappedBy = "routePoints")
    private List<OrderEntity> orders;

    public RoutePointEntity(Long id, String city, OperationType operationType, List<OrderEntity> orders) {
        this.id = id;
        this.city = city;
        this.operationType = operationType;
        this.orders = orders;
    }

    public RoutePointEntity() {}

}

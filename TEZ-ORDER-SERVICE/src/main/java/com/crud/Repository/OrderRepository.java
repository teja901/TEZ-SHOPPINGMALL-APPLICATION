package com.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.Entity.Cust_And_Order;
import com.crud.Entity.UserOrders;


@Repository
public interface OrderRepository extends JpaRepository<UserOrders, Long> {

	@Query("SELECT new com.crud.Entity.Cust_And_Order(o.orderId,c.name,c.mobileNumber,o.productName,o.address) FROM CustomerDetails c JOIN c.orders o WHERE c.mobileNumber= :number")
	public List<Cust_And_Order> findByMobileNumber(@Param("number")long number);
}

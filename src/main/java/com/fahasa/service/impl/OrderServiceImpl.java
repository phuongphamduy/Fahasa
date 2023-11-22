package com.fahasa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fahasa.dao.OrderDAO;
import com.fahasa.dao.OrderDetailDAO;
import com.fahasa.dao.StatussDAO;
import com.fahasa.model.Order;
import com.fahasa.model.OrderDetail;
import com.fahasa.model.Statuss;
import com.fahasa.service.OrderService;
import com.fahasa.service.VoucherService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO odao;

	@Autowired
	OrderDetailDAO ddao;

	@Autowired
	StatussDAO sdao;

	@Override
	public Order create(JsonNode order) {
		ObjectMapper mapper = new ObjectMapper();
		Order o = mapper.convertValue(order, Order.class);

		Order orderFromDB = odao.getOrderInCartByUser(o.getUser().getId());
		if (orderFromDB != null) {
			List<OrderDetail> list = o.getOrderdetails();
			List<OrderDetail> orderDetailFromDB = ddao.getOrderDetailByOrderId(orderFromDB.getId());
			// lưu orderdetail
			for (OrderDetail od1 : list) {
				boolean isSave = false;
				for (OrderDetail od2 : orderDetailFromDB) {
					if (od1.getBook() != null && od2.getBook() != null) {
						if (od1.getBook().getId() == od2.getBook().getId()) {
							od2.setQuantity(od1.getQuantity() + od2.getQuantity());
							ddao.save(od2);
							isSave = true;
							break;
						}
					}
					if (od1.getSchooltool() != null && od2.getSchooltool() != null) {
						if (od1.getSchooltool().getId() == od2.getSchooltool().getId()) {
							od2.setQuantity(od1.getQuantity() + od2.getQuantity());
							ddao.save(od2);
							isSave = true;
							break;
						}
					}

				}
				if (!isSave) {
					od1.setOrder(orderFromDB);
					ddao.save(od1);
				}
			}
			return odao.save(orderFromDB);
		}
		return odao.save(o);

	}

	@Override
	public List<Order> getAll() {
		return odao.findAll();
	}

	@Override
	public List<Order> getAllOrdersSuccess() {
		return odao.findAll();
	}

	@Override
	public Order getOrderInCart(Integer id) {
		Order o = odao.getOrderInCartByUser(id);
		return o;
	}

	@Override
	public Order payment(JsonNode data) {
		List<OrderDetail> orderdetails = new ArrayList<OrderDetail>();
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(data, Order.class);
		order.setOrderdetails(orderdetails);
		Order o = odao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> list = mapper.convertValue(data.get("orderdetails"), type);
		for (OrderDetail od : list) {
			od.setOrder(o);
			ddao.save(od);
		}
		return o;
	}

	@Override
	public List<Order> getOrderSuccess(Integer id) {
		return odao.getOrderSuccess(id);
	}

	@Override

	public Order getOrderById(Integer orderId) {
		return odao.findById(orderId).orElse(null);
	}

	@Override
	public Order updateOrderStatus(Integer orderId, Integer statusId) {
		Order order = odao.findById(orderId).orElse(null);
		if (order != null) {
			Statuss newStatus = new Statuss();
			newStatus.setId(statusId);
			order.setStatuss(newStatus);
			return odao.save(order);
		}
		return null;
	}

	public Order findById(Integer id) {
		return odao.findById(id).get();
	}

	@Override
	public void paymentSuccess(Integer id) {
		Order o = odao.findById(id).get();
		Statuss statuss = sdao.findById(2).get();
		o.setStatuss(statuss);
		odao.save(o);

	}

}

package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		Double total = 0.0;
		for(OrderItem oi: items) {
			total+= oi.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: "+ "\n");
		sb.append("Order moment: "+ sdf.format(moment)+"\n");
		sb.append("Order Status: "+ status+"\n");
		sb.append("Client: "+ client.getName() + "(" + sdf1.format(client.getBirthDate())+")"+" - "+client.getEmail()+"\n");
		sb.append("Order items: "+"\n");
		for(OrderItem it: items ) {
			sb.append(it.getProduct().getName()
					+", "+"$"
					+String.format("%.2f", it.getPrice())
					+", "+"Quantity: "+it.getQuantity()
					+", "+"Subtotal: $"+String.format("%.2f", it.subTotal())
					+"\n");
		}
		sb.append("Total price: "+ String.format("%.2f", total()));
		return sb.toString();
	}
	
}

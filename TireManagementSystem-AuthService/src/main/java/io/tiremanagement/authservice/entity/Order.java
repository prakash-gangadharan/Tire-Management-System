package io.tiremanagement.authservice.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String firstName;
	private String lastName;
	private String productName;

	@Override
	public String toString() {
		return String.format("Order[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
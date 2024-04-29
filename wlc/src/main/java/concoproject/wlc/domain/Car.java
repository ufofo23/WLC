package concoproject.wlc.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class Car {

	@Id @GeneratedValue
	@Column(name = "car_id")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "car")
	private List<CategoryCar> categoryCars = new ArrayList<>();
}

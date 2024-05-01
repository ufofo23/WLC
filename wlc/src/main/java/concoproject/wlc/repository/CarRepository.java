package concoproject.wlc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import concoproject.wlc.domain.Car;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CarRepository {

	private final EntityManager em;
	
	public void save(Car car) {
		if(car.getId() == null) {
			em.persist(car);
		} else {
			em.merge(car); // 차후에 dirty checking으로 변경 예정
		}
	}
	
	public Car findOne(Long id) {
		return em.find(Car.class, id);
	}
	
	public List<Car> findAll() {
		return em.createQuery("select c from Car c", Car.class)
				.getResultList();
	}
}

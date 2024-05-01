package concoproject.wlc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import concoproject.wlc.domain.Car;
import concoproject.wlc.repository.CarRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarService {
	
	private final CarRepository carRepository;
	
	// 자동차 등록
	@Transactional
	public void saveCar(Car car) {
		carRepository.save(car);
	}
	
	// 자동차 조회
	public List<Car> findCars() {
		return carRepository.findAll();
	}
	
	// 자동차 아이디로 조회
	public Car findOne(Long carId) {
		return carRepository.findOne(carId);
	}
}

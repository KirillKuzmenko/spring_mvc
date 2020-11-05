package web.service;

import web.dao.CarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.model.Car;
import java.util.List;

@Service
@Transactional
public class CarServiceImp implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public List<Car> listCars(int count) {
        return carDao.listCars(count);
    }
}

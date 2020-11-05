package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Car {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap modelMap){
        if (count >= 0 && count <= 5) {
            modelMap.addAttribute("cars", carService.listCars(count));
        } else {
            modelMap.addAttribute("cars", carService.listCars(5));
        }
        return "cars";
    }
}

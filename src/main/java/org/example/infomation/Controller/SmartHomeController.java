package org.example.infomation.Controller;

import org.example.infomation.Bean.*;
import org.example.infomation.Service.SmartHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class SmartHomeController {

    @Autowired
    private SmartHomeService smartHomeService;

    public SmartHomeController(SmartHomeService smartHomeService) {
        this.smartHomeService = smartHomeService;
    }

    @GetMapping("/smart_new")
    public String smart() {
        return "smart_new";
    }

    @GetMapping("/temp")
    public String temp() {
        return "temp";
    }

    @GetMapping("/main")
    public String showMainPage() {
        return "main";
    }

    @RequestMapping("/login_temp")
    public String show(){
        return "login_temp";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserBean user) {
        UserBean authenticatedUser = smartHomeService.login(user.getName(), user.getPassword());
        Map<String, Object> response = new HashMap<>();

        if (authenticatedUser != null) {
            response.put("status", "success");
            response.put("message", "Login successful!");
            response.put("user", authenticatedUser);
            return ResponseEntity.ok(response); // 返回200 OK状态
        } else {
            response.put("status", "error");
            response.put("message", "Invalid username or password!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // 返回401 Unauthorized状态
        }
    }


    // API for temperature sensor
    @GetMapping("/temp-sensor/{idTemp}")
    public ResponseEntity<Map<String, Object>> getTempSensorById(@PathVariable Integer idTemp) {
        Temp_sensor tempSensor = smartHomeService.getTempSensorById(idTemp);

        // Construct a JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", tempSensor);

        return ResponseEntity.ok(response);
    }

    // API for humidity sensor
    @GetMapping("/humidity/{idTemp}")
    public ResponseEntity<Map<String, Object>> getHumidityById(@PathVariable Integer idTemp) {
        Temp_sensor tempSensor = smartHomeService.getHumidityById(idTemp);

        // Construct a JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", tempSensor);

        return ResponseEntity.ok(response);
    }

    // API for smoke sensor
    @GetMapping("/smoke/{idDetected}")
    public ResponseEntity<Map<String, Object>> getSmokeById(@PathVariable Integer idDetected) {
        Detected detected = smartHomeService.getSmokeById(idDetected);

        // Construct a JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", detected);

        return ResponseEntity.ok(response);
    }

    // API for soil sensor
    @GetMapping("/soil/{idDetected}")
    public ResponseEntity<Map<String, Object>> getSoilById(@PathVariable Integer idDetected) {
        Detected detected = smartHomeService.getSoilById(idDetected);

        // Construct a JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", detected);

        return ResponseEntity.ok(response);
    }

    // Get door/window status
// API for door/window status
    @GetMapping("/door-status/{idDoor}")
    public ResponseEntity<Map<String, Object>> getDoorStatusById(@PathVariable Integer idDoor) {
        Door doorStatus = smartHomeService.getDoorById(idDoor);

        // Construct a JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", doorStatus);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/door/open")
    public ResponseEntity<Map<String, Object>> openDoor(@RequestParam int idDOOR) {
        smartHomeService.openDoor(idDOOR);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/door/close")
    public ResponseEntity<Map<String, Object>> closeDoor(@RequestParam int idDOOR) {
        smartHomeService.closeDoor(idDOOR);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    // Get light brightness
// API for light brightness
    @GetMapping("/light-brightness/{idLight}")
    public ResponseEntity<Map<String, Object>> getLightBrightnessById(@PathVariable Integer idLight) {
        Light lightBrightness = smartHomeService.getLightBrightness(idLight);

        // Construct a JSON response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", lightBrightness);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/fan/open")
    public ResponseEntity<Map<String, Object>> openFan(@RequestParam int idFAN) {
        smartHomeService.openFan(idFAN);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/fan/close")
    public ResponseEntity<Map<String, Object>> closeFan(@RequestParam int idFAN) {
        smartHomeService.closeFan(idFAN);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/window/open")
    public ResponseEntity<Map<String, Object>> openWindows(@RequestParam int idWINDOWS) {
        smartHomeService.openWindows(idWINDOWS);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/window/close")
    public ResponseEntity<Map<String, Object>> closeWindows(@RequestParam int idWINDOWS) {
        smartHomeService.closeWindows(idWINDOWS);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/Red/open")
    public ResponseEntity<Map<String, Object>> openRedLight(@RequestParam int idLight) {
        smartHomeService.openRedLight(idLight);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/Red/close")
    public ResponseEntity<Map<String, Object>> closeRedLight(@RequestParam int idLight) {
        smartHomeService.closeRedLight(idLight);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/Blue/open")
    public ResponseEntity<Map<String, Object>> openBlueLight(@RequestParam int idLight) {
        smartHomeService.openBlueLight(idLight);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/Blue/close")
    public ResponseEntity<Map<String, Object>> closeBlueLight(@RequestParam int idLight) {
        smartHomeService.closeBlueLight(idLight);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/Green/open")
    public ResponseEntity<Map<String, Object>> openGreenLight(@RequestParam int idLight) {
        smartHomeService.openGreenLight(idLight);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/Green/close")
    public ResponseEntity<Map<String, Object>> closeGreenLight(@RequestParam int idLight) {
        smartHomeService.closeGreenLight(idLight);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/garage/open")
    public ResponseEntity<Map<String, Object>> openGarage() {
        smartHomeService.openGarage();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
    @PostMapping("/garage/close")
    public ResponseEntity<Map<String, Object>> closeGarage() {
        smartHomeService.closeGarage();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}



package org.example.infomation.Service;

import org.example.infomation.Bean.*;
import org.example.infomation.Bluetooth.BluetoothReceiver2;
import org.example.infomation.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmartHomeService  {

    @Autowired
    private TempSensorMapper tempSensorMapper;

    @Autowired
    private DoorMapper doorMapper;

    @Autowired
    private LightMapper lightMapper;

    @Autowired
    private FanMapper fanMapper;

    @Autowired
    private WindowsMapper windowsMapper;

    @Autowired
    private DetectedMapper detectedMapper;

    @Autowired
    private BluetoothReceiver2 bluetoothReceiver;

    @Autowired
    public SmartHomeService(DoorMapper doorMapper) {
        this.doorMapper = doorMapper;
    }

    @Autowired
    private UserMapper userMapper;


    public UserBean login(String name, Integer password) {
        return userMapper.findByUsernameAndPassword(name, password);
    }
    // Open the door
    public void openDoor(int idDOOR) {
        doorMapper.updateDoorStatus(idDOOR, 1); // Update the door status to open in the database
        bluetoothReceiver.sendOpenDoorCommand(); // Send open door command
    }

    // Close the door
    public void closeDoor(int idDOOR) {
        doorMapper.updateDoorStatus(idDOOR, 0); // Update the door status to closed in the database
        bluetoothReceiver.sendCloseDoorCommand(); // Send close door command
    }

    // Save light brightness
    public void saveBrightness(Integer Brightness) {
        lightMapper.insertBrightness(Brightness);
    }

    public void saveSmokeAndSoil(Integer smoke_value, Integer soil_value) {
        Map<String, Integer> data = new HashMap<>();
        data.put("smoke_value", smoke_value);
        data.put("soil_value", soil_value);

        // Call Mapper to insert data
        detectedMapper.insertSmokeAndSoil(data);
    }

    // Save temperature and humidity
    public void saveTemperatureAndHumidity(Integer temperature, Integer humidity) {
        Map<String, Integer> data = new HashMap<>();
        data.put("temperature", temperature);
        data.put("humidity", humidity);

        // Call Mapper to insert data
        tempSensorMapper.insertTemperatureAndHumidity(data);
    }

    public Detected getSmokeById(Integer idDetected) {
        return detectedMapper.getSmokeById(idDetected);
    }

    public Detected getSoilById(Integer idDetected) {
        return detectedMapper.getSoilById(idDetected);
    }

    // Get temperature sensor data
    public Temp_sensor getTempSensorById(Integer idTemp) {
        return tempSensorMapper.getTempSensorById(idTemp);
    }

    public Temp_sensor getHumidityById(Integer idTemp) {
        return tempSensorMapper.getHumidityById(idTemp);
    }

    public Door getDoorById(Integer idDoor) {
        return doorMapper.getDoorById(idDoor);
    }

    public Light getLightBrightness(Integer idLight) {
        return lightMapper.getBrightnessByID(idLight);
    }

    // Turn on the fan
    public void openFan(int idFan) {
        fanMapper.updateFanStatus(idFan, 1); // Update the fan status to on in the database
        bluetoothReceiver.sendOpenFanCommand(); // Send fan on command
    }

    // Turn off the fan
    public void closeFan(int idFan) {
        fanMapper.updateFanStatus(idFan, 0); // Update the fan status to off in the database
        bluetoothReceiver.sendCloseFanCommand(); // Send fan off command
    }

    // Open the window
    public void openWindows(int idWindows) {
        windowsMapper.updateWindowsStatus(idWindows, 1); // Update the window status to open in the database
        bluetoothReceiver.sendOpenWindowsCommand(); // Send open window command
    }

    // Close the window
    public void closeWindows(int idWindows) {
        windowsMapper.updateWindowsStatus(idWindows, 0); // Update the window status to closed in the database
        bluetoothReceiver.sendCloseWindowsCommand(); // Send close window command
    }

    public void openRedLight(int idLight) {
        bluetoothReceiver.sendOpenRedLightCommand();
    }

    public void closeRedLight(int idLight) {
        bluetoothReceiver.sendCloseRedLightCommand();
    }

    public void openGreenLight(int idLight) {
        bluetoothReceiver.sendOpenGreenLightCommand();
    }

    public void closeGreenLight(int idLight) {
        bluetoothReceiver.sendCloseGreenLightCommand();
    }

    public void openBlueLight(int idLight) {
        bluetoothReceiver.sendOpenBlueLightCommand();
    }

    public void closeBlueLight(int idLight) {
        bluetoothReceiver.sendCloseBlueLightCommand();
    }

    public void openGarage() {
        bluetoothReceiver.sendOpenGarageCommand();
    }

    public void closeGarage() {
        bluetoothReceiver.sendCloseGarageCommand();
    }
}




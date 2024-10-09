package org.example.infomation.Bluetooth;

import org.example.infomation.Service.SmartHomeService;
import com.fazecast.jSerialComm.SerialPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BluetoothReceiver1 {

    private final SmartHomeService smartHomeService;
    private final SerialPort serialPort;
    private BluetoothReceiver2 bluetoothReceiver2;

    public BluetoothReceiver1(SmartHomeService smartHomeService, BluetoothReceiver2 bluetoothReceiver2) {
        this.smartHomeService = smartHomeService;
        this.bluetoothReceiver2 = bluetoothReceiver2;
        this.serialPort = SerialPort.getCommPort("COM8"); // Select COM8 port
        this.serialPort.setBaudRate(9600); // Setting the baud rate
        if(!serialPort.isOpen())
            this.openPort();
    }
    // Open the serial port
    public boolean openPort() {
        if (serialPort.openPort()) {
            System.out.println("Serial port is open: " + serialPort.getSystemPortName());
            return true;
        } else {
            System.out.println("Unable to open serial port: " + serialPort.getSystemPortName());
            return false;
        }
    }


    public void startListening() {
        try {
            System.out.println("Start listening for data...");
            while (true) {
                recognizeFace();
                Scanner scanner = new Scanner(serialPort.getInputStream());
                Thread.sleep(2000);
                // Check if there is data to read
                System.out.println(scanner.hasNextLine());
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println("Received data: " + line); // Print received data
                    Map<String, Integer> sensorData = parseSensorData(line);
                    if (sensorData != null) {
                        int temperatureValue = sensorData.get("temperature");
                        int humidityValue = sensorData.get("humidity");
                        int rainDropValue = sensorData.get("rainDrop");
                        int rfidDetected = sensorData.get("rfidDetected");
                        int light_value=sensorData.get("light_value");
                        int smoke_value=sensorData.get("smoke_value");
                        int soil_value=sensorData.get("soil_value");
                        // Storing temperature and humidity in a database
                        smartHomeService.saveTemperatureAndHumidity(temperatureValue, humidityValue);
                        System.out.println("Temperature value saved: " + temperatureValue + ", The humidity value has been saved: " + humidityValue);
                        //Storing light intensity in a database
                        smartHomeService.saveBrightness(light_value);
                        System.out.println("Light intensity saved："+light_value);
                        //Transfer of soil moisture and smoke into a database
                        smartHomeService.saveSmokeAndSoil(smoke_value,soil_value);
                        System.out.println("Smoke value saved: " + smoke_value + ", Soil moisture values are saved: " + soil_value);
                        // Print the status of raindrops and RFID
                        System.out.println("Raindrop detection value: " + rainDropValue);
                        System.out.println("RFID Detection Status: " + (rfidDetected == 1 ? "Object detected" : "No objects detected"));

                        // Checking the temperature and controlling the fan
                        if (temperatureValue > 30) {
                            bluetoothReceiver2.sendOpenFanCommand(); // Switch on the fan.
                            System.out.println("Temperatures above 30 degrees have automatically switched on the fan.");
                        } else {
                            bluetoothReceiver2.sendCloseFanCommand(); // Switch off the fan.
                            System.out.println("Temperatures are normal and the fan has been switched off.");
                        }
                        if(rainDropValue<300){
                            bluetoothReceiver2.sendCloseWindowsCommand();
                            System.out.println("It's starting to rain. Close the window.");
                        }else{
                            bluetoothReceiver2.sendOpenWindowsCommand();
                            System.out.println("It's not raining. Open the window.");
                        }
                        if(rfidDetected==1){
                            bluetoothReceiver2.sendOpenGarageCommand();
                            System.out.println("There's a car in the garage. Open the garage door.");
                        }else{
                            // Closing the garage door after a 2-second delay
                            try {
                                Thread.sleep(2000);  // Delay 2 seconds (2000 ms)
                            } catch (InterruptedException e) {
                                e.printStackTrace();  // Handling of exceptions
                            }
                            bluetoothReceiver2.sendCloseGarageCommand();
                            System.out.println("There's no car in the garage. Close the garage door.");
                        }
                        if(soil_value>900){
                            bluetoothReceiver2.sendWaterCommand();
                            System.out.println("Start watering.");
                        }else{
                            bluetoothReceiver2.sendStopWaterCommand();
                            System.out.println("stop watering");
                        }
                    } else {
                        System.out.println("Invalid data received: " + line);
                    }
                    // Add a delay in milliseconds, here set to 5500 milliseconds (5.5 seconds)
                    Thread.sleep(2000); // Adjust delay time as required
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serialPort.closePort();
            System.out.println("Port closed: " + serialPort.getSystemPortName());
        }
    }
    // Calls a Python script to perform face recognition, returning whether a face was detected or not
    public void recognizeFace() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String targetUrl = "http://127.0.0.1:5000";
            ResponseEntity<String> response = restTemplate.getForEntity(targetUrl, String.class);
            String result = response.getBody().trim();
            System.out.println(result);
            if (result.equals("unknown")) {
                // Face not detected or error occurred
                bluetoothReceiver2.sendCloseDoorCommand();  // Send closing command
                System.out.println("No face is detected and the door remains closed.");
            } else {
                // Face detected
                bluetoothReceiver2.sendOpenDoorCommand();  // Sending door opening commands
                System.out.println("A face has been detected and a door opening command has been sent.");
            }
        } catch (Exception e) {
            System.out.println("python not started");
        }
    }

    // Parsing Sensor Data
    private Map<String, Integer> parseSensorData(String data) {
        try {
            // Assuming the data format is: "29.0% 28.0C"
            String[] parts = data.split(" ");
            if (parts.length == 7) {
                // Remove the percent sign for humidity and the Celsius sign for temperature.
                String humidityStr = parts[0].replace("%", "");
                String temperatureStr = parts[1].replace("C", "");
                String rainDropStr = parts[2].replace("&", "");  // Remove symbols for raindrop data
                String lightStr = parts[3].replace("$", "");  // Remove the sign from the light intensity data
                String smokeStr = parts[4].replace("#", "");//Remove smoke data symbols
                String soilStr = parts[5].replace("@", "");//Remove soil moisture symbol
                String rfidDetectedStr = parts[6].replace("^", "");  // Remove symbols from RFID data

                // Convert to integer (assuming decimal parts can be ignored)
                int humidity = (int) Double.parseDouble(humidityStr);
                int temperature = (int) Double.parseDouble(temperatureStr);
                int rainDrop = Integer.parseInt(rainDropStr);
                int light_value = Integer.parseInt(lightStr);
                int smoke_value = Integer.parseInt(smokeStr);
                int soil_value = Integer.parseInt(soilStr);
                int rfidDetected = Integer.parseInt(rfidDetectedStr);

                // Returns a Map of temperature and humidity equivalents.
                Map<String, Integer> sensorData = new HashMap<>();
                sensorData.put("humidity", humidity);
                sensorData.put("temperature", temperature);
                sensorData.put("rainDrop", rainDrop);
                sensorData.put("light_value", light_value);
                sensorData.put("smoke_value", smoke_value);
                sensorData.put("soil_value", soil_value);
                sensorData.put("rfidDetected", rfidDetected);
                return sensorData;
            } else {
                // Data format mismatch
                return null;
            }
        } catch (Exception e) {
            // Catch any parsing errors
            e.printStackTrace();
            return null;
        }
    }
}

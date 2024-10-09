package org.example.infomation.Bluetooth;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.stereotype.Component;

@Component
public class BluetoothReceiver2 {
    private SerialPort serialPort;

    public BluetoothReceiver2() {
        serialPort = SerialPort.getCommPort("COM10");
        serialPort.setBaudRate(9600); // Set the baud rate to match the hardware
        if(!serialPort.isOpen())
            this.openPort();
    }

    // Open the serial port
    public boolean openPort() {
        if (serialPort.openPort()) {
            System.out.println("Serial port opened: " + serialPort.getSystemPortName());
            return true;
        } else {
            System.out.println("Failed to open serial port: " + serialPort.getSystemPortName());
            return false;
        }
    }

    // Send command to open the door
    public void sendOpenDoorCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {1};  // Send "1" as the open door command
            serialPort.writeBytes(command, command.length);
            System.out.println("Open door command sent");
        }
    }

    // Send command to close the door
    public void sendCloseDoorCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {2};  // Send "2" as the close door command
            serialPort.writeBytes(command, command.length);
            System.out.println("Close door command sent");
        }
    }

    // Send command to open the window
    public void sendOpenWindowsCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {3};  // Send "3" as the open window command
            serialPort.writeBytes(command, command.length);
            System.out.println("Open window command sent");
        }
    }

    // Send command to close the window
    public void sendCloseWindowsCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {4};  // Send "4" as the close window command
            serialPort.writeBytes(command, command.length);
            System.out.println("Close window command sent");
        }
    }

    // Send command to turn on the fan
    public void sendOpenFanCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {5};  // Send "5" as the fan on command
            serialPort.writeBytes(command, command.length);
            System.out.println("Fan on command sent");
        }
    }

    // Send command to turn off the fan
    public void sendCloseFanCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {6};  // Send "6" as the fan off command
            serialPort.writeBytes(command, command.length);
            System.out.println("Fan off command sent");
        }
    }

    // Send command to open the garage
    public void sendOpenGarageCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {7};  // Send "7" as the open garage command
            serialPort.writeBytes(command, command.length);
            System.out.println("Open garage command sent");
        }
    }

    // Send command to close the garage
    public void sendCloseGarageCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {8};  // Send "8" as the close garage command
            serialPort.writeBytes(command, command.length);
            System.out.println("Close garage command sent");
        }
    }

    // Send command to turn on the green light
    public void sendOpenGreenLightCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {9};  // Send "9" as the green light on command
            serialPort.writeBytes(command, command.length);
            System.out.println("Green light on command sent");
        }
    }

    // Send command to turn off the green light
    public void sendCloseGreenLightCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {10};  // Send "10" as the green light off command
            serialPort.writeBytes(command, command.length);
            System.out.println("Green light off command sent");
        }
    }

    // Send command to turn on the blue light
    public void sendOpenBlueLightCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {11};  // Send "11" as the blue light on command
            serialPort.writeBytes(command, command.length);
            System.out.println("Blue light on command sent");
        }
    }

    // Send command to turn off the blue light
    public void sendCloseBlueLightCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {12};  // Send "12" as the blue light off command
            serialPort.writeBytes(command, command.length);
            System.out.println("Blue light off command sent");
        }
    }

    // Send command to turn on the red light
    public void sendOpenRedLightCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {13};  // Send "13" as the red light on command
            serialPort.writeBytes(command, command.length);
            System.out.println("Red light on command sent");
        }
    }

    // Send command to turn off the red light
    public void sendCloseRedLightCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {14};  // Send "14" as the red light off command
            serialPort.writeBytes(command, command.length);
            System.out.println("Red light off command sent");
        }
    }

    // Send command to start watering
    public void sendWaterCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {15};  // Send "15" as the start watering command
            serialPort.writeBytes(command, command.length);
            System.out.println("Watering command sent");
        }
    }

    // Send command to stop watering
    public void sendStopWaterCommand() {
        if (serialPort.isOpen()) {
            byte[] command = {16};  // Send "16" as the stop watering command
            serialPort.writeBytes(command, command.length);
            System.out.println("Stop watering command sent");
        }
    }

    // Optional: Read the response from the device
    public String readResponse() {
        if (serialPort.isOpen()) {
            byte[] readBuffer = new byte[1024];
            int numRead = serialPort.readBytes(readBuffer, readBuffer.length);
            return new String(readBuffer, 0, numRead);
        }
        return null;
    }
}


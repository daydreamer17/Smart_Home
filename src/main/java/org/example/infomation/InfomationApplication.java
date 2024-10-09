package org.example.infomation;

import org.example.infomation.Bluetooth.BluetoothReceiver1;
import org.example.infomation.Bluetooth.BluetoothReceiver2;
import org.example.infomation.Service.SmartHomeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.infomation.Mapper")
public class InfomationApplication implements CommandLineRunner {

    @Autowired
    private SmartHomeService smartHomeService;

    @Autowired
    private BluetoothReceiver2 bluetoothReceiver;


    public static void main(String[] args) {
        SpringApplication.run(InfomationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BluetoothReceiver2 bluetoothReceiver2 = bluetoothReceiver;
        BluetoothReceiver1 bluetoothReceiver1 = new BluetoothReceiver1(smartHomeService, bluetoothReceiver2);
        bluetoothReceiver1.startListening();
    }
}

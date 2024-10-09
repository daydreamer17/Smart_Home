$(document).ready(function() {

    // 获取温度数据
    $('#getTemperature').click(function() {
        $.ajax({
            url: '/api/temp-sensor/5',  // 这里的1是示例，可以根据需要替换成实际的id
            type: 'GET',
            success: function(data) {
                $('#temperature').text(data?.data?.current_Temp);
            },
            error: function(error) {
                console.error('Error fetching temperature:', error);
            }
        });
    });

    // 获取湿度数据
    $('#getHumidity').click(function() {
        $.ajax({
            url: '/api/humidity/5',  // 这里的1是示例，可以根据需要替换成实际的id
            type: 'GET',
            success: function(data) {
                $('#humidity').text(data?.data?.humidity);
            },
            error: function(error) {
                console.error('Error fetching humidity:', error);
            }
        });
    });

    // 获取灯光数据
    $('#getBrightness').click(function() {
        $.ajax({
            url: '/api/light-brightness/5',  // 这里的5是示例，可以根据需要替换成实际的id
            type: 'GET',
            success: function(data) {
                $('#Brightness').text(data?.data?.Brightness);
            },
            error: function(error) {
                console.error('Error fetching brightness:', error);
            }
        });
    });

    // 获取灯光数据
    $('#getSmoke').click(function() {
        $.ajax({
            url: '/api/smoke/5',  // 这里的5是示例，可以根据需要替换成实际的id
            type: 'GET',
            success: function(data) {
                $('#Smoke').text(data?.data?.Smoke);
            },
            error: function(error) {
                console.error('Error fetching brightness:', error);
            }
        });
    });

    // 获取灯光数据
    $('#getSoil').click(function() {
        $.ajax({
            url: '/api/soil/5',  // 这里的5是示例，可以根据需要替换成实际的id
            type: 'GET',
            success: function(data) {
                $('#Soil').text(data?.data?.Soil);
            },
            error: function(error) {
                console.error('Error fetching brightness:', error);
            }
        });
    });

    // 获取门窗状态
    $('#getDoorWindowStatus').click(function() {
        console.log(12332)
        $.ajax({
            url: '/api/door-status/1',  // 假设这个URL用于获取门窗状态
            type: 'GET',
            success: function(data) {
                console.log(data)
                $('#doorStatus').text(data.data.status);
                // $('#windowStatus').text(data.windowStatus);
            },
            error: function(error) {
                console.error('Error fetching door/window status:', error);
            }
        });
    });

    // // 每5秒更新一次温度和湿度
    // setInterval(updateTemperatureAndHumidity, 5000);


    // 点击打开按钮时发送指令'1'
    $('#openDoor').click(function () {
        $.ajax({
            url: '/api/door/open',  // API端点假设用于打开门
            type: 'POST',
            data:{
               "idDOOR": 1
            },
            success: function (data) {
                alert('门已打开');
            },
            error: function (error) {
                console.error('打开门失败:', error);
            }
        });
    });

    // 点击关闭按钮时发送指令'2'
    $('#closeDoor').click(function () {
        $.ajax({
            url: '/api/door/close',  // API端点假设用于关闭门
            type: 'POST',
            data:{
                "idDOOR": 1
            },
            success: function (data) {
                alert('门已关闭');
            },
            error: function (error) {
                console.error('关闭门失败:', error);
            }
        });
    });

    // 点击打开按钮时发送指令'3'
    $('#openWindow').click(function () {
        $.ajax({
            url: '/api/window/open',  // API端点假设用于打开门
            type: 'POST',
            data:{
                "idWINDOWS": 1
            },
            success: function (data) {
                alert('窗已打开');
            },
            error: function (error) {
                console.error('打开窗失败:', error);
            }
        });
    });

    // 点击关闭按钮时发送指令'4'
    $('#closeWindow').click(function () {
        $.ajax({
            url: '/api/window/close',  // API端点假设用于关闭门
            type: 'POST',
            data:{
                "idWINDOWS": 1
            },
            success: function (data) {
                alert('窗已关闭');
            },
            error: function (error) {
                console.error('关闭窗失败:', error);
            }
        });
    });

    // 点击打开按钮时发送指令'5'
    $('#openFan').click(function () {
        $.ajax({
            url: '/api/fan/open',  // API端点假设用于打开风扇
            type: 'POST',
            data:{
                "idFAN": 1
            },
            success: function (data) {
                alert('风扇已打开');
            },
            error: function (error) {
                console.error('打开风扇失败:', error);
            }
        });
    });

    // 点击关闭按钮时发送指令'6'
    $('#closeFan').click(function () {
        $.ajax({
            url: '/api/fan/close',  // API端点假设用于关闭风扇
            type: 'POST',
            data:{
                "idFAN": 1
            },
            success: function (data) {
                alert('风扇已关闭');
            },
            error: function (error) {
                console.error('关闭风扇失败:', error);
            }
        });
    });
    // 点击打开按钮时发送指令'9'
    $('#openRed').click(function () {
        $.ajax({
            url: '/api/Red/open',  // API端点假设用于打开红灯
            type: 'POST',
            data:{
                "idLight":1
            },
            success: function (data) {
                alert('红灯已打开');
            },
            error: function (error) {
                console.error('打开红灯失败:', error);
            }
        });
    });
    // 点击打开按钮时发送指令'10'
    $('#closeRed').click(function () {
        $.ajax({
            url: '/api/Red/close',  // API端点假设用于打开红灯
            type: 'POST',
            data:{
                "idLight":1
            },
            success: function (data) {
                alert('红灯已关闭');
            },
            error: function (error) {
                console.error('关闭红灯失败:', error);
            }
        });
    });
    // 点击打开按钮时发送指令'11'
    $('#openBlue').click(function () {
        $.ajax({
            url: '/api/Blue/open',  // API端点假设用于打开红灯
            type: 'POST',
            data:{
                "idLight":1
            },
            success: function (data) {
                alert('蓝灯已打开');
            },
            error: function (error) {
                console.error('打开蓝灯失败:', error);
            }
        });
    });
    // 点击打开按钮时发送指令'12'
    $('#closeBlue').click(function () {
        $.ajax({
            url: '/api/Blue/close',  // API端点假设用于打开红灯
            type: 'POST',
            data:{
                "idLight":1
            },
            success: function (data) {
                alert('蓝灯已关闭');
            },
            error: function (error) {
                console.error('关闭蓝灯失败:', error);
            }
        });
    });
    // 点击打开按钮时发送指令'13'
    $('#openGreen').click(function () {
        $.ajax({
            url: '/api/Green/open',  // API端点假设用于打开红灯
            type: 'POST',
            data:{
                "idLight":1
            },
            success: function (data) {
                alert('绿灯已打开');
            },
            error: function (error) {
                console.error('打开绿灯失败:', error);
            }
        });
    });
    // 点击打开按钮时发送指令'14'
    $('#closeGreen').click(function () {
        $.ajax({
            url: '/api/Green/close',  // API端点假设用于打开红灯
            type: 'POST',
            data:{
                "idLight":1
            },
            success: function (data) {
                alert('绿灯已关闭');
            },
            error: function (error) {
                console.error('关闭绿灯失败:', error);
            }
        });
    });
});

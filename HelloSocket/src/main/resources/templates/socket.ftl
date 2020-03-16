<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>HelloSocket</title>
</head>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script>
    var socket;

    function openSocket() {
        if (typeof(WebSocket) === "undefined") {
            $("#status").html("浏览器不支持WebSocket");
        } else {
            if (socket !== undefined) {
                socket.close();
                socket = undefined;
            }

            // 建立连接
            var socketUrl = "ws://localhost:8080/ws/" + $("#uid").val();
            socket = new WebSocket(socketUrl);
            socket.onopen = function () {
                $("#status").html("WebSocket连接成功");
            };

            socket.onmessage = function (msg) {
                $("#status").html(msg.data);
            };

            socket.onclose = function () {
                $("#status").html("WebSocket关闭连接");
            };

            socket.onerror = function () {
                $("#status").html("WebSocket错误");
            }
        }
    }

    function sendMessage() {
        if (socket === undefined) {
            $("#status").html("请先连接Socket");
        } else {
            socket.send($("#msg").val() + ', ' + new Date().getTime());
        }
    }
</script>

<body>
${msg}

<br/>uid:
<div><input id="uid" name="uid" value="user_id"></div>
<br/>msg：
<div><input id="msg" name="msg" value="Hello WebSocket"></div>

<br/>
<div>
    <button onclick="openSocket()">连接Socket</button>
</div>
<br/>
<div>
    <button onclick="sendMessage()">发送消息</button>
</div>

<br/>
<div><label id="status">Status</label></div>
</body>

</html>
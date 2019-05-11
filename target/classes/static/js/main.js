'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');

var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#mes');


var stompClient = null;
var username = null;
var messag = null;


function connect(event) {
    username = document.querySelector('#name').value.trim();
    if(username && username.indexOf(' ')==-1)
    {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
    else
    {
        alert("Логин не может содержать пробелы или быть пустым")
    }
    event.preventDefault();
}



function onConnected() {
    stompClient.subscribe('/topic/public', onMessageReceived);
    usernamePage.classList.add('hidden');
    chatPage.classList.remove('hidden');
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({username: username})
    )
}


function onError(error) {

    alert("Could not connect to WebSocket")
}


function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    messag = document.querySelector('#mes').value.trim();
    username = document.querySelector('#name').value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            message: messag,
            username: username
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}



function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);

    var tbody = document.getElementById("tableArea").getElementsByTagName("TBODY")[0];
    var row = document.createElement("TR");
    var td1 = document.createElement("TD");
    td1.appendChild(document.createTextNode(message.username));
    var td2 = document.createElement("TD");
    td2.appendChild (document.createTextNode(message.datatime));
    var td3 = document.createElement("TD");
    td3.appendChild (document.createTextNode(message.message));
    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    tbody.appendChild(row);
}




usernameForm.addEventListener('submit', connect, true)

messageForm.addEventListener('submit',sendMessage , true)

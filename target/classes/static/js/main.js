'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var chatPage2= document.querySelector('#chat-page2');

var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#mes');
var messageArea = document.querySelector('#messageArea');
var tableArea = document.querySelector("tableArea");

var connectingElement = document.querySelector('.connecting');

var messageForm2 = document.querySelector('#messageForm2');


var stompClient = null;
var username = null;
var messag = null;


function connect(event) {
    username = document.querySelector('#name').value.trim();
   // alert(username);
    if(username) {
       // usernamePage.classList.add('hidden');
       /// chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}



function onConnected() {
 ///   alert("We are connected to WebSocket2")
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);
    usernamePage.classList.add('hidden');
    chatPage.classList.remove('hidden');
    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: username})
    )

  //  connectingElement.classList.add('hidden');
}


function onError(error) {

    alert("Could not connect to WebSocket")
}


function sendMessage(event) {
   // alert("sendMessage2");
    var messageContent = messageInput.value.trim();
   // alert("sendMessage2   messageInput.value  "+messageInput.value);

    messag = document.querySelector('#mes').value.trim();
    username = document.querySelector('#name').value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: messag,
            content: messageInput.value,
            username: username
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
   // alert("onMessageReceived   "+message.sender);

    var tbody = document.getElementById("tableArea").getElementsByTagName("TBODY")[0];
    var row = document.createElement("TR");
    var td1 = document.createElement("TD");
    td1.appendChild(document.createTextNode(message.username));
    var td2 = document.createElement("TD");
    td2.appendChild (document.createTextNode(message.mes));
    var td3 = document.createElement("TD");
    td3.appendChild (document.createTextNode(message.sender));
    row.appendChild(td1);
    row.appendChild(td2);
    row.appendChild(td3);
    tbody.appendChild(row);





   // messageArea.scrollTop = messageArea.scrollHeight;
}




//usernameForm.addEventListener('submit', connect, true)
usernameForm.addEventListener('submit', connect, true)

messageForm.addEventListener('submit',sendMessage , true)

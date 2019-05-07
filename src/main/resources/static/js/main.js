'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var chatPage2= document.querySelector('#chat-page2');

var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#mes');
var messageArea = document.querySelector('#messageArea');
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

    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

  //  connectingElement.classList.add('hidden');
}


function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
    alert("Could not connect to WebSocket")
}


function sendMessage(event) {
   // alert("sendMessage2");
    var messageContent = messageInput.value.trim();
   // alert("sendMessage2   messageInput.value  "+messageInput.value);

    messag = document.querySelector('#mes').value.trim();

    if(messageContent && stompClient) {
        var chatMessage = {
            sender: messag,
            content: messageInput.value,
            type: 'CHAT'
        };

        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
        messageInput.value = '';
    }
    event.preventDefault();
}


function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
   // alert("onMessageReceived   "+message.sender);

    var messageElement = document.createElement('li');
/*
    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);

        messageElement.appendChild(avatarElement);


    }*/
    var usernameElement = document.createElement('p');
    var usernameText = document.createTextNode(username +"     "+message.mes+"     "+message.sender+"      "+message.type);
    usernameElement.appendChild(usernameText);
    messageElement.appendChild(usernameElement);

/*
    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);*/

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}




//usernameForm.addEventListener('submit', connect, true)
usernameForm.addEventListener('submit', connect, true)

messageForm.addEventListener('submit',sendMessage , true)

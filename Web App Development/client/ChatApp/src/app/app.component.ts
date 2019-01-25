import { Component } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import $ from 'jquery';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private serverUrl = 'http://localhost:8080/ws';
  private title = 'WebSockets chat';
  private stompClient;

  constructor() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    const ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    this.stompClient.connect({}, function (frame) {
      that.stompClient.subscribe('/topic/public', (message: any) => {
        if (message.body) {
          $('.chat').append(`<div class='message'>` + JSON.parse(message.body).content + `</div>`);
          console.log(message.body);
        }
      });
    });
  }

  sendMessage(message) {
    const jsonObj = {
      sender: 'user',
      content: message,
      type: 'CHAT'
    };
    this.stompClient.send('/app/chat.sendMessage', {}, JSON.stringify(jsonObj));
    $('#input').val('');
  }

}

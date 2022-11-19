import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { Message } from 'src/app/entity/message';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {

  messageList: Message[];
  public currentUsers;
  constructor(private messageService: MessageService,

    private router: Router
  ) {}

  ngOnInit() {
    this.getUserLists();
  }

  
  private getUserLists() {
    this.messageService.getUserList().subscribe((data) => {
      this.messageList = data;
    });
  }

 

}

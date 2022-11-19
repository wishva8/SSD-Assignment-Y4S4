import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from '../entity/message';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private baseURL: string;
  constructor(private http: HttpClient) { }

  createMessage(message: Message): Observable<object> {
    return this.http.post(`${environment.baseUrl}message/`, message);
  }
   // getall
   getUserList(): Observable<any> {
    return this.http.get(`${environment.baseUrl}message/`);
  }
}

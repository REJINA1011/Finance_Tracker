import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserSessionService } from './user-session.service';

@Injectable({
  providedIn: 'root'
})
export class ValidationsService {

  constructor(private http: HttpClient, private userSessionService: UserSessionService) { }

  private userCredentialApi = 'http://localhost:8086/api/users/';


  register(data: any,) {
    return this.http.post(`${this.userCredentialApi}register`, data);
  }

  login(data: any) {
    localStorage.setItem("email", data.email);
    this.getUserData().subscribe(
      (response: any) => {
        localStorage.setItem("userId", response.data['id'])
      }
    )
    return this.http.post(`${this.userCredentialApi}login`, data);
  }
  getUserData() {
    const email: string | null = localStorage.getItem("email");
    return this.http.get(this.userCredentialApi + "getUserData/" + email);
  }
}

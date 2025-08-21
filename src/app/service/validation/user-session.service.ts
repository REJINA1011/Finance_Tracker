import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserSessionService {
  private userId: number | null = null;

  setUserId(userId: number) {
    this.userId = userId;
  }

  getUserId(): number | null {
    return this.userId;
  }
}

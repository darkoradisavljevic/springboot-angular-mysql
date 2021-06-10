import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserApiService {
  constructor(private httpClient: HttpClient) {}

  public getAllUsers(): Observable<any> {
    return this.httpClient.get<any>(`http://localhost:4200/api/users`);
  }

  public getUserById(idUser: number): Observable<any> {
    return this.httpClient.get<any>(`http://localhost:4200/api/user/${idUser}`);
  }

  public createUser(user: any) {
    return this.httpClient.post<any>(`http://localhost:4200/api/user`, user);
  }
  public updateUser(idUser: number, user: any) {
    return this.httpClient.put<any>(`http://localhost:4200/api/user/${idUser}`, user);
  }

  public deleteUserById(idUser: number): Observable<any> {
    return this.httpClient.delete<any>(`http://localhost:4200/api/user/${idUser}`);
  }
}

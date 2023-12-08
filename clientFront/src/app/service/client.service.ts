import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../model/client';
import { Response } from '../model/response';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(
    private Http: HttpClient,
  ) { }

  private url: string = environment.HOST;

  public getAll() {
    return this.Http.get<Response<Client[]>>(`${this.url}/list`);
  }

  public save(client: Client) {
    return this.Http.post<Client>(`${this.url}`,client);
  }

  public search(sharedKey: string) {
    return this.Http.get<Response<Client[]>>(`${this.url}/search/${sharedKey}`);
  }
}

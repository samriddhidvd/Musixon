import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { environment } from 'src/environments/environment';
import { Music } from './music';

@Injectable({
  providedIn: 'root'

})

export class MusicService {
  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient){ }

  public getMusics(): Observable<Music[]> {

    return this.http.get<Music[]>(`${this.apiServerUrl}/music/all`);
  }

  public addMusic(music : Music): Observable<Music> {

    return this.http.post<Music>(`${this.apiServerUrl}/music/add`,music);
  }

  public updateMusic(music : Music): Observable<Music> {

    return this.http.put<Music>(`${this.apiServerUrl}/music/update`,music);
  }

  public deleteMusic(musicId : number): Observable<void> {

    return this.http.delete<void>(`${this.apiServerUrl}/music/delete/${musicId}`);
  }

}
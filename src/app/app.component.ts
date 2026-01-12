import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Music } from './music';
import { MusicService } from './music.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public musics: Music[] = [];

  constructor(private musicservice: MusicService){}
  ngOnInit(){
    this.getMusics();
  }

  public getMusics(): void {
    this.musicservice.getMusics().subscribe(
      (response: Music[]) => {
        this.musics = response
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }  
    );
  }

  public onOpenModal(music:Music) {
    
  }
}
